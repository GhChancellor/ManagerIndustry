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
public class Fitter_old {
//    private EngineeringComplex engineeringComplex;
//    private Map< Integer, MaxGroupFitted > maxGroupFittedMap = new HashMap<>();
//    private float currentCalibration = 0;
//    private float currentSlot = 0;
//    
//    private enum ADD_RIGS {NEW, ADD_ANOTHER, DONT_ADD;}
//    
//    public Fitter_old() throws ErrorExeption {
//        engineeringComplex(PlatformEnum.RAITARU);
////        engineeringComplex.displayValue();
////
//        engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency II", SecurityStatusEnum.LOW_SEC);
//        engineeringRigs("Standup M-Set Equipment Manufacturing Material Efficiency II", SecurityStatusEnum.LOW_SEC);
////        engineeringRigs("Standup M-Set Equipment Manufacturing Time Efficiency II", SecurityStatusEnum.LOW_SEC);
////        engineeringRigs("Standup M-Set Ammunition Manufacturing Time Efficiency I", SecurityStatusEnum.LOW_SEC);
//
//        
//        /*
//        Standup M-Set Equipment Manufacturing Material Efficiency I 43920 / 43921
//Standup M-Set Equipment Manufacturing Time Efficiency I 37160 / 37161
//        Standup M-Set Ammunition Manufacturing Time Efficiency I
//        */
//
//    }
//    
//    public void engineeringComplex(PlatformEnum platformEnum){
//        engineeringComplex = new EngineeringComplex(platformEnum);
//    }
//    
//    public void engineeringRigs(String rigName, SecurityStatusEnum securityStatusEnum) throws ErrorExeption{
//        EngineeringRig engineeringRigs = new EngineeringRig(rigName, securityStatusEnum);
//        addRig(engineeringRigs);
//    }
//    
//    public void displayAllValue(){
//        engineeringComplex.getReductionManufacturingMaterial();
//        engineeringComplex.getReductionManufacturingScienceJobIskCost();
//        engineeringComplex.getReductionManufacturingScienceJobTime();
//        
//        if (engineeringComplex.getReductionManufacturingMaterial() != 0){
//            
//        }
//        
//        if (engineeringComplex.getReductionManufacturingScienceJobIskCost() != 0){
//            
//        }
//        
//        if (engineeringComplex.getReductionManufacturingScienceJobTime() != 0){
//            
//        }
//        
//    }
//    
//    /**
//     * Put to video a error
//     * @param errorExeption 
//     */
//    private void displayErrorRig(ErrorExeption.ErrorExeptionEnum errorExeptionEnum){
//        System.out.println(""+errorExeptionEnum);
//    }
//    
//    /**
//     * Manager errors rig
//     * @param engineeringRigs
//     * @throws ErrorExeption 
//     */
//    private boolean managerError(EngineeringRig engineeringRigs) throws ErrorExeption{
//        // if rig is wrong size
//        if (engineeringRigs.getRigSize() != engineeringComplex.getRigSize()){
//            displayErrorRig(ErrorExeption.ErrorExeptionEnum.RIG_SIZE);
//            return false;
//        }
//        
//        // if rig is duplicate
//        if (maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
//            if ( engineeringRigs.getMaxGroupFitted() > 
//                ManagerDB.getInstance().)
//            displayErrorRig(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
//            return false;
//        }
//
//        // if too much rig
//        if ( currentSlot > engineeringComplex.getMaxRigSlot()){        
//            displayErrorRig(ErrorExeption.ErrorExeptionEnum.MAX_SLOT_RIGS);
//            return false;            
//        }
//
//        // max calibration
//        if ( currentCalibration > engineeringComplex.getMaxCalibrationComplex()){
//            displayErrorRig(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);            
//            return false;
//        }
//
//        // if add a new rig exceed max calibration 
//        if ( ( currentCalibration + engineeringRigs.getCalibration() ) 
//                > engineeringComplex.getMaxCalibrationComplex() ){
//            displayErrorRig(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);
//            return false;
//        }
//        
//        return true;
//    }
//    
//    private void addRig(EngineeringRig engineeringRigs) throws ErrorExeption{
//        if ( managerError(engineeringRigs) ){
//            int tempCurrentRig =
//                maxGroupFittedMap.get(engineeringRigs.getTypeID()).getCurrentRigFitted();                        
//
//            maxGroupFittedMap.put(engineeringRigs.getTypeID(),
//                new MaxGroupFitted(engineeringRigs.getTypeID(),
//                tempCurrentRig++, 
//                engineeringRigs.getMaxGroupFitted()));
//            currentSlot++;
//            currentCalibration += engineeringRigs.getCalibration();            
//        }
//    }
//    
//    /**
//     * Add Rig
//     * @param EngineeringRig engineeringRigs
//     * @throws ErrorExeption 
//     */
//    private void addRig(EngineeringRig engineeringRigs) throws ErrorExeption{
//        
//        // if rig is wrong size
//        if (engineeringRigs.getRigSize() != engineeringComplex.getRigSize()){
//            ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.RIG_SIZE);
//            return;
//        }
//
//        // if rig is duplicate
//        if (maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
//            ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
//            return;
//        }
//        
//        // max number rig
//        if ( currentSlot < engineeringComplex.getMaxRigSlot()){
//            
//            // max calibration
//            if ( currentCalibration > engineeringComplex.getMaxCalibrationComplex()){
//                ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);            
//                return;
//            }
//            
//            // if add a new rig exceed max calibration 
//            if ( ( currentCalibration + engineeringRigs.getCalibration() ) 
//                    > engineeringComplex.getMaxCalibrationComplex() ){
//                ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);
//                return;
//            }
//            
//            
//            
//            // Calculate max Group Fitted
//            ADD_RIGS addRig = maxGroupFitted(engineeringRigs);   
//            
//            switch (addRig){
//                case NEW:
//                    int tempCurrentRig =
//                        maxGroupFittedMap.get(engineeringRigs.getTypeID()).getCurrentRigFitted();                        
//                                                
//                    maxGroupFittedMap.put(engineeringRigs.getTypeID(),
//                        new MaxGroupFitted(engineeringRigs.getTypeID(),
//                        tempCurrentRig++, 
//                        engineeringRigs.getMaxGroupFitted()));
//                    currentSlot++;
//                    currentCalibration += engineeringRigs.getCalibration();
//                    break;
//                case DONT_ADD: // serve?
//                    ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
//                default:
//                    ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.UNKNOW_ERROR);
//                    return;
//            }
//            
//            
//            // Add or don't add a rig
//            switch (addRig){
//                case ADD_ANOTHER:
//                    int tempCurrentRig =
//                        maxGroupFittedMap.get(engineeringRigs.getTypeID()).getCurrentRigFitted();                        
//                                                
//                    maxGroupFittedMap.put(engineeringRigs.getTypeID(),
//                        new MaxGroupFitted(engineeringRigs.getTypeID(),
//                        tempCurrentRig++, 
//                        engineeringRigs.getMaxGroupFitted()));
//                    currentSlot++;
//                    currentCalibration += engineeringRigs.getCalibration();
//                    break;
//                case DONT_ADD: // serve?
//                    ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
//                    return;
//                case NEW:
//                    maxGroupFittedMap.put(engineeringRigs.getTypeID(), new MaxGroupFitted
//                        ( engineeringRigs.getTypeID(), 
//                          engineeringRigs.getMaxGroupFitted()) );
//                    currentSlot++;
//                    currentCalibration += engineeringRigs.getCalibration();
//                    break;
//                default:
//                    ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.UNKNOW_ERROR);
//                    return;
//            }            
//        }else{
//            ManagerErrorExecption.displayErrorExecption(ErrorExeption.ErrorExeptionEnum.MAX_SLOT_RIGS);
//            return;
//        }        
//    }
//    
//    /**
//     * Calculate max Group Fitted
//     * @param EngineeringRig structureEngineeringRigs
//     * @return ENUM ADD_RIGS
//     */
//    private ADD_RIGS maxGroupFitted(EngineeringRig engineeringRigs){
//        if ( maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
//            
//        }
//        
//        Integer currentRigFitted;
//        
//        maxGroupFittedMap.forEach((t, u) -> {
//            t.
//            currentRigFitted = u.getCurrentRigFitted();
//        });
//        
//        if ()
//        
//        if ( maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
//            
//            MaxGroupFitted maxGroupFitted = 
//                maxGroupFittedMap.get(engineeringRigs.getTypeID());
//            
//            int currentRigFitted = maxGroupFitted.getCurrentRigFitted();
//                
//            if (currentRigFitted++ <= maxGroupFitted.getMaxGroupFitted() )
//                return ADD_RIGS.ADD_ANOTHER;
//            else
//                return ADD_RIGS.DONT_ADD;
//        }else{
//            return ADD_RIGS.NEW;
//        }           
//    } 
//
////    /**
////     * Calculate max Group Fitted
////     * @param EngineeringRig structureEngineeringRigs
////     * @return ENUM ADD_RIGS
////     */
////    private ADD_RIGS maxGroupFitted(EngineeringRig engineeringRigs){
////        if ( maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
////            
////            MaxGroupFitted maxGroupFitted = 
////                maxGroupFittedMap.get(engineeringRigs.getTypeID());
////            
////            int currentRigFitted = maxGroupFitted.getCurrentRigFitted();
////                
////            if (currentRigFitted++ <= maxGroupFitted.getMaxGroupFitted() )
////                return ADD_RIGS.ADD_ANOTHER;
////            else
////                return ADD_RIGS.DONT_ADD;
////        }else{
////            return ADD_RIGS.NEW;
////        }           
////    } 
////
//    public float getCurrentCalibration() {
//        return currentCalibration;
//    }
//
//    public void setCurrentCalibration(float currentCalibration) {
//        this.currentCalibration = currentCalibration;
//    }
//
//    public float getCurrentSlot() {
//        return currentSlot;
//    }
//
//    public void setCurrentSlot(float currentSlot) {
//        this.currentSlot = currentSlot;
//    }
//    
    
}