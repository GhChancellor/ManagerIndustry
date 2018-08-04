/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.structureEquipment;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;

/**
 * marketGroupID 2202 
 * parentGroupID null
 * @author lele
 */
public class StructureEquipment {
    /**
     * Get Structure Equipment / Structure modules
     * @return RigRecusion
     */     
    public final RigRecusion getStructureEquipment(){
        RigRecusion structureEquipment = new RigRecusion(2202); 
        return structureEquipment;
    }     
}
