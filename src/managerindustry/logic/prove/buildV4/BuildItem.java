/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV4;

import java.util.Map;
import managerindustry.logic.build.materialEfficiency.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.recursion.ItemRecursionA;


/**
 *
 * @author lele
 */
public class BuildItem {
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
    private int XXX;
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
        Map<String, BasicMaterialRequiredLogic> map = basicMaterialRequired.getMap();
        for (Map.Entry<String, BasicMaterialRequiredLogic> entry : map.entrySet()) {
            String key = entry.getKey();
            BasicMaterialRequiredLogic value = entry.getValue();
            
        System.out.println("");            
        }
//        System.out.println("");
    }
    
    private void requiredItem002(RequiredMaterialRecusion requiredMaterialRecusion_){
        for (ItemRecursionA requiredMaterialRecusion : requiredMaterialRecusion_.getItemRecursionAs()) {
            RequiredMaterialRecusion name = (RequiredMaterialRecusion) requiredMaterialRecusion.getRecursionA02();
            requiredItem003(name);
            
            if ( !name.getItemRecursionAs().isEmpty() )
                requiredItem002(name);
        }
    }
    
    private void requiredItem003(RequiredMaterialRecusion materialRecusion){
        calculateME(materialRecusion);
        calculateQuantityMaterial();

        System.out.println("");
//        addItem(materialRecusion);            
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
        if ( materialRecusion.getItemRecursionAs().isEmpty()){
            // T1 material .. bpoME ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (XXX, job, bpoME , materialRecusion.getQuantity() );
        }else{
            // T2 component .. componentMe ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (run, job, componentMe , materialRecusion.getQuantity() );
            XXX = materialRecusion.getQuantity();
        }        
    }
    
    /**
     * Display Build Item
     */
    public void displayBuildItem(){
        System.out.println("Single Items");
        Map<String, RequiredMaterialRecusion> singleCalculatedItemM = reportItem.getSingleCalculatedItemM();
        
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
