/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import managerindustry.db.entities.solarSystemTax.TaxCostIndexEntity;
import managerindustry.db.entities.solarSystemTax.TaxSolarSystemEntity;
import managerindustry.logic.exception.SolarSystemNotExists;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.CostIndex;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;

/**
 * Update, create and delete all Solar system
 * @author lele
 */
public class ManagerSystemCostIndex {
    private TaxSolarSystemEntity taxSolarSystemEntity = new TaxSolarSystemEntity();
    private Map<String, SolarSystem > solarSystemMap = new HashMap<>();
    private String solarSystemID = null;
    
    /**
     * Manager System Cost Index
     * @param solarSystemMap
     * @param solarSystemID 
     */
    public ManagerSystemCostIndex
     ( Map<String, SolarSystem > solarSystemMap, String solarSystemID ) {
         this.solarSystemMap = solarSystemMap;
         this.solarSystemID = solarSystemID;
         
         if ( this.solarSystemMap.isEmpty())
             return;
         
         initSystemCostIndexDB();
         initIfExists();
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
     */
    private void initIfExists(){
        TaxSolarSystemEntity tempTaxSolarSystemEntity = 
         ManagerDB.getInstance().solarSystemExists(this.solarSystemID);
        
        if ( tempTaxSolarSystemEntity == null){
            addSolarSystem();
        }else{
            updateSolarSystem(tempTaxSolarSystemEntity, true);
        }

        updateAllSolarSystem();
        deleteSolarSystem();
    }
    
    /**
     * Get Cost Index
     * @param solarSystemID
     * @param activity
     * @return String
     */
    public String getCostIndex(String solarSystemID, String activity){
        TaxSolarSystemEntity taxSolarSystemEntity = ManagerDB.getInstance().solarSystemExists(solarSystemID);
        
        try {
            if ( taxSolarSystemEntity == null){
                throw new SolarSystemNotExists();
            }
        } catch (SolarSystemNotExists e) {
            System.out.println(""+e.getMessage());
            return null;
        }

        List < TaxCostIndexEntity > taxCostIndexEntitys = taxSolarSystemEntity.getTaxCostIndexEntities();
        if (taxCostIndexEntitys.isEmpty())
            return null;
        
        for (TaxCostIndexEntity taxCostIndexEntity : taxCostIndexEntitys) {
            if ( taxCostIndexEntity.getActivity().equals(activity)){
                return taxCostIndexEntity.getCostIndex();
            }
        }
        return null;
    }
    
    /**
     * Add new solar system
     */
    private void addSolarSystem(){
        Date nowPresent = new Date( new Date().getTime());
        
        SolarSystem solarSystem = this.solarSystemMap.get(this.solarSystemID);
        
        try {
            
            if ( solarSystem == null){
                throw new SolarSystemNotExists();
            }
        } catch (SolarSystemNotExists e) {
            System.out.println(""+e.getMessage());
            return;
        }
        
    
        taxSolarSystemEntity.setSolarSystemID(this.solarSystemID);
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
     * @param TaxSolarSystemEntity taxSolarSystemEntity
     * @param boolean valueBool 
     */
    private void updateSolarSystem(TaxSolarSystemEntity taxSolarSystemEntity, boolean valueBool){
        
        if (valueBool){
            Date nowPresent = new Date( new Date().getTime());
            taxSolarSystemEntity.setLastUsed(nowPresent);            
        }
        
        // Solar systems From Json ( eve server )
        SolarSystem solarSystem = this.solarSystemMap.get(this.solarSystemID);
        
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
     */
    private void updateAllSolarSystem(){
        
        List < TaxSolarSystemEntity > tempTaxSolarSystemEntity = 
         ManagerDB.getInstance().getAllExceptSpecificSolarSysem(this.solarSystemID);
        
        if (tempTaxSolarSystemEntity.isEmpty())
            return;
        
        for (TaxSolarSystemEntity taxSolarSystemEntity : tempTaxSolarSystemEntity) {
            this.solarSystemID = taxSolarSystemEntity.getSolarSystemID();
            updateSolarSystem(taxSolarSystemEntity, false);
        }
    }

    /**
     * Delete Solar System
     * DBG
     */    
    private void deleteSolarSystem(){
        System.out.println("DBG deleteSolarSystem da errore nella eliminazione dei fati");
        long monthInSecond = 1l; // 2592000l;
        Date nowPresent = new Date( new Date().getTime());
        List < TaxSolarSystemEntity > solarSystemEntitys =
         ManagerDB.getInstance().getAllExceptSpecificSolarSysem(this.solarSystemID);
        
        if (solarSystemEntitys.isEmpty())
            return;        
        
        for (TaxSolarSystemEntity solarSystemEntity : solarSystemEntitys) {
            Date lastUsed = solarSystemEntity.getLastUsed();
            long timePassed = nowPresent.getTime() - lastUsed.getTime();

            
            if ( timePassed >  monthInSecond ){
//                ManagerDB.getInstance().deleteTaxSolarSystemEntity(taxSolarSystemEntity);
            }
        }
        
    }
}
