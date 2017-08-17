/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
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
         isExists(solarSystemMap, SolarSystemID, activity);
     }
    
    public void initSystemCostIndexDB(){
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
    public void isExists( Map<String, SolarSystem > solarSystemMap, String SolarSystemID, String activity ){
        TaxSolarSystemEntity tempTaxSolarSystemEntity = 
         ManagerDB.getInstance().isSolarSystemExists(SolarSystemID);
        
        if ( tempTaxSolarSystemEntity == null){
            addSolarSystem(solarSystemMap, SolarSystemID);
        }else{
            updateSolarSystem(solarSystemMap, SolarSystemID, tempTaxSolarSystemEntity );
        }
    }
    
    /**
     * Add new solar system
     * @param Map<String, SolarSystem > solarSystemMap
     * @param String solarSystemID 
     */
    private void addSolarSystem(Map<String, SolarSystem > solarSystemMap, String solarSystemID){
        SolarSystem solarSystem = solarSystemMap.get(solarSystemID);
        taxSolarSystemEntity.setSolarSystemID(solarSystemID);
        
        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());
        
        
        for (CostIndex costIndex : costIndexs) {
            TaxCostIndexEntity taxCostIndexEntity = new TaxCostIndexEntity();
            taxCostIndexEntity.setActivity(costIndex.getActivity());
            taxCostIndexEntity.setCostIndex(costIndex.getCostIndex());
            taxSolarSystemEntity.addTaxCostIndexEntity(taxCostIndexEntity);
        }
        ManagerDB.getInstance().addTaxSolarSystemEntity(taxSolarSystemEntity);
    }
    
    private void updateSolarSystem(Map<String, SolarSystem > solarSystemMap, 
     String solarSystemID, TaxSolarSystemEntity taxSolarSystemEntity ){
        taxSolarSystemEntity.deleteTaxCostIndexEntityies();
        
        SolarSystem solarSystem = solarSystemMap.get(solarSystemID);
        
        List < CostIndex > costIndexs = Arrays.asList(solarSystem.getCostIndexs());
        TaxCostIndexEntity taxCostIndexEntity = new TaxCostIndexEntity();
        
        for (CostIndex costIndex : costIndexs) {
            taxCostIndexEntity.setActivity(costIndex.getActivity());
            taxCostIndexEntity.setCostIndex(costIndex.getCostIndex());
            this.taxSolarSystemEntity.addTaxCostIndexEntity(taxCostIndexEntity);
        }   
        ManagerDB.getInstance().updateTaxSolarSystemEntity(this.taxSolarSystemEntity);

    }
}
