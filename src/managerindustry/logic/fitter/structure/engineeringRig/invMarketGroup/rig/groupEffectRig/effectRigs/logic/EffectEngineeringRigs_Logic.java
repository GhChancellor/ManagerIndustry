/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic;

import java.util.List;
import managerindustry.db.entities.cache.EffectEngineeringRigEntity;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;
import managerindustry.logic.manager.Manager;
//import managerindustry.logic.prove.buildV3.recusionRig.safe.RigRecusion_Init;

/**
 * @author lele
 */
public class EffectEngineeringRigs_Logic {
    private EffectEngineeringRig structureRig;

    public EffectEngineeringRigs_Logic() {
    }

    /**
     * Effect EngineeringRigs init list List < RigRecusion_Init >
     * @param int rigTypeID 
     * @param List < RigRecusion_Init > effectRigs 
     */
    public EffectEngineeringRigs_Logic(int rigTypeID, List < RigRecusion_Init > effectRigs) {
        structureRig = new EffectEngineeringRig(rigTypeID, effectRigs );  
        addEffectRig();
    }

    /**
     * Add Effect Rigs to DB
     */
    private void addEffectRig(){
        Manager.getInstance().db().item().effectRig().addEffectRigs(structureRig);        
    }
    
    /**
     * Get Effect Rig and his effect
     * @param int rigTypeID
     * @param int effectID_Item 
     * @return getEffectEngineeringRig
     */
    public EffectEngineeringRigEntity getEffectEngineeringRig(int rigTypeID, int effectID_Item){
        InvTypes groupEffectID = 
            Manager.getInstance().db().item().invTypes().getInvTypesById(effectID_Item);

        if (groupEffectID == null || 
            groupEffectID.getMarketGroupID() == null )
                return null;
        
        return Manager.getInstance().db().item().effectRig().
            getEffectEngineeringRigEntity(rigTypeID, groupEffectID.getMarketGroupID());
    }
    
    /**
     * Get Effect Rig
     * @param int rigTypeID
     * @return getEffectEngineeringRig
     */
    public EffectEngineeringRigEntity getEffectEngineeringRig(int rigTypeID){
        return Manager.getInstance().db().item().effectRig().getEffectEngineeringRigEntity(rigTypeID);
    }

    
    
}
