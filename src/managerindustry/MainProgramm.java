/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry;

import java.util.Map;
import managerindustry.logic.build.ReportCalculatedComponentX;
import managerindustry.logic.generic.enumName.PlatformEnum;
import managerindustry.logic.generic.enumName.SecurityStatusEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.gui.display.DisplaySpeculation;
import managerindustry.logic.manager.game.build.Build;
import managerindustry.logic.manager.game.build.ManagerComponentX;
import managerindustry.logic.solarSystem.SolarSystem;
import managerindustry.logic.gui.display.DisplayItemCost;
import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.ChooseRig;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.immondizia.Immondizia_001;

/**
 *
 * @author lele
 */
public class MainProgramm {

    public static void main(String[] args) throws SolarSystemNotExistsException, ErrorExeption{
//        buildItem(); // << controllare
//        jobInstallationFee(); << controllare funziona male
//        speculation(); // << controllare funziona male
//        recursionItems();
//        structure();
        immondizia();
    }
    
    public static void buildItem(){
         // Scythe  scimitar   R.A.M.- Starship Tech   CONCORD 25000mm Steel Plates
        // riporta sempre le quantità calcolate non quelle base
        //  drake
        // 	Tritanium 2500001 -> 2500001
	// Pyerite 612071 -> 612071
        Build managerBuild = new Build("scimitar", 1,  1, (byte)0, (byte) 0);         
    }
    
    /**
     * MN Civilian Afterburner 1 = 3ISK, 2 = 7Isk  
     * Sotrentaira
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */
    public static void jobInstallationFee() throws SolarSystemNotExistsException, ErrorExeption{
        String solarSystemID = String.valueOf( SolarSystem.getSolarSystemID("Sobaseki") ); // Sotrentaira 30001369// Isanamo 30001389
        System.out.println("Id Solar system "+ solarSystemID);
        
        // String item = "1MN Civilian Afterburner";

//        String item = "Hammerhead I";
        String item = "Punisher";
        
        int typeID = Manager.getInstance().db().item().invTypes().getInvTypesByName(item).getTypeID();
        System.out.println(""+ item + " ID: " + typeID );
        
        int run = 662;
        int job = 1;
        byte bpoME = 5;
        byte componentMe = 0;
        float taxRateStation = 0.1f;
        int runPerCopy = 5;
        int startLevel = 5;
        int finishLevel = 10;
        Build managerBuildX1 = 
                new Build(item, run, job, bpoME, componentMe);
                        
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
    
    /**
     * @deprecated 
     */
    public static void recursionItems(){
//        RigRecusion rigRecusion = GroupEffectRig.getInstance().
//            t3subsystems().getT3subsystems();
//                
//        rigRecusion.displayRecursion();
        
        // IMPORTANTE qualche rig crea doppione per dinamiche di gioco, sistemalo
//        ChooseRig chooseRig02 = new ChooseRig(43921);

    }
    
    public static void structure() throws ErrorExeption{
        EngineeringRig engineeringRig = new EngineeringRig("Standup XL-Set Equipment and Consumable Manufacturing Efficiency II", SecurityStatusEnum.LOW_SEC);
        engineeringRig.displayValue();
        engineeringRig.displayAllValueCalculated();

        System.out.println("");
        
        EngineeringComplex engineeringComplex = new EngineeringComplex(PlatformEnum.RAITARU);
        engineeringComplex.displayValue();        
    }
    
    public static void immondizia(){
        Immondizia_001 immondizia_001 = new Immondizia_001();
//        immondizia_001.buildItem();
    }
}
