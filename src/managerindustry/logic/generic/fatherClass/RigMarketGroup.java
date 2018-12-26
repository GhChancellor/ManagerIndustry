/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.fatherClass;

import managerindustry.logic.generic.fatherClass.recursion.ItemRecursion;

/**
 *
 * @author lele
 */
public class RigMarketGroup extends ItemRecursion < RigMarketGroup >{
    private short marketGroupID;
    private short parentGroupID;
    private String marketGroupName;

    public RigMarketGroup(short marketGroupID, short parentGroupID, String marketGroupName) {
        this.marketGroupID = marketGroupID;
        this.parentGroupID = parentGroupID;
        this.marketGroupName = marketGroupName;
    }

    public RigMarketGroup(short marketGroupID, short parentGroupID) {
        this.marketGroupID = marketGroupID;
        this.parentGroupID = parentGroupID;
    }

    public RigMarketGroup() {
    }

    public Short getMarketGroupID() {
        return marketGroupID;
    }

    public short getParentGroupID() {
        return parentGroupID;
    }

    public String getMarketGroupName() {
        return marketGroupName;
    }
        
}
