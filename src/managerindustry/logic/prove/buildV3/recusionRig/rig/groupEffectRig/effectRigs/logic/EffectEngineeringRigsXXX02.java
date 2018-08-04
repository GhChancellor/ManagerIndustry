/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3.recusionRig.rig.groupEffectRig.effectRigs.logic;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.prove.buildV3.recusionRig.safe.RigRecusion;


/**
 * @deprecated 
 * Trova un nome decente
 * @author lele
 */
public class EffectEngineeringRigsXXX02 {
    private int typeID;
    private List < RigRecusion > rigRecusions = new ArrayList<>();    

    /**
     * Add rig and add Effect
     * @param int typeId
     * @param List < RigRecusion > itemRecusions 
     */    
    public EffectEngineeringRigsXXX02(int typeID, List < RigRecusion > rigRecusions) {
        this.typeID = typeID;
        this.rigRecusions = rigRecusions;
    }

    public EffectEngineeringRigsXXX02(int typeID) {
        this.typeID = typeID;
    }
    
    /**
     * Get TypeID
     * @return int
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Get RigRecusions
     * @return List<RigRecusion>
     */
    public List<RigRecusion> getRigRecusions() {
        return rigRecusions;
    }    
}
