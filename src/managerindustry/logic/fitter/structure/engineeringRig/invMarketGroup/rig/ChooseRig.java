/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig;

import managerindustry.logic.enumName.ChooseEngineeringRigEnum;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs;
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
    public boolean isEffectEngineeringRig(int typeID, int effectID_Item){
        EffectEngineeringRigs engineeringRigs = new EffectEngineeringRigs();
        
        if (engineeringRigs.getEffectEngineeringRig(typeID, effectID_Item) == null ){
            return false;
        }
        
        return true;
    }
    
    /**
     * Is exits?
     * @param typeID typeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     * @return boolean
     */
    private boolean isExits(int typeID){
        EffectEngineeringRigs engineeringRigs = new EffectEngineeringRigs();
        if (engineeringRigs.getEffectEngineeringRig(typeID) == null ){
            return false;
        }
        
        return true;
    }
    
    /**
     * Init and add to db if not exits
     * @param typeId typeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     */
    public ChooseRig(int typeId) {
        if ( isExits(typeId) )
            return;
        
        if ( ChooseEngineeringRigEnum.M_EQUIPMENT_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_EQUIPMENT_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_EQUIPMENT_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_EQUIPMENT_TE_1.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetEquipmentManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_COMPONENT_TE_1.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetAdvancedComponentManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_LARGE_SHIP_TE_1.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetAdvancedLargeShipManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_MEDIUM_SHIP_TE_1.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetAdvancedMediumShipManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_ADVANCED_SMALL_SHIP_TE_1.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetAdvancedSmallShipManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_AMMUNITION_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_AMMUNITION_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_AMMUNITION_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_AMMUNITION_TE_1.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetAmmunitionManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_CAPITAL_COMPONENT_TE_1.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetBasicCapitalComponentManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_LARGE_SHIP_TE_1.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetBasicLargeShipManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_MEDIUM_SHIP_TE_2.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetBasicMediumShipManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BASIC_SMALL_SHIP_TE_2.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetBasicSmallShipManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_DRONE_FIGHTER_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_DRONE_FIGHTER_TE_2.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetDroneAndFighterManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_STRUCTURE_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_STRUCTURE_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_STRUCTURE_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_STRUCTURE_TE_2.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetStructureManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_THUKKER_BASIC_CAPITAL.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetThukkerBasicCapitalComponentManufacturing(typeId);
            return;
        }
            
        if ( ChooseEngineeringRigEnum.M_THUKKER_ADVANCED_COMPONENT.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetThukkerAdvancedComponentManufacturing(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_ACCELERATOR_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_ACCELERATOR_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_COST_OPTIMIZATION_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_COPY_COST_OPTIMIZATION_2.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetBlueprintCopy(typeId);
            return;
        }         
        
        if ( ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_ACCELERATOR_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_ACCELERATOR_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_INVENTION_COST_OPTIMIZATION_2.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetInvention(typeId);
            return;
        }         
        
        // controllare
        if ( ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_ME_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_ME_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_ME_2.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetMEResearch(typeId);
            return;
        }                 
        
        if ( ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_ACCELERATOR_TE_2.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_TE_1.getTypeID() == typeId ||
             ChooseEngineeringRigEnum.M_BLUEPRINT_RESEARCH_COST_OPTIMIZATION_TE_2.getTypeID() == typeId ){
            initMediumRigGroups.initStandupMSetTEResearch(typeId);  
            return;
        }         
        
        if ( ChooseEngineeringRigEnum.L_AMMUNITION_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_AMMUNITION_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetAmmunitionManufacturing(typeId);            
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_BASIC_LARGE_SHIP_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_BASIC_LARGE_SHIP_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetBasicLargeShipManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_ADVANCED_LARGE_SHIP_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_ADVANCED_LARGE_SHIP_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetAdvancedLargeShipManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_EQUIPMENT_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_EQUIPMENT_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetEquipmentManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_CAPITAL_SHIP_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_CAPITAL_SHIP_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetCapitalShipManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_ADVANCED_COMPONENT_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_ADVANCED_COMPONENT_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetAdvancedComponentManufacturing(typeId);                
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_ADVANCED_SMALL_SHIP_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_ADVANCED_SMALL_SHIP_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetAdvancedSmallShipManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_ADVANCED_MEDIUM_SHIP_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_ADVANCED_MEDIUM_SHIP_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetAdvancedMediumShipManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_DRONE_FIGHTER_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_DRONE_FIGHTER_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetDroneAndFighterManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_BASIC_SMALL_SHIP_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_BASIC_SMALL_SHIP_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetBasicSmallShipManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_BASIC_MEDIUM_SHIP_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_BASIC_MEDIUM_SHIP_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetBasicMediumShipManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_CAPITAL_SHIP_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_CAPITAL_SHIP_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetCapitalShipManufacturing(typeId);
            return;
        }
                
        if ( ChooseEngineeringRigEnum.L_STRUCTURE_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_STRUCTURE_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetStructureManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_THUKKER_BASIC_CAPITAL_COMPONENT.getTypeID()== typeId ){
            initLargeRigGroups.initStandupLSetThukkerBasicCapitalComponentManufacturing(typeId);
            return;
        }
                
        if ( ChooseEngineeringRigEnum.L_THUKKER_ADVANCED_COMPONENT.getTypeID()== typeId ){
            initLargeRigGroups.initStandupLSetThukkerAdvancedComponentManufacturing(typeId);
            return;
        }
        
        if ( ChooseEngineeringRigEnum.L_BLUEPRINT_INVENTION_OPTIMIZATION_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_BLUEPRINT_INVENTION_OPTIMIZATION_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetInvention(typeId);  
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_ME_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_ME_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetMEResearch(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_TE_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_BLUEPRINT_RESEARCH_OPTIMIZATION_TE_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetTEResearch(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.L_BLUEPRINT_COPY_OPTIMIZATION_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.L_BLUEPRINT_COPY_OPTIMIZATION_2.getTypeID() == typeId ){
            initLargeRigGroups.initStandupLSetBlueprintCopyOptimization(typeId);
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_EQUIPMENT_CONSUMABLE_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.XL_EQUIPMENT_CONSUMABLE_2.getTypeID() == typeId ){
            initXLRigGroups.initStandupXLSetEquipmentAndConsumableManufacturing(typeId);            
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_SHIP_MANUFACTURING_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.XL_SHIP_MANUFACTURING_1.getTypeID() == typeId ){
            initXLRigGroups.initStandupXLSetShipManufacturing(typeId);         
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_STRUCTURE_COMPONENT_1.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.XL_STRUCTURE_COMPONENT_2.getTypeID() == typeId ){
            initXLRigGroups.initStandupXLSetStructureAndComponentManufacturing(typeId);        
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_THUKKER_STRUCTURE_COMPONENT.getTypeID()== typeId ){
            initXLRigGroups.initStandupXLSetStructureAndComponentManufacturing(typeId);        
            return;
        }        
        
        if ( ChooseEngineeringRigEnum.XL_BLUEPRINT_LABORATORY_2.getTypeID()== typeId ||
             ChooseEngineeringRigEnum.XL_BLUEPRINT_LABORATORY_1.getTypeID() == typeId ){
            initXLRigGroups.initStandupXLSetLaboratory(typeId);
            return;
        }                              
    }
}
