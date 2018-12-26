/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs_Logic;
import managerindustry.logic.generic.enumName.ChooseEngineeringRigEnum;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.largeRig.InitLargeRigGroups;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.mediumRig.InitMediumRigGroups;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.xl_Rig.InitXLRigGroups;

/**
 *
 * @author lele
 */
public class ChooseRig {
    private InitMediumRigGroups initMediumRigGroups = new InitMediumRigGroups();
    private InitLargeRigGroups initLargeRigGroups = new InitLargeRigGroups();
    private InitXLRigGroups initXLRigGroups = new InitXLRigGroups();
    
    /**
     * Get Effect Rig and his effect
     * @param int typeID is enginnering rig like Standup M-Set Blueprint Copy Accelerator II
     * @param int effectID has effect on item to build like ammunition
     * @return boolean
     */
    public boolean isEffectEngineeringRig(int rigTypeID, int effectID_Item){
        EffectEngineeringRigs_Logic engineeringRigs = new EffectEngineeringRigs_Logic();
        
        if (engineeringRigs.getEffectEngineeringRig(rigTypeID, effectID_Item) == null ){
            return false;
        }
        
        return true;
    }
    
    /**
     * Is exits?
     * @param rigTypeID typeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     * @return boolean
     */
    private boolean isExits(int rigTypeID){
        EffectEngineeringRigs_Logic engineeringRigs = new EffectEngineeringRigs_Logic();
        
        if (engineeringRigs.getEffectEngineeringRig(rigTypeID) == null ){
            return false;
        }
        
        return true;
    }
    
    /**
     * Init and add to db if not exits
     * @param rigTypeID typeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     */
    public ChooseRig(int rigTypeID) {
        if ( isExits(rigTypeID) )
            return;
        
        if ( ChooseEngineeringRigEnum.M_EQUIPMENT_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_EQUIPMENT_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_EQUIPMENT_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_EQUIPMENT_TE_1.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetEquipmentManufacturing(rigTypeID);
            return;
        }        
        
        /**
         *  it's not error
         * Advanced Component Manufacturing / Thukker Advanced Component Manufacturing 
         * getAdvancedComponents, getAdvancedCapitalComponents, getRam, getSubsystemComponents 
         */
        if ( ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_TE_1.getRigTypeID() == rigTypeID || 
             ChooseEngineeringRigEnum.M_THUKKER_ADVANCED_COMPONENT.getRigTypeID() == rigTypeID ){ // < it's same
            initMediumRigGroups.initStandupMSetAdvancedComponentManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_TE_1.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetAdvancedLargeShipManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_TE_1.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetAdvancedMediumShipManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_TE_1.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetAdvancedSmallShipManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_AMMUNITION_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_AMMUNITION_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_AMMUNITION_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_AMMUNITION_TE_1.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetAmmunitionManufacturing(rigTypeID);
            return;
        }                
        
        /**
         * it's not error
         * Basic Capital Component Manufacturing / Thukker Basic Capital Component Manufacturing
         * getStandardCapitalShipComponents  
         */
        if ( ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_THUKKER_BASIC_CAPITAL.getRigTypeID() == rigTypeID ){ // < it's same
            initMediumRigGroups.initStandupMSetBasicCapitalComponentManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_TE_1.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetBasicLargeShipManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_TE_2.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetBasicMediumShipManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_TE_2.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetBasicSmallShipManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_DRONE_FIGHTER_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_TE_2.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetDroneAndFighterManufacturing(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_STRUCTURE_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_STRUCTURE_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_STRUCTURE_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_STRUCTURE_TE_2.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetStructureManufacturing(rigTypeID);
            return;
        }        
        

        // ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT
//        if ( ChooseEngineeringRigEnum.M_THUKKER_BASIC_CAPITAL.getTypeID() == rigTypeID ){
//            initMediumRigGroups.initStandupMSetThukkerBasicCapitalComponentManufacturing(rigTypeID);
//            return;
//        }
        
//        // check ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_1
//        if ( ChooseEngineeringRigEnum.M_THUKKER_ADVANCED_COMPONENT.getTypeID() == rigTypeID ){
//            initMediumRigGroups.initStandupMSetThukkerAdvancedComponentManufacturing(rigTypeID);
//            return;
//        }        
        
        if ( ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_ACCELERATOR_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_ACCELERATOR_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_COST_OPTIMIZATION_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_COST_OPTIMIZATION_2.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetBlueprintCopy(rigTypeID);
            return;
        }         
        
        if ( ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_ACCELERATOR_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_ACCELERATOR_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_2.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetInvention(rigTypeID);
            return;
        }         
        
        // controllare
        if ( ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_ME_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_ME_2.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetMEResearch(rigTypeID);
            return;
        }                 
        
        if ( ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_TE_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_TE_2.getRigTypeID() == rigTypeID ){
            initMediumRigGroups.initStandupMSetTEResearch(rigTypeID);  
            return;
        }         
        
        if ( ChooseEngineeringRigEnum.L_AMMUNITION_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_AMMUNITION_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetAmmunitionManufacturing(rigTypeID);            
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_BASIC_LARGE_SHIP_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_BASIC_LARGE_SHIP_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetBasicLargeShipManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_ADVANCED_LARGE_SHIP_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_ADVANCED_LARGE_SHIP_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetAdvancedLargeShipManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_EQUIPMENT_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_EQUIPMENT_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetEquipmentManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_CAPITAL_SHIP_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_CAPITAL_SHIP_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetCapitalShipManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_ADVANCED_COMPONENT_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_ADVANCED_COMPONENT_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetAdvancedComponentManufacturing(rigTypeID);                
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_ADVANCED_SMALL_SHIP_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_ADVANCED_SMALL_SHIP_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetAdvancedSmallShipManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_ADVANCED_MEDIUM_SHIP_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_ADVANCED_MEDIUM_SHIP_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetAdvancedMediumShipManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_DRONE_FIGHTER_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_DRONE_FIGHTER_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetDroneAndFighterManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_BASIC_SMALL_SHIP_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_BASIC_SMALL_SHIP_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetBasicSmallShipManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_BASIC_MEDIUM_SHIP_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_BASIC_MEDIUM_SHIP_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetBasicMediumShipManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_CAPITAL_SHIP_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_CAPITAL_SHIP_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetCapitalShipManufacturing(rigTypeID);
            return;
        }
                
        if ( ChooseEngineeringRigEnum.L_STRUCTURE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_STRUCTURE_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetStructureManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_THUKKER_BASIC_CAPITAL_COMPONENT.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetThukkerBasicCapitalComponentManufacturing(rigTypeID);
            return;
        }
                
        if ( ChooseEngineeringRigEnum.L_THUKKER_ADVANCED_COMPONENT.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetThukkerAdvancedComponentManufacturing(rigTypeID);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_BLUEPRINT_INVENTION_OPTIMIZATION_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_BLUEPRINT_INVENTION_OPTIMIZATION_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetInvention(rigTypeID);  
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_ME_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_ME_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetMEResearch(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_TE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_TE_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetTEResearch(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.L_BLUEPRINT_COPY_OPTIMIZATION_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.L_BLUEPRINT_COPY_OPTIMIZATION_2.getRigTypeID() == rigTypeID ){
            initLargeRigGroups.initStandupLSetBlueprintCopyOptimization(rigTypeID);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_EQUIPMENT_CONSUMABLE_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.XL_EQUIPMENT_CONSUMABLE_2.getRigTypeID() == rigTypeID ){
            initXLRigGroups.initStandupXLSetEquipmentAndConsumableManufacturing(rigTypeID);            
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_SHIP_MANUFACTURING_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.XL_SHIP_MANUFACTURING_1.getRigTypeID() == rigTypeID ){
            initXLRigGroups.initStandupXLSetShipManufacturing(rigTypeID);         
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_STRUCTURE_COMPONENT_1.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.XL_STRUCTURE_COMPONENT_2.getRigTypeID() == rigTypeID ){
            initXLRigGroups.initStandupXLSetStructureAndComponentManufacturing(rigTypeID);        
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_THUKKER_STRUCTURE_COMPONENT.getRigTypeID() == rigTypeID ){
            initXLRigGroups.initStandupXLSetStructureAndComponentManufacturing(rigTypeID);        
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_BLUEPRINT_LABORATORY_2.getRigTypeID() == rigTypeID ||
             ChooseEngineeringRigEnum.XL_BLUEPRINT_LABORATORY_1.getRigTypeID() == rigTypeID ){
            initXLRigGroups.initStandupXLSetLaboratory(rigTypeID);
            return;
        }                              
    }
}
