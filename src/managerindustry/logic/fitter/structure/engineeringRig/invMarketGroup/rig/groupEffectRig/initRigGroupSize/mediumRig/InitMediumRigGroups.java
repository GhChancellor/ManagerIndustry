/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.mediumRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.manager.managerDB.ManagerDB;
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
     */
    public void initStandupMSetEquipmentManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonEquipmentManufacturing();
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
      
    /**
     * @deprecated 
     * mancano i data interfaces 
     * 
     */
    public void initStandupMSetAdvancedComponentManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedComponentManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs); 
    }
    
    /**
     * Init Standup MSet Advanced Large Ship Manufacturing
     */
    public void initStandupMSetAdvancedLargeShipManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedLargeShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
    
    /**
     * Init Standup MSet Advanced Medium Ship Manufacturing
     */
    public void initStandupMSetAdvancedMediumShipManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedMediumShipManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
    
    /**
     * Init Standup MSet Advanced Small Ship Manufacturing
     */
    public void initStandupMSetAdvancedSmallShipManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAdvancedSmallShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
    
    /**
     * Init Standup MSet Ammunition Manufacturing
     */
    public void initStandupMSetAmmunitionManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonAmmunitionManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Capital Component Manufacturing
     */
    public void initStandupMSetBasicCapitalComponentManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicCapitalComponentManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Large Ship Manufacturing
     */
    public void initStandupMSetBasicLargeShipManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicLargeShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Medium Ship Manufacturing
     */
    public void initStandupMSetBasicMediumShipManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicMediumShipManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
    
    /**
     * Init Standup MSet Basic Small Ship Manufacturing
     */
    public void initStandupMSetBasicSmallShipManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonBasicSmallShipManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
        
    /**
     * init Standup MSet Drone And Fighter Manufacturing
     */
    public void initStandupMSetDroneAndFighterManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonDroneAndFighterManufacturing(); 
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }
    
    /**
     * Init Standup MSet Structure Manufacturing
     */
    public void initStandupMSetStructureManufacturing(int rig1, int rig2,int rig3,int rig4){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonStructureManufacturing();  
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, effectRigs);
    }    
    
    /**
     * @deprecated 
     * mancano ti data interfaces
     */
    public void initStandupMSetThukkerAdvancedComponentManufacturing(int rig1){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerAdvancedComponentManufacturing();     
        initCommonRigGroups.addEffectEngineeringRig(rig1, effectRigs);
    }

    /**
     * Init Standup MSet Thukker Basic Capital Component Manufacturing
     */
    public void initStandupMSetThukkerBasicCapitalComponentManufacturing(int rig1){
        List < ItemRecusion > effectRigs = initCommonRigGroups.initStandupCommonThukkerBasicCapitalComponentManufacturing();   
        initCommonRigGroups.addEffectEngineeringRig(rig1, effectRigs);       
    }
    
    /**
     * Init Standup MSet Blueprint Copy 
     * bonuses apply to all blueprints
     */
    public void initStandupMSetBlueprintCopy(int rig1, int rig2,int rig3,int rig4){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4,  new ArrayList<>());
    }    
    
    /**
     * Init Standup MSet Invention
     * bonuses apply to all blueprints
     */
    public void initStandupMSetInvention(int rig1, int rig2,int rig3,int rig4){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, new ArrayList<>());
    }
    
    /**
     * Init Standup MSet ME Research
     * bonuses apply to all blueprints
     */
    public void initStandupMSetMEResearch(int rig1, int rig2,int rig3,int rig4){
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, new ArrayList<>());
    }
    
    /**
     * Init Standup MSet TE Research
     * bonuses apply to all blueprints
     */
    public void initStandupMSetTEResearch(int rig1, int rig2,int rig3,int rig4){
        // new ArrayList<>() must be empty               
        initCommonRigGroups.addEffectEngineeringRig(rig1, rig2, rig3, rig4, new ArrayList<>());        
    }    
 
}

/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/