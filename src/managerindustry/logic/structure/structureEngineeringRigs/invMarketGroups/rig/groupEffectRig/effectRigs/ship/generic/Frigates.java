/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * marketGroupID 5 - 1364 
 * parentGroupID 1361
 * @author lele
 */
public class Frigates {
    /**
     * Get Standard Frigates
     * @return ItemRecusion
     */     
    public final ItemRecusion getStandardFrigates(){
        ItemRecusion standardFrigates = new ItemRecusion(5);
        return standardFrigates;
    } 
    
    /**
     * Get Advanced Frigates
     * @return ItemRecusion
     */     
    public final ItemRecusion getAdvancedFrigates(){
        ItemRecusion advancedFrigates = new ItemRecusion(1364);
        return advancedFrigates;
    }     
}
