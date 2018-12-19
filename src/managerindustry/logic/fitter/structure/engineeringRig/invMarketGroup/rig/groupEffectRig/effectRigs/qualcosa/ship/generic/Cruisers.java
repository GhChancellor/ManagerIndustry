/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.old.RigRecusion_Init;

/**
 * marketGroupID 6 - 1368 - 1138
 * parentGroupID 1367 
 * @author lele
 */
public class Cruisers {
    /**
     * Get Standard Cruisers
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getStandardCruisers(){
        RigRecusion_Init standardCruisers = new RigRecusion_Init(6);
        return standardCruisers;
    } 
    
    /**
     * Get Advanced Cruisers exclude T3 Strategic cruiser
     * @return RigRecusion_Init
     */
    public final RigRecusion_Init getAdvancedCruisers(){
        // Init RigRecusion_Init exclude T3 Strategic cruiser
        RigRecusion_Init advancedCruisers = new RigRecusion_Init(1368, 1138); // 1138 T3 Strategic cruiser
        
        return advancedCruisers;
    } 
    
    /**
     * Get T3 Strategic cruiser
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getT3Cruisers(){
        RigRecusion_Init t3Cruisers = new RigRecusion_Init(1138); // <----
        return t3Cruisers;
    }     
}
