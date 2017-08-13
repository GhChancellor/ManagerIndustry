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
public class ManagerSystemCostIndex {

    public ManagerSystemCostIndex(String solarSystemID) {
        SystemCostIndex systemCostIndex = new SystemCostIndex();
        
        Map<String, SolarSystem > solarSystemMap = systemCostIndex.getSystemCostIndexs();
    }
    
}
