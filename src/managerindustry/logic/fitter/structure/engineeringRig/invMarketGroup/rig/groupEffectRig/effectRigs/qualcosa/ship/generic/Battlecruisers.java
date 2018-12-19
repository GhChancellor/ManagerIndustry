/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.old.RigRecusion_Init;

/**
 * marketGroupID 469 - 822
 * parentGroupID 1374
 * @author lele
 */
public class Battlecruisers {
    
    /**
     * Get Standard Battlecruisers
     * @return RigRecusion_Init
     */
    public final RigRecusion_Init getStandardBattlecruisers(){
        RigRecusion_Init standardBattlecruisers = new RigRecusion_Init(469);       
        return standardBattlecruisers;
    } 
    
    /**
     * Get Advanced Battlecruisers
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getAdvancedBattlecruisers(){
        RigRecusion_Init advancedBattlecruisers = new RigRecusion_Init(822);
        return advancedBattlecruisers;
    }     
}
