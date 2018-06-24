/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * marketGroupID 7 - 1377 
 * parentGroupID 1376
 * @author lele
 */
public class Battleships {
    /**
     * Get Standard Battleships
     * @return ItemRecusion
     */
    public final ItemRecusion getStandardBattleships(){
        ItemRecusion standardBattleships = new ItemRecusion(7);     
        return standardBattleships;
    } 
    
    /**
     * Get Advanced Battleships
     * @return ItemRecusion
     */    
    public final ItemRecusion getAdvancedBattleships (){
        ItemRecusion advancedBattleships = new ItemRecusion(1377);
        return advancedBattleships;
    }     
}
