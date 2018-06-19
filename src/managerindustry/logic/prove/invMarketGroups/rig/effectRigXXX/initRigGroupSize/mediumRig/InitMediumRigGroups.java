/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.initRigGroupSize.mediumRig;

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
public class InitMediumRigGroups {
    
    public InitMediumRigGroups() {
        initStandupMSetEquipmentManufacturing();
        initStandupMSetAdvancedComponentManufacturing();
        initStandupMSetAdvancedLargeShipManufacturing();
        initStandupMSetAdvancedMediumShipManufacturing();
        initStandupMSetAdvancedSmallShipManufacturing();
        initStandupMSetAmmunitionManufacturing();
        initStandupMSetBasicCapitalComponentManufacturing();
        initStandupMSetBasicLargeShipManufacturing();
        initStandupMSetBasicMediumShipManufacturing();
        initStandupMSetBasicSmallShipManufacturing();
        initStandupMSetDroneAndFighterManufacturing();
        initStandupMSetStructureManufacturing();
        initStandupMSetThukkerAdvancedComponentManufacturing();
        initStandupMSetThukkerBasicCapitalComponentManufacturing();
        initStandupMSetBlueprintCopy();
        initStandupMSetInvention();
        initStandupMSetMEResearch();
        initStandupMSetTEResearch();
    }
    
    /**
     * Init Standup MSet Equipment Manufacturing
     */
    private void initStandupMSetEquipmentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().shipEquipments().getshipEquipments());
        effectRigs.add(GroupEffectRig.getInstance().ship_ModuleModifications().rigs().getRigs());
        effectRigs.add(GroupEffectRig.getInstance().structures().deployableStructures().getPersonalDeployables()); // <-- include cargo container  
        effectRigs.add(GroupEffectRig.getInstance().implantsBoosters().implants().getImplants());   
        
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
    private void initStandupMSetAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );   
        
        structureRig(43867, effectRigs); // Standup M-Set Advanced Component Manufacturing Material Efficiency I
        structureRig(43866, effectRigs); // Standup M-Set Advanced Component Manufacturing Material Efficiency II
        structureRig(43869, effectRigs); // Standup M-Set Advanced Component Manufacturing Time Efficiency I
        structureRig(43868, effectRigs); // Standup M-Set Advanced Component Manufacturing Time Efficiency II   
    }
    
    /**
     * Init Standup MSet Advanced Large Ship Manufacturing
     */
    private void initStandupMSetAdvancedLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getAdvancedBattleships() );
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getJumpFreighters() );
        
        structureRig(43862, effectRigs); // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency I
        structureRig(43863, effectRigs); // Standup M-Set Advanced Large Ship Manufacturing Material Efficiency II
        structureRig(43865, effectRigs); // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency I
        structureRig(43864, effectRigs); // Standup M-Set Advanced Large Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Advanced Medium Ship Manufacturing
     */
    private void initStandupMSetAdvancedMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getAdvancedCruisers() );
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getT3Cruisers() ); 
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getAdvancedBattlecruisers() );
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().advancedIndustrialShips().getTransportShips() ); 
        effectRigs.add(GroupEffectRig.getInstance().ships().miningBarges().getExhumers() );   
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );   
        
        structureRig(43858, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency I
        structureRig(43859, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency II
        structureRig(43860, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency I
        structureRig(43861, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Advanced Small Ship Manufacturing
     */
    private void initStandupMSetAdvancedSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getAdvancedFrigates()  );
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getAdvancedBattlecruisers() );
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getT3Destroyers() ); 
        
        structureRig(43855, effectRigs); // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency I
        structureRig(43854, effectRigs); // Standup M-Set Advanced Small Ship Manufacturing Material Efficiency II
        structureRig(43856, effectRigs); // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency I
        structureRig(43857, effectRigs); // Standup M-Set Advanced Small Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Ammunition Manufacturing
     */
    private void initStandupMSetAmmunitionManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ammunitionCarges().getAmmunitionCarges() );
    
        structureRig(37158, effectRigs); // Standup M-Set Ammunition Manufacturing Material Efficiency I
        structureRig(37159, effectRigs); // Standup M-Set Ammunition Manufacturing Material Efficiency II
        structureRig(37150, effectRigs); // Standup M-Set Ammunition Manufacturing Time Efficiency I
        structureRig(37151, effectRigs); // Standup M-Set Ammunition Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Basic Capital Component Manufacturing
     */
    private void initStandupMSetBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents() );
        
        structureRig(43870, effectRigs); // Standup M-Set Basic Capital Component Manufacturing Material Efficiency I
        structureRig(43871, effectRigs); // Standup M-Set Basic Capital Component Manufacturing Material Efficiency II
        structureRig(43872, effectRigs); // Standup M-Set Basic Capital Component Manufacturing Time Efficiency I
        structureRig(43873, effectRigs); // Standup M-Set Basic Capital Component Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Basic Large Ship Manufacturing
     */
    private void initStandupMSetBasicLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getStandardBattleships());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getFreighters()); 
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().industrialCommandShips().getIndustrialCommandShips() );
        
        structureRig(43732, effectRigs); // Standup M-Set Basic Large Ship Manufacturing Material Efficiency I
        structureRig(37152, effectRigs); // Standup M-Set Basic Large Ship Manufacturing Material Efficiency II
        structureRig(43733, effectRigs); // Standup M-Set Basic Large Ship Manufacturing Time Efficiency I
        structureRig(43734, effectRigs); // Standup M-Set Basic Large Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Basic Medium Ship Manufacturing
     */
    private void initStandupMSetBasicMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getStandardCruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getStandardBattlecruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().standardIndustrialShips().getStandardIndustrialShips() ); 
        effectRigs.add(GroupEffectRig.getInstance().ships().miningBarges().getMiningBarges());   
        
        structureRig(37146, effectRigs); // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency I
        structureRig(37147, effectRigs); // Standup M-Set Basic Medium Ship Manufacturing Material Efficiency II
        structureRig(43919, effectRigs); // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency I
        structureRig(37153, effectRigs); // Standup M-Set Basic Medium Ship Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Basic Small Ship Manufacturing
     */
    private void initStandupMSetBasicSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getStandardFrigates());
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getStandardDestroyers());
        effectRigs.add(GroupEffectRig.getInstance().ships().shuttles().getShuttles()); 
        
        structureRig(37154, effectRigs); // Standup M-Set Basic Small Ship Manufacturing Material Efficiency I
        structureRig(37155, effectRigs); // Standup M-Set Basic Small Ship Manufacturing Material Efficiency II
        structureRig(37162, effectRigs); // Standup M-Set Basic Small Ship Manufacturing Time Efficiency I
        structureRig(37163, effectRigs); // Standup M-Set Basic Small Ship Manufacturing Time Efficiency II
    }
        
    /**
     * init Standup MSet Drone And Fighter Manufacturing
     */
    private void initStandupMSetDroneAndFighterManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().droneFighters().getDroneFighters() );
        
        structureRig(37156, effectRigs); // Standup M-Set Drone and Fighter Manufacturing Material Efficiency I
        structureRig(37157, effectRigs); // Standup M-Set Drone and Fighter Manufacturing Material Efficiency II
        structureRig(37148, effectRigs); // Standup M-Set Drone and Fighter Manufacturing Time Efficiency I
        structureRig(37149, effectRigs); // Standup M-Set Drone and Fighter Manufacturing Time Efficiency II
    }
    
    /**
     * Init Standup MSet Structure Manufacturing
     */
    private void initStandupMSetStructureManufacturing(){
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
        
        structureRig(43875, effectRigs); // Standup M-Set Structure Manufacturing Material Efficiency I
        structureRig(43874, effectRigs); // Standup M-Set Structure Manufacturing Material Efficiency II
        structureRig(43876, effectRigs); // Standup M-Set Structure Manufacturing Time Efficiency I
        structureRig(43877, effectRigs); // Standup M-Set Structure Manufacturing Time Efficiency II
    }    
    
    /**
     * @deprecated 
     * mancano ti data interfaces
     */
    private void initStandupMSetThukkerAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );    
        
        structureRig(45640, effectRigs); // Standup M-Set Thukker Advanced Component Manufacturing Material Efficiency
    }

    /**
     * Init Standup MSet Thukker Basic Capital Component Manufacturing
     */
    private void initStandupMSetThukkerBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents()  );    
        structureRig(45544, effectRigs); // Standup M-Set Thukker Basic Capital Component Manufacturing Material Efficiency        
    }
    
    /**
     * @deprecated 
     * Init Standup MSet Blueprint Copy
     */
    private void initStandupMSetBlueprintCopy(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(GroupEffectRig.getInstance(). );
//        effectRigs.add(GroupEffectRig.getInstance(). );
//        effectRigs.add(GroupEffectRig.getInstance(). ); 
//        effectRigs.add(GroupEffectRig.getInstance(). );   
//        
//        structureRig(43893, effectRigs); // Standup M-Set Blueprint Copy Accelerator I
//        structureRig(43892, effectRigs); // Standup M-Set Blueprint Copy Accelerator II
//        structureRig(43891, effectRigs); // Standup M-Set Blueprint Copy Cost Optimization I
//        structureRig(43890, effectRigs); // Standup M-Set Blueprint Copy Cost Optimization II
    }    
    
    /**
     * @deprecated 
     * Init Standup MSet Invention
     */
    private void initStandupMSetInvention(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(GroupEffectRig.getInstance(). );
//        effectRigs.add(GroupEffectRig.getInstance(). );
//        effectRigs.add(GroupEffectRig.getInstance(). ); 
//        effectRigs.add(GroupEffectRig.getInstance(). );   
//        
//        structureRig(43880, effectRigs); // Standup M-Set Invention Accelerator I
//        structureRig(43881, effectRigs); // Standup M-Set Invention Accelerator II
//        structureRig(43879, effectRigs); // Standup M-Set Invention Cost Optimization I
//        structureRig(43878, effectRigs); // Standup M-Set Invention Cost Optimization II
    }
    
    /**
     * @deprecated 
     * Init Standup MSet ME Research
     */
    private void initStandupMSetMEResearch(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(GroupEffectRig.getInstance(). );
//        effectRigs.add(GroupEffectRig.getInstance(). );
//        effectRigs.add(GroupEffectRig.getInstance(). ); 
//        effectRigs.add(GroupEffectRig.getInstance(). );   
//        
//        structureRig(43883, effectRigs); // Standup M-Set ME Research Accelerator I
//        structureRig(43882, effectRigs); // Standup M-Set ME Research Accelerator II
//        structureRig(43885, effectRigs); // Standup M-Set ME Research Cost Optimization I
//        structureRig(43884, effectRigs); // Standup M-Set ME Research Cost Optimization II
    }
    
    /**
     * @deprecated 
     * Init Standup MSet TE Research
     */
    private void initStandupMSetTEResearch(){
        
        
        
        
//        structureRig(43889, effectRigs); // 43889 Standup M-Set TE Research Accelerator I
//        structureRig(43888, effectRigs); // 43888 Standup M-Set TE Research Accelerator II
//        structureRig(43887, effectRigs); // 43887 Standup M-Set TE Research Cost Optimization I
//        structureRig(43886, effectRigs); // 43886 Standup M-Set TE Research Cost Optimization II
    }    
    
    private void structureRigBlueprint(int typeID){
        
        StructureRigBlueprints structureRigBlueprints = new StructureRigBlueprints(typeID);
    }
    
    
    private void structureRig(int typeId, List < ItemRecusion > effectRigs){
        StructureRig rig = new StructureRig(typeId, effectRigs );   
        ManagerDB.getInstance().effectRig().addEffectRigs(rig);
    }    
    
}

//    private void initStandupMSetInvention(){
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