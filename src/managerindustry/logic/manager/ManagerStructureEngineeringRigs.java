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
public class ManagerStructureEngineeringRigs {
    private List < StructureEngineeringRigs > engineeringRigses = new ArrayList<>();
    private static ManagerStructureEngineeringRigs instance = null;    
    
    public static ManagerStructureEngineeringRigs getInstace(){
        if ( instance == null ){
            instance = new ManagerStructureEngineeringRigs();
        }
        return instance;
    }

    public ManagerStructureEngineeringRigs() {
    }
    
    /**
     * Get Engineering Rigses
     * @return List<StructureEngineeringRigs>
     */
    public List<StructureEngineeringRigs> getEngineeringRigses() {
        return engineeringRigses;
    }

    /**
     * Set Engineering Rigses
     * @param List<StructureEngineeringRigs> engineeringRigses 
     */
    private void setEngineeringRigses(List<StructureEngineeringRigs> engineeringRigses) {
        this.engineeringRigses = engineeringRigses;
    }
    
    /**
     * Add Engineering Rigses and avoid duplicate
     * @param StructureEngineeringRigs engineeringRigs 
     */
    public boolean addEngineeringRigses( StructureEngineeringRigs engineeringRigs) {
        
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
    
    
    public void initStructureEngineeringRigs(String nameRig){
        StructureEngineeringRigs structureEngineeringRigs = new StructureEngineeringRigs(nameRig);
        avoidDuplicateRigsAdd(structureEngineeringRigs);
        
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
                    
            
    }
    
    public double getRate() {
        StructureEngineeringRigs structureEngineeringRigs = new StructureEngineeringRigs();
        structureEngineeringRigs.setSecurityStatusBonus(0.0f);
        
        for (int i = 0; i < engineeringRigses.size(); i++) {
            if ( structureEngineeringRigs.getSecurityStatusBonus() == 0.0 ){
                structureEngineeringRigs.setSecurityStatusBonus( engineeringRigses.get(i).getSecurityStatusBonus() );
            }
            
//            structureEngineeringRigs.g
        }
        return 0.0d;
    }
}
/*
    private int calibration;
    private float bonusSecurityStatus;    
    private float materialEfficiency;
    private float timeEfficiency;          
    private float costBonus;          
    private float timeBonus;   
*/