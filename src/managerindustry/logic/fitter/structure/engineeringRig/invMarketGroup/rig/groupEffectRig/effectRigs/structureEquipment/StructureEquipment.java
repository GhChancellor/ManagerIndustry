/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.structureEquipment;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;

/**
 * marketGroupID 2202 
 * parentGroupID null
 * @author lele
 */
public class StructureEquipment {
    /**
     * Get Structure Equipment / Structure modules
     * @return ItemRecusion
     */     
    public final ItemRecusion getStructureEquipment(){
        ItemRecusion structureEquipment = new ItemRecusion(2202); 
        return structureEquipment;
    }     
}
