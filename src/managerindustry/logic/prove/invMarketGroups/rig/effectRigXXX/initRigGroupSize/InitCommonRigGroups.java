/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.initRigGroupSize;

import managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.initRigGroupSize.mediumRig.*;
import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.db.entities.InvTypes;
import managerindustry.db.entities.cache.EffectRigEntity;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.RigDescription;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.StructureRig;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.StructureRigBlueprints;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.StructureRig_OLD;
import managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.GroupEffectRig;
import managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.GroupEffectRig;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.RigGroups;

/**
 *
 * @author lele
 */
public class InitCommonRigGroups {
    
    public InitCommonRigGroups() {
        initStandupCommonEquipmentManufacturing();
        initStandupCommonAdvancedComponentManufacturing();
        initStandupCommonAdvancedLargeShipManufacturing();
        initStandupCommonAdvancedMediumShipManufacturing();
        initStandupCommonAdvancedSmallShipManufacturing();
        initStandupCommonAmmunitionManufacturing();
        initStandupCommonBasicCapitalComponentManufacturing();
        initStandupCommonBasicLargeShipManufacturing();
        initStandupCommonBasicMediumShipManufacturing();
        initStandupCommonBasicSmallShipManufacturing();
        initStandupCommonDroneAndFighterManufacturing();
        initStandupCommonStructureManufacturing();
        initStandupCommonThukkerAdvancedComponentManufacturing();
        initStandupCommonThukkerBasicCapitalComponentManufacturing();
//        initStandupCommonBlueprintCopy();
//        initStandupCommonInvention();
//        initStandupCommonMEResearch();
//        initStandupCommonTEResearch();
    }
    
    /**
     * Init Standup Common Equipment Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonEquipmentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().shipEquipments().getshipEquipments());
        effectRigs.add(GroupEffectRig.getInstance().ship_ModuleModifications().rigs().getRigs());
        effectRigs.add(GroupEffectRig.getInstance().structures().deployableStructures().getPersonalDeployables()); // <-- include cargo container  
        effectRigs.add(GroupEffectRig.getInstance().implantsBoosters().implants().getImplants());   
        
        return effectRigs;
    }
    
    /**
     * @deprecated 
     * mancano i data interfaces 
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );   
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Advanced Large Ship Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonAdvancedLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getAdvancedBattleships() );
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getJumpFreighters() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Advanced Medium Ship Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonAdvancedMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getAdvancedCruisers() );
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getT3Cruisers() ); 
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getAdvancedBattlecruisers() );
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().advancedIndustrialShips().getTransportShips() ); 
        effectRigs.add(GroupEffectRig.getInstance().ships().miningBarges().getExhumers() );   
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );   
                
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Advanced Small Ship Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonAdvancedSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getAdvancedFrigates()  );
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getAdvancedBattlecruisers() );
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getT3Destroyers() ); 
                        
        return effectRigs;
    }
    
    /**
     * Init Standup Common Ammunition Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonAmmunitionManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ammunitionCarges().getAmmunitionCarges() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Capital Component Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Large Ship Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonBasicLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getStandardBattleships());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getFreighters()); 
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().industrialCommandShips().getIndustrialCommandShips() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Medium Ship Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonBasicMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getStandardCruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getStandardBattlecruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().standardIndustrialShips().getStandardIndustrialShips() ); 
        effectRigs.add(GroupEffectRig.getInstance().ships().miningBarges().getMiningBarges());   
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Small Ship Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonBasicSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getStandardFrigates());
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getStandardDestroyers());
        effectRigs.add(GroupEffectRig.getInstance().ships().shuttles().getShuttles()); 
        
        return effectRigs;        
    }
        
    /**
     * init Standup Common Drone And Fighter Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonDroneAndFighterManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().droneFighters().getDroneFighters() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Structure Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonStructureManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().outpostComponent().getStationComponents() );
        effectRigs.add(GroupEffectRig.getInstance().structureEquipment().getStructureEquipment() );
        effectRigs.add(GroupEffectRig.getInstance().structureModifications().getStructureModifications() ); 
        // upwell Structure
        effectRigs.add(GroupEffectRig.getInstance().structures().citadels().getCitadels() );   
        effectRigs.add(GroupEffectRig.getInstance().structures().engineeringComplexes().getEngineeringComplexes() );   
        effectRigs.add(GroupEffectRig.getInstance().structures().refineries().getRefineries() );   
        
        effectRigs.add(GroupEffectRig.getInstance().structures().starbaseStructures().getStarbaseStructures() );   
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().fuelBlocks().getFuelBlocks() );   
        
        return effectRigs;        
    }    
    
    /**
     * @deprecated 
     * mancano ti data interfaces
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonThukkerAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );    
        
        return effectRigs;        
    }

    /**
     * Init Standup Common Thukker Basic Capital Component Manufacturing
     * @return List < ItemRecusion >
     */
    public List < ItemRecusion > initStandupCommonThukkerBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents()  );    
        
        return effectRigs;        
    }
    
//    /**
//     * @deprecated 
//     * Init Standup Common Blueprint Copy
//     */
//    public List < ItemRecusion > initStandupCommonBlueprintCopy(){
////        List < ItemRecusion > effectRigs = new ArrayList<>();
////        
////        effectRigs.add(GroupEffectRig.getInstance(). );
////        effectRigs.add(GroupEffectRig.getInstance(). );
////        effectRigs.add(GroupEffectRig.getInstance(). ); 
////        effectRigs.add(GroupEffectRig.getInstance(). );   
////        
////        structureRig(43893, effectRigs); // Standup M-Set Blueprint Copy Accelerator I
////        structureRig(43892, effectRigs); // Standup M-Set Blueprint Copy Accelerator II
////        structureRig(43891, effectRigs); // Standup M-Set Blueprint Copy Cost Optimization I
////        structureRig(43890, effectRigs); // Standup M-Set Blueprint Copy Cost Optimization II
//    }    
//    
//    /**
//     * @deprecated 
//     * Init Standup Common Invention
//     */
//    public List < ItemRecusion > initStandupCommonInvention(){
////        List < ItemRecusion > effectRigs = new ArrayList<>();
////        
////        effectRigs.add(GroupEffectRig.getInstance(). );
////        effectRigs.add(GroupEffectRig.getInstance(). );
////        effectRigs.add(GroupEffectRig.getInstance(). ); 
////        effectRigs.add(GroupEffectRig.getInstance(). );   
////        
////        structureRig(43880, effectRigs); // Standup M-Set Invention Accelerator I
////        structureRig(43881, effectRigs); // Standup M-Set Invention Accelerator II
////        structureRig(43879, effectRigs); // Standup M-Set Invention Cost Optimization I
////        structureRig(43878, effectRigs); // Standup M-Set Invention Cost Optimization II
//    }
//    
//    /**
//     * @deprecated 
//     * Init Standup Common ME Research
//     */
//    public List < ItemRecusion > initStandupCommonMEResearch(){
////        List < ItemRecusion > effectRigs = new ArrayList<>();
////        
////        effectRigs.add(GroupEffectRig.getInstance(). );
////        effectRigs.add(GroupEffectRig.getInstance(). );
////        effectRigs.add(GroupEffectRig.getInstance(). ); 
////        effectRigs.add(GroupEffectRig.getInstance(). );   
////        
////        structureRig(43883, effectRigs); // Standup M-Set ME Research Accelerator I
////        structureRig(43882, effectRigs); // Standup M-Set ME Research Accelerator II
////        structureRig(43885, effectRigs); // Standup M-Set ME Research Cost Optimization I
////        structureRig(43884, effectRigs); // Standup M-Set ME Research Cost Optimization II
//    }
//    
//    /**
//     * @deprecated 
//     * Init Standup Common TE Research
//     */
//    public List < ItemRecusion > initStandupCommonTEResearch(){
//        
//        
//        
//        
////        structureRig(43889, effectRigs); // 43889 Standup M-Set TE Research Accelerator I
////        structureRig(43888, effectRigs); // 43888 Standup M-Set TE Research Accelerator II
////        structureRig(43887, effectRigs); // 43887 Standup M-Set TE Research Cost Optimization I
////        structureRig(43886, effectRigs); // 43886 Standup M-Set TE Research Cost Optimization II
//    }    
//    
//    public List < ItemRecusion > structureRigBlueprint(int typeID){
//        
//        StructureRigBlueprints structureRigBlueprints = new StructureRigBlueprints(typeID);
//    }
//    
//    
//    public void structureRig(int typeId, List < ItemRecusion > effectRigs){
//        StructureRig rig = new StructureRig(typeId, effectRigs );   
//        ManagerDB.getInstance().effectRig().addEffectRigs(rig);
//    }    
    
}




//    public List < ItemRecusion > initStandupMSetInvention(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(GroupEffectRig.getInstance(). );
//        effectRigs.add(GroupEffectRig.getInstance(). );
//        effectRigs.add(GroupEffectRig.getInstance(). ); 
//        effectRigs.add(GroupEffectRig.getInstance(). );   
//        
//        structureRig(, effectRigs); 
//        structureRig(, effectRigs); 
//        structureRig(, effectRigs); 
//        structureRig(, effectRigs); 
//    }   



/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/