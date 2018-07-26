/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.daValutare.blueprints;

import managerindustry.db.entities.eve.IndustryActivity;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.manager.db.Db;

/**
 * @author lele
 */
public class TEResearch_OLD {
    /**
     * Get TE Research
     * @param int typeID
     * @return IndustryActivity
     */
    public IndustryActivity getTEResearch(int typeID){
        IndustryActivity industryActivity = 
          Manager.getInstance().db().item().industryActivity().getIndustryActivity(typeID, RamActivitiesEnum.RESEARCHING_TIME_EFFICIENCY);
        return industryActivity;
    }        
}
