/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.basicRecursionRequired;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.IndustryActivityProducts;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.recursion_object.genericRequiredItem.requiredMaterial.RequiredMaterialV2;


/**
 *
 * @author lele
 */
public class BasicMaterialRequired_LogicV2 < C > 
        extends RequiredMaterialV2 < NameBase, List<IndustryActivityMaterials>, 
                C, InvTypes, IndustryActivityMaterials>{
    
    private RamActivitiesEnum activitiesEnum;
    
    /**
     * Basic Material Required Logic
     * @param String bpoName     
     * @param RamActivitiesEnum activitiesEnum
     * @exception ErrorExeption
     */    
    public BasicMaterialRequired_LogicV2(String bpoName,
            RamActivitiesEnum activitiesEnum) throws ErrorExeption {      
        this.activitiesEnum = activitiesEnum;
        
        // id of item
        InvTypes invTypes = getInvTypesByName(bpoName);
        
        // Item not exits
        if ( invTypes == null )
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.ITEM_NOT_EXITS);        
        
        requiredItem( requiredMaterial, getMaterials(invTypes) );        
    } 

    /**
     * Get Materials
     * @param String bpoName     
     * @return List< IndustryActivityMaterials >
     * @throws ErrorExeption 
     */
    private List< IndustryActivityMaterials > getMaterials (InvTypes invTypes){
 
        // typeId From ProductTypeID
        IndustryActivityProducts typeIdFromProductTypeID = 
            getTypeIdFromProductTypeID(invTypes.getTypeID(), activitiesEnum);
        
        if ( typeIdFromProductTypeID == null)
            return new ArrayList<>();
        
        return getMaterialsID(typeIdFromProductTypeID.getTypeID());
    }
    
    /**
     * Get Materials ID
     * @param int typeID
     * @return List< IndustryActivityMaterials >
     */
    private List< IndustryActivityMaterials > getMaterialsID(int typeID){
        return Manager.getInstance().db().item().industryActivityMaterials().
            getMaterialsID(typeID, activitiesEnum);
    }             
            
    /**
     * Calculate Required Item
     * @param List< IndustryActivityMaterials> materials_
     * @param RequiredMaterialRecusion requiredA_ 
     */
    @Override
    public void requiredItem(NameBase requiredA, List< IndustryActivityMaterials> materials) {
        
        for (IndustryActivityMaterials material : materials) {
            InvTypes invTypes = getInvTypesById(material.getMaterialTypeID());

            // only for dbg, use this for more info on object
            NameBase requiredItemsRecursionA = 
                requiredItemMoreInfo(invTypes, material);

//            NameBase requiredItemsRecursionA = 
//                (NameBase) requiredItemMoreInfo(invTypes, material);
//
            requiredA.addItemRecursions(requiredItemsRecursionA);

            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
                getMaterials(invTypes);
                        
            if (neededComponents != null){
                requiredItem(requiredItemsRecursionA, neededComponents );   
            }
        }    
    }
    
    /**
     * Only for dbg, use this for more info on object
     * @param InvTypes invTypes_
     * @param IndustryActivityMaterials material_
     * @return NameBase
     */
    @Override
    public NameBase requiredItemMoreInfo(InvTypes invTypes, IndustryActivityMaterials material) {
        System.err.print("BasicMaterialRequiredLogic > requiredItemMoreInfo is ENABLE!!!");

        NameBase nameBase = new NameBase(
            invTypes.getTypeID(), 
            invTypes.getTypeName(), 
            material.getQuantity());
        
        return nameBase;
    }     
}