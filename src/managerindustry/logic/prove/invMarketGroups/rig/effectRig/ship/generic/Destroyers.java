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
public class Destroyers {
    public final ItemRecusion getStandardDestroyers(){
        ItemRecusion standardDestroyers = new ItemRecusion(464);
        return standardDestroyers;
    } 
    
    /**
     * @deprecated 
     * @return 
     */
    public final ItemRecusion getAdvancedDestroyers(){
        ItemRecusion advancedDestroyers = new ItemRecusion(1373); // *
        return advancedDestroyers;
    } 
    
    public final ItemRecusion getT3Destroyers(){
        ItemRecusion t3Destroyers = new ItemRecusion(1951); // <----
        return t3Destroyers;
    }     
}
