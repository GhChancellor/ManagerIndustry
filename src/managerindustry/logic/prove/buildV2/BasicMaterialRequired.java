/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.GenericRequiredItem;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.recursion.ItemRecursionB;
import managerindustry.logic.manager.Manager;

/**
 * Calculate required Material
 * @author lele
 */
public class BasicMaterialRequired extends GenericRequiredItem{
    private RequiredMaterialRecusion requiredMaterial = new RequiredMaterialRecusion();
    
    /**
     * 
     * @param String bpoName
     * @param int run <<---- controllare se si può mettere in byte
     * @param int job <<---- controllare se si può mettere in byte
     * @param byte bpoME
     * @param byte componentMe 
     */    
    public BasicMaterialRequired(String bpoName, int run, int job, byte bpoME, 
        byte componentMe, RamActivitiesEnum activitiesEnum) throws ErrorExeption {
        
        bpoName += " blueprint";
        
        InvTypes invTypes = getInvTypesByName(bpoName);
        if ( invTypes == null )
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.ITEM_NOT_EXITS);

        // list material to build an item
        List< IndustryActivityMaterials> materials = 
            Manager.getInstance().db().item().industryActivityMaterials().getMaterialsID(invTypes.getTypeID(), activitiesEnum);
        
        calculateRequiredItem(materials, requiredMaterial, activitiesEnum);        
    }

    /**
     * calculate Required Item
     * @param List <IndustryActivityMaterials> materials
     * @param RequiredMaterialRecusion requiredA
     * @param RamActivitiesEnum activitiesEnum 
     */
    @Override
    protected void calculateRequiredItem(List materials, Object requiredA, RamActivitiesEnum activitiesEnum) {        
        for (Object material : materials) {
            
            IndustryActivityMaterials material_ = (IndustryActivityMaterials) material;
            RequiredMaterialRecusion requiredA_ = (RequiredMaterialRecusion) requiredA; 
            
            InvTypes invTypes = getInvTypesById(material_.getMaterialTypeID());
            
            RequiredMaterialRecusion requiredItemsRecursionA = 
                new RequiredMaterialRecusion(invTypes.getTypeID(), invTypes.getTypeName(), material_.getQuantity());
//                new RequiredMaterialRecusion(invTypes.getTypeName(), materialList.getQuantity());       

            requiredA_.addRecursionB02(new ItemRecursionB(requiredItemsRecursionA));
            
            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);

            if (neededComponents != null)
                calculateRequiredItem(neededComponents, requiredItemsRecursionA, activitiesEnum);            
        }        
    }
    
    /**
     * Display BaseMaterial Required
     */
    public void displayBasicMaterialRequired(){
        displayRequiredItem(requiredMaterial, " ");        
    }  
    
    /**
     * Display Required Item
     * @param RequiredMaterialRecusion requiredItemA
     * @param String tab 
     */
    @Override
    protected void displayRequiredItem(Object requiredItemA, String tab) {
        RequiredMaterialRecusion requiredItemA_ = (RequiredMaterialRecusion) requiredItemA;
        
        System.out.println(tab + requiredItemA_.getTypeID() + " " + 
            requiredItemA_.getTypeName()+ " " + 
            requiredItemA_.getQuantity()+ " - " +
            requiredItemA_.getQuanityDbl());
        
        tab +="\t";
        
        for (ItemRecursionB requiredItem : requiredItemA_.getRecursionB02s()) {
            displayRequiredItem((RequiredMaterialRecusion) requiredItem.getRecursionA02(), tab);
        }                
    }
    
    public RequiredMaterialRecusion getRequiredMaterial(){
        return (RequiredMaterialRecusion) getRequiredItem();
    }
    
    /**
     *Get Required Items
     * @return RequiredMaterialRecusion
     */
    @Override
    protected Object getRequiredItem() {
        return requiredMaterial;
    }
    
}
