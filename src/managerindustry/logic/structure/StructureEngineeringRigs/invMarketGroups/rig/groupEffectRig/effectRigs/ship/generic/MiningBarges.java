/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * marketGroupID 874 - 494 
 * parentGroupID 1384
 * @author lele
 */
public class MiningBarges {
    /**
     * Get Exhumers
     * @return ItemRecusion
     */     
    public final ItemRecusion getExhumers(){
        ItemRecusion exhumers = new ItemRecusion(874);
        return exhumers;
    } 
    
    /**
     * Get Mining Barges
     * @return ItemRecusion
     */     
    public final ItemRecusion getMiningBarges(){
        ItemRecusion miningBarges = new ItemRecusion(494);
        return miningBarges;
    }     
}
