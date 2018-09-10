/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.init;

import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.IndustryActivityProducts;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class InitBaseValue {

    private RamActivitiesEnum activitiesEnum;

    public InitBaseValue(String bpoName, RamActivitiesEnum activitiesEnum) {
        this.activitiesEnum = activitiesEnum;
    }
    
    /**
     * Get Materials
     * @param String bpoName     
     * @return List< IndustryActivityMaterials >
     * @throws ErrorExeption 
     */
    private List< IndustryActivityMaterials > getMaterials(
            String bpoName, RamActivitiesEnum activitiesEnum) throws ErrorExeption{
        
        // id of item
        InvTypes invTypes = getInvTypesByName(bpoName);
        
        // Item not exits
        if ( invTypes == null )
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.ITEM_NOT_EXITS);
        
        // typeId From ProductTypeID ( "scyhte" + " blueprint" )
        IndustryActivityProducts typeIdFromProductTypeID = 
            getTypeIdFromProductTypeID(invTypes);
        
        // list material to build an item
        List< IndustryActivityMaterials > materials = 
            Manager.getInstance().db().item().industryActivityMaterials().
            getMaterialsID(typeIdFromProductTypeID.getTypeID(), activitiesEnum);        
        
        return materials;
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
    
    /**
     * Get InvTypes By Name
     * @param String bpoName
     * @return InvTypes
     */
    public InvTypes getInvTypesByName(String bpoName) {
        return Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName);
    }       
}
