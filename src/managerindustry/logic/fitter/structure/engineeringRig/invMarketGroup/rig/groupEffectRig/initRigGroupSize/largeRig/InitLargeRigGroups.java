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
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;

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
     * @param int typeId 
     */
    public void initStandupLSetAmmunitionManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Get Standup LSet Basic Large Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetBasicLargeShipManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Large Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetAdvancedLargeShipManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Equipment Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetEquipmentManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * @deprecated 
     * Get Standup LSet Capital Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetCapitalShipManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getCarriers());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getDreadnoughts());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getForceAuxiliaries());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getTitans());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getCapitalIndustrialShips().ore().getOre());
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Component Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetAdvancedComponentManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Small Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetAdvancedSmallShipManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Get Standup LSet Advanced Medium Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetAdvancedMediumShipManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Drone And Fighter Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetDroneAndFighterManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Small Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetBasicSmallShipManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Medium Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetBasicMediumShipManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Capital Component Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetBasicCapitalComponentManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Structure Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetStructureManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();      
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Thukker Basic Capital Component Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetThukkerBasicCapitalComponentManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }    
    
    /**
     * Init Standup LSet Thukker Advanced Component Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetThukkerAdvancedComponentManufacturing(int typeId){
        List < RigRecusion_Init > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();    
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Invention
     * @param int typeId 
     */
    public void initStandupLSetInvention(int typeId){
        // new ArrayList<>() must be empty     
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet ME Research
     * @param int typeId 
     */
    public void initStandupLSetMEResearch(int typeId){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet TE Research
     * @param int typeId 
     */
    public void initStandupLSetTEResearch(int typeId){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet Blueprint Copy
     * @param int typeId 
     */
    public void initStandupLSetBlueprintCopyOptimization(int typeId){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());        
    }
    
  
}
