/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.solarSystem;

import managerindustry.db.entities.InvNames;
import managerindustry.logic.manager.managerDB.ManagerDB;

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
        InvNames invNames = ManagerDB.getInstance().invNames().getSolarSystemID(solarSystemName);
        return invNames.getItemID();
    }
    
//    public static String getSolarSystemName(int solarSystemID){
//        
//    }
    
}
