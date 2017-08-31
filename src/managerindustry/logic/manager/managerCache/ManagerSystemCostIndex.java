/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerCache;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import managerindustry.db.entities.cache.TaxCostIndexEntity;
import managerindustry.db.entities.cache.TaxSolarSystemEntity;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.managerDB.ManagerDBCache;
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
    
    
    /*
        SystemCostIndex systemCostIndex = new SystemCostIndex();
        Map<String, SolarSystem > solarSystemMap = systemCostIndex.getSystemCostIndexs();
        
        ManagerSystemCostIndex managerSystemCostIndex = 
         new ManagerSystemCostIndex(solarSystemMap, "1");
        System.out.println(""+ managerSystemCostIndex.getCostIndexEntity("1", "manufacturing"));
    */
    /**
     * Manager System Cost Index
     * @param solarSystemMap
     * @param solarSystemID 
     */
    public ManagerSystemCostIndex
     ( Map<String, SolarSystem > solarSystemMap, String solarSystemID ) throws SolarSystemNotExistsException {
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
        
        if (ManagerDBCache.getInstance().getAllTaxSolarSystemEntity() == null ){
            ManagerDBCache.getInstance().addTaxSolarSystemEntity(taxSolarSystemEntity);
        }
    }
     
    /**
     * Check if exists a specific solar system
     */
    private void initIfExists() throws SolarSystemNotExistsException{
         this.taxSolarSystemEntity = 
         ManagerDBCache.getInstance().getSolarSystem(this.solarSystemID);
        
                
        if ( taxSolarSystemEntity == null){
            addSolarSystemIfExists();
        }else{
            updateSolarSystem(true);
        }

//        updateAllSolarSystem();
//        deleteSolarSystem();
    }
    
    /**
     * Get Cost Index
     * @param solarSystemID
     * @param activity
     * @return String
     */
    public String getCostIndexEntity(Map<String, SolarSystem > solarSystemMap, String solarSystemID, String activity) throws SolarSystemNotExistsException{
        TaxSolarSystemEntity taxSolarSystemEntity = ManagerDBCache.getInstance().getSolarSystem(solarSystemID);
  
        
        if (taxSolarSystemEntity == null){
            addSolarSystem(solarSystemMap, solarSystemID);
            
            taxSolarSystemEntity = ManagerDBCache.getInstance().getSolarSystem(solarSystemID);
            
            if ( taxSolarSystemEntity == null){
                throw new SolarSystemNotExistsException();
            }
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
    private void addSolarSystemIfExists() throws SolarSystemNotExistsException{
        Date nowPresent = new Date();
        
        SolarSystem solarSystem = this.solarSystemMap.get(this.solarSystemID);
        
        if ( solarSystem == null){
            throw new SolarSystemNotExistsException();
        }
        
        taxSolarSystemEntity = new TaxSolarSystemEntity();
        taxSolarSystemEntity.setSolarSystemID(this.solarSystemID);
        taxSolarSystemEntity.setLastUsed(nowPresent);
        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());
        
        
        for (CostIndex costIndex : costIndexs) {
            TaxCostIndexEntity taxCostIndexEntity = new TaxCostIndexEntity();
            taxCostIndexEntity.setActivity(costIndex.getActivity());
            taxCostIndexEntity.setCostIndex(costIndex.getCostIndex());

            taxSolarSystemEntity.addTaxCostIndexEntity(taxCostIndexEntity);
        }
        ManagerDBCache.getInstance().addTaxSolarSystemEntity(taxSolarSystemEntity);
    }
    
    /**
     * Add new solar system
     * @param Map<String, SolarSystem > solarSystemMap
     * @param String solarSystemID 
     */        
    private void addSolarSystem(Map<String, SolarSystem > solarSystemMap, String solarSystemID) throws SolarSystemNotExistsException{
        this.solarSystemID = solarSystemID;
        this.solarSystemMap = solarSystemMap;
        addSolarSystemIfExists();
    }
    
    /**
     * Update Solar System
     * @param TaxSolarSystemEntity taxSolarSystemEntity
     * @param boolean valueBool 
     */
    private void updateSolarSystem(boolean valueBool){
        
        if (valueBool){
            Date nowPresent = new Date();
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
            ManagerDBCache.getInstance().updateTaxCostIndex(taxCostIndexEntity1);
            
            if ( valueBool ){
                ManagerDBCache.getInstance().updateTaxSolarSystemEntity(taxSolarSystemEntity);
            }
        }
    }
    
    /**
     * Update All Solar System
     */
    private void updateAllSolarSystem(){
        
        List < TaxSolarSystemEntity > tempTaxSolarSystemEntity = 
         ManagerDBCache.getInstance().getAllExceptSpecificSolarSysem(this.solarSystemID);
        
        if (tempTaxSolarSystemEntity.isEmpty())
            return;
        
        for (TaxSolarSystemEntity taxSolarSystemEntity : tempTaxSolarSystemEntity) {
            this.solarSystemID = taxSolarSystemEntity.getSolarSystemID();
            this.taxSolarSystemEntity = taxSolarSystemEntity;
            updateSolarSystem(false);
        }
    }

    /**
     * Delete Solar System
     * DBG
     */    
    private void deleteSolarSystem(){
        System.out.println("DBG deleteSolarSystem da errore nella eliminazione dei fati");
        long monthInSecond = 3600l; // 2592000l;
        Date nowPresent = new Date( new Date().getTime());
        List < TaxSolarSystemEntity > solarSystemEntitys =
         ManagerDBCache.getInstance().getAllExceptSpecificSolarSysem(this.solarSystemID);
        
        if (solarSystemEntitys.isEmpty())
            return;        
        
        for (TaxSolarSystemEntity solarSystemEntity : solarSystemEntitys) {
            Date lastUsed = solarSystemEntity.getLastUsed();
            long timePassed = nowPresent.getTime() - lastUsed.getTime();

            if ( timePassed >  monthInSecond ){
                ManagerDBCache.getInstance().deleteTaxSolarSystemEntity(taxSolarSystemEntity);
            }
        }
        
    }
}