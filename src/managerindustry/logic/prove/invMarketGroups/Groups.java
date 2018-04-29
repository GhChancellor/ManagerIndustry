/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups;

import java.util.List;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.logic.manager.old.managerDB.ManagerDBEve_OLD;

/**
 *
 * @author lele
 */
public class Groups {

    public Groups() {
        InvMarketGroups marketGroupID = ManagerDBEve_OLD.getInstance().getInvMarketGroups_marketGroupID(1372);
        
        List < InvMarketGroups > parentGroupIDs = ManagerDBEve_OLD.getInstance().getInvMarketGroups_parentGroupID(marketGroupID.getMarketGroupID());
        
        parentGroupIDs.forEach((t) -> {
            System.out.println(""+ t.getMarketGroupName());
        });
    }
    
}
