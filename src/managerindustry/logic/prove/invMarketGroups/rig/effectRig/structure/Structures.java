/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig.structure;

import managerindustry.logic.prove.invMarketGroups.rig.effectRig.structure.starbaseStructure.*;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.structure.deployableStructures.DeployableStructures;

/**
 * marketGroupID 477 
 * parentGroupID null
 * @author lele
 */
public class Structures {
    
    public StarbaseStructures starbaseStructures(){
       StarbaseStructures starbaseStructures = new StarbaseStructures();
       return starbaseStructures;
    }
   
    public DeployableStructures deployableStructures(){
       DeployableStructures deployableStructures = new DeployableStructures();
       return deployableStructures;
    }
}
