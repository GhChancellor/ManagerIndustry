/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.mediumRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.manager.db.Db;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigsXXX;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;

/**
 *
 * @author lele
 */
public class InitMediumRigGroups {
    private InitCommonRigGroups initCommonRigGroups = new InitCommonRigGroups();
    
    public InitMediumRigGroups() {
//        initStandupMSetEquipmentManufacturing();
//        initStandupMSetAdvancedComponentManufacturing();
//        initStandupMSetAdvancedLargeShipManufacturing();
//        initStandupMSetAdvancedMediumShipManufacturing();
//        initStandupMSetAdvancedSmallShipManufacturing();
//        initStandupMSetAmmunitionManufacturing();
//        initStandupMSetBasicCapitalComponentManufacturing();
//        initStandupMSetBasicLargeShipManufacturing();
//        initStandupMSetBasicMediumShipManufacturing();
//        initStandupMSetBasicSmallShipManufacturing();
//        initStandupMSetDroneAndFighterManufacturing();
//        initStandupMSetStructureManufacturing();
//        initStandupMSetThukkerAdvancedComponentManufacturing();
//        initStandupMSetThukkerBasicCapitalComponentManufacturing();
//        initStandupMSetBlueprintCopy();
//        initStandupMSetInvention();
//        initStandupMSetMEResearch();
//        initStandupMSetTEResearch();
    }
    
    /**
     * Init Standup MSet Equipment Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetEquipmentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
      
    /**
     * @deprecated 
     * mancano i data interfaces 
     * @param int typeId 
     */
    public void initStandupMSetAdvancedComponentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs); 
    }
    
    /**
     * Init Standup MSet Advanced Large Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetAdvancedLargeShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Advanced Medium Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetAdvancedMediumShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Advanced Small Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetAdvancedSmallShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Ammunition Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetAmmunitionManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Capital Component Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetBasicCapitalComponentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Large Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetBasicLargeShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Medium Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetBasicMediumShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Small Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetBasicSmallShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId,effectRigs);
    }
        
    /**
     * init Standup MSet Drone And Fighter Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetDroneAndFighterManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Structure Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetStructureManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }    
    
    /**
     * @deprecated 
     * mancano ti data interfaces
     * @param int typeId 
     */
    public void initStandupMSetThukkerAdvancedComponentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();     
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }

    /**
     * Init Standup MSet Thukker Basic Capital Component Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetThukkerBasicCapitalComponentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);       
    }
    
    /**
     * Init Standup MSet Blueprint Copy 
     * bonuses apply to all blueprints
     * @param int typeId 
     */
    public void initStandupMSetBlueprintCopy(int typeId){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());
    }    
    
    /**
     * Init Standup MSet Invention
     * bonuses apply to all blueprints
     * @param int typeId 
     */
    public void initStandupMSetInvention(int typeId){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());
    }
    
    /**
     * Init Standup MSet ME Research
     * bonuses apply to all blueprints
     * @param int typeId 
     */
    public void initStandupMSetMEResearch(int typeId){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());
    }
    
    /**
     * Init Standup MSet TE Research
     * bonuses apply to all blueprints
     * @param int typeId 
     */
    public void initStandupMSetTEResearch(int typeId){
        // new ArrayList<>() must be empty               
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());        
    }    
 
}

/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/