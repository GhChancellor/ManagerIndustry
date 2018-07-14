/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.largeRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.manager.managerDB.ManagerDB;
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
//        initStandupLSetBlueprintCopy();
//        initStandupLSetThukkerBasicCapitalComponentManufacturing();
//        initStandupLSetThukkerAdvancedComponentManufacturing();
    }
    
    /**
     * Get Standup LSet Ammunition Manufacturing
     */
    public void initStandupLSetAmmunitionManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);
    }
    
    /**
     * Get Standup LSet Basic Large Ship Manufacturing
     */
    public void initStandupLSetBasicLargeShipManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Large Ship Manufacturing
     */
    public void initStandupLSetAdvancedLargeShipManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Equipment Manufacturing
     */
    public void initStandupLSetEquipmentManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * @deprecated 
     * Get Standup LSet Capital Ship Manufacturing
     */
    public void initStandupLSetCapitalShipManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getCarriers());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getDreadnoughts());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getForceAuxiliaries());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getTitans());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getCapitalIndustrialShips().ore().getOre());
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Component Manufacturing
     */
    public void initStandupLSetAdvancedComponentManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Small Ship Manufacturing
     */
    public void initStandupLSetAdvancedSmallShipManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);
    }
    
    /**
     * Get Standup LSet Advanced Medium Ship Manufacturing
     */
    public void initStandupLSetAdvancedMediumShipManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Drone And Fighter Manufacturing
     */
    public void initStandupLSetDroneAndFighterManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Small Ship Manufacturing
     */
    public void initStandupLSetBasicSmallShipManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Medium Ship Manufacturing
     */
    public void initStandupLSetBasicMediumShipManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Basic Capital Component Manufacturing
     */
    public void initStandupLSetBasicCapitalComponentManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Structure Manufacturing
     */
    public void initStandupLSetStructureManufacturing(int rig1, int rig2){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();      
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, effectRigs);        
    }
    
    /**
     * Get Standup LSet Thukker Basic Capital Component Manufacturing
     */
    public void initStandupLSetThukkerBasicCapitalComponentManufacturing(int rig1){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(rig1, effectRigs);        
    }    
    
    /**
     * Init Standup LSet Thukker Advanced Component Manufacturing
     */
    public void initStandupLSetThukkerAdvancedComponentManufacturing(int rig1){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();    
        initCommonRigGroups.addEffectEngineeringRig(rig1, effectRigs);        
    }
    
    /**
     * Get Standup LSet Invention
     */
    public void initStandupLSetInvention(int rig1, int rig2){
        // new ArrayList<>() must be empty     
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet ME Research
     */
    public void initStandupLSetMEResearch(int rig1, int rig2){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet TE Research
     */
    public void initStandupLSetTEResearch(int rig1, int rig2){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, new ArrayList<>());        
    }
    
    /**
     * Get Standup LSet Blueprint Copy
     */
    public void initStandupLSetBlueprintCopy(int rig1, int rig2){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, new ArrayList<>());        
    }
    
  
}
