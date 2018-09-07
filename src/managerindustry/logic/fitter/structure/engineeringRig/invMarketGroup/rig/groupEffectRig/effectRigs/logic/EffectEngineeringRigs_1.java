/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;


/**
 * @deprecated 
 * Trova un nome decente
 * @author lele
 */
public class EffectEngineeringRigs_1 {
    private int typeID;
    private List < RigRecusion_Init > itemRecusions = new ArrayList<>();    

    public EffectEngineeringRigs_1() {
    }

    /**
     * Add rig and add Effect
     * @param int typeId
     * @param List < RigRecusion_Init > itemRecusions 
     */    
    public EffectEngineeringRigs_1(int typeID, List < RigRecusion_Init > rigRecusion) {
        this.typeID = typeID;
        this.itemRecusions = rigRecusion;
    }

    public EffectEngineeringRigs_1(int typeID) {
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
    public List<RigRecusion_Init> getRigRecusions() {
        return itemRecusions;
    }        
}
