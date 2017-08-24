/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.Map;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SystemCostIndex;

/**
 *
 * @author lele
 */
public class MainManagerSystemCost {
    public static void main(String[] args) {
        SystemCostIndex systemCostIndex = new SystemCostIndex();
        Map<String, SolarSystem > solarSystemMap = systemCostIndex.getSystemCostIndexs();
        
//        ManagerSystemCostIndex managerSystemCostIndex = 
//         new ManagerSystemCostIndex(solarSystemMap, "111", "manufacturing");

        ManagerSystemCostIndex managerSystemCostIndex2 = 
         new ManagerSystemCostIndex(solarSystemMap, "2", "manufacturing");

//        ManagerSystemCostIndex managerSystemCostIndex3 = 
//         new ManagerSystemCostIndex(solarSystemMap, "3", "manufacturing");
    }
}
