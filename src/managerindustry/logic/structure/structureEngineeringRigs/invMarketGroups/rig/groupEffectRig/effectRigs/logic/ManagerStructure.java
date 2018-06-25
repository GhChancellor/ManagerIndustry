/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.logic;

import java.util.List;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 *
 * @author lele
 */
public class ManagerStructure {
    private StructureRig structureRig;

    public ManagerStructure(int typeId, List < ItemRecusion > effectRigs) {
        structureRig = new StructureRig(typeId, effectRigs );  
        addEffectRigs();
    }

    /**
     * Add Effect Rigs to DB
     */
    private void addEffectRigs(){
        ManagerDB.getInstance().effectRig().addEffectRigs(structureRig);        
    }
}
