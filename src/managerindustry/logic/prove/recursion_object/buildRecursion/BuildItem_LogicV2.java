/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.buildRecursion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.logic.build.production.basicMaterialRequired.old.MaterialRequired_Init;
import managerindustry.logic.build.production.buildItem.ReportItem;
import managerindustry.logic.build.skill.efficiency.MaterialEfficiency;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.BuildItem;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.prove.recursion_object.genericRequiredItem.requiredMaterial.RequiredMaterialV2;

/**
 *
 * @author lele
 */
public class BuildItem_LogicV2 < E, G > extends 
        RequiredMaterialV2 < NameBase, List <NameBase>, BuildItem, NameBase, E, NameBase, G > {
    
    private MaterialEfficiency materialEfficiencyCalculate = new MaterialEfficiency( (byte) 0 , 1f, 1f, 1f);
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
    public BuildItem_LogicV2(BuildItem buildItem, 
        RamActivitiesEnum activitiesEnum) throws ErrorExeption{
        
        MaterialRequired_Init basicMaterialRequired = 
            new MaterialRequired_Init(buildItem.getBpoName(), activitiesEnum);
        
        requiredItem(requiredMaterial, 
            basicMaterialRequired.getRequiredMaterialObject().getItemRecursions(), 
            buildItem);
        
        System.out.println("");
    }    

    /**
     * Required Item recursion
     * @param BuildItem buildItem
     * @param NameBase requiredA
     * @param List <NameBase> requiredMaterialRecusions 
     */
    @Override
    public void requiredItem(NameBase requiredA, 
            List <NameBase> requiredMaterialRecusions, BuildItem buildItem) {

        for (NameBase requiredMaterialRecusion : requiredMaterialRecusions) {
            
            calculateME( buildItem, requiredMaterialRecusion);
            calculateQuantityMaterial();
            addItem(requiredMaterialRecusion);                 
            
            NameBase requiredItemsRecursionA = 
                requiredItemMoreInfo(requiredMaterialRecusion);            
      
            requiredA.addItemRecursions(requiredItemsRecursionA);
            
            if ( !requiredMaterialRecusion.getItemRecursions().isEmpty() ){
                BuildItem buildItemSecondPassage = 
                    getBuildItemSecondPassage( buildItem.getBpoME());
                
                requiredItem( requiredItemsRecursionA, 
                    requiredMaterialRecusion.getItemRecursions(), buildItemSecondPassage);

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
            materialEfficiencyCalculate.materialEfficiencyCalculate
                (buildItem.getRun(), buildItem.getJob(), 
                    buildItem.getBpoME(), materialRecusion.getBaseQuantity() );
        }else{
            // T2 component .. componentMe ..
            materialEfficiencyCalculate.materialEfficiencyCalculate
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

    }     
    
    /**
     * Required Item More Info
     * @param Object requiredMaterial
     * @return Object
     */
    @Override
    public NameBase requiredItemMoreInfo(NameBase requiredMaterial) {
        System.err.print("BuildItemLogic > requiredItemMoreInfo is ENABLE!!!");

        NameBase nameBase = new NameBase(
            requiredMaterial.getTypeID(),
            requiredMaterial.getTypeName(), 
            requiredMaterial.getBaseQuantity(),    
            requiredMaterial.getSingleItemQuantity(),
            requiredMaterial.getTotalItemsQuantity());

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
