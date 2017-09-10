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
import managerindustry.logic.manager.build.ManagerBuild;
import managerindustry.logic.tax.formulas.itemcost.json.adjustedPrices.Price;
import managerindustry.logic.tax.formulas.itemcost.json.adjustedPrices.PriceFetch;
import managerindustry.logic.tax.formulas.itemcost.json.systemCostIndices.SolarSystemCost;
import managerindustry.logic.tax.formulas.itemcost.json.systemCostIndices.SystemCostFetch;

/**
 *
 * @author lele
 */
public class ManagerCache {

    public ManagerCache() {
        Map<String, SolarSystemCost > solarSystemMap = SystemCostFetch.getSystemCostIndexs();
        Map<String, Price > priceFetchMap = PriceFetch.getPrice();
        
//        ManagerBuild managerBuild = new ManagerBuild();
//        managerBuild.buildItem("scimitar Blueprint");
//        
//        List<ComponentX> componentXs =
//         ManagerComponentX.getInstance().getBaseComponentXs();
        
    }
    
}
