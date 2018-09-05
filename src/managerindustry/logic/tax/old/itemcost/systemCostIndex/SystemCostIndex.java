/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.old.itemcost.systemCostIndex;

import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.Manager;

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
        return Manager.getInstance().game().systemCost().getCostIndexEntity(solarSystemID, actvity);
    }

    /**
     * @deprecated 
     * @param solarSystemID
     * @param actvity
     * @return
     * @throws SolarSystemNotExistsException 
     */
    public static float SystemCostIndexDBG(String solarSystemID, String actvity) throws SolarSystemNotExistsException{
        return Manager.getInstance().game().systemCost().getCostIndexEntityDBG(solarSystemID, actvity, false);
    }
}
