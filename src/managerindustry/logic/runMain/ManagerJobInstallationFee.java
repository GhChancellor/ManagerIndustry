/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.runMain;

import java.util.Map;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.manager.managerDB.ManagerDBEve;
import managerindustry.logic.manager.ManagerBuild;
import managerindustry.logic.solarSystem.SolarSystem;
import managerindustry.logic.tax.formulas.itemcost.MainItemCost;

/**
 * MN Civilian Afterburner 1 = 3ISK, 2 = 7Isk  
 * Sotrentaira
 * @author lele
 */
public class ManagerJobInstallationFee {
    public static void main(String[] args) throws SolarSystemNotExistsException, PriceNotExistsException {
        String solarSystemID = String.valueOf( SolarSystem.getSolarSystemID("Sobaseki") ); // Sotrentaira 30001369// Isanamo 30001389
        System.out.println("Id Solar system "+ solarSystemID);
        
        // String item = "1MN Civilian Afterburner";

//        String item = "Hammerhead I";
        String item = "Hammerhead I";
        
        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(item);
        System.out.println(""+ item + " ID: " +invTypes.getTypeID());
        
        int run = 1;
        int job = 1;
        int bpoME = 10;
        int componentMe = 0;
        float taxRateStation = 0.1f;
        int runPerCopy = 1;
        int startLevel = 0;
        int finishLevel = 10;
        ManagerBuild managerBuildX1 = 
                new ManagerBuild(item, run, job, bpoME, componentMe);
                        
        Map < String, ReportCalculatedComponentX > reportCalculatedComponentXMap = 
         ManagerComponentX.getInstance().getReportCalculatedComponentXMap();

        MainItemCost mainItemCost = new MainItemCost();
        
        mainItemCost.calculateJobInstallationCost
         (reportCalculatedComponentXMap, solarSystemID, "manufacturing",
          run, taxRateStation);
        mainItemCost.calculateCopingFee
         (reportCalculatedComponentXMap, solarSystemID, "copying", 
          run, taxRateStation, runPerCopy);
        
        mainItemCost.calculateResearchCosts
         (reportCalculatedComponentXMap, solarSystemID, "researching_material_efficiency", 
          run, taxRateStation, startLevel, finishLevel);
        
        mainItemCost.calculateResearchCosts
         (reportCalculatedComponentXMap, solarSystemID, "researching_time_efficiency", 
          run, taxRateStation, startLevel, finishLevel);
        

    }
}
