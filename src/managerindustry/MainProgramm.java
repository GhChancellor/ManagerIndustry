/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry;

import java.util.Map;
import managerindustry.logic.generic.enumName.PlatformEnum;
import managerindustry.logic.generic.enumName.SecurityStatusEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;

import managerindustry.logic.solarSystem.SolarSystem;
import managerindustry.logic.gui.display.DisplayItemCost;
import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.build.production.basicMaterialRequired.MaterialRequired_Init;
import managerindustry.logic.generic.fatherClass.BuildItem;
import managerindustry.logic.build.production.buildItem.BuildItemRequired_Init;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.generic.fatherClass.ItemCostBase;
import managerindustry.logic.prove.immondizia.Immondizia_001;
import managerindustry.logic.build.skill.requiredSkill.SkillRequired_Init;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.ChooseRig;

/**
 *
 * @author lele
 */
public class MainProgramm {

    public static void main(String[] args) throws SolarSystemNotExistsException, ErrorExeption{
        buildItemV7();
//        basicMaterial();
//        jobInstallationFeeV2(); 
//        speculation();
//        requiredSkill();
//        recursionItems();
// ----------------------------------------

//        structure();
//        immondizia();
//        old();
    }

    /**
     * sopra i 100m di materiale è leggermente impreciso, aumentare la precisione
     * gli arrotandenti devono essere più precisi
     */
    
    public static void buildItemV7(){
        //                                   bpoName   run job   bpoME    componentMe
        BuildItem buildItem = new BuildItem("scimitar",  1, 1, (byte) 10, (byte) 10);        
        
//        Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I
//        Standup XL-Set Equipment and Consumable Manufacturing Efficiency II
        try {
            EngineeringRig engineeringRig = 
                new EngineeringRig(
                "Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I", 
                SecurityStatusEnum.NULL_SEC);
           
            EngineeringComplex engineeringComplex = 
                new EngineeringComplex(PlatformEnum.RAITARU);
            
            BuildItemRequired_Init buildItemRequired = new BuildItemRequired_Init
                (buildItem, RamActivitiesEnum.MANUFACTURING, engineeringComplex, engineeringRig);   
            
            
//            BuildItemRequired_Init buildItemRequired = new BuildItemRequired_Init
//                (buildItem, RamActivitiesEnum.MANUFACTURING, null, null);
            
            buildItemRequired.display();
        } catch (Exception e) {
            System.out.println("errore");
        }          
    }
    
    public static void jobInstallationFeeV2() throws ErrorExeption{
        ItemCostBase itemCostBase = new ItemCostBase();      
        managerindustry.logic.tax.itemcost.DisplayItemCost displayItemCost = new managerindustry.logic.tax.itemcost.DisplayItemCost();
        
        String solarSystemID = String.valueOf( SolarSystem.getSolarSystemID("Sobaseki") ); // Sotrentaira 30001369// Isanamo 30001389
        System.out.println("Id Solar system "+ solarSystemID);
        
        // "1MN Civilian Afterburner", "Hammerhead I, "Punisher"
        //                                    bpoName   run job   bpoME    componentMe
        BuildItem buildItem = new BuildItem("Punisher",  1,  0, (byte) 0, (byte) 0);

        BuildItemRequired_Init buildItemRequired = 
            new BuildItemRequired_Init(buildItem, RamActivitiesEnum.MANUFACTURING, null, null);                        
        
        itemCostBase.setTaxRateStation(0.1f);
        itemCostBase.setRunPerCopy(5);
        itemCostBase.setLevelStar( (byte) 5);
        itemCostBase.setLevelFinish( (byte) 5);
        itemCostBase.setSolarSystemID(solarSystemID);
        // prima esisteva una lista controlla se può servire
//        itemCostBase.setNameBases(buildItemRequired.getList());
        
        itemCostBase.setActivitiesEnum(RamActivitiesEnum.MANUFACTURING);
        displayItemCost.calculateJobInstallationCost(itemCostBase);        
        
        itemCostBase.setActivitiesEnum(RamActivitiesEnum.COPYING);
        displayItemCost.calculateCopyingFees(itemCostBase);
        
        itemCostBase.setActivitiesEnum(RamActivitiesEnum.RESEARCHING_MATERIAL_EFFICIENCY);
        displayItemCost.calculateResearchCost(itemCostBase);        
        
        itemCostBase.setActivitiesEnum(RamActivitiesEnum.RESEARCHING_TIME_EFFICIENCY);
        displayItemCost.calculateResearchCost(itemCostBase);                
    }
    /**
     * 
     */
    public static void recursionItems(){
        ChooseRig chooseRig02 = new ChooseRig(43921);       
        
        System.out.println(""+ chooseRig02.isEffectEngineeringRig(43921,588));

//        RigRecusion_Init rigRecusion = GroupEffectRig.getInstance().
//            t3subsystems().getT3subsystems();
//                
//        rigRecusion.display();

    }
    
    public static void requiredSkill(){
        int typeId = Manager.getInstance().db().item().invTypes().getInvTypesByName("Scimitar blueprint").getTypeID();
        
        SkillRequired_Init required_Init = new SkillRequired_Init(
            typeId, RamActivitiesEnum.MANUFACTURING);            
        required_Init.display();
    }
    
    public static void structure() throws ErrorExeption{
        EngineeringRig engineeringRig = 
            new EngineeringRig(
            "Standup XL-Set Equipment and Consumable Manufacturing Efficiency II", 
            SecurityStatusEnum.LOW_SEC);
        
        engineeringRig.displayValue();
        engineeringRig.displayAllValueCalculated();

        System.out.println("");
        
        EngineeringComplex engineeringComplex = new EngineeringComplex(PlatformEnum.RAITARU);
        engineeringComplex.displayAllValueCalculated();        

    }

    public static void basicMaterial(){
        try {
            MaterialRequired_Init buildItemRequired = 
                new MaterialRequired_Init("scimitar", RamActivitiesEnum.MANUFACTURING); 
            buildItemRequired.display();
            
        } catch (ErrorExeption e) {
            System.out.println(""+ e.getErrorEnum());  
        }
    }
        
    public static void speculation(){
        managerindustry.logic.tax.speculation.DisplaySpeculation displaySpeculation = 
            new managerindustry.logic.tax.speculation.DisplaySpeculation();
    }
    
    public static void immondizia() throws ErrorExeption{
        Immondizia_001 immondizia_001 = new Immondizia_001();
    }    
    
    // *****************************************************************************
    
    /**
     * @deprecated 
     * old check before delete it
     */
    public static void old(){
        System.out.println("*****************************************************************************\n");
//        jobInstallationFee_OLD(); // << controllare funziona male
    }         
        
    /**
     * @deprecated 
     * MN Civilian Afterburner 1 = 3ISK, 2 = 7Isk  
     * Sotrentaira
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */
    public static void jobInstallationFee_OLD() throws SolarSystemNotExistsException, ErrorExeption{
//        String solarSystemID = String.valueOf( SolarSystem.getSolarSystemID("Sobaseki") ); // Sotrentaira 30001369// Isanamo 30001389
//        System.out.println("Id Solar system "+ solarSystemID);
//        
//        // String item = "1MN Civilian Afterburner";
//
////        String item = "Hammerhead I";
//        String item = "Punisher";
//        
//        int typeID = Manager.getInstance().db().item().invTypes().getInvTypesByName(item).getTypeID();
//        System.out.println(""+ item + " ID: " + typeID );
//        
//        int run = 1;
//        int job = 0;
//        byte bpoME = 0;
//        byte componentMe = 0;
//        float taxRateStation = 0.1f;
//        int runPerCopy = 5;
//        int startLevel = 5;
//        int finishLevel = 10;
//        Build_OLD managerBuildX1 = 
//                new Build_OLD(item, run, job, bpoME, componentMe);
//                        
//        Map < String, ReportCalculatedComponentX > reportCalculatedComponentXMap = 
//         ManagerComponentX.getInstance().getReportCalculatedComponentXMap();
//               
//        DisplayItemCost.calculateJobInstallationCost
//         (reportCalculatedComponentXMap, solarSystemID, "manufacturing",
//          run, taxRateStation);
//        
//        DisplayItemCost.calculateCopingFee
//         (reportCalculatedComponentXMap, solarSystemID, "copying", 
//          run, taxRateStation, runPerCopy);
//        
//        DisplayItemCost.calculateResearchCosts
//         (reportCalculatedComponentXMap, solarSystemID, "researching_time_efficiency", 
//          run, taxRateStation, startLevel, finishLevel);
//
//        DisplayItemCost.calculateResearchCosts
//         (reportCalculatedComponentXMap, solarSystemID, "researching_material_efficiency", 
//          run, taxRateStation, startLevel, finishLevel);        
    }    
    
}
