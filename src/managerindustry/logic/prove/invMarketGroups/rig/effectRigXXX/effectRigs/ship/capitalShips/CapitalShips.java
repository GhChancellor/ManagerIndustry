/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.effectRigs.ship.capitalShips;

import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * 
 * marketGroupID 1089 
 * parentGroupID 1381
 * @author lele
 * 
 * Capital Industrial Ships <-----
 */
public class CapitalShips {
    /**
     * Get Jump Freighters
     * @return ItemRecusion
     */
    public final ItemRecusion getJumpFreighters(){
        ItemRecusion jumpFreighters = new ItemRecusion(1089); 
        return jumpFreighters;
    }
    
    /**
     * Get Freighters
     * @return ItemRecusion
     */
    public final ItemRecusion getFreighters(){
        ItemRecusion jumpFreighters = new ItemRecusion(766); 
        return jumpFreighters;
    }
    
    
    public final ItemRecusion getDreadnoughts(){
        ItemRecusion dreadnoughts = new ItemRecusion(761); 
        return dreadnoughts;
    }
    
    public final ItemRecusion getTitans(){
        ItemRecusion titans = new ItemRecusion(812); 
        return titans;
    }
    
    public final ItemRecusion getCarriers(){
        ItemRecusion carriers = new ItemRecusion(817); 
        return carriers;
    }
    
    public final ItemRecusion getForceAuxiliaries(){
        ItemRecusion forceAuxiliaries = new ItemRecusion(2271); 
        return forceAuxiliaries;
    }
    

    public CapitalIndustrialShips getCapitalIndustrialShips(){
        CapitalIndustrialShips capitalIndustrialShips = new CapitalIndustrialShips();
        return capitalIndustrialShips;
    }
    
}
