/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.structure.EngineeringComplex;
import managerindustry.logic.structure.StructureEngineeringRigs;

/**
 *
 * @author lele
 */
public class ManagerFitter {
    private float currentCalibartionComplex;
    
    public ManagerFitter() {
        currentCalibartionComplex = 0;
        
        EngineeringComplex engineeringComplex = new EngineeringComplex("Raitaru");
        StructureEngineeringRigs structureEngineeringRigs = new 
         StructureEngineeringRigs("Standup M-Set Blueprint Copy Cost Optimization II");
        
        addRigToStation(engineeringComplex, structureEngineeringRigs);
        
        System.out.println("" + engineeringComplex.getNameEngineeringComplex() + "\n" +
         structureEngineeringRigs.getNameRig() + " " + structureEngineeringRigs.getCalibration() + "\n" +
         "currentCalibartionComplex " + currentCalibartionComplex);
        
        System.out.println("---------------------\n");
        StructureEngineeringRigs structureEngineeringRigs02 = 
         new StructureEngineeringRigs("Standup M-Set Advanced Component Manufacturing Material Efficiency II");
        
        addRigToStation(engineeringComplex, structureEngineeringRigs02);
        
        System.out.println("" + engineeringComplex.getNameEngineeringComplex() + "\n" +
         structureEngineeringRigs02.getNameRig() + " " + structureEngineeringRigs02.getCalibration() + "\n" +
         "currentCalibartionComplex " + currentCalibartionComplex);
                
        System.out.println("---------------------\n");
        StructureEngineeringRigs structureEngineeringRigs03 = 
         new StructureEngineeringRigs("Standup M-Set ME Research Accelerator II");
        
        System.out.println("" + engineeringComplex.getNameEngineeringComplex() + "\n" +
         structureEngineeringRigs03.getNameRig() + " " + structureEngineeringRigs03.getCalibration() + "\n" +
         "currentCalibartionComplex " + currentCalibartionComplex);
        
    }

    public void initFitter(){
        
    }
    
    public void addRigToStation(EngineeringComplex engineeringComplex, StructureEngineeringRigs structureEngineeringRigs ){
        
        if ( currentCalibartionComplex == 0){ // is empty add now
            currentCalibartionComplex += structureEngineeringRigs.getCalibration();
            ManagerStructureEngineeringRigs.getInstace().addEngineeringRigses(structureEngineeringRigs);
            return;
        }else if(currentCalibartionComplex > engineeringComplex.getMaxCalibrationComplex() ){ // non sarà mai vera
            System.out.println("ManagerFItter > addRigToStation   Calibration complex superata ");
            return;
        }else if (currentCalibartionComplex < engineeringComplex.getMaxCalibrationComplex()){ // currentCalibartionComplex < 400
            
            float tempCurrentCalibationComplex = 0;
            tempCurrentCalibationComplex = currentCalibartionComplex + structureEngineeringRigs.getCalibration();
            
            if ( tempCurrentCalibationComplex < engineeringComplex.getMaxCalibrationComplex() ) // currentCalibartionComplex < 400
            
                if ( ManagerStructureEngineeringRigs.getInstace().addEngineeringRigses(structureEngineeringRigs) ){
                    currentCalibartionComplex = tempCurrentCalibationComplex;
            }
        }        
    }    

}
/*
    stazione
        valori stazione
            valori rig
    controllo dei valori
*/