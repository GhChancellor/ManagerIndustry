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

/**
 *
 * @author lele
 */
public class Immondizia_001 <T> {
    List < Integer > duplicate = new ArrayList<>();
    
    public Immondizia_001() throws ErrorExeption{
        System.out.println("\n\n\n");
//        basicMaterialV2();
//        buildItem();
//        rigRucursion();
//        chooseRig();
//        immondizia2();
        requiredSkill();
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
                new BuildItemRequired_Init(buildItem, RamActivitiesEnum.MANUFACTURING);
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
        RigRecusion_Init rigRecusion = GroupEffectRig.getInstance().
            t3subsystems().getT3subsystems();

        rigRecusion.display();

    }
    
    
    private void chooseRig(){
        // IMPORTANTE qualche rig crea doppione per dinamiche di gioco, sistemalo
        ChooseRig chooseRig02 = new ChooseRig(43921);        
        
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

