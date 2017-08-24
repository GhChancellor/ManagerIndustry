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

/**
 *
 * @author lele
 */
public class ManagerSystemCostIndex {
    private TaxSolarSystemEntity taxSolarSystemEntity = new TaxSolarSystemEntity();
    
    /**
     * Manager System Cost Index
     * @param Map<String, SolarSystem > solarSystemMap form json server EVe
     * @param String SolarSystemID
     * @param String activity 
     */
    public ManagerSystemCostIndex
     ( Map<String, SolarSystem > solarSystemMap, String solarSystemID, String activity ) {
         
         initSystemCostIndexDB();
         initIfExists(solarSystemMap, solarSystemID, activity);
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
            updateSolarSystem(solarSystemMap, SolarSystemID, tempTaxSolarSystemEntity, true);
        }

        updateAllSolarSystem(solarSystemMap, SolarSystemID);
        deleteSolarSystem(SolarSystemID);
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
     * Update Solar System
     * @param Map<String, SolarSystem > solarSystemMap
     * @param String solarSystemID
     * @param TaxSolarSystemEntity taxSolarSystemEntity 
     * @param boolean valueBoo
     */    
    private void updateSolarSystem(Map<String, SolarSystem > solarSystemMap, 
     String solarSystemID, TaxSolarSystemEntity taxSolarSystemEntity, boolean valueBool){
        
        if (valueBool){
            Date nowPresent = new Date( new Date().getTime());
            taxSolarSystemEntity.setLastUsed(nowPresent);            
        }
        
        // Solar systems From Json ( eve server )
        SolarSystem solarSystem = solarSystemMap.get(solarSystemID);
        
        // Convert Arrays to Costindexs
        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());        

        Map < String, CostIndex > costIndexMap = 
         costIndexs.stream().collect(Collectors.toMap(CostIndex::getActivity, CostIndex -> CostIndex));

        // "activity": "manufacturing"....From DB
        List < TaxCostIndexEntity > taxCostIndexEntity = taxSolarSystemEntity.getTaxCostIndexEntities();   
        
        for (TaxCostIndexEntity taxCostIndexEntity1 : taxCostIndexEntity) {
            CostIndex costIndex = costIndexMap.get(taxCostIndexEntity1.getActivity());
            taxCostIndexEntity1.setCostIndex(costIndex.getCostIndex());
            ManagerDB.getInstance().updateTaxCostIndex(taxCostIndexEntity1);
            if ( valueBool ){
                ManagerDB.getInstance().updateTaxSolarSystemEntity(taxSolarSystemEntity);
            }
        }
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
            updateSolarSystem(solarSystemMap, taxSolarSystemEntity.getSolarSystemID(), taxSolarSystemEntity, false);
        }
    }

    private void deleteSolarSystem(String SolarSystemID){
        long monthInSecond = 1l; // 2592000l;
        Date nowPresent = new Date( new Date().getTime());
        List < TaxSolarSystemEntity > solarSystemEntitys =
         ManagerDB.getInstance().getAllExceptSpecificSolarSysem(SolarSystemID);
        
        for (TaxSolarSystemEntity solarSystemEntity : solarSystemEntitys) {
            Date lastUsed = solarSystemEntity.getLastUsed();
            long timePassed = nowPresent.getTime() - lastUsed.getTime();

            
            if ( timePassed >  monthInSecond ){
                System.out.println("passed");
                ManagerDB.getInstance().deleteTaxSolarSystemEntity(taxSolarSystemEntity);
            }
        }
        
    }
}
