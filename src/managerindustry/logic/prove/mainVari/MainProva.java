/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.mainVari;

import java.util.Map;
import managerindustry.logic.apiEsiJson.ApiEsi;
import managerindustry.logic.apiEsiJson.industry.listSolarSystemCostIndices.ListSolarSystemCostIndices;
import managerindustry.logic.apiEsiJson.industry.listSolarSystemCostIndices.SolarSystemCost;
import managerindustry.logic.manager.ManagerBuild;
import managerindustry.logic.manager.ManagerSkill;
import managerindustry.logic.prove.buildItem.BuildItem;
import managerindustry.logic.skill.SkillX;
import managerindustry.logic.skill.specificSkill.BrokerFee;

/**
 *
 * @author lele
 */
public class MainProva {
    public static void main(String[] args) {
//        BuildItem buildItem = new BuildItem("scimitar", 2, 2, 10, 10);
//        buildItem.xxx2();

        ManagerBuild managerBuild = new ManagerBuild("scimitar", 1, 1, 10, 10);
    }
}
