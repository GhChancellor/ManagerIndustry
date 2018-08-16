/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3;

import java.util.List;
import java.util.Map;
import managerindustry.logic.build.materialEfficiency.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.recursion.ItemRecursionA;
import managerindustry.logic.generic.recursion.ItemRecursionB;

/**
 *
 * @author lele
 */
public class BuildItem{
    private MaterialEfficiencyCalculate materialEfficiencyCalculate = new MaterialEfficiencyCalculate();    
    private String bpoName;
    private int run;
    private int job;
    private byte bpoME;
    private byte componentMe;
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
        
        this.bpoName = bpoName;
        this.run = run;
        this.job = job;
        this.bpoME = bpoME;
        this.componentMe = componentMe;
        this.activitiesEnum = activitiesEnum;
        BasicMaterialRequired basicMaterialRequired = 
            new BasicMaterialRequired(bpoName, activitiesEnum);

        requiredItem(basicMaterialRequired);
    }
    
    private void requiredItem(BasicMaterialRequired basicMaterialRequired){
        Map<String, RequiredMaterialRecusion> basicMaterialMap = basicMaterialRequired.getBasicMaterialMap();
        
        for (Map.Entry<String, RequiredMaterialRecusion> entry : basicMaterialMap.entrySet()) {
            if ( entry.getKey() != null )
                requiredItem003(entry.getValue());
            
            if ( !entry.getValue().getRecursionB02s().isEmpty() ){
                requiredItem002( (RequiredMaterialRecusion) entry.getValue() );
            }
        }
    }
    
    private void requiredItem002(RequiredMaterialRecusion requiredMaterialRecusion_){
        for (ItemRecursionB requiredMaterialRecusion : requiredMaterialRecusion_.getRecursionB02s()) {
            RequiredMaterialRecusion name = (RequiredMaterialRecusion) requiredMaterialRecusion.getRecursionA02();
            requiredItem003(name);
            
            if ( !name.getRecursionB02s().isEmpty() )
                requiredItem002(name);
        }
    }
    
    private void requiredItem003(RequiredMaterialRecusion materialRecusion){
        calculateME(materialRecusion);
        calculateQuantityMaterial();
        addItem(materialRecusion);            
    }      
    
    /**
     * Add Item
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void addItem(RequiredMaterialRecusion materialRecusion){
        materialRecusion.setQuantity(singleMaterialQuantity);
        materialRecusion.setQuanityDbl(totalMaterialQuantity);
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
     * Calculate ME
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void calculateME(RequiredMaterialRecusion materialRecusion){
        if ( materialRecusion.getRecursionB02s().isEmpty()){
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
     * Display Build Item
     */
    public void displayBuildItem(){
        System.out.println("Single Items");
        Map<String, RequiredMaterialRecusion> singleCalculatedItemM = reportItem.getTotalCalculatedItemM();
        
        for (Map.Entry<String, RequiredMaterialRecusion> entry : singleCalculatedItemM.entrySet()) {
            String key = entry.getKey();
            RequiredMaterialRecusion value = entry.getValue();
            System.out.println(""+ value.getTypeID() + ": "
            + value.getTypeName() + " "
            + value.getQuantity() + " - "
            + value.getQuanityDbl());            
        }           
    }
}    

