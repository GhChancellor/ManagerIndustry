/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.buildItem;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.efficiency.materialEfficiency.MaterialEfficiencyCalculate;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.nameBase.NameBase;
import managerindustry.logic.build.basicMaterialRequired.BasicMaterialRequired;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterial;

/**
 *
 * @author lele
 */
public class BuildItemLogic extends RequiredMaterial{
    private MaterialEfficiencyCalculate materialEfficiencyCalculate = new MaterialEfficiencyCalculate();    
    private int singleMaterialQuantity;
    private double totalMaterialQuantity;
    private ReportItem reportItem = new ReportItem();
    
    /**
     * Buld Item Logic
     * @param BuildItem buildItem
     * @param RamActivitiesEnum activitiesEnum
     * @throws ErrorExeption 
     */    
    public BuildItemLogic(BuildItem buildItem, 
        RamActivitiesEnum activitiesEnum) throws ErrorExeption{
        
        BasicMaterialRequired basicMaterialRequired = 
            new BasicMaterialRequired(buildItem.getBpoName(), activitiesEnum);

        requiredItem(buildItem, requiredMaterial,
            basicMaterialRequired.getRequiredMaterialObject().getItemRecursions());
    }    
    
    /**
     * Required Item recursion
     * @param BuildItem buildItem
     * @param NameBase requiredA
     * @param List <NameBase> requiredMaterialRecusions 
     */
    private void requiredItem(BuildItem buildItem, NameBase requiredA, 
        List <NameBase> requiredMaterialRecusions ){

        for (NameBase requiredMaterialRecusion : requiredMaterialRecusions) {
            
            calculateME(buildItem, requiredMaterialRecusion);
            calculateQuantityMaterial();
            addItem(requiredMaterialRecusion);

//            NameBase requiredItemsRecursionA = 
//                new NameBase(requiredMaterialRecusion.getTypeId(), 
//                    requiredMaterialRecusion.getQuanityI(),
//                    requiredMaterialRecusion.getQuanityD());                        
            
            NameBase requiredItemsRecursionA = 
                (NameBase) requiredItemMoreInfo(requiredMaterialRecusion);
            requiredA.addItemRecursions(requiredItemsRecursionA);
            
            if ( !requiredMaterialRecusion.getItemRecursions().isEmpty() ){
                BuildItem buildItemSecondPassage = 
                    getBuildItemSecondPassage(buildItem.getBpoME());
                
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
                    buildItem.getBpoME(), materialRecusion.getQuanityI() );
        }else{
            // T2 component .. componentMe ..
            materialEfficiencyCalculate = new MaterialEfficiencyCalculate
                (buildItem.getRun(), buildItem.getJob(),
                    buildItem.getComponentMe(), materialRecusion.getQuanityI() );
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
     * Required Item More Info
     * @param Object requiredMaterial
     * @return Object
     */
    @Override
    public Object requiredItemMoreInfo(Object requiredMaterial) {
        System.err.print("BuildItemLogic > requiredItemMoreInfo is ENABLE!!!");

        NameBase nameBase = new NameBase(
            ((NameBase)requiredMaterial).getTypeId(), 
            ((NameBase)requiredMaterial).getTypeName(), 
            ((NameBase)requiredMaterial).getQuanityI(), 
            ((NameBase)requiredMaterial).getQuanityD());

        return nameBase;
    }    
    
    /**
     * Sum all value into map
     */
    public Map<String, NameBase> getTotalCalculatedItem(){    
        return reportItem.getTotalCalculatedItem();
    }
}
