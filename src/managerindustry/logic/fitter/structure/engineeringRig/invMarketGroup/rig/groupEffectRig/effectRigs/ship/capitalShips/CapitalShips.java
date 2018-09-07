/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.capitalShips;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;


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
     * @return RigRecusion_Init
     */
    public final RigRecusion_Init getJumpFreighters(){
        RigRecusion_Init jumpFreighters = new RigRecusion_Init(1089); 
        return jumpFreighters;
    }
    
    /**
     * Get Freighters
     * @return RigRecusion_Init
     */
    public final RigRecusion_Init getFreighters(){
        RigRecusion_Init jumpFreighters = new RigRecusion_Init(766); 
        return jumpFreighters;
    }
    
    /**
     * Get Dreadnoughts
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getDreadnoughts(){
        RigRecusion_Init dreadnoughts = new RigRecusion_Init(761); 
        return dreadnoughts;
    }

    /**
     * Get Titans
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getTitans(){
        RigRecusion_Init titans = new RigRecusion_Init(812); 
        return titans;
    }
    
    /**
     * Get Carriers
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getCarriers(){
        RigRecusion_Init carriers = new RigRecusion_Init(817); 
        return carriers;
    }
    
    /**
     * Get Force Auxiliaries
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getForceAuxiliaries(){
        RigRecusion_Init forceAuxiliaries = new RigRecusion_Init(2271); 
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
