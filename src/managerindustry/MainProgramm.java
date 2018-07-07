/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry;

import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.enumName.PlatformEnum;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.gui.display.DisplaySpeculation;
import managerindustry.logic.manager.ManagerBuild;
import managerindustry.logic.manager.ManagerComponentX;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.solarSystem.SolarSystem;
import managerindustry.logic.gui.display.DisplayItemCost;
import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;

/**
 *
 * @author lele
 */
public class MainProgramm {

    public static void main(String[] args) throws SolarSystemNotExistsException, PriceNotExistsException {
        buildItem(); // << controllare
//        jobInstallationFee();
//        speculation(); // << controllare
//        recursionItems();
//        structure();
    }
    
    public static void buildItem(){
         // Scythe  scimitar   R.A.M.- Starship Tech   CONCORD 25000mm Steel Plates
        // riporta sempre le quantità calcolate non quelle base
        //  drake
        // 	Tritanium 2500001 -> 2500001
	// Pyerite 612071 -> 612071
        ManagerBuild managerBuild = new ManagerBuild("drake", 1, 1, 1, 0);         
    }
    
    /**
     * MN Civilian Afterburner 1 = 3ISK, 2 = 7Isk  
     * Sotrentaira
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */
    public static void jobInstallationFee() throws SolarSystemNotExistsException, PriceNotExistsException{
        String solarSystemID = String.valueOf( SolarSystem.getSolarSystemID("Sobaseki") ); // Sotrentaira 30001369// Isanamo 30001389
        System.out.println("Id Solar system "+ solarSystemID);
        
        // String item = "1MN Civilian Afterburner";

//        String item = "Hammerhead I";
        String item = "Punisher";
        
        int typeID = ManagerDB.getInstance().invTypes().getInvTypesByName(item).getTypeID();
        System.out.println(""+ item + " ID: " + typeID );
        
        int run = 662;
        int job = 1;
        int bpoME = 5;
        int componentMe = 0;
        float taxRateStation = 0.1f;
        int runPerCopy = 5;
        int startLevel = 5;
        int finishLevel = 10;
        ManagerBuild managerBuildX1 = 
                new ManagerBuild(item, run, job, bpoME, componentMe);
                        
        Map < String, ReportCalculatedComponentX > reportCalculatedComponentXMap = 
         ManagerComponentX.getInstance().getReportCalculatedComponentXMap();
               
        DisplayItemCost.calculateJobInstallationCost
         (reportCalculatedComponentXMap, solarSystemID, "manufacturing",
          run, taxRateStation);
        
        DisplayItemCost.calculateCopingFee
         (reportCalculatedComponentXMap, solarSystemID, "copying", 
          run, taxRateStation, runPerCopy);
        
        DisplayItemCost.calculateResearchCosts
         (reportCalculatedComponentXMap, solarSystemID, "researching_time_efficiency", 
          run, taxRateStation, startLevel, finishLevel);

        DisplayItemCost.calculateResearchCosts
         (reportCalculatedComponentXMap, solarSystemID, "researching_material_efficiency", 
          run, taxRateStation, startLevel, finishLevel);        
    }
    
    public static void speculation(){
        DisplaySpeculation speculation = new DisplaySpeculation();
    }
    
    public static void recursionItems(){
//        ItemRecusion advancedBattleships = GroupEffectRig.getInstance().ships().battleships().getAdvancedBattleships();
//        advancedBattleships.display();


    }
    
    public static void structure(){
        EngineeringRig engineeringRig = new EngineeringRig("Standup XL-Set Equipment and Consumable Manufacturing Efficiency II", SecurityStatusEnum.LOW_SEC);
        engineeringRig.displayValue();
        engineeringRig.displayAllValueCalculated();

        System.out.println("");
        
        EngineeringComplex engineeringComplex = new EngineeringComplex(PlatformEnum.RAITARU);
        engineeringComplex.displayValue();        
    }
}
