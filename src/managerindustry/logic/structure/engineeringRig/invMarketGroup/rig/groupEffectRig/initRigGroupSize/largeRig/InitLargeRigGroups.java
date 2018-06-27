/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.largeRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigsXXX;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;

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
    public void initStandupLSetAmmunitionManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing();
        
        structureRig(37164, effectRigs); // Standup L-Set Ammunition Manufacturing Efficiency I 
        structureRig(37165, effectRigs); // Standup L-Set Ammunition Manufacturing Efficiency II
    }
    
    /**
     * Get Standup LSet Basic Large Ship Manufacturing
     */
    public void initStandupLSetBasicLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing();
        
        structureRig(37166, effectRigs); // Standup L-Set Basic Large Ship Manufacturing Efficiency I        
        structureRig(37167, effectRigs); // Standup L-Set Basic Large Ship Manufacturing Efficiency II       
    }
    
    /**
     * Get Standup LSet Advanced Large Ship Manufacturing
     */
    public void initStandupLSetAdvancedLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing();
        
        structureRig(37168, effectRigs); // Standup L-Set Advanced Large Ship Manufacturing Efficiency I              
        structureRig(37169, effectRigs); // Standup L-Set Advanced Large Ship Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Equipment Manufacturing
     */
    public void initStandupLSetEquipmentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        
        structureRig(37170, effectRigs); // Standup L-Set Equipment Manufacturing Efficiency I
        structureRig(37171, effectRigs); // Standup L-Set Equipment Manufacturing Efficiency II
    }
    
    /**
     * @deprecated 
     * Get Standup LSet Capital Ship Manufacturing
     */
    public void initStandupLSetCapitalShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getCarriers());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getDreadnoughts());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getForceAuxiliaries());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getTitans());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getCapitalIndustrialShips().ore().getOre());
        
        structureRig(37172, effectRigs); // Standup L-Set Capital Ship Manufacturing Efficiency II              
        structureRig(37173, effectRigs); // Standup L-Set Capital Ship Manufacturing Efficiency I              
    }
    
    /**
     * Get Standup LSet Advanced Component Manufacturing
     */
    public void initStandupLSetAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing();
        
        structureRig(37174, effectRigs); // Standup L-Set Advanced Component Manufacturing Efficiency I              
        structureRig(37175, effectRigs); // Standup L-Set Advanced Component Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Advanced Small Ship Manufacturing
     */
    public void initStandupLSetAdvancedSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing();
        
        structureRig(43707, effectRigs); // Standup L-Set Advanced Small Ship Manufacturing Efficiency I              
        structureRig(43708, effectRigs); // Standup L-Set Advanced Small Ship Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Advanced Medium Ship Manufacturing
     */
    public void initStandupLSetAdvancedMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();
        
        structureRig(43709, effectRigs); // Standup L-Set Advanced Medium Ship Manufacturing Efficiency I              
        structureRig(43711, effectRigs); // Standup L-Set Advanced Medium Ship Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Drone And Fighter Manufacturing
     */
    public void initStandupLSetDroneAndFighterManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing();
        
        structureRig(43712, effectRigs); // Standup L-Set Drone and Fighter Manufacturing Efficiency I              
        structureRig(43713, effectRigs); // Standup L-Set Drone and Fighter Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Basic Small Ship Manufacturing
     */
    public void initStandupLSetBasicSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing();
        
        structureRig(43714, effectRigs); // Standup L-Set Basic Small Ship Manufacturing Efficiency I              
        structureRig(43715, effectRigs); // Standup L-Set Basic Small Ship Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Basic Medium Ship Manufacturing
     */
    public void initStandupLSetBasicMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing();
        
        structureRig(43716, effectRigs); // Standup L-Set Basic Medium Ship Manufacturing Efficiency I              
        structureRig(43717, effectRigs); // Standup L-Set Basic Medium Ship Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Basic Capital Component Manufacturing
     */
    public void initStandupLSetBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing();
        
        structureRig(43718, effectRigs); // Standup L-Set Basic Capital Component Manufacturing Efficiency I              
        structureRig(43719, effectRigs); // Standup L-Set Basic Capital Component Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Structure Manufacturing
     */
    public void initStandupLSetStructureManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();
        
        structureRig(43720, effectRigs); // Standup L-Set Structure Manufacturing Efficiency I              
        structureRig(43721, effectRigs); // Standup L-Set Structure Manufacturing Efficiency II              
    }
    
    /**
     * Get Standup LSet Thukker Basic Capital Component Manufacturing
     */
    public void initStandupLSetThukkerBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();
        
        structureRig(45546, effectRigs); // Standup L-Set Thukker Basic Capital Component Manufacturing Efficiency              
    }    
    
    /**
     * Init Standup LSet Thukker Advanced Component Manufacturing
     */
    public void initStandupLSetThukkerAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();
        
        structureRig(45641, effectRigs); // Standup L-Set Thukker Advanced Component Manufacturing Efficiency           
    }
    
    /**
     * Get Standup LSet Invention
     */
    public void initStandupLSetInvention(){
        // new ArrayList<>() must be empty
        structureRig(43722, new ArrayList<>()); // Standup L-Set Invention Optimization I              
        structureRig(43723, new ArrayList<>()); // Standup L-Set Invention Optimization II              
    }
    
    /**
     * Get Standup LSet ME Research
     */
    public void initStandupLSetMEResearch(){
        // new ArrayList<>() must be empty
        structureRig(43724, new ArrayList<>()); // Standup L-Set ME Research Optimization I              
        structureRig(43725, new ArrayList<>()); // Standup L-Set ME Research Optimization II              
    }
    
    /**
     * Get Standup LSet TE Research
     */
    public void initStandupLSetTEResearch(){
        // new ArrayList<>() must be empty
        structureRig(43726, new ArrayList<>()); // Standup L-Set TE Research Optimization I               
        structureRig(43727, new ArrayList<>()); // Standup L-Set TE Research Optimization II              
    }
    
    /**
     * Get Standup LSet Blueprint Copy
     */
    public void initStandupLSetBlueprintCopy(){
        // new ArrayList<>() must be empty
        structureRig(43729, new ArrayList<>()); // Standup L-Set Blueprint Copy Optimization I              
        structureRig(43730, new ArrayList<>()); // Standup L-Set Blueprint Copy Optimization II              
    }
    
    private void structureRig(int typeId, List < ItemRecusion > effectRigs){
        EffectEngineeringRigs managerStructure = new EffectEngineeringRigs(typeId, effectRigs);
    }       
}
