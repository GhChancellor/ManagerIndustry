/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter;

import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.enumName.PlatformEnum;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.fitter.maxGroupFitted.MaxGroupFitted;
import managerindustry.logic.manager.ManagerErrorExecption;
import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class Fitter {
    private EngineeringComplex engineeringComplex;
    private Map< Integer /* typeId */, Integer /* currentRigFitted */ > maxGroupFittedMap = new HashMap<>();
    private float currentCalibration = 0;
    private int engineeringComplex_CurrentSlot = 0;
    
    private enum ADD_RIGS {NEW, ADD_ANOTHER, DONT_ADD;}
    
    public Fitter() throws ErrorExeption {
        engineeringComplex(PlatformEnum.RAITARU);
//        engineeringComplex.displayValue();
//
        engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency II", SecurityStatusEnum.LOW_SEC);
//        engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency I", SecurityStatusEnum.LOW_SEC);
        engineeringRigs("Standup M-Set Equipment Manufacturing Time Efficiency II", SecurityStatusEnum.LOW_SEC);
        engineeringRigs("Standup M-Set Ammunition Manufacturing Time Efficiency II", SecurityStatusEnum.LOW_SEC);

        
        /*
        Standup M-Set Equipment Manufacturing Material Efficiency I 43920 / 43921
Standup M-Set Equipment Manufacturing Time Efficiency I 37160 / 37161
        Standup M-Set Ammunition Manufacturing Time Efficiency I
        */

    }
    
    /**
     * 
     * @param PlatformEnum platformEnum 
     */
    public void engineeringComplex(PlatformEnum platformEnum){
        engineeringComplex = new EngineeringComplex(platformEnum);
    }
    
    public void engineeringRigs(String rigName, SecurityStatusEnum securityStatusEnum) throws ErrorExeption{
        EngineeringRig engineeringRigs = new EngineeringRig(rigName, securityStatusEnum);
        addRig(engineeringRigs);
    }
    
    public void displayAllValue(){
        engineeringComplex.getReductionManufacturingMaterial();
        engineeringComplex.getReductionManufacturingScienceJobIskCost();
        engineeringComplex.getReductionManufacturingScienceJobTime();
        
        if (engineeringComplex.getReductionManufacturingMaterial() != 0){
            
        }
        
        if (engineeringComplex.getReductionManufacturingScienceJobIskCost() != 0){
            
        }
        
        if (engineeringComplex.getReductionManufacturingScienceJobTime() != 0){
            
        }
        
    }
    
    /**
     * Put to video a error
     * @param errorExeption 
     */
    private void displayErrorRig(ErrorExeption.ErrorExeptionEnum errorExeptionEnum){
        System.out.println(""+errorExeptionEnum);
    }
    
    /**
     * Manager errors rig
     * @param engineeringRigs
     * @throws ErrorExeption 
     */
    private boolean managerError(EngineeringRig engineeringRigs) throws ErrorExeption{
        // if rig is wrong size
        if (engineeringRigs.getRigSize() != engineeringComplex.getRigSize()){
            displayErrorRig(ErrorExeption.ErrorExeptionEnum.RIG_SIZE);
            return false;
        }

        // if rig is duplicate
        if ( maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
            if( maxGroupFittedMap.get(engineeringRigs.getTypeID()) >= 
               engineeringRigs.getMaxGroupFitted().intValue() ){
                displayErrorRig(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
                return false;            
            }            
        }
        
        // Engineering Complex Max Rig Slot
        if ( engineeringComplex_CurrentSlot > engineeringComplex.getMaxRigSlot()){        
            displayErrorRig(ErrorExeption.ErrorExeptionEnum.MAX_SLOT_RIGS);
            return false;            
        }

        // max calibration
        if ( currentCalibration > engineeringComplex.getMaxCalibrationComplex()){
            displayErrorRig(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);            
            return false;
        }

        // if add a new rig exceed max calibration 
        if ( ( currentCalibration + engineeringRigs.getCalibration() ) 
                > engineeringComplex.getMaxCalibrationComplex() ){
            displayErrorRig(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);
            return false;
        }
        
        return true;
    }
    
    /**
     * Add Rig
     * @param EngineeringRig engineeringRigs
     * @throws ErrorExeption 
     */
    private void addRig(EngineeringRig engineeringRigs) throws ErrorExeption{
        if ( managerError(engineeringRigs) ){                   

            if (maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
                maxGroupFittedMap.put(engineeringRigs.getTypeID(), 
                    maxGroupFittedMap.get(engineeringRigs.getTypeID()) + 1 );                
            }else{
                maxGroupFittedMap.put(engineeringRigs.getTypeID(), 1);                
            }
            
            engineeringComplex_CurrentSlot++;
            currentCalibration += engineeringRigs.getCalibration();            
        }
    }

    public float getCurrentCalibration() {
        return currentCalibration;
    }

    public void setCurrentCalibration(float currentCalibration) {
        this.currentCalibration = currentCalibration;
    }

    public int getEngineeringComplex_CurrentSlot() {
        return engineeringComplex_CurrentSlot;
    }

    public void setEngineeringComplex_CurrentSlot(int engineeringComplex_CurrentSlot) {
        this.engineeringComplex_CurrentSlot = engineeringComplex_CurrentSlot;
    }
    
    
}