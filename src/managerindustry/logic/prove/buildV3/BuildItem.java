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

        // Attenzione da armonizzare
        requiredItem(basicMaterialRequired);        
    }
         
    /**
     * Add Item
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void addItem(RequiredMaterialRecusion materialRecusion){
        Item singleItem = new Item(
            materialRecusion.getTypeID(), materialRecusion.getTypeName(), 
            singleMaterialQuantity, totalMaterialQuantity);

        reportItem.addItem(singleItem);
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
     * Calculate required Item
     * @param basicMaterialRequired 
     */
    private void requiredItem(BasicMaterialRequired basicMaterialRequired) {
        List<RequiredMaterialRecusion> basicMaterialRequireds = 
            basicMaterialRequired.getBasicMaterialList();
        
        for (RequiredMaterialRecusion materialRecusion : basicMaterialRequireds) {
            calculateME(materialRecusion);
            calculateQuantityMaterial();
            addItem(materialRecusion);              
        }
    }
    
    /**
     * Display Build Item
     */
    public void displayBuildItem(){
        System.out.println("Single Items");
        Map<String, Item> singleCalculatedItemM = reportItem.getSingleCalculatedItemM();
        for (Map.Entry<String, Item> singleItem : singleCalculatedItemM.entrySet()) {
            Item item = singleItem.getValue();
            
//            System.out.println(""+ item.getTypeId() + ": "
//            + item.getName() + " "
//            + item.getQuanityInt() + " - "
//            + item.getQuanityDbl());
            
//            String key = item.getKey();
//            Item value = item.getValue();
            
        }

        
    }    
   
}
