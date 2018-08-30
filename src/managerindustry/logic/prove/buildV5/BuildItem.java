/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV5;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.efficiency.materialEfficiency.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.prove.buildV5.basicMaterial.BasicMaterialRequired;
import managerindustry.logic.generic.nameBase.NameBase;

/**
 *
 * @author lele
 */
public class BuildItem {
    private MaterialEfficiencyCalculate materialEfficiencyCalculate = new MaterialEfficiencyCalculate();    
    private int singleMaterialQuantity;
    private double totalMaterialQuantity;  
    private ReportItem reportItem = new ReportItem();

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
        
        BasicMaterialRequired basicMaterialRequired = 
            new BasicMaterialRequired(bpoName, activitiesEnum);

        requiredItem(bpoName, run, job, bpoME, componentMe, 
            basicMaterialRequired.getRequiredMaterialRecusion().getItemRecursionAs());
    }    
    /**
     * Required Item recursion
     * @param String bpoName
     * @param int run
     * @param int job
     * @param byte bpoME
     * @param byte componentMe
     * @param List <NameBase> requiredMaterialRecusions 
     */
    private void requiredItem(String bpoName, int run, int job, byte bpoME, 
        byte componentMe, List <NameBase> requiredMaterialRecusions ){

        for (NameBase requiredMaterialRecusion : requiredMaterialRecusions) {
            
            calculateME(requiredMaterialRecusion, run, job, bpoME, componentMe);
            calculateQuantityMaterial();
            addItem(requiredMaterialRecusion);
            
            if ( !requiredMaterialRecusion.getItemRecursionAs().isEmpty() ){
                int tempJob = 1;
                byte tempComponetMe = 1;
                requiredItem("", singleMaterialQuantity, tempJob, bpoME, 
                    tempComponetMe, requiredMaterialRecusion.getItemRecursionAs());
            }
        }
    }

    /**
     * Calculate ME
     * @param NameBase materialRecusion
     * @param int run
     * @param int job
     * @param byte bpoME
     * @param byte componentMe 
     */
    private void calculateME(NameBase materialRecusion, 
            int run, int job, byte bpoME, byte componentMe ){
        
        if ( materialRecusion.getItemRecursionAs().isEmpty()){
            // T1 material .. bpoME ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (run, job, bpoME , materialRecusion.getQuanityI() );
        }else{
            // T2 component .. componentMe ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (run, job, componentMe , materialRecusion.getQuanityI() );
        }   
    }       
    
    /**
     * Add Item
     * @param NameBase materialRecusion 
     */
    private void addItem(NameBase materialRecusion){
        materialRecusion.setQuanityI(singleMaterialQuantity);
        materialRecusion.setQuanityD(totalMaterialQuantity);
        reportItem.addItem(materialRecusion);        
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
        Map<String, NameBase> singleCalculatedItemM = reportItem.getSingleCalculatedItemM();
        
        for (Map.Entry<String, NameBase> entry : singleCalculatedItemM.entrySet()) {
            display(entry.getValue().getItemRecursionAs());
        }
    }    
 
    private void display(List <NameBase> requiredMaterialRecusions){
        List<NameBase> requiredMaterialRecusions1 = requiredMaterialRecusions;
        for (NameBase requiredMaterialRecusion : requiredMaterialRecusions1) {
            System.out.println(""+ requiredMaterialRecusion.getTypeId() + " " +
                requiredMaterialRecusion.getTypeName() + " " +
                requiredMaterialRecusion.getQuanityI() + " > " + 
                requiredMaterialRecusion.getQuanityD());
         
            if ( !requiredMaterialRecusion.getItemRecursionAs().isEmpty() ){
                display(requiredMaterialRecusion.getItemRecursionAs());
            }            
        }        
    }
}
