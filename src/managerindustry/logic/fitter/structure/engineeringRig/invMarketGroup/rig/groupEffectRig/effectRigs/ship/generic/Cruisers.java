/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;

/**
 * marketGroupID 6 - 1368 - 1138
 * parentGroupID 1367 
 * @author lele
 */
public class Cruisers {
    /**
     * Get Standard Cruisers
     * @return ItemRecusion
     */    
    public final ItemRecusion getStandardCruisers(){
        ItemRecusion standardCruisers = new ItemRecusion(6);
        return standardCruisers;
    } 
    
    /**
     * Get Advanced Cruisers exclude T3 Strategic cruiser
     * @return ItemRecusion
     */
    public final ItemRecusion getAdvancedCruisers(){
        // Init ItemRecusion exclude T3 Strategic cruiser
        ItemRecusion advancedCruisers = new ItemRecusion(1368, 1138); // 1138 T3 Strategic cruiser
        
        return advancedCruisers;
    } 
    
    /**
     * Get T3 Strategic cruiser
     * @return ItemRecusion
     */    
    public final ItemRecusion getT3Cruisers(){
        ItemRecusion t3Cruisers = new ItemRecusion(1138); // <----
        return t3Cruisers;
    }     
}
