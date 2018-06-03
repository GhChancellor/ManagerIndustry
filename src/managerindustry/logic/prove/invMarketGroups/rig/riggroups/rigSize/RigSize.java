/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class RigSize {
    protected List<InvTypes> getInvTypes(List<Integer> rigGroups){
        List<InvTypes> invTypeses = new ArrayList<>();
        for (Integer rigGroup : rigGroups) {
            InvTypes invTypes = ManagerDB.getInstance().invTypes().getInvTypesById(rigGroup);
            invTypeses.add(invTypes);
        }
        return invTypeses;
    }    
}
