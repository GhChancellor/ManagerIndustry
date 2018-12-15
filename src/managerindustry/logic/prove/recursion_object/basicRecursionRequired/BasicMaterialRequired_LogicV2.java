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
public class BasicMaterialRequired_LogicV2 extends RequiredMaterialV2{
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
        
        requiredItem( getMaterials(invTypes), requiredMaterial);        
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
        
        return getMaterialsID_(typeIdFromProductTypeID.getTypeID());
    }
    
    /**
     * @deprecated trova un nome
     * getMaterialsID_
     * @param int typeID
     * @return List< IndustryActivityMaterials >
     */
    private List< IndustryActivityMaterials > getMaterialsID_(int typeID){
        return Manager.getInstance().db().item().industryActivityMaterials().
            getMaterialsID(typeID, activitiesEnum);
    }             
            
    /**
     * Calculate Required Item
     * @param List< IndustryActivityMaterials> materials_
     * @param RequiredMaterialRecusion requiredA_ 
     */
    @Override
    public void requiredItem(Object materials, Object requiredA) {
        
        for (IndustryActivityMaterials material : (List< IndustryActivityMaterials>) materials) {
            InvTypes invTypes = getInvTypesById(material.getMaterialTypeID());
        
//            NameBase requiredItemsRecursionA = 
//                new NameBase(
//                    invTypes.getTypeID(), material.getQuantity()); 

            // only for dbg, use this for more info on object
            NameBase requiredItemsRecursionA = 
                (NameBase) requiredItemMoreInfo(invTypes, material);

            ((NameBase) requiredA).addItemRecursions(requiredItemsRecursionA);
            
            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
                getMaterials(invTypes);
                        
            if (neededComponents != null){
                requiredItem(neededComponents, requiredItemsRecursionA);   
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
    public Object requiredItemMoreInfo(Object invTypes, Object material) {
        System.err.print("BasicMaterialRequiredLogic > requiredItemMoreInfo is ENABLE!!!");

        NameBase nameBase = 
            new NameBase(
                ((InvTypes)invTypes).getTypeID(), 
                ((InvTypes)invTypes).getTypeName(), 
                ((IndustryActivityMaterials)material).getQuantity());
        
        return nameBase;
    }     
}