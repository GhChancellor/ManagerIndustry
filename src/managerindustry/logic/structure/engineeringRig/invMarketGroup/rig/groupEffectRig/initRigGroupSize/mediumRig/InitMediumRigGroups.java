/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.mediumRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigsXXX;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;

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
     */
    public void initStandupMSetEquipmentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        
        structureRig(43920, effectRigs); // Standup M-Set Equipment Manufacturing Material Efficiency I
        structureRig(43921, effectRigs); // Standup M-Set Equipment Manufacturing Material Efficiency II
        structureRig(37160, effectRigs); // Standup M-Set Equipment Manufacturing Time Efficiency I
        structureRig(37161, effectRigs); // Standup M-Set Equipment Manufacturing Time Efficiency II

    }
    
    /**
     * @deprecated 
     * mancano i data interfaces 
     * 
     */
    public void initStandupMSetAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing(); 
        
        structureRig(43867, effectRigs); // Standup M-Set Advanced Component Manufacturing Material Efficiency I
        structureRig(43866, effectRigs); // Standup M-Set Advanced Component Manufacturing Material Efficiency II
        structureRig(43869, effectRigs); // Standup M-Set Advanced Component Manufacturing Time Efficiency I
        structureRig(43868, effectRigs); // Standup M-Set Advanced Component Manufacturing Time Efficiency II   
    }
    
    /**
     * Init Standup MSet Advanced Large Ship Manufacturing
     */
    public void initStandupMSetAdvancedLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing(); 
        
        structureRig(43862, effectRigs); // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency I
        structureRig(43863, effectRigs); // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency II
        structureRig(43865, effectRigs); // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency I
        structureRig(43864, effectRigs); // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Advanced Medium Ship Manufacturing
     */
    public void initStandupMSetAdvancedMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();  
        
        structureRig(43858, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency I
        structureRig(43859, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency II
        structureRig(43860, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency I
        structureRig(43861, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Advanced Small Ship Manufacturing
     */
    public void initStandupMSetAdvancedSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing(); 
        
        structureRig(43855, effectRigs); // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency I
        structureRig(43854, effectRigs); // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency II
        structureRig(43856, effectRigs); // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency I
        structureRig(43857, effectRigs); // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Ammunition Manufacturing
     */
    public void initStandupMSetAmmunitionManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing(); 
    
        structureRig(37158, effectRigs); // Standup M-Set Ammunition Manufacturing Material Efficiency I
        structureRig(37159, effectRigs); // Standup M-Set Ammunition Manufacturing Material Efficiency II
        structureRig(37150, effectRigs); // Standup M-Set Ammunition Manufacturing Time Efficiency I
        structureRig(37151, effectRigs); // Standup M-Set Ammunition Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Basic Capital Component Manufacturing
     */
    public void initStandupMSetBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing(); 
        
        structureRig(43870, effectRigs); // Standup M-Set Basic Capital Component Manufacturing Material Efficiency I
        structureRig(43871, effectRigs); // Standup M-Set Basic Capital Component Manufacturing Material Efficiency II
        structureRig(43872, effectRigs); // Standup M-Set Basic Capital Component Manufacturing Time Efficiency I
        structureRig(43873, effectRigs); // Standup M-Set Basic Capital Component Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Basic Large Ship Manufacturing
     */
    public void initStandupMSetBasicLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing(); 
        
        structureRig(43732, effectRigs); // Standup M-Set Basic Large Ship Manufacturing Material Efficiency I
        structureRig(37152, effectRigs); // Standup M-Set Basic Large Ship Manufacturing Material Efficiency II
        structureRig(43733, effectRigs); // Standup M-Set Basic Large Ship Manufacturing Time Efficiency I
        structureRig(43734, effectRigs); // Standup M-Set Basic Large Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Basic Medium Ship Manufacturing
     */
    public void initStandupMSetBasicMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing();   
        
        structureRig(37146, effectRigs); // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I
        structureRig(37147, effectRigs); // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency II
        structureRig(43919, effectRigs); // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency I
        structureRig(37153, effectRigs); // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Basic Small Ship Manufacturing
     */
    public void initStandupMSetBasicSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing(); 
        
        structureRig(37154, effectRigs); // Standup M-Set Basic Small Ship Manufacturing Material Efficiency I
        structureRig(37155, effectRigs); // Standup M-Set Basic Small Ship Manufacturing Material Efficiency II
        structureRig(37162, effectRigs); // Standup M-Set Basic Small Ship Manufacturing Time Efficiency I
        structureRig(37163, effectRigs); // Standup M-Set Basic Small Ship Manufacturing Time Efficiency II
    }
        
    /**
     * init Standup MSet Drone And Fighter Manufacturing
     */
    public void initStandupMSetDroneAndFighterManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing(); 
        
        structureRig(37156, effectRigs); // Standup M-Set Drone and Fighter Manufacturing Material Efficiency I
        structureRig(37157, effectRigs); // Standup M-Set Drone and Fighter Manufacturing Material Efficiency II
        structureRig(37148, effectRigs); // Standup M-Set Drone and Fighter Manufacturing Time Efficiency I
        structureRig(37149, effectRigs); // Standup M-Set Drone and Fighter Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Structure Manufacturing
     */
    public void initStandupMSetStructureManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();  
        
        structureRig(43875, effectRigs); // Standup M-Set Structure Manufacturing Material Efficiency I
        structureRig(43874, effectRigs); // Standup M-Set Structure Manufacturing Material Efficiency II
        structureRig(43876, effectRigs); // Standup M-Set Structure Manufacturing Time Efficiency I
        structureRig(43877, effectRigs); // Standup M-Set Structure Manufacturing Time Efficiency II
    }    
    
    /**
     * @deprecated 
     * mancano ti data interfaces
     */
    public void initStandupMSetThukkerAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();     
        
        structureRig(45640, effectRigs); // Standup M-Set Thukker Advanced Component Manufacturing Material Efficiency
    }

    /**
     * Init Standup MSet Thukker Basic Capital Component Manufacturing
     */
    public void initStandupMSetThukkerBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
        structureRig(45544, effectRigs); // Standup M-Set Thukker Basic Capital Component Manufacturing Material Efficiency        
    }
    
    /**
     * Init Standup MSet Blueprint Copy 
     * bonuses apply to all blueprints
     */
    public void initStandupMSetBlueprintCopy(){
        // new ArrayList<>() must be empty
        
        structureRig(43893, new ArrayList<>()); // Standup M-Set Blueprint Copy Accelerator I
        structureRig(43892, new ArrayList<>()); // Standup M-Set Blueprint Copy Accelerator II
        structureRig(43891, new ArrayList<>()); // Standup M-Set Blueprint Copy Cost Optimization I
        structureRig(43890, new ArrayList<>()); // Standup M-Set Blueprint Copy Cost Optimization II
    }    
    
    /**
     * Init Standup MSet Invention
     * bonuses apply to all blueprints
     */
    public void initStandupMSetInvention(){
        // new ArrayList<>() must be empty
        
        structureRig(43880, new ArrayList<>()); // Standup M-Set Invention Accelerator I
        structureRig(43881, new ArrayList<>()); // Standup M-Set Invention Accelerator II
        structureRig(43879, new ArrayList<>()); // Standup M-Set Invention Cost Optimization I
        structureRig(43878, new ArrayList<>()); // Standup M-Set Invention Cost Optimization II
    }
    
    /**
     * Init Standup MSet ME Research
     * bonuses apply to all blueprints
     */
    public void initStandupMSetMEResearch(){
        // new ArrayList<>() must be empty
        
        structureRig(43883, new ArrayList<>()); // Standup M-Set ME Research Accelerator I
        structureRig(43882, new ArrayList<>()); // Standup M-Set ME Research Accelerator II
        structureRig(43885, new ArrayList<>()); // Standup M-Set ME Research Cost Optimization I
        structureRig(43884, new ArrayList<>()); // Standup M-Set ME Research Cost Optimization II
    }
    
    /**
     * Init Standup MSet TE Research
     * bonuses apply to all blueprints
     */
    public void initStandupMSetTEResearch(){
        // new ArrayList<>() must be empty        
        
        structureRig(43889, new ArrayList<>()); // 43889 Standup M-Set TE Research Accelerator I
        structureRig(43888, new ArrayList<>()); // 43888 Standup M-Set TE Research Accelerator II
        structureRig(43887, new ArrayList<>()); // 43887 Standup M-Set TE Research Cost Optimization I
        structureRig(43886, new ArrayList<>()); // 43886 Standup M-Set TE Research Cost Optimization II
    }    
    
    /**
     * Add rig and effect to DB
     * @param typeId
     * @param effectRigs 
     */
    private void structureRig(int typeId, List < ItemRecusion > effectRigs){
        EffectEngineeringRigs managerStructure = new EffectEngineeringRigs(typeId, effectRigs);
    }       
    
}

/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/