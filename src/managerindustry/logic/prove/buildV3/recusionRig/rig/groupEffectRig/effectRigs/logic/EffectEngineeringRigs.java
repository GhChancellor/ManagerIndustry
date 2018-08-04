/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3.recusionRig.rig.groupEffectRig.effectRigs.logic;

import java.util.List;
import managerindustry.db.entities.cache.EffectEngineeringRigEntity;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.buildV3.recusionRig.safe.RigRecusion;

/**
 * @author lele
 */
public class EffectEngineeringRigs {
    private EffectEngineeringRigsXXX02 structureRig;

    public EffectEngineeringRigs() {
    }

    public EffectEngineeringRigs(int typeId, List < RigRecusion > effectRigs) {
        structureRig = new EffectEngineeringRigsXXX02(typeId, effectRigs );  
        addEffectRig();
    }

    /**
     * Add Effect Rigs to DB
     */
    private void addEffectRig(){
        Manager.getInstance().db().item().effectRigX2().addEffectRigs(structureRig);        
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
