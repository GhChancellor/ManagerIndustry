/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.runMain;

import java.util.Map;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.manager.build.ManagerBuild;
import managerindustry.logic.manager.managerCache.ManagerSystemCostIndex;
import managerindustry.logic.manager.managerDB.ManagerDBEve;
import managerindustry.logic.solarSystem.SolarSystem;
import managerindustry.logic.tax.jobInstallationFee.JobInstallationFee;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystemCost;

/**
 * MN Civilian Afterburner 1 = 3ISK, 2 = 7Isk  
 * Sotrentaira
 * @author lele
 */
public class ManagerJobInstallationFee {
    public static void main(String[] args) throws SolarSystemNotExistsException, PriceNotExistsException {
        String solarSystemID = String.valueOf( SolarSystem.getSolarSystemID("Sotrentaira") );
        System.out.println("Id Solar system "+ solarSystemID);
        // String item = "1MN Civilian Afterburner";
        String item = "Ferox";
        
        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(item);
        System.out.println(""+ item + " " +invTypes.getTypeID());
        
        ManagerBuild managerBuild = new ManagerBuild();
        managerBuild.buildItem(item + " blueprint", 10, 1,10, 0);
        Map<String,TotalCalculatedComponentX> totalCalculatedComponentXMap =
         ManagerComponentX.getInstance().getTotalcalculatedComponentXMap();
        
        System.out.println("-------------------------------");
//        
        JobInstallationFee jobInstallationFee = new JobInstallationFee(solarSystemID, "manufacturing", totalCalculatedComponentXMap);
        System.out.println(""+ jobInstallationFee.getJobInstallationFee());
    }
}
