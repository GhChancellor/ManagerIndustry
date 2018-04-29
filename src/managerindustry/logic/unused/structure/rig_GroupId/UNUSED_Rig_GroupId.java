/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.unused.structure.rig_GroupId;

import java.util.HashMap;
import java.util.Map;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.old.managerDB.ManagerDBEve_OLD;

/**
 * il tipo rig id  groupID controllare il gruop ID della drake 
 * drake > groupID
 * 
 * Standup M-Set basic medium ship manufacturing material efficiency I
 * Standup M-Set Basic Medium Ship Manufacturing Time Efficiency I
 * groupID 419 Battlecruiser Drake
 * groupID 631 cruiser shythe
 * groupID 28 industrial Bestower
 * groupID 463 mining bardges
 * @author lele
 */
public class UNUSED_Rig_GroupId {
    private int rig;
    private int gruop;

    public UNUSED_Rig_GroupId() {
    }

    public UNUSED_Rig_GroupId(int rig, int gruop) {
        this.rig = rig;
        this.gruop = gruop;
    }

    public int getRig() {
        return rig;
    }

    public int getGroup() {
        return gruop;
    }

    public void setRig(int rig) {
        this.rig = rig;
    }

    public void setGruop(int gruop) {
        this.gruop = gruop;
    }

    
}


//        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName("Standup M-Set Basic Large Ship Manufacturing Time Efficiency II");
//        System.out.println("Group "+ invTypes.getGroupID());
//        System.out.println("Id " + invTypes.getTypeID()

/*

*/