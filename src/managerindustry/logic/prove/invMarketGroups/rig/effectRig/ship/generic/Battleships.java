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
public class Battleships {
    public final ItemRecusion getStandardBattleships(){
        ItemRecusion standardBattleships = new ItemRecusion(7);     
        return standardBattleships;
    } 
    
    public final ItemRecusion getAdvancedBattleships (){
        ItemRecusion advancedBattleships = new ItemRecusion(1377);
        return advancedBattleships;
    }     
}
