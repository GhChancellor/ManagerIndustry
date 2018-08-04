/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;


/**
 * marketGroupID 874 - 494 
 * parentGroupID 1384
 * @author lele
 */
public class MiningBarges {
    /**
     * Get Exhumers
     * @return RigRecusion
     */     
    public final RigRecusion getExhumers(){
        RigRecusion exhumers = new RigRecusion(874);
        return exhumers;
    } 
    
    /**
     * Get Mining Barges
     * @return RigRecusion
     */     
    public final RigRecusion getMiningBarges(){
        RigRecusion miningBarges = new RigRecusion(494);
        return miningBarges;
    }     
}
