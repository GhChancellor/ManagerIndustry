/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.List;
import java.util.Map;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.buiild.MaterialForComponents;
import managerindustry.logic.buiild.MaterialEfficiencyCalculate;
import managerindustry.logic.buiild.SingleCalculatedComponentX;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *
 * @author lele
 */
public class ManagerBuild {    
    private void displayTotalMaterial(String bpoName){
        Map < String, TotalCalculatedComponentX > calculatedComponentXMap = ManagerComponentX.getInstance().getTotalCalculatedComponentXMap();
        System.out.println("\nTotal material to build "+ bpoName);
        for (Map.Entry<String, TotalCalculatedComponentX> entry : calculatedComponentXMap.entrySet()) {
            String key = entry.getKey();
            TotalCalculatedComponentX value = entry.getValue();
            System.out.println(""+ key + " --> " +  String.format("%.0f", value.getQuanityDbl()) );
        }    
                
        
//        for (String key : calculatedComponentXMap.keySet()) {
//            TotalCalculatedComponentX value = calculatedComponentXMap.get(key);
//            System.out.println(""+ key + " " + value.getQuanity());
//        }
    }
    
    /**
     * Build Item
     * DBG potrebbe avere piccole imprecisioni con Dra 10 run, 10 job, 10 ME
     * @param bpoName
     * @param run
     * @param job
     * @param bpoME
     * @param componentMe 
     */
    public void buildItem(String bpoName, int run, int job, int bpoME, int componentMe ){
        // Errore nella produzione capital "Concord 25000mm Steel Plate"
        // ci vuole la ricorsione per le T3
        
        System.out.println(bpoName + ": run " + run + ", Job " + job + ", meBPO " + bpoME + ", meComponent " + componentMe );

        baseMaterial(bpoName);
        
        // get value base from DB
        List < ComponentX > componentXs = ManagerComponentX.getInstance().getBaseComponentXs();
        
        for (ComponentX componentX : componentXs) {
            // calculate materialEfficiencyCalculate
            MaterialEfficiencyCalculate materialEfficiencyCalculate = new MaterialEfficiencyCalculate(run, job, bpoME , componentX.getQuanityInt() );
            
            // value of the single item
            int firstStepSingleMaterial = materialEfficiencyCalculate.getSingleItemMaterial();
            
            // values of the total item
            double firstStepTotalMaterials = materialEfficiencyCalculate.getTotalItemsMaterials();            
            System.out.println(""+ componentX.getName() + ": B: " + componentX.getQuanityInt() + " --> " + 
             firstStepSingleMaterial + " --> " + 
             String.format("%.0f", firstStepTotalMaterials)  );
            
            
            // Put Total Calculated Components
            TotalCalculatedComponentX totalCalculatedComponentX = 
                new TotalCalculatedComponentX(componentX.getName(), firstStepTotalMaterials);
            
            // Put single Calculated Component
            SingleCalculatedComponentX singleCalculatedComponentX = 
                new SingleCalculatedComponentX(componentX.getName(), firstStepSingleMaterial);
            
            // add values of the items to map 
            ManagerComponentX.getInstance().addTotalcalculatedComponentX(totalCalculatedComponentX);
            
            // add value of the single item to map
            ManagerComponentX.getInstance().addSingleCalculatedComponentXMap(singleCalculatedComponentX);
            
            // get Value for compoenents T2
            List < MaterialForComponents > materialForComponents =  componentX.getMaterialForComponents();
            
            for (MaterialForComponents materialForComponent : materialForComponents) {
                // DBG non funziona bene
                // calculate materialEfficiencyCalculate
                materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                  ( firstStepSingleMaterial , 1, componentMe, materialForComponent.getQuanityInt() );
                
                // value of the single item
                int secondStepSingleMaterial = materialEfficiencyCalculate.getSingleItemMaterial();
                
                // values of the total item
                double secondStepTotalMaterials = materialEfficiencyCalculate.getTotalItemsMaterials();
                
                // Put Total Calculated Components
                totalCalculatedComponentX = new TotalCalculatedComponentX(materialForComponent.getName(), secondStepTotalMaterials );
                
                // Put single Calculated Component
                singleCalculatedComponentX = new SingleCalculatedComponentX(materialForComponent.getName(), secondStepSingleMaterial);

                // add values of the items to map 
                // DBG NON RICORDA TUTTI I TOTALI IMMESSI 
                ManagerComponentX.getInstance().addTotalcalculatedComponentX(totalCalculatedComponentX);
                
                // add value of the single item to map
                ManagerComponentX.getInstance().addSingleCalculatedComponentXMap(singleCalculatedComponentX);

                System.out.println("\t\t"+ materialForComponent.getName() + ": Mat: " 
                 + singleCalculatedComponentX.getQuanityInt() + " --> " + String.format("%.0f", totalCalculatedComponentX.getQuanityDbl()) );
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
                componentX.setQuanityInt(invTypeMaterialse.getQuantity());
                
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
}
