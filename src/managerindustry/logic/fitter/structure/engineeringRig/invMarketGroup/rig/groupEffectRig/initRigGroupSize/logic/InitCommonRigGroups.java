/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs_2;


/**
 * @deprecated  doppioni
 * Advanced Component Manufacturing / Thukker Advanced Component Manufacturing 
 * * getAdvancedComponents OK
 * * getAdvancedCapitalComponents OK
 * * getRam OK
 * * getSubsystemComponents OK
 * 
 * Basic Capital Component Manufacturing / Thukker Basic Capital Component Manufacturing
 * * getStandardCapitalShipComponents
 * 
 * 
 * @author lele
 */
public class InitCommonRigGroups {
    
    public InitCommonRigGroups() {
    }
    
    public List < RigRecusion_Init > DBGinitCommonRigGroups(){
        List<RigRecusion_Init> effectRigs = new ArrayList<>();
        
        List<RigRecusion_Init> initStandupCommonEquipmentManufacturing = initStandupCommonEquipmentManufacturing();
        List<RigRecusion_Init> initStandupCommonAdvancedComponentManufacturing = initStandupCommonAdvancedComponentManufacturing();
        List<RigRecusion_Init> initStandupCommonAdvancedLargeShipManufacturing = initStandupCommonAdvancedLargeShipManufacturing();
        List<RigRecusion_Init> initStandupCommonAdvancedMediumShipManufacturing = initStandupCommonAdvancedMediumShipManufacturing();
        List<RigRecusion_Init> initStandupCommonAdvancedSmallShipManufacturing = initStandupCommonAdvancedSmallShipManufacturing();
        List<RigRecusion_Init> initStandupCommonAmmunitionManufacturing = initStandupCommonAmmunitionManufacturing();
        List<RigRecusion_Init> initStandupCommonBasicCapitalComponentManufacturing = initStandupCommonBasicCapitalComponentManufacturing();
        List<RigRecusion_Init> initStandupCommonBasicLargeShipManufacturing = initStandupCommonBasicLargeShipManufacturing();
        List<RigRecusion_Init> initStandupCommonBasicMediumShipManufacturing = initStandupCommonBasicMediumShipManufacturing();
        List<RigRecusion_Init> initStandupCommonBasicSmallShipManufacturing = initStandupCommonBasicSmallShipManufacturing();
        List<RigRecusion_Init> initStandupCommonDroneAndFighterManufacturing = initStandupCommonDroneAndFighterManufacturing();
        List<RigRecusion_Init> initStandupCommonStructureManufacturing = initStandupCommonStructureManufacturing();
//        List<RigRecusion> initStandupCommonThukkerAdvancedComponentManufacturing = initStandupCommonThukkerAdvancedComponentManufacturing();
//        List<RigRecusion> initStandupCommonThukkerBasicCapitalComponentManufacturing = initStandupCommonThukkerBasicCapitalComponentManufacturing();
        
        effectRigs.addAll(initStandupCommonEquipmentManufacturing);
        effectRigs.addAll(initStandupCommonAdvancedComponentManufacturing);
        effectRigs.addAll(initStandupCommonAdvancedLargeShipManufacturing);
        effectRigs.addAll(initStandupCommonAdvancedMediumShipManufacturing);
        effectRigs.addAll(initStandupCommonAdvancedSmallShipManufacturing);
        effectRigs.addAll(initStandupCommonAmmunitionManufacturing);
        effectRigs.addAll(initStandupCommonBasicCapitalComponentManufacturing);
        effectRigs.addAll(initStandupCommonBasicLargeShipManufacturing);
        effectRigs.addAll(initStandupCommonBasicMediumShipManufacturing);
        effectRigs.addAll(initStandupCommonBasicSmallShipManufacturing);
        effectRigs.addAll(initStandupCommonDroneAndFighterManufacturing);
        effectRigs.addAll(initStandupCommonStructureManufacturing);
//        effectRigs.addAll(initStandupCommonThukkerAdvancedComponentManufacturing);
//        effectRigs.addAll(initStandupCommonThukkerBasicCapitalComponentManufacturing);
        return effectRigs;
    }
    
    /**
     * @deprecated 
     * init Standup Common Advanced Component Manufacturing
     * mancano i data interfaces 
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonAdvancedComponentManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );   
        
        return effectRigs;        
    }    
    
    /**
     * @deprecated 
     * init Standup Common Thukker Advanced Component Manufacturing 
     * mancano ti data interfaces
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonThukkerAdvancedComponentManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );    
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Equipment Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonEquipmentManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().shipEquipments().getshipEquipments());
        effectRigs.add(GroupEffectRig.getInstance().ship_ModuleModifications().rigs().getRigs());
        effectRigs.add(GroupEffectRig.getInstance().structures().deployableStructures().getPersonalDeployables()); // <-- include cargo container  
        effectRigs.add(GroupEffectRig.getInstance().implantsBoosters().implants().getImplants());   
        
        return effectRigs;
    }
    
    /**
     * Init Standup Common Basic Capital Component Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonBasicCapitalComponentManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Thukker Basic Capital Component Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonThukkerBasicCapitalComponentManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents()  );    
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Advanced Large Ship Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonAdvancedLargeShipManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getAdvancedBattleships() );
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getJumpFreighters() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Advanced Medium Ship Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonAdvancedMediumShipManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
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
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonAdvancedSmallShipManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getAdvancedFrigates()  );
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getAdvancedDestroyers() );
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getT3Destroyers() ); 
                                 
        return effectRigs;
    }
    
    /**
     * Init Standup Common Ammunition Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonAmmunitionManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ammunitionCarges().getAmmunitionCarges() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Large Ship Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonBasicLargeShipManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getStandardBattleships());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getFreighters()); 
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().industrialCommandShips().getIndustrialCommandShips() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Medium Ship Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonBasicMediumShipManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getStandardCruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getStandardBattlecruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().standardIndustrialShips().getStandardIndustrialShips() ); 
        effectRigs.add(GroupEffectRig.getInstance().ships().miningBarges().getMiningBarges());   
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Small Ship Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonBasicSmallShipManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getStandardFrigates());
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getStandardDestroyers());
        effectRigs.add(GroupEffectRig.getInstance().ships().shuttles().getShuttles()); 
        
        return effectRigs;        
    }
        
    /**
     * init Standup Common Drone And Fighter Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonDroneAndFighterManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().droneFighters().getDroneFighters() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Structure Manufacturing
     * @return List < RigRecusion_Init >
     */
    public List < RigRecusion_Init > initStandupCommonStructureManufacturing(){
        List < RigRecusion_Init > effectRigs = new ArrayList<>();
        
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
     * Add Effect Engineering Rig to DB
     * @param int typeId
     * @param List < RigRecusion_Init > effectRigs 
     */
    public void addEffectEngineeringRig(int typeId, List < RigRecusion_Init > effectRigs ){
        EffectEngineeringRigs_2 managerStructure = new EffectEngineeringRigs_2(typeId, effectRigs);
    }
 
}

/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/