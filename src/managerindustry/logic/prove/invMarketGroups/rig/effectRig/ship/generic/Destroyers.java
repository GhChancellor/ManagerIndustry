/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic;

import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * marketGroupID 464 - 1373 - 1951
 * parentGroupID 1372
 * @author lele
 */
public class Destroyers {
    /**
     * Get Standard Destroyers
     * @return ItemRecusion
     */
    public final ItemRecusion getStandardDestroyers(){
        ItemRecusion standardDestroyers = new ItemRecusion(464);
        return standardDestroyers;
    } 
    
    /**
     * Get Advanced Destroyers
     * @return ItemRecusion
     */
    public final ItemRecusion getAdvancedDestroyers(){
        // Init ItemRecusion Exclude some branches 
        ItemRecusion advancedDestroyers = new ItemRecusion(1373, 1951); //1951 Exclude T3 Destroyers
        return advancedDestroyers;
    } 
    
    /**
     * Get T3 Destroyers
     * @return ItemRecusion
     */    
    public final ItemRecusion getT3Destroyers(){
        ItemRecusion t3Destroyers = new ItemRecusion(1951); // <----
        return t3Destroyers;
    }     
}
