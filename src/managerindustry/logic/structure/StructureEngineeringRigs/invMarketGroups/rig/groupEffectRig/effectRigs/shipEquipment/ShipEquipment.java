/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.shipEquipment;

import managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * marketGroupID 9 
 * parentGroupID null
 * @author lele
 */
public class ShipEquipment {
    /**
     * Get ship Equipments / ship modules
     * @return ItemRecusion
     */     
    public final ItemRecusion getshipEquipments(){
        ItemRecusion shipEquipment = new ItemRecusion(9);
        return shipEquipment;
    }    
}
