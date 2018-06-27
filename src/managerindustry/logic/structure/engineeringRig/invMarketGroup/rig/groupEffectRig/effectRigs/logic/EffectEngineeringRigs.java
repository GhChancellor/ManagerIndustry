/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic;

import java.util.List;
import managerindustry.db.entities.cache.EffectRigEntity;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;

/**
 * @author lele
 */
public class EffectEngineeringRigs {
    private EffectEngineeringRigsXXX structureRig;

    public EffectEngineeringRigs() {
    }

    public EffectEngineeringRigs(int typeId, List < ItemRecusion > effectRigs) {
        structureRig = new EffectEngineeringRigsXXX(typeId, effectRigs );  
        addEffectRig();
    }

    /**
     * Add Effect Rigs to DB
     */
    private void addEffectRig(){
        ManagerDB.getInstance().effectRig().addEffectRigs(structureRig);        
    }
    
    /**
     * Get Effect Rig and his effect
     * @param int typeID
     * @param int effectID 
     * @return EffectRigEntity
     */
    public EffectRigEntity getEffectRig(int typeID, int effectID){
        return ManagerDB.getInstance().effectRig().getEffectRigEntity(typeID, effectID);
    }
}
