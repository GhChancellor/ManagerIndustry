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
import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;

/**
 *
 * @author lele
 */
public class Fitter {
    private EngineeringComplex engineeringComplex;
    private Map< /* typeId */ Integer , /* currentRigFitted */ Integer  > maxGroupFittedMap = new HashMap<>();
    private float currentCalibration = 0;
    private byte engineeringComplex_CurrentSlot = 0;
    
    enum EngineeringRigEnum {ADD, REMOVE};
        
    public Fitter() throws ErrorExeption {
        engineeringComplex(PlatformEnum.RAITARU);

        engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency II", SecurityStatusEnum.LOW_SEC);
        engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency I", SecurityStatusEnum.LOW_SEC);
        engineeringRigs("Standup M-Set Equipment Manufacturing Time Efficiency II", SecurityStatusEnum.LOW_SEC);
//        engineeringRigs("Standup M-Set Ammunition Manufacturing Time Efficiency II", SecurityStatusEnum.LOW_SEC);

    }
    
    /**
     * 
     * @param PlatformEnum platformEnum 
     */
    public void engineeringComplex(PlatformEnum platformEnum){
        engineeringComplex = new EngineeringComplex(platformEnum);
        engineeringComplex.displayAllValueCalculated();
    }
    
    public void engineeringRigs(String rigName, SecurityStatusEnum securityStatusEnum) throws ErrorExeption{
        EngineeringRig engineeringRigs = new EngineeringRig(rigName, securityStatusEnum);
        engineeringRigs.displayValue();
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
    private boolean managerError(EngineeringRig engineeringRigs, EngineeringRigEnum engineeringRigEnum ) throws ErrorExeption{
        // if rig is wrong size
        if (engineeringRigs.getRigSize() != engineeringComplex.getRigSize()){
            displayErrorRig(ErrorExeption.ErrorExeptionEnum.RIG_SIZE);
            return false;
        }

        // Max Modules Of This Group Allowed
        if ( maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
            
            switch (engineeringRigEnum){
            
                case ADD:
                    if( maxGroupFittedMap.get(engineeringRigs.getTypeID()) >= 
                        engineeringRigs.getMaxGroupFitted().intValue() ){
                            displayErrorRig(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
                        return false;     
                    }                    
                
                case REMOVE:
                    if (maxGroupFittedMap.get(engineeringRigs.getTypeID()) <= 0){
                        displayErrorRig(ErrorExeption.ErrorExeptionEnum.CANT_REMOVE);
                        return false;
                    }                  
            default:
                displayErrorRig(ErrorExeption.ErrorExeptionEnum.UNKNOW_ERROR);
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
    public void addRig(EngineeringRig engineeringRigs) throws ErrorExeption{
        if ( managerError(engineeringRigs, EngineeringRigEnum.ADD) ){                   

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

    /**
     * Remove Rig
     * @param EngineeringRig engineeringRigs
     * @throws ErrorExeption 
     */
    public void removeRig(EngineeringRig engineeringRigs) throws ErrorExeption{        
        if ( managerError(engineeringRigs, EngineeringRigEnum.REMOVE ) ){
            engineeringComplex_CurrentSlot--;
            currentCalibration -= engineeringRigs.getCalibration();               
            
            maxGroupFittedMap.remove(engineeringRigs.getTypeID());
        }
    }
    
    public void updateBonus(){
        
    }
    
    /**
     *  Get Current Calibration
     * @return float
     */
    public float getCurrentCalibration() {
        return currentCalibration;
    }

    /**
     * Set Current Calibration
     * @param float currentCalibration 
     */
    public void setCurrentCalibration(float currentCalibration) {
        this.currentCalibration = currentCalibration;
    }

    /**
     * Get EngineeringComplex Current Slot
     * @return byte
     */
    public byte getEngineeringComplex_CurrentSlot() {
        return engineeringComplex_CurrentSlot;
    }

    /**
     * Set EngineeringComplex Current Slot
     * @param byte engineeringComplex_CurrentSlot 
     */
    public void setEngineeringComplex_CurrentSlot(byte engineeringComplex_CurrentSlot) {
        this.engineeringComplex_CurrentSlot = engineeringComplex_CurrentSlot;
    }
    
    
}