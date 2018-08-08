/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.mediumRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;

/**
 *
 * @author lele
 */
public class InitMediumRigGroups {
    private InitCommonRigGroups initCommonRigGroups = new InitCommonRigGroups();
    
    public InitMediumRigGroups() {

        
    }
    
    private InitCommonRigGroups DBGinitMedium(){
        initStandupMSetEquipmentManufacturing(0);
        initStandupMSetAdvancedComponentManufacturing(0);
        initStandupMSetAdvancedLargeShipManufacturing(0);
        initStandupMSetAdvancedMediumShipManufacturing(0);
        initStandupMSetAdvancedSmallShipManufacturing(0);
        initStandupMSetAmmunitionManufacturing(0);
        initStandupMSetBasicCapitalComponentManufacturing(0);
        initStandupMSetBasicLargeShipManufacturing(0);
        initStandupMSetBasicMediumShipManufacturing(0);
        initStandupMSetBasicSmallShipManufacturing(0);
        initStandupMSetDroneAndFighterManufacturing(0);
        initStandupMSetStructureManufacturing(0);
//        initStandupMSetThukkerAdvancedComponentManufacturing(0);
//        initStandupMSetThukkerBasicCapitalComponentManufacturing(0);
        initStandupMSetBlueprintCopy(0);
        initStandupMSetInvention(0);
        initStandupMSetMEResearch(0);
        initStandupMSetTEResearch(0);   
        return initCommonRigGroups;
    }
    /**
     * Init Standup MSet Equipment Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetEquipmentManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
      
    /**
     * @deprecated 
     * mancano i data interfaces 
     * @param int typeId 
     */
    public void initStandupMSetAdvancedComponentManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs); 
    }
    
    /**
     * Init Standup MSet Advanced Large Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetAdvancedLargeShipManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Advanced Medium Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetAdvancedMediumShipManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Advanced Small Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetAdvancedSmallShipManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Ammunition Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetAmmunitionManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Capital Component Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetBasicCapitalComponentManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Large Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetBasicLargeShipManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Medium Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetBasicMediumShipManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Small Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetBasicSmallShipManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId,effectRigs);
    }
        
    /**
     * init Standup MSet Drone And Fighter Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetDroneAndFighterManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Init Standup MSet Structure Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetStructureManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }    
    
    /**
     * @deprecated 
     * mancano ti data interfaces
     * @param int typeId 
     */
    public void initStandupMSetThukkerAdvancedComponentManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();     
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }

    /**
     * Init Standup MSet Thukker Basic Capital Component Manufacturing
     * @param int typeId 
     */
    public void initStandupMSetThukkerBasicCapitalComponentManufacturing(int typeId){
        List < RigRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
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