/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.solarSystem;

import managerindustry.db.entities.eve.InvNames;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.Manager;

/**
 * Name and ID of solar system, moon etc
 * @author lele
 */
public class SolarSystem {

    public SolarSystem() {
    }
    
    /** 
     * Get solar system ID
     * @return int
     */
    public static int getSolarSystemID(String solarSystemName){
        InvNames invNames = Manager.getInstance().db().item().invNames().getSolarSystemID(solarSystemName);
        return invNames.getItemID();
    }
    
    /**
     * @param String solarSystemID
     * @param String actvity
     * @return float
     * @throws SolarSystemNotExistsException 
    */
    public static float SystemCostIndex(String solarSystemID, String actvity) throws SolarSystemNotExistsException{
        return Manager.getInstance().game().systemCost().getCostIndexEntity(solarSystemID, actvity);
    }
    
}
