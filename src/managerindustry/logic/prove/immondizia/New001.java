/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.immondizia;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs_2;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.prove.buildV3.BasicMaterialRequired;

/**
 *
 * @author lele
 */
public class New001 <T> {
    List < Integer > duplicate = new ArrayList<>();
    
    public New001() {
        baseMaterial();
    }
   
    public void baseMaterial() {
        try {
            BasicMaterialRequired basicMaterialRequired = new BasicMaterialRequired
                ("scimitar", RamActivitiesEnum.MANUFACTURING);
            
            basicMaterialRequired.displatBasicMaterial();
        } catch (ErrorExeption e) {
            System.out.println(""+ e.getErrorEnum());
        }

    }
    
    public void rigRucursion(){
        setDublicate();
//        InitCommonRigGroups commonRigGroups = new InitCommonRigGroups();
        List < RigRecusion > effectRigs = new ArrayList<>();
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );

        for (RigRecusion effectRig : effectRigs) {
            effectRig.displayRecursion();
        }

//        EffectEngineeringRigs_2 managerStructure = new EffectEngineeringRigs_2(43921, effectRigs);        
    }
    
    public void setDublicate(){
        duplicate.add(1138); // Strategic Cruisers
        duplicate.add(1147); // Subsystem Components
        duplicate.add(1951); // Tactical Destroyers    
    }
}

