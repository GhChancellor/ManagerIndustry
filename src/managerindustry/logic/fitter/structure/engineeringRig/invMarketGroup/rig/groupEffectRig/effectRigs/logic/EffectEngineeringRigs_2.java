/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic;

import java.util.List;
import managerindustry.db.entities.cache.EffectEngineeringRigEntity;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;
import managerindustry.logic.manager.Manager;
//import managerindustry.logic.prove.buildV3.recusionRig.safe.RigRecusion_Init;

/**
 * @author lele
 */
public class EffectEngineeringRigs_2 {
    private EffectEngineeringRigs_1 structureRig;

    public EffectEngineeringRigs_2() {
    }

    /**
     * Effect EngineeringRigs init list List < RigRecusion_Init >
     * @param int typeId 
     * @param List < RigRecusion_Init > effectRigs 
     */
    public EffectEngineeringRigs_2(int typeId, List < RigRecusion_Init > effectRigs) {
        structureRig = new EffectEngineeringRigs_1(typeId, effectRigs );  
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
     * @param int typeID
     * @param int effectID 
     * @return getEffectEngineeringRig
     */
    public EffectEngineeringRigEntity getEffectEngineeringRig(int typeID, int effectID){
        return Manager.getInstance().db().item().effectRig().getEffectEngineeringRigEntity(typeID, effectID);
    }
    
    /**
     * Get Effect Rig
     * @param int typeID
     * @return getEffectEngineeringRig
     */
    public EffectEngineeringRigEntity getEffectEngineeringRig(int typeID){
        return Manager.getInstance().db().item().effectRig().getEffectEngineeringRigEntity(typeID);
    }

    
    
}
