/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;


/**
 * marketGroupID 5 - 1364 
 * parentGroupID 1361
 * @author lele
 */
public class Frigates {
    /**
     * Get Standard Frigates
     * @return RigRecusion
     */     
    public final RigRecusion getStandardFrigates(){
        RigRecusion standardFrigates = new RigRecusion(5);
        return standardFrigates;
    } 
    
    /**
     * Get Advanced Frigates
     * @return RigRecusion
     */     
    public final RigRecusion getAdvancedFrigates(){
        RigRecusion advancedFrigates = new RigRecusion(1364);
        return advancedFrigates;
    }     
}
