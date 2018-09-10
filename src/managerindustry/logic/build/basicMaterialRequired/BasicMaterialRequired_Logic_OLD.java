/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.basicMaterialRequired;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.IndustryActivityProducts;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterial;

/**
 *
 * @author lele
 */
public class BasicMaterialRequired_Logic_OLD extends RequiredMaterial{
    private RamActivitiesEnum activitiesEnum;
    
    /**
     * Basic Material Required Logic
     * @param String bpoName     
     */    
    public BasicMaterialRequired_Logic_OLD(String bpoName,
            RamActivitiesEnum activitiesEnum) throws ErrorExeption {      
        this.activitiesEnum = activitiesEnum;
        
        requiredItem( getMaterials(bpoName), requiredMaterial);        
    } 

    /**
     * Get Materials
     * @param String bpoName     
     * @return List< IndustryActivityMaterials >
     * @throws ErrorExeption 
     */
    private List< IndustryActivityMaterials > getMaterials (String bpoName) 
            throws ErrorExeption{
        
        // id of item
        InvTypes invTypes = getInvTypesByName(bpoName);
        
        // Item not exits
        if ( invTypes == null )
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.ITEM_NOT_EXITS);
        
        // typeId From ProductTypeID
        IndustryActivityProducts typeIdFromProductTypeID = 
            getTypeIdFromProductTypeID(invTypes);
        
        // list material to build an item
        List< IndustryActivityMaterials > materials = 
            Manager.getInstance().db().item().industryActivityMaterials().
            getMaterialsID(typeIdFromProductTypeID.getTypeID(), activitiesEnum);        
        
        return materials;
    }
    
    /**
     * 
     * @param InvTypes invTypes     
     * @return List< IndustryActivityMaterials>
     */
    private List< IndustryActivityMaterials> getNeededComponents(
            InvTypes invTypes ){
   
        IndustryActivityProducts productTypeID = getTypeIdFromProductTypeID(invTypes);
        if ( productTypeID == null)
            return new ArrayList<>();
        
        return Manager.getInstance().db().item().industryActivityMaterials().
            getMaterialsID(productTypeID.getTypeID(), activitiesEnum );       
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
                getNeededComponents(invTypes);
                        
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
    
    /**
     * Get typeId from ProductTypeID ( from item blueprint to item )
     * From scimitar blueprint to scimitar ( ship ) 
     * @param InvTypes invTypes     
     * @return IndustryActivityProducts
     */
    private IndustryActivityProducts getTypeIdFromProductTypeID(InvTypes invTypes){
        
        return Manager.getInstance().db().item().industryActivityProducts().
            getTypeID_ByProductId_ByActivityId(invTypes.getTypeID(), activitiesEnum);
    }
    
    /**
     * Get ProductTypeID from typeID ( from item to item blueprint )
     * From scimitar ( ship ) to scimitar blueprint
     * @param InvTypes invTypes     
     * @return IndustryActivityProducts
     */
    private IndustryActivityProducts getProductTypeID(InvTypes invTypes){        
        return Manager.getInstance().db().item().industryActivityProducts().
            getProductTypeID_ByTypeID_ByActivityID(invTypes.getTypeID(), activitiesEnum);
    }    
    
}