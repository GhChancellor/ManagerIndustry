/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.init;

import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.IndustryActivityProducts;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class InitBaseValue {

    private RamActivitiesEnum activitiesEnum;

    public InitBaseValue(String bpoName, RamActivitiesEnum activitiesEnum) {
        this.activitiesEnum = activitiesEnum;
    }
     
}
