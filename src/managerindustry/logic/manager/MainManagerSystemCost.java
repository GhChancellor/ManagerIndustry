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
        
        ManagerSystemCostIndex managerSystemCostIndex = 
         new ManagerSystemCostIndex(solarSystemMap, "1");
        System.out.println(""+ managerSystemCostIndex.getCostIndex("1", "manufacturing"));
        
        ManagerSystemCostIndex managerSystemCostIndex2 = 
         new ManagerSystemCostIndex(solarSystemMap, "2");
        System.out.println(""+managerSystemCostIndex2.getCostIndex("2", "researching_time_efficiency"));

        ManagerSystemCostIndex managerSystemCostIndex3 = 
         new ManagerSystemCostIndex(solarSystemMap, "3" );
        System.out.println(""+ managerSystemCostIndex3.getCostIndex("3", "copying"));
    }
}
