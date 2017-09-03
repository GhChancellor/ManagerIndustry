/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.build;

import java.util.List;
import java.util.Map;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.MaterialCalc;
import managerindustry.logic.buiild.MaterialForComponents;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *
 * @author lele
 */
public class ManagerBuild {
    /**
     * Inizio da qui
     */
    public void buildItem(String bpoName, int meBPO, int job, int run, int meComponet ){
        // Errore nella produzione capital "Concord 25000mm Steel Plate"
        
        // VALORE NULLO
        IndustryActivityMaterials industryActivityMaterials = new IndustryActivityMaterials();
        
        baseMaterial(bpoName);
        
//        int job = 1;
//        int run = 1;
//        int meBPO = 0;
//        int meComponet = 0;
        System.out.println("job " + job + " run "+ run + " me "+ meBPO);
        List < ComponentX > componentXs = ManagerComponentX.getInstance().getBaseComponentXs();
        for (ComponentX componentX : componentXs) {
                        
            int firstStep = MaterialCalc.calculateMaterialEfficiency(job, run, componentX.getQuanity(), meBPO);
            System.out.println(""+componentX.getName() + " " + componentX.getQuanity() + " --> " + firstStep );
            
            TotalCalculatedComponentX calculatedComponentX = new TotalCalculatedComponentX(componentX.getName(), firstStep);
            
            ManagerComponentX.getInstance().addTotalcalculatedComponentX(calculatedComponentX);
            
            List < MaterialForComponents > materialForComponents =  componentX.getMaterialForComponents();
            
            for (MaterialForComponents materialForComponent : materialForComponents)  {
                
                int secondStep = MaterialCalc.calculateMaterialEfficiency(job, firstStep, materialForComponent.getQuanity(), meComponet);
                calculatedComponentX = new TotalCalculatedComponentX(materialForComponent.getName(), secondStep);
                ManagerComponentX.getInstance().addTotalcalculatedComponentX(calculatedComponentX);
                
                
                System.out.println("\t\t"+ materialForComponent.getName() + " " + materialForComponent.getQuanity() + " --> " + secondStep);
            }
        }
        
        displayTotalMaterial(bpoName);
    }    
    
    /**
     * Get from DB all materail to build an object 
    */
    private void baseMaterial(String bpoName){     
        System.out.println(""+bpoName);
        
        // get item to build
        List < IndustryActivityMaterials > nameItemToBuild = ManagerDBEve.getInstance().getMaterialNeedByName(bpoName);
 
        
        if ( ! nameItemToBuild.isEmpty() ){
            for (IndustryActivityMaterials invTypeMaterialse :  nameItemToBuild) {
                InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(invTypeMaterialse.getMaterialTypeID());
                
                // get component
                List < IndustryActivityMaterials > neededComponents = ManagerDBEve.getInstance().getMaterialNeedByName( invTypes.getTypeName() + " blueprint");
                
                ComponentX componentX = new ComponentX();
                componentX.setName(invTypes.getTypeName());
                componentX.setQuanity(invTypeMaterialse.getQuantity());
                
                if ( neededComponents != null){                    
                    for (IndustryActivityMaterials neededComponent : neededComponents) { 
                        
                        invTypes = ManagerDBEve.getInstance().getInvTypes_NameById(neededComponent.getMaterialTypeID());
                        
                        MaterialForComponents materialForComponents = new MaterialForComponents
                         ( invTypes.getTypeID(), invTypes.getTypeName(), neededComponent.getQuantity());
                        componentX.addMaterialForComponents(materialForComponents);   
                    }
                }
                ManagerComponentX.getInstance().addComponentXs(componentX); 
            }             
        }         
    }
        
    private void displayTotalMaterial(String bpoName){
        Map < String, TotalCalculatedComponentX > calculatedComponentXMap = ManagerComponentX.getInstance().getTotalcalculatedComponentXMap();
        System.out.println("Total material to build "+ bpoName);
        for (Map.Entry<String, TotalCalculatedComponentX> entry : calculatedComponentXMap.entrySet()) {
            String key = entry.getKey();
            TotalCalculatedComponentX value = entry.getValue();
            System.out.println(""+ key + " " + value.getQuanity());
        }    
        
//        for (String key : calculatedComponentXMap.keySet()) {
//            TotalCalculatedComponentX value = calculatedComponentXMap.get(key);
//            System.out.println(""+ key + " " + value.getQuanity());
//        }
    }
}
