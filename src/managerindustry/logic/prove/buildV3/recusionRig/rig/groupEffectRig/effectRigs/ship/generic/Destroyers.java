/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3.recusionRig.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.prove.buildV3.recusionRig.safe.RigRecusion;


/**
 * marketGroupID 464 - 1373 - 1951
 * parentGroupID 1372
 * @author lele
 */
public class Destroyers {
    /**
     * Get Standard Destroyers
     * @return RigRecusion
     */
    public final RigRecusion getStandardDestroyers(){
        RigRecusion standardDestroyers = new RigRecusion(464);
        return standardDestroyers;
    } 
    
    /**
     * Get Advanced Destroyers
     * @return RigRecusion
     */
    public final RigRecusion getAdvancedDestroyers(){
        // Init RigRecusion Exclude some branches 
        RigRecusion advancedDestroyers = new RigRecusion(1373, 1951); //1951 Exclude T3 Destroyers
        return advancedDestroyers;
    } 
    
    /**
     * Get T3 Destroyers
     * @return RigRecusion
     */    
    public final RigRecusion getT3Destroyers(){
        RigRecusion t3Destroyers = new RigRecusion(1951); // <----
        return t3Destroyers;
    }     
}
