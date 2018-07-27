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
import managerindustry.logic.fitter.structure.logic.AvoidDuplicateRig;
import managerindustry.logic.fitter.structure.logic.MaxGroupFitted;
import managerindustry.logic.fitter.structure.logic.StructureLibrary;

/**
 *
 * @author lele
 */
public class EngineeringComplexSlot {
    private EngineeringComplex engineeringComplex;
    
    private Map< /* typeId */ Integer , MaxGroupFitted > maxGroupFittedMap = new HashMap<>();
    
    private float currentCalibration = 0;
    private byte engineeringComplex_CurrentSlot = 0;
    float totReductionManufacturingMaterial;
    float totReductionManufacturingScienceJobIskCost;
    float totReductionManufacturingScienceJobTime;
    private AvoidDuplicateRig avoidDuplicateRig = new AvoidDuplicateRig(); 
    
    public enum EngineeringRigEnum {ADD, REMOVE};
    
    private void init(){
        try {
            engineeringComplex(PlatformEnum.RAITARU);

//            engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency II", SecurityStatusEnum.LOW_SEC);
//            engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency I", SecurityStatusEnum.LOW_SEC);
            engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency II", SecurityStatusEnum.LOW_SEC);

//            engineeringRigs("Standup M-Set Equipment Manufacturing Time Efficiency II", SecurityStatusEnum.LOW_SEC);
//            engineeringRigs("Standup M-Set Equipment Manufacturing Time Efficiency I", SecurityStatusEnum.LOW_SEC);
//            engineeringRigs("Standup M-Set Ammunition Manufacturing Time Efficiency I", SecurityStatusEnum.LOW_SEC);
//            engineeringRigs("Standup M-Set Advanced Component Manufacturing Time Efficiency I", SecurityStatusEnum.LOW_SEC);
            engineeringComplex.displayAllValueCalculated();
            calculatesBonus();
            displayAllValue();            
        } catch (ErrorExeption e) {
            System.out.println(""+ e.getErrorEnum().getErrorMessage());
        }        
    }
    
    public EngineeringComplexSlot(PlatformEnum platformEnum, 
        String rigName, SecurityStatusEnum securityStatusEnum) throws ErrorExeption {
        engineeringComplex(platformEnum);
        engineeringRigs(rigName, securityStatusEnum);
    }
   
    /**
     * Engineering Complex Slot
     */
    public EngineeringComplexSlot() {
        init();
    }
    
    /**
     * Engineering complex
     * @param PlatformEnum platformEnum 
     */
    public void engineeringComplex(PlatformEnum platformEnum){
        engineeringComplex = new EngineeringComplex(platformEnum);
    }
    
    /**
     * Engineering Rigs
     * @param String rigName
     * @param SecurityStatusEnum securityStatusEnum
     * @throws ErrorExeption 
     */
    public void engineeringRigs(String rigName, SecurityStatusEnum securityStatusEnum) throws ErrorExeption{
        EngineeringRig engineeringRigs = new EngineeringRig(rigName, securityStatusEnum);
        addRig(engineeringRigs);
    }
    
    /**
     * Display AllV alue
     */
    public void displayAllValue(){        
        if (totReductionManufacturingMaterial != 0){
            System.out.println("XX totReductionManufacturingMaterial " + totReductionManufacturingMaterial);
        }
        
        if (totReductionManufacturingScienceJobIskCost != 0){
            System.out.println("XX totReductionManufacturingScienceJobIskCost " + totReductionManufacturingScienceJobIskCost);
        }
        
        if (totReductionManufacturingScienceJobTime != 0){
            System.out.println("XX totReductionManufacturingScienceJobTime " + totReductionManufacturingScienceJobTime);
        }        
    }   
    
    /**
     * Add Rig, 10-07-2018 Il gioco prevede SOLO 1 rig dello stesso tipo. 
     * Aggiunge più rig dello stesso tipo aggiornando currentCalibration, engineeringComplex_CurrentSlot
     * @param EngineeringRig engineeringRigs
     * @throws ErrorExeption 
     */
    public void addRig(EngineeringRig engineeringRigs) throws ErrorExeption{
        // Manager errors rig
        managerError(engineeringRigs, EngineeringRigEnum.ADD);
        
        if (maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){

            MaxGroupFitted tempMaxGroupFitted = maxGroupFittedMap.get(engineeringRigs.getTypeID());
            byte currentFitted = tempMaxGroupFitted.getCurrentFitted();
            tempMaxGroupFitted.setCurrentFitted( (byte) ( currentFitted + 1) );

            maxGroupFittedMap.put(engineeringRigs.getTypeID(), tempMaxGroupFitted);
        }else{
            MaxGroupFitted tempMaxGroupFitted = new MaxGroupFitted(engineeringRigs, (byte) 1);
            maxGroupFittedMap.put(engineeringRigs.getTypeID(), tempMaxGroupFitted );
        }

        engineeringComplex_CurrentSlot++;
        currentCalibration += engineeringRigs.getCalibration();    
    }
    
    /**
     * Remove Rig, 10-07-2018 Il gioco prevede SOLO 1 rig dello stesso tipo. 
     * Elimina più rig dello stesso tipo aggiornando currentCalibration, engineeringComplex_CurrentSlot
     * @param EngineeringRig engineeringRigs
     * @throws ErrorExeption 
     */
    public void removeRig(EngineeringRig engineeringRigs) throws ErrorExeption{    
        managerError(engineeringRigs, EngineeringRigEnum.REMOVE );
        
        if (maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
            MaxGroupFitted tempMaxGroupFitted = maxGroupFittedMap.get(engineeringRigs.getTypeID());

            engineeringComplex_CurrentSlot--;
            currentCalibration -= engineeringRigs.getCalibration();               

            if  ( tempMaxGroupFitted.getCurrentFitted() == 1){
                maxGroupFittedMap.remove(engineeringRigs.getTypeID());
            }            
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
    private void managerError(EngineeringRig engineeringRigs, EngineeringRigEnum engineeringRigEnum ) throws ErrorExeption{        
        // if rig is wrong size
        if (engineeringRigs.getRigSize() != engineeringComplex.getRigSize()){
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.RIG_SIZE);
        }

        // avoid duplicate rig
        avoidDuplicateRig.maxGroupFitted(maxGroupFittedMap, engineeringRigs, engineeringRigEnum);
        
        // Engineering Complex Max Rig Slot
        if ( engineeringComplex_CurrentSlot >= engineeringComplex.getMaxRigSlot()){        
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_SLOT_RIGS);       
        }

        // max calibration
        if ( currentCalibration > engineeringComplex.getMaxCalibrationComplex()){
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);            
        }

        // if add a new rig exceed max calibration 
        if ( ( currentCalibration + engineeringRigs.getCalibration() ) 
                > engineeringComplex.getMaxCalibrationComplex() ){
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);
        }
    }
    
    /**
     * Calculates Bonus
     */
    private void calculatesBonus(){
        EngineeringRig _engineeringRig = new EngineeringRig();
        byte trucateDecimal = 2;
        float tempFloat;
        
        for (Map.Entry<Integer, MaxGroupFitted> entry : maxGroupFittedMap.entrySet()) {
            _engineeringRig = entry.getValue().getEngineeringRig();
        
            if ( _engineeringRig.getMaterialEfficiency_SecurityStatus() != 0 ){
                tempFloat = engineeringComplex.getReductionManufacturingMaterial() +
                    _engineeringRig.getMaterialEfficiency_SecurityStatus();
                totReductionManufacturingMaterial = truncateToDecimal(tempFloat, trucateDecimal);
            }
            
            if ( _engineeringRig.getTimeEfficiency_SecurityStatus()!= 0 ){
                tempFloat = engineeringComplex.getReductionManufacturingScienceJobTime() +
                    _engineeringRig.getTimeEfficiency_SecurityStatus();
                totReductionManufacturingScienceJobTime = truncateToDecimal(tempFloat, trucateDecimal);
            }
            
            if ( _engineeringRig.getCostBonus_SecurityStatus()!= 0 ){
                tempFloat = engineeringComplex.getReductionManufacturingScienceJobIskCost() +
                    _engineeringRig.getCostBonus_SecurityStatus(); 
                totReductionManufacturingScienceJobIskCost = truncateToDecimal(tempFloat, trucateDecimal);
            }        
        }
    }
    
    /**
     * Truncate to decimal
     * @param float value
     * @param byte numberofDecimals
     * @return float 
     */
    private float truncateToDecimal(float value, byte numberofDecimals){
        return StructureLibrary.truncateToDecimal(value, numberofDecimals).floatValue();     
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
    private void setCurrentCalibration(float currentCalibration) {
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
    private void setEngineeringComplex_CurrentSlot(byte engineeringComplex_CurrentSlot) {
        this.engineeringComplex_CurrentSlot = engineeringComplex_CurrentSlot;
    }
    
    /**
     * Get Tot Reduction Manufacturing Material
     * @return float
     */
    public float getTotReductionManufacturingMaterial() {
        return totReductionManufacturingMaterial;
    }

    /**
     * Get Tot Reduction Manufacturing Science Job Isk Cost
     * @return float
     */
    public float getTotReductionManufacturingScienceJobIskCost() {
        return totReductionManufacturingScienceJobIskCost;
    }

    /**
     * Get Tot Reduction Manufacturing Science Job Time
     * @return float
     */
    public float getTotReductionManufacturingScienceJobTime() {
        return totReductionManufacturingScienceJobTime;
    }   
}