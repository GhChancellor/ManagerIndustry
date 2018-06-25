/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.manufacture_research.components.outpostComponent;

import managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * Structure components
 * marketGroupID 1865
 * parentGroupID 1035
 * @author lele
 */
public class OutpostComponent {
    /**
     * Get Station Components for Citadel, Engineering Complexes, Refineries
     * @return ItemRecusion
     */     
    public final ItemRecusion getStationComponents(){
        ItemRecusion fuelBlocks = new ItemRecusion(1870); 
        return fuelBlocks;
    }     
}
