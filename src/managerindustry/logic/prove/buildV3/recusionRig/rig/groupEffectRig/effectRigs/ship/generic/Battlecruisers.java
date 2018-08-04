/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3.recusionRig.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.prove.buildV3.recusionRig.safe.RigRecusion;

/**
 * marketGroupID 469 - 822
 * parentGroupID 1374
 * @author lele
 */
public class Battlecruisers {
    
    /**
     * Get Standard Battlecruisers
     * @return RigRecusion
     */
    public final RigRecusion getStandardBattlecruisers(){
        RigRecusion standardBattlecruisers = new RigRecusion(469);       
        return standardBattlecruisers;
    } 
    
    /**
     * Get Advanced Battlecruisers
     * @return RigRecusion
     */    
    public final RigRecusion getAdvancedBattlecruisers(){
        RigRecusion advancedBattlecruisers = new RigRecusion(822);
        return advancedBattlecruisers;
    }     
}
