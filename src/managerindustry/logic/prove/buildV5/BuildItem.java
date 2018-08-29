/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV5;

import java.util.List;
import java.util.Map;
import managerindustry.logic.build.materialEfficiency.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.prove.buildV5.basicMaterial.BasicMaterialRequired;
import managerindustry.logic.prove.buildV5.basicMaterial.RequiredMaterialRecusion;

/**
 *
 * @author lele
 */
public class BuildItem {
    private MaterialEfficiencyCalculate materialEfficiencyCalculate = new MaterialEfficiencyCalculate();    
    private int singleMaterialQuantity;
    private double totalMaterialQuantity;  
    private ReportItem reportItem = new ReportItem();
    private RamActivitiesEnum activitiesEnum;

    /**
     * Buld Item
     * @param String bpoName
     * @param int run
     * @param int job
     * @param byte bpoME
     * @param byte componentMe
     * @param RamActivitiesEnum activitiesEnum
     * @throws ErrorExeption 
     */
    public BuildItem(String bpoName, int run, int job, byte bpoME, byte componentMe, 
        RamActivitiesEnum activitiesEnum) throws ErrorExeption{
        
        this.activitiesEnum = activitiesEnum;
        BasicMaterialRequired basicMaterialRequired = 
            new BasicMaterialRequired(bpoName, activitiesEnum);

        requiredItem(bpoName, run, job, bpoME, componentMe, basicMaterialRequired.getRequiredMaterialRecusion().getItemRecursionAs());
    }    
    
    private void requiredItem(String bpoName, int run, int job, byte bpoME, byte componentMe, 
            List <RequiredMaterialRecusion> requiredMaterialRecusions ){

        for (RequiredMaterialRecusion requiredMaterialRecusion : requiredMaterialRecusions) {
            
            calculateME(requiredMaterialRecusion, run, job, bpoME, componentMe);
            calculateQuantityMaterial();
            
            if ( !requiredMaterialRecusion.getItemRecursionAs().isEmpty() ){
                int tempJob = 1;
                byte tempComponetMe = 1;
                requiredItem("", materialEfficiencyCalculate.getSingleItemMaterial(), 
                    tempJob, bpoME, componentMe, requiredMaterialRecusion.getItemRecursionAs());
            }
        }

    }

    /**
     * Calculate ME
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void calculateME(RequiredMaterialRecusion materialRecusion, 
            int run, int job, byte bpoME, byte componentMe ){
        
        if ( materialRecusion.getItemRecursionAs().isEmpty()){
            // T1 material .. bpoME ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (run, job, bpoME , materialRecusion.getQuantity() );
        }else{
            // T2 component .. componentMe ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (run, job, componentMe , materialRecusion.getQuantity() );
        }   
    }       
    
    /**
     * Add Item
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void addItem(RequiredMaterialRecusion materialRecusion){
        materialRecusion.setQuantity(singleMaterialQuantity);
        materialRecusion.setQuanityDbl(totalMaterialQuantity);
//        reportItem.addItem(materialRecusion);        
    }    
    
    /**
     * Calculate Quantity Material
     */
    private void calculateQuantityMaterial(){
        // quantity material per single item 1 run
        singleMaterialQuantity = materialEfficiencyCalculate.getSingleItemMaterial();
           
        // quantity material per all items 1 run
        totalMaterialQuantity = materialEfficiencyCalculate.getTotalItemsMaterials();         
        
        // destroy object
        materialEfficiencyCalculate = null;        
    }      
    
    /**
     * Display Build Item
     */
    public void displayBuildItem(){
     
    }    
   
}
