/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.immondizia;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.build.skill.requiredSkill.SkillRequired_Init;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.ChooseRig;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.BuildItem;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.build.production.basicMaterialRequired.MaterialRequired_Init;
import managerindustry.logic.build.production.buildItem.BuildItemRequired_Init;
import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.generic.enumName.PlatformEnum;
import managerindustry.logic.generic.enumName.SecurityStatusEnum;

/**
 *
 * @author lele
 */
public class Immondizia_001 <T> {
    List < Integer > duplicate = new ArrayList<>();
    
    public Immondizia_001() throws ErrorExeption{
        System.out.println("\n\n\n");
        buildItemX();
//        basicMaterialV2();
//        buildItem();
//        rigRucursion();
//        chooseRig();
//        immondizia2();
//        requiredSkill();
    }    
    
    public void buildItemX() {        
        System.out.println("\n\n\n\n");
        //                                   bpoName   run job   bpoME    componentMe
        BuildItem buildItem = new BuildItem("drake",  1, 1, (byte) 0, (byte) 0);        
        
//        Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I
//        Standup XL-Set Equipment and Consumable Manufacturing Efficiency II
        try {
         EngineeringRig engineeringRig = 
            new EngineeringRig(
            "Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I", 
            SecurityStatusEnum.HI_SEC);
           
            EngineeringComplex engineeringComplex = 
                new EngineeringComplex(PlatformEnum.SOTIYO);
            
            managerindustry.logic.build.production.buildItem.BuildItemRequired_Init 
                buildItemRequired = new managerindustry.logic.build.production.buildItem.BuildItemRequired_Init
                (buildItem, RamActivitiesEnum.MANUFACTURING, engineeringComplex, engineeringRig);   
            
            buildItemRequired.display();
        } catch (Exception e) {
            System.out.println("errore");
        }   
        
    }
    
    public void requiredSkill(){
        int typeId = Manager.getInstance().db().item().invTypes().getInvTypesByName("Scimitar blueprint").getTypeID();
        
        SkillRequired_Init required_Init = new SkillRequired_Init(
            typeId, RamActivitiesEnum.MANUFACTURING);            
        required_Init.display();
    }    
    
    public void buildItem(){
        
        System.out.println("\n\n\n\n");
        //                                   bpoName   run job   bpoME    componentMe
        BuildItem buildItem = new BuildItem("scimitar",  2, 1, (byte) 0, (byte) 0);
        
        try {
            BuildItemRequired_Init buildItemRequired = 
                new BuildItemRequired_Init(buildItem, RamActivitiesEnum.MANUFACTURING, null, null);
            buildItemRequired.display();
        } catch (ErrorExeption e) {
            System.out.println(""+ e.getErrorEnum());
        }          
    }
    
    public void basicMaterialV2(){
        try {
            MaterialRequired_Init buildItemRequired = 
                new MaterialRequired_Init("scimitar", RamActivitiesEnum.MANUFACTURING); 
            buildItemRequired.display();
            
        } catch (ErrorExeption e) {
            System.out.println(""+ e.getErrorEnum());  
        }        
    }
    
    public void rigRucursion(){
        RigRecusion_Init rigRecusion = 
            GroupEffectRig.getInstance().shipEquipments().getshipEquipments();

        rigRecusion.display();

    }
    
    
    private void chooseRig(){
        // IMPORTANTE qualche rig crea doppione per dinamiche di gioco, sistemalo
        ChooseRig chooseRig02 = new ChooseRig(37146);       
        
//         System.out.println(""+ chooseRig02.isEffectEngineeringRig(37146,24698));
        
        
//        setDublicate();
        // aggiunge un " effectID 0 " da controllare
//        List < RigRecusion_Init > effectRigs = new ArrayList<>();
//        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );
// 
//        for (RigRecusion_Init effectRig : effectRigs) {
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

