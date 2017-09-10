/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.runMain;

import java.util.Map;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.build.ManagerBuild;
import managerindustry.logic.manager.managerCache.ManagerPrice;
import managerindustry.logic.manager.managerCache.ManagerSystemCostIndex;
import managerindustry.logic.tax.formulas.itemcost.json.adjustedPrices.Price;
import managerindustry.logic.tax.formulas.itemcost.json.adjustedPrices.PriceFetch;
import managerindustry.logic.tax.formulas.itemcost.json.systemCostIndices.SolarSystemCost;
import managerindustry.logic.tax.formulas.itemcost.json.systemCostIndices.SystemCostFetch;

/**
 * 1MN Civilian Afterburner Blueprint 1 = 3ISK, 2 = 7Isk  
 * Sotrentaira 
 * @author lele
 */
public class MainManagerCache {
    public static void main(String[] args) throws SolarSystemNotExistsException, PriceNotExistsException {
        
//        ManagerSystemCostIndex managerSystemCostIndex = new ManagerSystemCostIndex();
//        ManagerSystemCostIndex.getInstance().getCostIndexEntity("1", "manufacturing");
//        ManagerSystemCostIndex.getInstance().getCostIndexEntity("2", "researching_time_efficiency");
//        ManagerSystemCostIndex.getInstance().getCostIndexEntity("3", "copying");
        
//        ManagerPrice managerPrice = new ManagerPrice();
//        ManagerPrice.getInstance().getAdjustedPriceEntity("32780");
    
//        PriceFetch price = new PriceFetch();
//        Map<String, Price > priceMap = PriceFetch.getPrice();
//        
//        ManagerPrice managerAdjustedPrice = new ManagerPrice("32780", priceMap);
//        System.out.println(""+managerAdjustedPrice.getAdjustedPriceEntity("32780", priceMap));
        
    }
}
