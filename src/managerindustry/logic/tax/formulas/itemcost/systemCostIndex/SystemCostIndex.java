/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.systemCostIndex;

import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.ManagerSystemCostIndex;

/**
 * 
 * @author lele
 */
public class SystemCostIndex {
    /**
     * @param String solarSystemID
     * @param String actvity
     * @return float
     * @throws SolarSystemNotExistsException 
    */
    public static float SystemCostIndex(String solarSystemID, String actvity) throws SolarSystemNotExistsException{
        return ManagerSystemCostIndex.getInstance().getCostIndexEntity(solarSystemID, actvity);
    }

    public static float SystemCostIndexDBG(String solarSystemID, String actvity) throws SolarSystemNotExistsException{
        return ManagerSystemCostIndex.getInstance().getCostIndexEntityDBG(solarSystemID, actvity, false);
    }
}
