/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig;

import managerindustry.logic.generic.recursion.ItemRecursionA;

/**
 *
 * @author lele
 */
public class RigMarketGroup extends ItemRecursionA {
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

    public short getMarketGroupID() {
        return marketGroupID;
    }

    public short getParentGroupID() {
        return parentGroupID;
    }

    public String getMarketGroupName() {
        return marketGroupName;
    }
        
}
