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
public class Cruisers {
    public final ItemRecusion getStandardCruisers(){
        ItemRecusion standardCruisers = new ItemRecusion(6);
        return standardCruisers;
    } 
    
    /**
     * @deprecated 
     * @return 
     */
    public final ItemRecusion getAdvancedCruisers(){
        ItemRecusion advancedCruisers = new ItemRecusion(1368); // *
        return advancedCruisers;
    } 
    
    public final ItemRecusion getT3Cruisers(){
        ItemRecusion t3Cruisers = new ItemRecusion(1138); // <----
        return t3Cruisers;
    }     
}
