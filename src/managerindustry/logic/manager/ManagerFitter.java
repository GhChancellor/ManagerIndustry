/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.structure.StructureEngineeringRigs;

/**
 *
 * @author lele
 */
public class ManagerFitter {
    private List < StructureEngineeringRigs > engineeringRigses = new ArrayList<>();
    private float currentCalibartionComplex = 0;

    public ManagerFitter() {
    }
    
    /**
    * Add Engineering Rigses and avoid duplicate
    * @param StructureEngineeringRigs engineeringRigs 
    */
    private boolean addEngineeringRigses( StructureEngineeringRigs engineeringRigs) {
        
        // if list is empty add now
        if ( this.engineeringRigses.isEmpty() ){
            this.engineeringRigses.add(engineeringRigs);
            return true;
                   
        }else if ( avoidDuplicateRigsAdd(engineeringRigs) ){  // avoid Duplicate Rigs         
            this.engineeringRigses.add(engineeringRigs);
            return true;            
        }
        return false;

    }
    
    /**
     * Avoid dudplicate Engineerings 
     * @param structureEngineeringRigs 
     */
    private boolean avoidDuplicateRigsAdd( StructureEngineeringRigs structureEngineeringRigs ){
        for (int i = 0; i < engineeringRigses.size(); i++) {
            if (engineeringRigses.get(i).getNameRig() == structureEngineeringRigs.getNameRig()){
                System.out.println("ManagerStructureEngineeringRigs avoidDuplicateRigsAdd: Nn puoi inserire lo stesso rig "
                + structureEngineeringRigs.getNameRig() );
                return false;
            }
        }
        return true;
    }    
    /**
     * Get Engineering Rigses
     * @return List<StructureEngineeringRigs>
     */
    private List<StructureEngineeringRigs> getEngineeringRigses() {
        return engineeringRigses;
    }

    /**
     * Set Engineering Rigses
     * @param List<StructureEngineeringRigs> engineeringRigses 
     */
    private void setEngineeringRigses(List<StructureEngineeringRigs> engineeringRigses) {
        this.engineeringRigses = engineeringRigses;
    }    
    
    
}

/*
//            Standup M-Set Equipment Manufacturing Material Efficiency I
//            Standup M-Set Equipment Manufacturing Material Efficiency II
        
//            Standup M-Set Advanced Component Manufacturing Material Efficiency I 
//            Standup M-Set Advanced Component Manufacturing Material Efficiency II 
//
//            Standup M-Set Advanced Component Manufacturing Time Efficiency I
//            Standup M-Set Advanced Component Manufacturing Time Efficiency II 
//
//            Standup M-Set Blueprint Copy Accelerator I
//            Standup M-Set Blueprint Copy Accelerator II 
//
//            Standup M-Set Blueprint Copy Cost Optimization I 
//            Standup M-Set Blueprint Copy Cost Optimization II 
//
//            Standup M-Set ME Research Accelerator I  
//            Standup M-Set ME Research Accelerator II 
//
//            Standup M-Set TE Research Accelerator I 
//            Standup M-Set TE Research Accelerator II 
//
//            Standup M-Set Invention Accelerator I 
//            Standup M-Set Invention Accelerator II     
                    
//            Standup XL-Set Equipment and Consumable Manufacturing Efficiency I 
//            Standup XL-Set Equipment and Consumable Manufacturing Efficiency II
*/