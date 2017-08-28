/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.cache;

import managerindustry.logic.manager.rule.ManagerCache.ManagerSystemCostIndex;
import java.util.Map;
import managerindustry.logic.manager.rule.ManagerCache.ManagerAdjustedPrice;
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.AdjustedPrice;
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.XXXAdjustedPrice;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SystemCostIndex;

/**
 *
 * @author lele
 */
public class MainManagerCache {
    public static void main(String[] args) {
//        SystemCostIndex systemCostIndex = new SystemCostIndex();
//        Map<String, SolarSystem > solarSystemMap = systemCostIndex.getSystemCostIndexs();
        
//        ManagerSystemCostIndex managerSystemCostIndex = 
//         new ManagerSystemCostIndex(solarSystemMap, "1");
//        System.out.println(""+ managerSystemCostIndex.getCostIndex(solarSystemMap, "1", "manufacturing"));
//        
//        ManagerSystemCostIndex managerSystemCostIndex2 = 
//         new ManagerSystemCostIndex(solarSystemMap, "2");
//        System.out.println(""+managerSystemCostIndex2.getCostIndex(solarSystemMap, "1", "researching_time_efficiency"));
//
//        ManagerSystemCostIndex managerSystemCostIndex3 = 
//         new ManagerSystemCostIndex(solarSystemMap, "3" );
//        System.out.println(""+ managerSystemCostIndex3.getCostIndex(solarSystemMap, "3", "copying"));
    
    
        XXXAdjustedPrice adjustedPrice = new XXXAdjustedPrice();
        Map<String, AdjustedPrice > adjustedPriceMap = adjustedPrice.getAdjustedPrice();
        
        ManagerAdjustedPrice managerAdjustedPrice = new ManagerAdjustedPrice("32780", adjustedPriceMap);
        System.out.println(""+managerAdjustedPrice.getAdjustedPriceEntity("32780", adjustedPriceMap));
    }
}
