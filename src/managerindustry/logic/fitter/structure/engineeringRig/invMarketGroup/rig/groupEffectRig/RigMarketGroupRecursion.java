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
public class RigMarketGroupRecursion extends ItemRecursionA {
    private short marketGroupID;
    private short parentGroupID;
    private String marketGroupName;

    public RigMarketGroupRecursion(short marketGroupID, short parentGroupID, String marketGroupName) {
        this.marketGroupID = marketGroupID;
        this.parentGroupID = parentGroupID;
        this.marketGroupName = marketGroupName;
    }

    public RigMarketGroupRecursion(short marketGroupID, short parentGroupID) {
        this.marketGroupID = marketGroupID;
        this.parentGroupID = parentGroupID;
    }

    public RigMarketGroupRecursion() {
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
