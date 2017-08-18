/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import managerindustry.db.entities.solarSystemTax.TaxCostIndexEntity;
import managerindustry.db.entities.solarSystemTax.TaxSolarSystemEntity;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.CostIndex;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SystemCostIndex;

/**
 *
 * @author lele
 */
public class ManagerSystemCostIndex {
    private TaxSolarSystemEntity taxSolarSystemEntity = new TaxSolarSystemEntity();
    
    public ManagerSystemCostIndex
     ( Map<String, SolarSystem > solarSystemMap, String SolarSystemID, String activity ) {
         
         initSystemCostIndexDB();
         initIfExists(solarSystemMap, SolarSystemID, activity);
     }
    
    /**
     * Create the database
     */
    private void initSystemCostIndexDB(){
        if (ManagerDB.getInstance().getAllTaxSolarSystemEntity() == null ){
            ManagerDB.getInstance().addTaxSolarSystemEntity(taxSolarSystemEntity);
        }
    }
     
    /**
     * Check if exists a specific solar system
     * @param solarSystemMap
     * @param SolarSystemID
     * @param activity 
     */
    private void initIfExists( Map<String, SolarSystem > solarSystemMap, String SolarSystemID, String activity ){
        TaxSolarSystemEntity tempTaxSolarSystemEntity = 
         ManagerDB.getInstance().solarSystemExists(SolarSystemID);
        

        if ( tempTaxSolarSystemEntity == null){
            addSolarSystem(solarSystemMap, SolarSystemID);
        }else{
            // updateSolarSystem(solarSystemMap, SolarSystemID, tempTaxSolarSystemEntity );
            updateSolarSystem02(solarSystemMap, SolarSystemID, taxSolarSystemEntity, true);
        }
        updateAllSolarSystem(solarSystemMap, SolarSystemID);  
    }
    
    /**
     * Add new solar system
     * @param Map<String, SolarSystem > solarSystemMap
     * @param String solarSystemID 
     */
    private void addSolarSystem(Map<String, SolarSystem > solarSystemMap, String solarSystemID){
        Date nowPresent = new Date( new Date().getTime());
        
        SolarSystem solarSystem = solarSystemMap.get(solarSystemID);
        taxSolarSystemEntity.setSolarSystemID(solarSystemID);
        taxSolarSystemEntity.setLastUsed(nowPresent);
        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());
        
        
        for (CostIndex costIndex : costIndexs) {
            TaxCostIndexEntity taxCostIndexEntity = new TaxCostIndexEntity();
            taxCostIndexEntity.setActivity(costIndex.getActivity());
            taxCostIndexEntity.setCostIndex(costIndex.getCostIndex());

            taxSolarSystemEntity.addTaxCostIndexEntity(taxCostIndexEntity);
        }
        ManagerDB.getInstance().addTaxSolarSystemEntity(taxSolarSystemEntity);
    }
    
    /**
     * DBG da migliorare in efficienza Una mappa che data una stringa 
     * con il nome dele activity di cost index ritorni direttamente la 
     * corrispettiva taxcostindexentity
     * @param Map<String, SolarSystem > solarSystemMap
     * @param String solarSystemID
     * @param TaxSolarSystemEntity taxSolarSystemEntity 
     */
    private void updateSolarSystem(Map<String, SolarSystem > solarSystemMap, 
     String solarSystemID, TaxSolarSystemEntity taxSolarSystemEntity ){
        Date nowPresent = new Date( new Date().getTime());
        
        taxSolarSystemEntity.setLastUsed(nowPresent);
        
        SolarSystem solarSystem = solarSystemMap.get(solarSystemID);

        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());
        List < TaxCostIndexEntity > taxCostIndexEntity = taxSolarSystemEntity.getTaxCostIndexEntities();

        for (TaxCostIndexEntity taxCostIndex : taxCostIndexEntity) {
            for (CostIndex costIndex : costIndexs) {
                if ( taxCostIndex.getActivity().equals(costIndex.getActivity())){
                    taxCostIndex.setCostIndex(costIndex.getCostIndex());
                    ManagerDB.getInstance().updateTaxCostIndex(taxCostIndex);
                }
            } 
        }
    }
    
    private void updateSolarSystem02(Map<String, SolarSystem > solarSystemMap, 
     String solarSystemID, TaxSolarSystemEntity taxSolarSystemEntity, boolean valueBool){
        
        if (valueBool){
            Date nowPresent = new Date( new Date().getTime());
            taxSolarSystemEntity.setLastUsed(nowPresent);            
        }
        
        // valore preso dai Json di eve
        SolarSystem solarSystem = solarSystemMap.get(solarSystemID);
        
        // "activity": "manufacturing"....  di uno specifico sistema preso da Json
        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());        
        Map < String, CostIndex > costIndexMap = 
         costIndexs.stream().collect(Collectors.toMap(CostIndex::getActivity, CostIndex -> CostIndex));

        // "activity": "manufacturing".... preso dal DB
        List < TaxCostIndexEntity > taxCostIndexEntity = taxSolarSystemEntity.getTaxCostIndexEntities();   
        
        for (TaxCostIndexEntity taxCostIndexEntity1 : taxCostIndexEntity) {
            CostIndex costIndex = costIndexMap.get(taxCostIndexEntity1.getActivity());
            taxCostIndexEntity1.setCostIndex(costIndex.getCostIndex());
            ManagerDB.getInstance().updateTaxCostIndex(taxCostIndexEntity1);
//            if ( valueBool ){
//                ManagerDB.getInstance().updateTaxSolarSystemEntity(taxSolarSystemEntity);
//            }
        }
        
/*
            Map<String, SolarSystem > solarSystemMap = 
             solarSystems.stream().collect(Collectors.toMap(SolarSystem::getSolarSystem, SolarSystem -> SolarSystem));        
        */        
        
    }

    
    /**
     * Update All Solar System
     * @param Map<String, SolarSystem > solarSystemMap
     * @param String solarSystemID 
     */
    private void updateAllSolarSystem(Map<String, SolarSystem > solarSystemMap, String solarSystemID){
        List < TaxSolarSystemEntity > tempTaxSolarSystemEntity = 
         ManagerDB.getInstance().getAllExceptSpecificSolarSysem(solarSystemID);
        
        for (TaxSolarSystemEntity taxSolarSystemEntity : tempTaxSolarSystemEntity) {
            // updateSolarSystem2(solarSystemMap, solarSystemID, taxSolarSystemEntity);           
            updateSolarSystem02(solarSystemMap, taxSolarSystemEntity.getSolarSystemID(), taxSolarSystemEntity, false);
        }
    }    
}
