/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.basicMaterialRequired;

import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.nameBase.NameBase;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterial;

/**
 *
 * @author lele
 */
public class BasicMaterialRequiredLogic extends RequiredMaterial{
    /**
     * Basic Material Required Logic
     * @param String bpoName
     * @param RamActivitiesEnum activitiesEnum
     */    
    public BasicMaterialRequiredLogic(String bpoName, RamActivitiesEnum activitiesEnum)
            throws ErrorExeption {
        
        bpoName += " blueprint";
        
        InvTypes invTypes = getInvTypesByName(bpoName);
        if ( invTypes == null )
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.ITEM_NOT_EXITS);

        // list material to build an item
        List< IndustryActivityMaterials> materials = 
            Manager.getInstance().db().item().industryActivityMaterials().getMaterialsID(invTypes.getTypeID(), activitiesEnum);

        requiredItem(materials, requiredMaterial, activitiesEnum);        
    } 

    /**
     * Calculate Required Item
     * @param List< IndustryActivityMaterials> materials_
     * @param RequiredMaterialRecusion requiredA_
     * @param RamActivitiesEnum activitiesEnum_ 
     */
    @Override
    public void requiredItem(Object materials, Object requiredA, Object activitiesEnum) {
        
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
                getNeededComponents(invTypes, ( RamActivitiesEnum ) activitiesEnum);
                        
            if (neededComponents != null)
                requiredItem(neededComponents, requiredItemsRecursionA, ( RamActivitiesEnum ) activitiesEnum);   
        }    
    }

    /**
     * 
     * @param InvTypes invTypes
     * @param RamActivitiesEnum activitiesEnum
     * @return List< IndustryActivityMaterials>
     */
    private List< IndustryActivityMaterials> getNeededComponents(
        InvTypes invTypes, RamActivitiesEnum activitiesEnum ){
        
        return Manager.getInstance().db().item().industryActivityMaterials().    
            getMaterialNeedByName(invTypes.getTypeName() + " blueprint", 
            activitiesEnum);        
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
    
//    /**
//     * Get InvTypes By Name
//     * @param String bpoName
//     * @return InvTypes
//     */
//    public InvTypes getInvTypesByName(String bpoName) {
//        return Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName);
//    }
    
    /**
     * Get InvTypes By Id
     * @param int typeId
     * @return InvTypes
     */
    public InvTypes getInvTypesById(int typeId) {    
        return Manager.getInstance().db().item().invTypes().getInvTypesById(typeId);
    }     
}
