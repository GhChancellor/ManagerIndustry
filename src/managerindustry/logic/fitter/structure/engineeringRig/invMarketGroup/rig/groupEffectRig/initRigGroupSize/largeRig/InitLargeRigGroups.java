/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.largeRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.manager.managerDB.Db;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigsXXX;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;

/**
 *
 * @author lele
 */
public class InitLargeRigGroups {
    private InitCommonRigGroups initCommonRigGroups = new InitCommonRigGroups();
    
    public InitLargeRigGroups() {
//        initStandupLSetAmmunitionManufacturing();
//        initStandupLSetBasicLargeShipManufacturing();
//        initStandupLSetAdvancedLargeShipManufacturing();
//        initStandupLSetEquipmentManufacturing();
//        initStandupLSetCapitalShipManufacturing();
//        initStandupLSetAdvancedComponentManufacturing();
//        initStandupLSetAdvancedSmallShipManufacturing();
//        initStandupLSetAdvancedMediumShipManufacturing();
//        initStandupLSetDroneAndFighterManufacturing();
//        initStandupLSetBasicSmallShipManufacturing();
//        initStandupLSetBasicMediumShipManufacturing();
//        initStandupLSetBasicCapitalComponentManufacturing();
//        initStandupLSetStructureManufacturing();
//        initStandupLSetInvention();
//        initStandupLSetMEResearch();
//        initStandupLSetTEResearch();
//        initStandupLSetBlueprintCopyOptimization();
//        initStandupLSetThukkerBasicCapitalComponentManufacturing();
//        initStandupLSetThukkerAdvancedComponentManufacturing();
    }
    
    /**
     * Get Standup LSet Ammunition Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetAmmunitionManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Get Standup LSet Basic Large Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetBasicLargeShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Large Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetAdvancedLargeShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Equipment Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetEquipmentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * @deprecated 
     * Get Standup LSet Capital Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetCapitalShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = new ArrayList<>();
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
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Small Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetAdvancedSmallShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }
    
    /**
     * Get Standup LSet Advanced Medium Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetAdvancedMediumShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Drone And Fighter Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetDroneAndFighterManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Small Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetBasicSmallShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Medium Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetBasicMediumShipManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Capital Component Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetBasicCapitalComponentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Structure Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetStructureManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();      
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }
    
    /**
     * Get Standup LSet Thukker Basic Capital Component Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetThukkerBasicCapitalComponentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);        
    }    
    
    /**
     * Init Standup LSet Thukker Advanced Component Manufacturing
     * @param int typeId 
     */
    public void initStandupLSetThukkerAdvancedComponentManufacturing(int typeId){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();    
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
