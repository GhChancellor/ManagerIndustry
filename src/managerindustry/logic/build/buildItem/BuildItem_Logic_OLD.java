/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.buildItem;

import java.util.HashMap;
import managerindustry.logic.generic.fatherClass.BuildItem;
import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.efficiency.materialEfficiency.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.build.basicMaterialRequired.MaterialRequired_Init;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterial;
import managerindustry.logic.prove.efficiency.MaterialEfficiency;

/**
 *
 * @author lele
 */
public class BuildItem_Logic_OLD extends RequiredMaterial{
    private MaterialEfficiencyCalculate materialEfficiencyCalculate = new MaterialEfficiencyCalculate();    
    // private MaterialEfficiency materialEfficiencyCalculate = new MaterialEfficiency( (byte) 0 , 1f, 1f, 1f);
    private int baseQuantity;;
    private int singleMaterialQuantity;
    private long totalMaterialQuantity;
    private ReportItem reportItem = new ReportItem();
    
    /**
     * Buld Item Logic
     * @param BuildItem buildItem
     * @param RamActivitiesEnum activitiesEnum
     * @throws ErrorExeption 
     */    
    public BuildItem_Logic_OLD(BuildItem buildItem, 
        RamActivitiesEnum activitiesEnum) throws ErrorExeption{
        
        MaterialRequired_Init basicMaterialRequired = 
            new MaterialRequired_Init(buildItem.getBpoName(), activitiesEnum);

        requiredItem(buildItem, requiredMaterial,
            basicMaterialRequired.getRequiredMaterialObject().getItemRecursions());
        System.out.println("");
    }    

    /**
     * Required Item recursion
     * @param BuildItem buildItem
     * @param NameBase requiredA
     * @param List <NameBase> requiredMaterialRecusions 
     */
    @Override
    public void requiredItem(Object buildItem, Object requiredA, 
        Object requiredMaterialRecusions) {

        for (NameBase requiredMaterialRecusion : (List <NameBase>) requiredMaterialRecusions) {
            
            calculateME( (BuildItem) buildItem, requiredMaterialRecusion);
            calculateQuantityMaterial();
            addItem(requiredMaterialRecusion);

//            NameBase requiredItemsRecursionA = 
//                new NameBase(requiredMaterialRecusion.getTypeId(), 
//                    requiredMaterialRecusion.getQuanityI(),
//                    requiredMaterialRecusion.getQuanityD());                        
            
            NameBase requiredItemsRecursionA = 
                (NameBase) requiredItemMoreInfo(requiredMaterialRecusion);
            ((NameBase) requiredA).addItemRecursions(requiredItemsRecursionA);
            
            if ( !requiredMaterialRecusion.getItemRecursions().isEmpty() ){
                BuildItem buildItemSecondPassage = 
                    getBuildItemSecondPassage( ((BuildItem) buildItem).getBpoME());
                
                requiredItem(buildItemSecondPassage, requiredItemsRecursionA,
                    requiredMaterialRecusion.getItemRecursions());
            }
        }
    }  

    /**
     * Get Build Item Second Passage
     * @param byte bpoMe
     * @return BuildItem
     */
    private BuildItem getBuildItemSecondPassage(byte bpoMe){
        int tempJob = 1;
        byte tempComponetMe = 1;
                
        BuildItem buildItem = new BuildItem("", singleMaterialQuantity, tempJob, 
            bpoMe, tempComponetMe);
        return buildItem;
    }
    
    /**
     * Calculate ME
     * @param BuildItem buildItem
     * @param NameBase materialRecusion
     */
    private void calculateME(BuildItem buildItem,
            NameBase materialRecusion){
        
        if ( materialRecusion.getItemRecursions().isEmpty()){
            // T1 material .. bpoME ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (buildItem.getRun(), buildItem.getJob(), 
                    buildItem.getBpoME(), materialRecusion.getBaseQuantity() );
        }else{
            // T2 component .. componentMe ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (buildItem.getRun(), buildItem.getJob(),
                    buildItem.getComponentMe(), materialRecusion.getBaseQuantity() );
        }   
    }       
    
    /**
     * Add Item
     * @param NameBase materialRecusion 
     */
    private void addItem(NameBase materialRecusion){
        materialRecusion.setBaseQuantity(baseQuantity);
        materialRecusion.setSingleItemQuantity(singleMaterialQuantity);
        materialRecusion.setTotalItemsQuantity(totalMaterialQuantity);   
    }    
    
    /**
     * Calculate Quantity Material
     */
    private void calculateQuantityMaterial(){
        // base Quantity
        baseQuantity = materialEfficiencyCalculate.getBaseQuantity();
        
        // quantity material per single item 1 run
        singleMaterialQuantity = materialEfficiencyCalculate.getSingleItemQuantity();
           
        // quantity material per all items 1 run
        totalMaterialQuantity = 
            materialEfficiencyCalculate.getTotalItemsQuantity();         
        
        // destroy object
        materialEfficiencyCalculate = null;        
    }     
    
    /**
     * Required Item More Info
     * @param Object requiredMaterial
     * @return Object
     */
    @Override
    public Object requiredItemMoreInfo(Object requiredMaterial) {
        System.err.print("BuildItemLogic > requiredItemMoreInfo is ENABLE!!!");

        NameBase nameBase = new NameBase(
            ((NameBase)requiredMaterial).getTypeID(), 
            ((NameBase)requiredMaterial).getTypeName(), 
            ((NameBase)requiredMaterial).getBaseQuantity(), 
            ((NameBase)requiredMaterial).getSingleItemQuantity(),
            ((NameBase)requiredMaterial).getTotalItemsQuantity() );

        return nameBase;
    }    
    
    /**
     * @deprecated 
     * Sum all value into map
     */
    public Map<String, NameBase> getTotalCalculatedItem(){    
        return new HashMap<>();
        // return reportItem.getTotalCalculatedItem();
    }
}
