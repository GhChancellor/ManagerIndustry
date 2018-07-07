/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;

/**
 * marketGroupID 469 - 822
 * parentGroupID 1374
 * @author lele
 */
public class Battlecruisers {
    
    /**
     * Get Standard Battlecruisers
     * @return ItemRecusion
     */
    public final ItemRecusion getStandardBattlecruisers(){
        ItemRecusion standardBattlecruisers = new ItemRecusion(469);       
        return standardBattlecruisers;
    } 
    
    /**
     * Get Advanced Battlecruisers
     * @return ItemRecusion
     */    
    public final ItemRecusion getAdvancedBattlecruisers(){
        ItemRecusion advancedBattlecruisers = new ItemRecusion(822);
        return advancedBattlecruisers;
    }     
}
