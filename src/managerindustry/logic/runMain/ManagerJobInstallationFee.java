/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.runMain;

import java.util.Map;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.SingleCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.manager.ManagerBuild;
import managerindustry.logic.manager.managerDB.ManagerDBEve;
import managerindustry.logic.solarSystem.SolarSystem;
import managerindustry.logic.tax.formulas.vecchio.jobInstallationCost.JobInstallationCost;

/**
 * MN Civilian Afterburner 1 = 3ISK, 2 = 7Isk  
 * Sotrentaira
 * @author lele
 */
public class ManagerJobInstallationFee {
    public static void main(String[] args) throws SolarSystemNotExistsException, PriceNotExistsException {
        String solarSystemID = String.valueOf( SolarSystem.getSolarSystemID("Isanamo") ); // Sotrentaira 30001369// Isanamo 30001389
        System.out.println("Id Solar system "+ solarSystemID);
        
        // String item = "1MN Civilian Afterburner";
        String item = "Dominix";
        
        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(item);
        System.out.println(""+ item + " " +invTypes.getTypeID());
        
        ManagerBuild managerBuild = new ManagerBuild();
                                                //  run Job  meBPO  MeComponent
        managerBuild.buildItem(item + " blueprint", 10, 10  , 10  ,  0);
        Map<String, SingleCalculatedComponentX> singleCalculatedComponentXMap =
         ManagerComponentX.getInstance().getSingleCalculatedComponentXMap();
        
        System.out.println("-------------------------------");
//      

//        MainItemCost mainItemCost = new MainItemCost();
//        mainItemCost.calculateJobInstallationCost(totalCalculatedComponentXMap, solarSystemID, "manufacturing", 0.1f);

        JobInstallationCost jobInstallationFee = new JobInstallationCost(solarSystemID, "manufacturing", singleCalculatedComponentXMap);
        System.out.println(""+ jobInstallationFee.getJobInstallationFee());
    }
}
