/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem;

import managerindustry.db.entities.eve.IndustryActivityProducts;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public abstract class AGenericItemRequired < A, B, C, D, E, F, G > 
        implements IGenericItemRequired < A, B, C, D, E, F, G > {    
    
    /**
     * Get InvTypes By Name
     * @param String bpoName
     * @return InvTypes
     */
    public InvTypes getInvTypesByName(String bpoName) {
        return Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName);
    }    
    
    /**
     * Get Inv Types By Id
     * @param typeID
     * @return InvTypes
     */
    public InvTypes getInvTypesById(int typeID){
        return Manager.getInstance().db().item().invTypes().getInvTypesById(typeID);
    }
    
    /**
     * Get typeId from ProductTypeID ( from item blueprint to item )
     * From scimitar blueprint to scimitar ( ship ) 
     * @param InvTypes invTypes     
     * @return IndustryActivityProducts
     */
    public IndustryActivityProducts getTypeIdFromProductTypeID(
            int typeID, RamActivitiesEnum activitiesEnum){
        
        return Manager.getInstance().db().item().industryActivityProducts().
            getTypeID_ByProductId_ByActivityId(typeID, activitiesEnum);
    }
    
    /**
     * Get ProductTypeID from typeID ( from item to item blueprint )
     * From scimitar ( ship ) to scimitar blueprint
     * @param InvTypes invTypes     
     * @return IndustryActivityProducts
     */
    public IndustryActivityProducts getProductTypeID(
            int typeID, RamActivitiesEnum activitiesEnum){        
        
        return Manager.getInstance().db().item().industryActivityProducts().
            getProductTypeID_ByTypeID_ByActivityID(typeID, activitiesEnum);
    }     

}
