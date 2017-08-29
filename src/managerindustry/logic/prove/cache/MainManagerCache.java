/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.cache;

import java.util.Map;
import managerindustry.logic.manager.ManagerCache.ManagerPrice;
import managerindustry.logic.manager.ManagerCache.ManagerSystemCostIndex;
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.Price;
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.PriceFetch;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SystemCostFetch;

/**
 *
 * @author lele
 */
public class MainManagerCache {
    public static void main(String[] args) {
//        SystemCostFetch systemCostIndex = new SystemCostFetch();
        Map<String, SolarSystem > solarSystemMap = SystemCostFetch.getSystemCostIndexs();
        
        ManagerSystemCostIndex managerSystemCostIndex = 
         new ManagerSystemCostIndex(solarSystemMap, "1");
        System.out.println(""+ managerSystemCostIndex.getCostIndex(solarSystemMap, "1", "manufacturing"));
//        
//        ManagerSystemCostIndex managerSystemCostIndex2 = 
//         new ManagerSystemCostIndex(solarSystemMap, "2");
//        System.out.println(""+managerSystemCostIndex2.getCostIndex(solarSystemMap, "1", "researching_time_efficiency"));
//
//        ManagerSystemCostIndex managerSystemCostIndex3 = 
//         new ManagerSystemCostIndex(solarSystemMap, "3" );
//        System.out.println(""+ managerSystemCostIndex3.getCostIndex(solarSystemMap, "3", "copying"));
    
    
//        PriceFetch price = new PriceFetch();
        Map<String, Price > priceMap = PriceFetch.getPrice();
        
        ManagerPrice managerAdjustedPrice = new ManagerPrice("32780", priceMap);
        System.out.println(""+managerAdjustedPrice.getAdjustedPriceEntity("32780", priceMap));
        
    }
}
