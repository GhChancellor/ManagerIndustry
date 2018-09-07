/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.manufacture_research.components.outpostComponent;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;

/**
 * Structure components
 * marketGroupID 1865
 * parentGroupID 1035
 * @author lele
 */
public class OutpostComponent {
    /**
     * Get Station Components for Citadel, Engineering Complexes, Refineries
     * @return RigRecusion_Init
     */     
    public final RigRecusion_Init getStationComponents(){
        RigRecusion_Init stationComponents = new RigRecusion_Init(1865); 
        return stationComponents;
    }     
}
