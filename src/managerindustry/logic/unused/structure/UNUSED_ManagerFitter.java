/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.unused.structure;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.ManagerErrorExecption;
import managerindustry.logic.unused.structure.UNUSED_EngineeringComplex;
import managerindustry.logic.unused.structure.rig_GroupId.UNUSED_StructureEngineeringRigs;

/**
 *
 * @author lele
 */
public class UNUSED_ManagerFitter {
    private List < UNUSED_StructureEngineeringRigs > engineeringRigses = new ArrayList<>();
    private float currentCalibartionComplex = 0;
    private UNUSED_EngineeringComplex engineeringComplex;
    
    /**
     * DBG con "Standup M-Set Blueprint Copy Cost Optimization II", SecurityStatusEnum.NULL_SEC
     * calcolaValoriSecurityStatusConRig() da -25.19 al posto di -25,2  arrotodamento sbagliato
     * @throws ErrorExeption 
     */
    public UNUSED_ManagerFitter() throws ErrorExeption  { // <----- DBG ATTENZIONE TRY CATCH DA FARE GESTIRE ALLA GUI
        SecurityStatusEnum securityStatusEnum = SecurityStatusEnum.HI_SEC;
        
        try {
            engineeringComplex = new UNUSED_EngineeringComplex("Raitaru");
            UNUSED_StructureEngineeringRigs structureEngineeringRigs01 = new 
                UNUSED_StructureEngineeringRigs("Standup M-Set Blueprint Copy Cost Optimization II",   securityStatusEnum );

            addEngineeringRigses(structureEngineeringRigs01);

            System.out.println("" + engineeringComplex.getNameEngineeringComplex() + "\n" +
             structureEngineeringRigs01.getNameRig() + " " + structureEngineeringRigs01.getCalibration() + "\n" +
             "currentCalibartionComplex " + currentCalibartionComplex);        

            UNUSED_StructureEngineeringRigs structureEngineeringRigs02 = new 
                UNUSED_StructureEngineeringRigs("Standup M-Set Blueprint Copy Cost Optimization II", securityStatusEnum );

            addEngineeringRigses(structureEngineeringRigs02);

            System.out.println("" + engineeringComplex.getNameEngineeringComplex() + "\n" +
             structureEngineeringRigs02.getNameRig() + " " + structureEngineeringRigs02.getCalibration() + "\n" +
             "currentCalibartionComplex " + currentCalibartionComplex);             
        } catch (ErrorExeption e) {
            System.out.println(""+ ManagerErrorExecption.getErrorExecption(e.getErrorEnum()));
        }

     
        
        
    }
    
    /**
    * Add Engineering Rigses and avoid duplicate
    * @param StructureEngineeringRigs engineeringRigs 
    */
    private void addEngineeringRigses( UNUSED_StructureEngineeringRigs structureEngineeringRigs ) throws ErrorExeption {
        // if list is empty add now
        if ( this.engineeringRigses.isEmpty() ){
            this.engineeringRigses.add(structureEngineeringRigs);
            currentCalibartionComplex = structureEngineeringRigs.getCalibration();
            return;
            
        }else if ( avoidDuplicateRigsAdd(structureEngineeringRigs ) ){
            calculateCurrentCalibartionComplex(structureEngineeringRigs);
            this.engineeringRigses.add(structureEngineeringRigs);             
        }  
  
    }

    private void calculateCurrentCalibartionComplex(UNUSED_StructureEngineeringRigs structureEngineeringRigs) throws ErrorExeption {
        float maxCalibration = engineeringComplex.getMaxCalibrationComplex();
        float tempCurrentCalibartionComplex = 0;
        
        if (currentCalibartionComplex <= maxCalibration){
            tempCurrentCalibartionComplex = 
                currentCalibartionComplex + structureEngineeringRigs.getCalibration();
            
            if ( tempCurrentCalibartionComplex <= maxCalibration){
                currentCalibartionComplex = tempCurrentCalibartionComplex;
                return;
            }
        }
        throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);
    }        
    
    /**
     * Avoid dudplicate Engineerings 
     * @param structureEngineeringRigs 
     */
    private boolean avoidDuplicateRigsAdd( UNUSED_StructureEngineeringRigs structureEngineeringRigs ) throws ErrorExeption{
        for (int i = 0; i < engineeringRigses.size(); i++) {
            if (engineeringRigses.get(i).getNameRig() == structureEngineeringRigs.getNameRig()){
                System.out.println("ManagerStructureEngineeringRigs avoidDuplicateRigsAdd: Nn puoi inserire lo stesso rig "
                + structureEngineeringRigs.getNameRig() );
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
            }
        }
        return true;
    }    
    /**
     * Get Engineering Rigses
     * @return List<StructureEngineeringRigs>
     */
    private List<UNUSED_StructureEngineeringRigs> getEngineeringRigses() {
        return engineeringRigses;
    }

    /**
     * Set Engineering Rigses
     * @param List<StructureEngineeringRigs> engineeringRigses 
     */
    private void setEngineeringRigses(List<UNUSED_StructureEngineeringRigs> engineeringRigses) {
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