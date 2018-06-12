/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups;

import java.util.List;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.RigDescription;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.StructureRig;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.EffectRig;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.RigGroups;

/**
 *
 * @author lele
 */
public class InvMarketGroup {

    public InvMarketGroup() {

    }
    
    public void xxx(int code){
        List<InvTypes> standupMSetEquipmentManufacturing = RigGroups.getInstance().rigMedium().getStandupMSetEquipmentManufacturing();
        
        for (InvTypes invTypes : standupMSetEquipmentManufacturing) {
            if ( code == invTypes.getTypeID()){
                
            }
        }
    }
    
    
    public StructureRig getStandupMSetEquipmentManufacturing(int code){
        StructureRig structureRig = new StructureRig();
        structureRig.newRigGroups(RigGroups.getInstance().rigMedium().getStandupMSetEquipmentManufacturing());
        
        for (RigDescription rigGroup : structureRig.getRigGroups()) {
            if (code == rigGroup.getTypeID()){
                structureRig.newEffect(EffectRig.getInstance().shipEquipments().getshipEquipments());
                structureRig.newEffect(EffectRig.getInstance().ship_ModuleModifications().rigs().getRigs() );
                structureRig.newEffect(EffectRig.getInstance().deployableStructures().getPersonalDeployables()); // <-- include cargo container
                structureRig.newEffect(EffectRig.getInstance().implantsBoosters().implants().getImplants());
                return structureRig;                
            }
        }
        return null;
    }
    
}
/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/