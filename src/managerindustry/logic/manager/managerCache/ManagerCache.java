/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerCache;

import java.util.List;
import java.util.Map;
import managerindustry.logic.buiild.ComponentX;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.json.tax.json.adjustedPrices.Price;
import managerindustry.logic.json.tax.json.adjustedPrices.PriceFetch;
import managerindustry.logic.json.tax.json.systemCostIndices.SolarSystemCost;
import managerindustry.logic.json.tax.json.systemCostIndices.SystemCostFetch;

/**
 *
 * @author lele
 */
public class ManagerCache {

    public ManagerCache() {
        Map<String, SolarSystemCost > solarSystemMap = SystemCostFetch.getSystemCostIndexs();
        Map<String, Price > priceFetchMap = PriceFetch.getPrice();
        
//        ManagerBuildOLD managerBuild = new ManagerBuildOLD();
//        managerBuild.buildItem("scimitar Blueprint");
//        
//        List<ComponentX> componentXs =
//         ManagerComponentX.getInstance().getBaseComponentXs();
        
    }
    
}
