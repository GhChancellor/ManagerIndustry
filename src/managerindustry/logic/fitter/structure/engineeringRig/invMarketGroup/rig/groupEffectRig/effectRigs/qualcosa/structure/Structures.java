/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.structure;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.structure.citadels.Citadels;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.structure.deployableStructures.DeployableStructures;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.structure.engineeringComplexes.EngineeringComplexes;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.structure.refineries.Refineries;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.structure.starbaseStructure.StarbaseStructures;

/**
 * marketGroupID 477
 * parentGroupID 477
 * @author lele
 */
public class Structures {
    /**
     * Base Structures: Astrahus, Fortizar
     * @return StarbaseStructures
     */
    public StarbaseStructures starbaseStructures(){
       StarbaseStructures starbaseStructures = new StarbaseStructures();
       return starbaseStructures;
    }
   
    /**
     * Personal Deployables: Cargo containers, Mobile tractor unit...
     * @return DeployableStructures
     */
    public DeployableStructures deployableStructures(){
       DeployableStructures deployableStructures = new DeployableStructures();
       return deployableStructures;
    }
    
    /**
     * Upwell Structures: Citadels: Astrahus, Fortizar
     * @return Citadels
     */
    public Citadels citadels(){
        Citadels citadels = new Citadels();
        return citadels;
    }
    
    /**
     * Upwell Structures: Engineering Complexes: Azbel, Raitaru
     * @return EngineeringComplexes
     */
    public EngineeringComplexes engineeringComplexes(){
        EngineeringComplexes engineeringComplexes = new EngineeringComplexes();
        return engineeringComplexes;
    }
    
    /**
     * Upwell Structures: Refineries: Athanor, Tatara
     * @return Refineries
     */
    public Refineries refineries(){
        Refineries refineries = new Refineries();
        return refineries;
    }
}
