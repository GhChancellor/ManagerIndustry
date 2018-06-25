/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.daValutare.blueprints;

import managerindustry.db.entities.IndustryActivity;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 * @author lele
 */
public class Copy_OLD {
    /**
     * Get Copy_OLD
     * @param int typeID
     * @return IndustryActivity
     */
    public IndustryActivity getCopy(int typeID){
        IndustryActivity industryActivity = 
          ManagerDB.getInstance().industryActivity().getIndustryActivity(typeID, RamActivitiesEnum.COPYING);
        return industryActivity;
    }  
}
