/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship_ModuleModifications;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;

/**
 * marketGroupID 1112 
 * parentGroupID 955
 * @author lele
 */
public class Subsystems {
    /**
     * Get T3 subsystems
     * @return RigRecusion
     */     
    public final RigRecusion getT3subsystems(){
        RigRecusion t3Subsystems = new RigRecusion(1112); 
        return t3Subsystems;
    }     
}
