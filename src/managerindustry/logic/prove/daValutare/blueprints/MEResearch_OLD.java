/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.daValutare.blueprints;

import managerindustry.db.entities.eve.IndustryActivity;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 * @author lele
 */
public class MEResearch_OLD {
    /**
     * Get ME Research
     * @param int typeID
     * @return IndustryActivity
     */
    public IndustryActivity getMEResearch(int typeID){
        IndustryActivity industryActivity = 
          Manager.getInstance().managerDB().industryActivity().getIndustryActivity(typeID, RamActivitiesEnum.RESEARCHING_MATERIAL_EFFICIENCY);
        return industryActivity;
    }     
}
