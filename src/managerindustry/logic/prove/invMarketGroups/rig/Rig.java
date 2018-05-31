/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig;

import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class Rig{
    private String typeName;
    private String description;
    private int typeID;

    public Rig() {
    }

    public Rig(int typeID) {
        InvTypes invTypes = ManagerDB.getInstance().invTypes().getNameById(typeID);
        this.typeID = invTypes.getTypeID();
        this.typeName = invTypes.getTypeName();
    }

    public String getTypeName() {
        return typeName;
    }

    public int getTypeID() {
        return typeID;
    }
        
}
