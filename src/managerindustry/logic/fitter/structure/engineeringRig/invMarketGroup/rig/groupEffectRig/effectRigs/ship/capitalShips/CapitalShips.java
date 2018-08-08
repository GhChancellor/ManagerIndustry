/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.capitalShips;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;


/**
 * 
 * marketGroupID 1089 - 766 - 761 - 812 - 817 - 2271
 * parentGroupID 1381
 * @author lele
 * 
 * Capital Industrial Ships <-----
 */
public class CapitalShips {
    /**
     * Get Jump Freighters
     * @return RigRecusion
     */
    public final RigRecusion getJumpFreighters(){
        RigRecusion jumpFreighters = new RigRecusion(1089); 
        return jumpFreighters;
    }
    
    /**
     * Get Freighters
     * @return RigRecusion
     */
    public final RigRecusion getFreighters(){
        RigRecusion jumpFreighters = new RigRecusion(766); 
        return jumpFreighters;
    }
    
    /**
     * Get Dreadnoughts
     * @return RigRecusion
     */    
    public final RigRecusion getDreadnoughts(){
        RigRecusion dreadnoughts = new RigRecusion(761); 
        return dreadnoughts;
    }

    /**
     * Get Titans
     * @return RigRecusion
     */    
    public final RigRecusion getTitans(){
        RigRecusion titans = new RigRecusion(812); 
        return titans;
    }
    
    /**
     * Get Carriers
     * @return RigRecusion
     */    
    public final RigRecusion getCarriers(){
        RigRecusion carriers = new RigRecusion(817); 
        return carriers;
    }
    
    /**
     * Get Force Auxiliaries
     * @return RigRecusion
     */    
    public final RigRecusion getForceAuxiliaries(){
        RigRecusion forceAuxiliaries = new RigRecusion(2271); 
        return forceAuxiliaries;
    }
    
    /**
     * Capital Industrial Ships
     * @return CapitalIndustrialShips
     */
    public CapitalIndustrialShips getCapitalIndustrialShips(){
        CapitalIndustrialShips capitalIndustrialShips = new CapitalIndustrialShips();
        return capitalIndustrialShips;
    }
    
}
