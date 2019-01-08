/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.buildItem;


import java.util.List;
import managerindustry.logic.build.production.basicMaterialRequired.MaterialRequired_Init;

import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.BuildItem;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterial;
import managerindustry.logic.build.production.efficiency.MaterialEfficiency;
import org.eclipse.persistence.internal.queries.ReportItem;

/**
 *
 * @author lele
 */
public class BuildItem_Logic < E, G > extends 
        RequiredMaterial < NameBase, List <NameBase>, BuildItem, NameBase, E, NameBase, G > {
    
    private MaterialEfficiency materialEfficiency = 
        new MaterialEfficiency();

    private int baseQuantity;;
    private int singleMaterialQuantity;
    private long totalMaterialQuantity;
    private ReportItem reportItem = new ReportItem();
    private EngineeringRig engineeringRig;
    private EngineeringComplex engineeringComplex;
    
    /**
     * Buld Item Logic
     * @param BuildItem buildItem
     * @param RamActivitiesEnum activitiesEnum
     * @throws ErrorExeption 
     */    
    public BuildItem_Logic(BuildItem buildItem, 
        RamActivitiesEnum activitiesEnum, EngineeringComplex engineeringComplex,
        EngineeringRig engineeringRig ) throws ErrorExeption{
        
        this.engineeringComplex = engineeringComplex;
        this.engineeringRig = engineeringRig;
        
        MaterialRequired_Init basicMaterialRequired = 
            new MaterialRequired_Init(buildItem.getBpoName(), activitiesEnum);
        
        requiredItem(requiredMaterial, 
            basicMaterialRequired.getRequiredMaterialObject().getItemRecursions(), 
            buildItem);
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
        /*
            private MaterialEfficiency materialEfficiencyCalculate = 
                new MaterialEfficiency( (byte) 0 , 1f, 1f, 1f);
        */
        
        if ( materialRecusion.getItemRecursions().isEmpty()){
            // T1 material .. bpoME ..
            materialEfficiency = new MaterialEfficiency(
                buildItem, true, materialRecusion, engineeringComplex, engineeringRig);
         
        }else{
            // T2 component .. componentMe ..
            materialEfficiency = new MaterialEfficiency(
                buildItem, false, materialRecusion, engineeringComplex, engineeringRig);
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
        /* base Quantity */
        baseQuantity = materialEfficiency.getBaseQuantity();
        
        /* quantity material per single item 1 run */
        singleMaterialQuantity = materialEfficiency.getSingleItemQuantity();
           
        /* quantity material per all items 1 run */
        totalMaterialQuantity = 
            materialEfficiency.getTotalItemsQuantity();      
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
      
}
