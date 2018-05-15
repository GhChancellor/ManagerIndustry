/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.old;

import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class ItemClass {
    private String typeName;
    private int marketGroupID;
    private int parentGroupID;

    public ItemClass(String typeName, int marketGroupID, int parentGroupID) {
        this.typeName = typeName;
        this.marketGroupID = marketGroupID;
        this.parentGroupID = parentGroupID;
    }

    public String getTypeName() {
        return typeName;
    }

    public int getMarketGroupID() {
        return marketGroupID;
    }

    public int getParentGroupID() {
        return parentGroupID;
    }

    

    
}
