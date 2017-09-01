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
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.Price;
import managerindustry.logic.tax.jobInstallationFee.adjustedPrice.PriceFetch;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SystemCostFetch;

/**
 *
 * @author lele
 */
public class ManagerCache {

    public ManagerCache() {
        Map<String, SolarSystem > solarSystemMap = SystemCostFetch.getSystemCostIndexs();
        Map<String, Price > priceFetchMap = PriceFetch.getPrice();
        
        ManagerBuild managerBuild = new ManagerBuild();
        managerBuild.buildItem("scimitar Blueprint");
        
        List<ComponentX> componentXs =
         ManagerComponentX.getInstance().getBaseComponentXs();
        
    }
    
}
