/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.industrialShips;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;


/**
 * ADVANCED_INDUSTRIAL_SHIPS(1373)
 * marketGroupID 629 
 * parentGroupID 1385
 * @author lele
 */
public class AdvancedIndustrialShips {
    /**
     * T2 Haulers - TransportShips
     * @return RigRecusion
     */
    public final RigRecusion getTransportShips(){
        RigRecusion transportShips = new RigRecusion(629);
        return transportShips;
    }     
}
