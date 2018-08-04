/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.shipEquipment;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;


/**
 * marketGroupID 9 
 * parentGroupID null
 * @author lele
 */
public class ShipEquipment {
    /**
     * Get ship Equipments / ship modules
     * @return RigRecusion
     */     
    public final RigRecusion getshipEquipments(){
        RigRecusion shipEquipment = new RigRecusion(9);
        return shipEquipment;
    }    
}
