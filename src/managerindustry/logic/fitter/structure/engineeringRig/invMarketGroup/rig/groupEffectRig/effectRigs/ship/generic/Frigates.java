/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;


/**
 * marketGroupID 5 - 1364 
 * parentGroupID 1361
 * @author lele
 */
public class Frigates {
    /**
     * Get Standard Frigates
     * @return RigRecusion_Init
     */     
    public final RigRecusion_Init getStandardFrigates(){
        RigRecusion_Init standardFrigates = new RigRecusion_Init(5);
        return standardFrigates;
    } 
    
    /**
     * Get Advanced Frigates
     * @return RigRecusion_Init
     */     
    public final RigRecusion_Init getAdvancedFrigates(){
        RigRecusion_Init advancedFrigates = new RigRecusion_Init(1364);
        return advancedFrigates;
    }     
}
