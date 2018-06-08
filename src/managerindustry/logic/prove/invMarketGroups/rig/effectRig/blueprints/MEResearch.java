/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig.blueprints;

import managerindustry.db.entities.IndustryActivity;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 * marketGroupID  
 * parentGroupID 
 * @author lele
 */
public class MEResearch {
    public IndustryActivity getMEResearch(int typeID){
        IndustryActivity industryActivity = 
          ManagerDB.getInstance().industryActivity().getIndustryActivity(typeID, RamActivitiesEnum.RESEARCHING_MATERIAL_EFFICIENCY);
        return industryActivity;
    }     
}
