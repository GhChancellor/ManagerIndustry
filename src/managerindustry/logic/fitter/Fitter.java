/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import jdk.nashorn.internal.ir.BreakNode;
import managerindustry.logic.enumName.PlatformEnum;
import managerindustry.logic.enumName.RuleBonusRigEnum;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.enumName.TierEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.fitter.duplicateRig.DuplicateRig;
import managerindustry.logic.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.structure.engineeringRig.EngineeringRig_OLD;

/**
 *
 * @author lele
 */
public class Fitter {
    private EngineeringComplex engineeringComplex;
    private Map< Integer, DuplicateRig > maxGroupFittedMap = new HashMap<>();
    private float currentCalibration = 0;
    private float currentSlot = 0;
    
    private enum ADD_RIGS {NEW, ADD_ANOTHER, DONT_ADD;}
    
    public Fitter() {
        engineeringComplex(PlatformEnum.RAITARU);
        engineeringComplex.displayValue();

    }
    
    public void engineeringComplex(PlatformEnum platformEnum){
        engineeringComplex = new EngineeringComplex(platformEnum);
    }
    
    public void structureEngineeringRigs(TierEnum tierEnum, RuleBonusRigEnum bonusRigEnum, SecurityStatusEnum securityStatusEnum){
        EngineeringRig_OLD structureEngineeringRigs = new EngineeringRig_OLD(tierEnum, bonusRigEnum, securityStatusEnum);
    }
    
    private void addRig(EngineeringRig_OLD structureEngineeringRigs) throws ErrorExeption{
        if ( currentSlot <= engineeringComplex.getMaxRigSlot()){
            
            if ( currentCalibration > engineeringComplex.getMaxCalibrationComplex())
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);
            
            if ( ( currentCalibration + structureEngineeringRigs.getCalibration() ) 
                    > engineeringComplex.getMaxCalibrationComplex() ){
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_CALIBRATION);
            }
        
            ADD_RIGS addRig = maxGroupFitted(structureEngineeringRigs);
            
            switch (addRig){
                case ADD_ANOTHER:
                    int tempCurrentRig = 
                        maxGroupFittedMap.get(structureEngineeringRigs).getCurrentRigFitted();
                                                
                    maxGroupFittedMap.put(structureEngineeringRigs.getTypeID(),
                        new DuplicateRig(structureEngineeringRigs.getTypeID(),
                        tempCurrentRig++, 
                        structureEngineeringRigs.getMaxGroupFitted()));
                    break;
                case DONT_ADD:
                    throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
                case NEW:
                    maxGroupFittedMap.put(structureEngineeringRigs.getTypeID(), new DuplicateRig
                        ( structureEngineeringRigs.getTypeID(), 
                          structureEngineeringRigs.getMaxGroupFitted()) );
                    break;
                default:
                    throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.UNKNOW_ERROR);
            }
            
        }else{
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_SLOT_RIGS);
        }
        
    }
    
    /**
     * Calculate max Group Fitted
     * @param StructureEngineeringRigs structureEngineeringRigs
     * @return ENUM ADD_RIGS
     */
    private ADD_RIGS maxGroupFitted(EngineeringRig_OLD engineeringRigs){
        if ( maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
            
            DuplicateRig duplicateRig = 
                maxGroupFittedMap.get(engineeringRigs.getTypeID());
            
                int currentRigFitted = duplicateRig.getCurrentRigFitted();
                
                if (currentRigFitted++ <= duplicateRig.getMaxGroupFitted() )
                    return ADD_RIGS.ADD_ANOTHER;
                else
                    return ADD_RIGS.DONT_ADD;
        }else{
            return ADD_RIGS.NEW;
        }           
    }
}
