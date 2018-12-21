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
 * @author lele
 */
public class EffectEngineeringRig {
    private int rigTypeID;
    private List < RigRecusion_Init > itemRecusions = new ArrayList<>();    

    public EffectEngineeringRig() {
    }

    /**
     * Add rig and add Effect
     * @param int typeId
     * @param List < RigRecusion_Init > itemRecusions 
     */    
    public EffectEngineeringRig(int rigTypeID, List < RigRecusion_Init > rigRecusion) {
        this.rigTypeID = rigTypeID;
        this.itemRecusions = rigRecusion;
    }

    public EffectEngineeringRig(int rigTypeID) {
        this.rigTypeID = rigTypeID;
    }
    
    /**
     * Get TypeID
     * @return int
     */
    public int getRigTypeID() {
        return rigTypeID;
    }

    /**
     * Get RigRecusions
     * @return List<RigRecusion>
     */
    public List<RigRecusion_Init> getRigRecusions() {
        return itemRecusions;
    }        
}
