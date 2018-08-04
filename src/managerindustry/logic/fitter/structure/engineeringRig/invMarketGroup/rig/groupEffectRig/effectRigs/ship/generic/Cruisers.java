/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;

/**
 * marketGroupID 6 - 1368 - 1138
 * parentGroupID 1367 
 * @author lele
 */
public class Cruisers {
    /**
     * Get Standard Cruisers
     * @return RigRecusion
     */    
    public final RigRecusion getStandardCruisers(){
        RigRecusion standardCruisers = new RigRecusion(6);
        return standardCruisers;
    } 
    
    /**
     * Get Advanced Cruisers exclude T3 Strategic cruiser
     * @return RigRecusion
     */
    public final RigRecusion getAdvancedCruisers(){
        // Init RigRecusion exclude T3 Strategic cruiser
        RigRecusion advancedCruisers = new RigRecusion(1368, 1138); // 1138 T3 Strategic cruiser
        
        return advancedCruisers;
    } 
    
    /**
     * Get T3 Strategic cruiser
     * @return RigRecusion
     */    
    public final RigRecusion getT3Cruisers(){
        RigRecusion t3Cruisers = new RigRecusion(1138); // <----
        return t3Cruisers;
    }     
}
