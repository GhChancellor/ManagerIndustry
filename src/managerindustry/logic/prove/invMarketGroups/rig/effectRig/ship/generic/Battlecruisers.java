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
public class Battlecruisers {
    public final ItemRecusion getStandardBattlecruisers(){
        ItemRecusion standardBattlecruisers = new ItemRecusion(469);       
        return standardBattlecruisers;
    } 
    
    public final ItemRecusion getAdvancedBattlecruisers(){
        ItemRecusion advancedBattlecruisers = new ItemRecusion(822);
        return advancedBattlecruisers;
    }     
}
