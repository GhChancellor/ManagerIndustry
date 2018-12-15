/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.mediumRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;

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
     * @param int rigTypeID 
     */
    public void initStandupMSetEquipmentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
      
    /**
     * @deprecated 
     * mancano i data interfaces 
     * @param int rigTypeID 
     */
    public void initStandupMSetAdvancedComponentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs); 
    }
    
    /**
     * Init Standup MSet Advanced Large Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetAdvancedLargeShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Init Standup MSet Advanced Medium Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetAdvancedMediumShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Init Standup MSet Advanced Small Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetAdvancedSmallShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Init Standup MSet Ammunition Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetAmmunitionManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Capital Component Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetBasicCapitalComponentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Large Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetBasicLargeShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Medium Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetBasicMediumShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Small Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetBasicSmallShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID,effectRigs);
    }
        
    /**
     * init Standup MSet Drone And Fighter Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetDroneAndFighterManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Init Standup MSet Structure Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetStructureManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }    
    
    /**
     * @deprecated 
     * mancano ti data interfaces
     * @param int rigTypeID 
     */
    public void initStandupMSetThukkerAdvancedComponentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();     
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }

    /**
     * Init Standup MSet Thukker Basic Capital Component Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupMSetThukkerBasicCapitalComponentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);       
    }
    
    /**
     * Init Standup MSet Blueprint Copy 
     * bonuses apply to all blueprints
     * @param int rigTypeID 
     */
    public void initStandupMSetBlueprintCopy(int rigTypeID){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, new ArrayList<>());
    }    
    
    /**
     * Init Standup MSet Invention
     * bonuses apply to all blueprints
     * @param int rigTypeID 
     */
    public void initStandupMSetInvention(int rigTypeID){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, new ArrayList<>());
    }
    
    /**
     * Init Standup MSet ME Research
     * bonuses apply to all blueprints
     * @param int rigTypeID 
     */
    public void initStandupMSetMEResearch(int rigTypeID){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, new ArrayList<>());
    }
    
    /**
     * Init Standup MSet TE Research
     * bonuses apply to all blueprints
     * @param int rigTypeID 
     */
    public void initStandupMSetTEResearch(int rigTypeID){
        // new ArrayList<>() must be empty               
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, new ArrayList<>());        
    }    
 
}

/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/