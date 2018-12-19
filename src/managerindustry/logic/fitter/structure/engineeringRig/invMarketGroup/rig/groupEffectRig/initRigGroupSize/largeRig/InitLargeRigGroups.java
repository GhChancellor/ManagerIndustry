/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.largeRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.old.RigRecusion_Init;

/**
 *
 * @author lele
 */
public class InitLargeRigGroups {
    private InitCommonRigGroups initCommonRigGroups = new InitCommonRigGroups();
    
    public InitLargeRigGroups() {
    }
    
    /**
     * Get Standup LSet Ammunition Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetAmmunitionManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Get Standup LSet Basic Large Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetBasicLargeShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Large Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetAdvancedLargeShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Equipment Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetEquipmentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * @deprecated 
     * Get Standup LSet Capital Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetCapitalShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getCarriers());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getDreadnoughts());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getForceAuxiliaries());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getTitans());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getCapitalIndustrialShips().ore().getOre());
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Component Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetAdvancedComponentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Small Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetAdvancedSmallShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);
    }
    
    /**
     * Get Standup LSet Advanced Medium Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetAdvancedMediumShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Drone And Fighter Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetDroneAndFighterManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Small Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetBasicSmallShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Medium Ship Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetBasicMediumShipManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Capital Component Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetBasicCapitalComponentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Structure Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetStructureManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();      
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Thukker Basic Capital Component Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetThukkerBasicCapitalComponentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }    
    
    /**
     * Init Standup LSet Thukker Advanced Component Manufacturing
     * @param int rigTypeID 
     */
    public void initStandupLSetThukkerAdvancedComponentManufacturing(int rigTypeID){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();    
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, effectRigs);        
    }
    
    /**
     * Get Standup LSet Invention
     * @param int rigTypeID 
     */
    public void initStandupLSetInvention(int rigTypeID){
        // new ArrayList<>() must be empty     
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet ME Research
     * @param int rigTypeID 
     */
    public void initStandupLSetMEResearch(int rigTypeID){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet TE Research
     * @param int rigTypeID 
     */
    public void initStandupLSetTEResearch(int rigTypeID){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet Blueprint Copy
     * @param int rigTypeID 
     */
    public void initStandupLSetBlueprintCopyOptimization(int rigTypeID){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rigTypeID, new ArrayList<>());        
    }
    
  
}
