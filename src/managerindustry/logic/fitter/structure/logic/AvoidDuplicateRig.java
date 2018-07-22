/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.logic;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.cache.AvoidDuplicateRigEntity;
import managerindustry.logic.enumName.ChooseEngineeringRigEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.ManagerErrorExecption;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.manager.managerDB.cache.avoidDuplicateRig.AvoidDuplicateRigX;
import managerindustry.logic.manager.managerDB.cache.avoidDuplicateRig.AvoidDuplicateRigX.Parameter;

/**
 *
 * @author lele
 */
public class AvoidDuplicateRig {
    private List < Integer > avoidDuplicateRigs = new ArrayList();
    private enum TIER{T1,T2};
    
    public AvoidDuplicateRig() {
        if ( isDuplicateInToDb(AvoidDuplicateRigX.NamedQueryEnum.QUERY_1, 
             AvoidDuplicateRigX.Parameter.PARAMETER_1, 
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_1.getTypeID()) ){
        
            return;
        }
        
        init();
    }
    
    public boolean isOpposite(int value){

        if ( getOpposite(AvoidDuplicateRigX.NamedQueryEnum.QUERY_1, 
            AvoidDuplicateRigX.Parameter.PARAMETER_1, value, TIER.T1) == -1 ){
            return false;
        }
        
        if ( getOpposite(AvoidDuplicateRigX.NamedQueryEnum.QUERY_2, 
            AvoidDuplicateRigX.Parameter.PARAMETER_2, value, TIER.T2) == -1 ){
            return false;
        }
        return true;
    }
    
    private int getOpposite(AvoidDuplicateRigX.NamedQueryEnum namedQueryEnum, 
        Parameter parameter, int value, TIER tier ){
        
        AvoidDuplicateRigEntity avoidDuplicateRigEntity = 
            ManagerDB.getInstance().avoidDuplicateRigEntity().getAvoidDuplicateRig(
            namedQueryEnum, parameter, value);
        
        if (avoidDuplicateRigEntity == null)
            return -10; 
        
        switch(tier){
            
            case T1:
                if (avoidDuplicateRigs.isEmpty()){
//                    addAvoidDuplicateRigs(avoidDuplicateRigEntity.getTypeId_T1());
//                    return avoidDuplicateRigEntity.getTypeId_T1();                    
                }
                
                if (avoidDuplicateRigs.contains(avoidDuplicateRigEntity.getTypeId_T1())){
//                    avoidDuplicateRigs.add(avoidDuplicateRigEntity.getTypeId_T1());
//                    return avoidDuplicateRigEntity.getTypeId_T1();
                }                 
                return -1;
            case T2:
                if (avoidDuplicateRigs.isEmpty()){
//                    avoidDuplicateRigs.add(avoidDuplicateRigEntity.getTypeId_T2());
//                    return avoidDuplicateRigEntity.getTypeId_T2();                    
                }                
                
                if (avoidDuplicateRigs.contains(avoidDuplicateRigEntity.getTypeId_T2()) ){
//                    avoidDuplicateRigs.add(avoidDuplicateRigEntity.getTypeId_T2());                
//                    return avoidDuplicateRigEntity.getTypeId_T2();                    
                }                  
                return -1;
            default:
                return -1;
        }         

    }    
    
    /**
     * Add Effect Rigs
     * @param AvoidDuplicateRigEntity avoidDuplicateRigEntity 
     */
    private void addRigsToDb(AvoidDuplicateRigEntity avoidDuplicateRigEntity){
        ManagerDB.getInstance().avoidDuplicateRigEntity().addEffectRigs(avoidDuplicateRigEntity);
    }    
    
    /**
     * Check if already exists in to db
     * @param NamedQueryEnum namedQueryEnum
     * @param Parameter parameter
     * @param int value
     * @return 
     */
    private boolean isDuplicateInToDb(AvoidDuplicateRigX.NamedQueryEnum namedQueryEnum, 
        AvoidDuplicateRigX.Parameter parameter, int value){
        
        if ( ManagerDB.getInstance().avoidDuplicateRigEntity().getAvoidDuplicateRig(
            namedQueryEnum, parameter, value) == null){
            return false;
        }else{
            return true;
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

    private List<Integer> getAvoidDuplicateRigs() {
        return avoidDuplicateRigs;
    }

    private void setAvoidDuplicateRigs(List<Integer> avoidDuplicateRigs) {
        this.avoidDuplicateRigs = avoidDuplicateRigs;
    }

    private void addAvoidDuplicateRigs(Integer avoidDuplicateRig) {
        if ( this.avoidDuplicateRigs.contains(avoidDuplicateRig) == false){
            this.avoidDuplicateRigs.add(avoidDuplicateRig);
        }
    }
    
    /**
     * Init all object
     */
    private void init(){
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_AMMUNITION_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_AMMUNITION_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_AMMUNITION_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_AMMUNITION_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_ACCELERATOR_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_ACCELERATOR_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_COST_OPTIMIZATION_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_COST_OPTIMIZATION_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_ACCELERATOR_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_ACCELERATOR_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_DRONE_FIGHTER_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_DRONE_FIGHTER_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_EQUIPMENT_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_EQUIPMENT_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_EQUIPMENT_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_EQUIPMENT_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_STRUCTURE_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_STRUCTURE_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.M_STRUCTURE_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.M_STRUCTURE_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_ADVANCED_COMPONENT_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_ADVANCED_COMPONENT_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_ADVANCED_LARGE_SHIP_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_ADVANCED_LARGE_SHIP_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_AMMUNITION_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_AMMUNITION_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BASIC_LARGE_SHIP_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_BASIC_LARGE_SHIP_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_ADVANCED_MEDIUM_SHIP_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_ADVANCED_MEDIUM_SHIP_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_ADVANCED_SMALL_SHIP_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_ADVANCED_SMALL_SHIP_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BASIC_CAPITAL_COMPONENT_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_BASIC_CAPITAL_COMPONENT_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BASIC_MEDIUM_SHIP_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_BASIC_MEDIUM_SHIP_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BASIC_SMALL_SHIP_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_BASIC_SMALL_SHIP_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BLUEPRINT_INVENTION_OPTIMIZATION_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_BLUEPRINT_INVENTION_OPTIMIZATION_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_ME_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_ME_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_TE_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_TE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_BLUEPRINT_COPY_OPTIMIZATION_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_BLUEPRINT_COPY_OPTIMIZATION_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_CAPITAL_SHIP_2.getTypeID(), 
             ChooseEngineeringRigEnum.L_CAPITAL_SHIP_1.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_DRONE_FIGHTER_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_DRONE_FIGHTER_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_EQUIPMENT_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_EQUIPMENT_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.L_STRUCTURE_1.getTypeID(), 
             ChooseEngineeringRigEnum.L_STRUCTURE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.XL_EQUIPMENT_CONSUMABLE_1.getTypeID(), 
             ChooseEngineeringRigEnum.XL_EQUIPMENT_CONSUMABLE_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.XL_BLUEPRINT_LABORATORY_2.getTypeID(), 
             ChooseEngineeringRigEnum.XL_BLUEPRINT_LABORATORY_1.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.XL_SHIP_MANUFACTURING_1.getTypeID(), 
             ChooseEngineeringRigEnum.XL_SHIP_MANUFACTURING_2.getTypeID());
        
        createIncompatibleObject
            (ChooseEngineeringRigEnum.XL_STRUCTURE_COMPONENT_1.getTypeID(), 
             ChooseEngineeringRigEnum.XL_STRUCTURE_COMPONENT_2.getTypeID());        
    }
    

}
