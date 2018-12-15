/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;


/**
 * marketGroupID 464 - 1373 - 1951
 * parentGroupID 1372
 * @author lele
 */
public class Destroyers {
    /**
     * Get Standard Destroyers
     * @return RigRecusion_Init
     */
    public final RigRecusion_Init getStandardDestroyers(){
        RigRecusion_Init standardDestroyers = new RigRecusion_Init(464);
        return standardDestroyers;
    } 
    
    /**
     * Get Advanced Destroyers
     * @return RigRecusion_Init
     */
    public final RigRecusion_Init getAdvancedDestroyers(){
        // Init RigRecusion_Init Exclude some branches 
        RigRecusion_Init advancedDestroyers = new RigRecusion_Init(1373, 1951); //1951 Exclude T3 Destroyers
        return advancedDestroyers;
    } 
    
    /**
     * Get T3 Destroyers
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getT3Destroyers(){
        RigRecusion_Init t3Destroyers = new RigRecusion_Init(1951); // <----
        return t3Destroyers;
    }     
}
