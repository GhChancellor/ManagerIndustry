/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.cache.AvoidDuplicateRigEntity;
import managerindustry.logic.generic.enumName.ChooseEngineeringRigEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.fitter.EngineeringComplexSlot;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.manager.db.item.cache.avoidDuplicateRig.AvoidDuplicateRigX;
import managerindustry.logic.manager.db.item.cache.avoidDuplicateRig.AvoidDuplicateRigX.Parameter;

/**
 * Evita che due rig dello stesso tipo T1 o T2 vengano aggiunti
 * @author lele
 */
public class AvoidDuplicateRig {
    private List < Integer > avoidDuplicateRigs = new ArrayList<>();
    
    private enum TIER{T1,T2};
       
    public AvoidDuplicateRig() {
        // Check if already exists in to db
        checkIfDbExits();        
    }
    
    /**
     * Max Modules Of This Group Allowed
     * @param maxGroupFittedMap
     * @param engineeringRigs
     * @param engineeringRigEnum
     * @throws ErrorExeption 
     */
    public void maxGroupFitted( Map<Integer, MaxGroupFitted> maxGroupFittedMap,
        EngineeringRig engineeringRigs,
        EngineeringComplexSlot.EngineeringRigEnum engineeringRigEnum ) throws ErrorExeption {
        
        // Max Modules Of This Group Allowed
        // 10-07-2018 Il gioco prevede SOLO 1 rig dello stesso tipo. 
        if ( maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
            switch (engineeringRigEnum){
                case ADD:
                    if( maxGroupFittedMap.get(engineeringRigs.getTypeID()).getCurrentFitted() >= 
                        engineeringRigs.getMaxGroupFitted().intValue() ){
                            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
                    }                       
                case REMOVE:
                    if (maxGroupFittedMap.get(engineeringRigs.getTypeID()).getCurrentFitted() <= 0){
                        throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.CANT_REMOVE);
                    }                    
            default:
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.UNKNOW_ERROR);             
            }
        }

        // non puoi mettere solo lo stesso rig in versione T1 e T2 contemporaneamente
        addOpposite(AvoidDuplicateRigX.NamedQueryEnum.QUERY_1, Parameter.PARAMETER_1, engineeringRigs.getTypeID(), TIER.T1);
        addOpposite(AvoidDuplicateRigX.NamedQueryEnum.QUERY_2, Parameter.PARAMETER_2, engineeringRigs.getTypeID(), TIER.T2);
    
        for (Integer avoidDuplicateRig : avoidDuplicateRigs) {
            if (avoidDuplicateRig == engineeringRigs.getTypeID()){
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
            }
        }         
    }
    
    /**
     * Add Opposite
     * @param NamedQueryEnum namedQueryEnum
     * @param Parameter parameter
     * @param int value
     * @param TIER tier
     */
    private void addOpposite(AvoidDuplicateRigX.NamedQueryEnum namedQueryEnum, 
        Parameter parameter, int typeId, AvoidDuplicateRig.TIER tier ) throws ErrorExeption {

        AvoidDuplicateRigEntity avoidDuplicateRigEntity = 
            Manager.getInstance().db().item().avoidDuplicateRigEntity().getAvoidDuplicateRig(
            namedQueryEnum, parameter, typeId);
        
        if (avoidDuplicateRigEntity == null)
            return;
        
        switch(tier){
            case T1:
                addAvoidDuplicateRigs( avoidDuplicateRigEntity.getTypeId_T2() );
                break;
            case T2:
                addAvoidDuplicateRigs( avoidDuplicateRigEntity.getTypeId_T1() );
                break;
            default:
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.UNKNOW_ERROR);  
        }
    }

    /**
     * Check and add if there are not duplicate
     * @param value 
     */
    private void addAvoidDuplicateRigs(Integer value) {
        if ( avoidDuplicateRigs.contains(value) == false){
            avoidDuplicateRigs.add(value);
        }
    }  

    /**
     * Add Effect Rigs
     * @param AvoidDuplicateRigEntity avoidDuplicateRigEntity 
     */
    private void addRigsToDb(AvoidDuplicateRigEntity avoidDuplicateRigEntity){
        Manager.getInstance().db().item().avoidDuplicateRigEntity().addEffectRigs(avoidDuplicateRigEntity);
    }    
    
    /**
     * Check if already exists in to db
     * @param NamedQueryEnum namedQueryEnum
     * @param Parameter parameter
     * @param int value
     * @return boolean
     */
    private void checkIfDbExits(){
        
        AvoidDuplicateRigEntity avoidDuplicateRigEntity = 
            Manager.getInstance().db().item().avoidDuplicateRigEntity().getAvoidDuplicateRig(
            AvoidDuplicateRigX.NamedQueryEnum.QUERY_1, 
            Parameter.PARAMETER_1, 
            ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_1.getRigTypeID());
        
        if ( avoidDuplicateRigEntity == null){
            initDB();
        }
    }
    
    /**
     * Create Incompatible Object
     * @param typeID_T1
     * @param typeID_T2 
     */
    private void createIncompatibleObject(int typeID_T1, int typeID_T2){
        AvoidDuplicateRigEntity avoidDuplicateRigEntity = new AvoidDuplicateRigEntity(typeID_T1, typeID_T2);
        addRigsToDb(avoidDuplicateRigEntity);        
    }
    
    /**
     * Init all object
     */
    private void initDB(){
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_AMMUNITION_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_AMMUNITION_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_AMMUNITION_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_AMMUNITION_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_ACCELERATOR_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_ACCELERATOR_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_COST_OPTIMIZATION_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_COST_OPTIMIZATION_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_ACCELERATOR_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_ACCELERATOR_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_DRONE_FIGHTER_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_DRONE_FIGHTER_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_EQUIPMENT_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_EQUIPMENT_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_EQUIPMENT_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_EQUIPMENT_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_STRUCTURE_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_STRUCTURE_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_STRUCTURE_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.M_STRUCTURE_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_ADVANCED_COMPONENT_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_ADVANCED_COMPONENT_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_ADVANCED_LARGE_SHIP_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_ADVANCED_LARGE_SHIP_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_AMMUNITION_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_AMMUNITION_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BASIC_LARGE_SHIP_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_BASIC_LARGE_SHIP_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_ADVANCED_MEDIUM_SHIP_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_ADVANCED_MEDIUM_SHIP_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_ADVANCED_SMALL_SHIP_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_ADVANCED_SMALL_SHIP_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BASIC_CAPITAL_COMPONENT_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_BASIC_CAPITAL_COMPONENT_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BASIC_MEDIUM_SHIP_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_BASIC_MEDIUM_SHIP_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BASIC_SMALL_SHIP_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_BASIC_SMALL_SHIP_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BLUEPRINT_INVENTION_OPTIMIZATION_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_BLUEPRINT_INVENTION_OPTIMIZATION_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_ME_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_ME_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_TE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_TE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BLUEPRINT_COPY_OPTIMIZATION_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_BLUEPRINT_COPY_OPTIMIZATION_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_CAPITAL_SHIP_2.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_CAPITAL_SHIP_1.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_DRONE_FIGHTER_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_DRONE_FIGHTER_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_EQUIPMENT_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_EQUIPMENT_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_STRUCTURE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.L_STRUCTURE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.XL_EQUIPMENT_CONSUMABLE_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.XL_EQUIPMENT_CONSUMABLE_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.XL_BLUEPRINT_LABORATORY_2.getRigTypeID(), 
             ChooseEngineeringRigEnum.XL_BLUEPRINT_LABORATORY_1.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.XL_SHIP_MANUFACTURING_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.XL_SHIP_MANUFACTURING_2.getRigTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.XL_STRUCTURE_COMPONENT_1.getRigTypeID(), 
             ChooseEngineeringRigEnum.XL_STRUCTURE_COMPONENT_2.getRigTypeID());        
    }    

}
