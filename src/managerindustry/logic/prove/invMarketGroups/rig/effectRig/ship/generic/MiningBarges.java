/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic;

import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 *
 * @author lele
 */
public class MiningBarges {
    /**
     * GetExhumers
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
