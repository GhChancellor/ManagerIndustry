/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.immondizia;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.build.buildItem.BuildItem;
import managerindustry.logic.build.buildItem.BuildItemRequired;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.itemcost.DisplayItemCost;
import managerindustry.logic.tax.itemcost.logic.ItemCost.ItemCostBase;
import managerindustry.logic.solarSystem.SolarSystem;

/**
 *
 * @author lele
 */
public class Immondizia_001 <T> {
    List < Integer > duplicate = new ArrayList<>();
    
    public Immondizia_001() throws ErrorExeption{
//        rigRucursion();
//        chooseRig();
//        immondizia2();
    }    
           
    public void rigRucursion(){
        RigRecusion rigRecusion = GroupEffectRig.getInstance().
            t3subsystems().getT3subsystems();

        rigRecusion.display();

    }
    
    
    private void chooseRig(){
        // IMPORTANTE qualche rig crea doppione per dinamiche di gioco, sistemalo
//        ChooseRig chooseRig02 = new ChooseRig(43921);        
        
//        setDublicate();
        // aggiunge un " effectID 0 " da controllare
//        List < RigRecusion > effectRigs = new ArrayList<>();
//        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );
// 
//        for (RigRecusion effectRig : effectRigs) {
//            effectRig.displayRecursion();
//        }
//        EffectEngineeringRigs_2 managerStructure = new EffectEngineeringRigs_2(43921, effectRigs);   

    }
    private void setDublicate(){
        duplicate.add(1138); // Strategic Cruisers
        duplicate.add(1147); // Subsystem Components
        duplicate.add(1951); // Tactical Destroyers    
    }
    
    private static void immondizia2(){
        Immondizia_002 immondizia_002 = new Immondizia_002();
    }
}

