/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry;

import managerindustry.logic.prove.ricorsione.skill.*;
import managerindustry.logic.manager.ManagerBuild;
import managerindustry.logic.prove.buildItem.BuildItem;
import managerindustry.logic.prove.ricorsione.buildItemRecursion.BuildItemRecusion;
import managerindustry.logic.prove.ricorsione.skill.skillProduction.SkillProduction;
import managerindustry.logic.prove.ricorsione.skill.skillProduction.qualcosa.SkillProva;

/**
 *
 * @author lele
 */
public class Main02 {
    public static void main(String[] args) {
//        SkillProduction skillProduction = new SkillProduction();

        BuildItemRecusion buildItemRecusion = new BuildItemRecusion("scimitar", 1, 1, 10, 1);
        
//        ManagerBuild managerBuild = new ManagerBuild("scimitar", 1, 1, 10, 1);
        
    }
}
