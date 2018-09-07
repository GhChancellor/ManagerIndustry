/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.shipEquipment;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;


/**
 * marketGroupID 9 
 * parentGroupID null
 * @author lele
 */
public class ShipEquipment {
    /**
     * Get ship Equipments / ship modules
     * @return RigRecusion_Init
     */     
    public final RigRecusion_Init getshipEquipments(){
        RigRecusion_Init shipEquipment = new RigRecusion_Init(9);
        return shipEquipment;
    }    
}
