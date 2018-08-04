/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigs_2;


/**
 *
 * @author lele
 */
public class InitCommonRigGroups {
    
    public InitCommonRigGroups() {
    }
    
    /**
     * Init Standup Common Equipment Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonEquipmentManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        
        effectRigs.add(GroupEffectRig.getInstance().shipEquipments().getshipEquipments());
        effectRigs.add(GroupEffectRig.getInstance().ship_ModuleModifications().rigs().getRigs());
        effectRigs.add(GroupEffectRig.getInstance().structures().deployableStructures().getPersonalDeployables()); // <-- include cargo container  
        effectRigs.add(GroupEffectRig.getInstance().implantsBoosters().implants().getImplants());   
        
        return effectRigs;
    }
    
    /**
     * @deprecated 
     * mancano i data interfaces 
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonAdvancedComponentManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );   
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Advanced Large Ship Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonAdvancedLargeShipManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getAdvancedBattleships() );
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getJumpFreighters() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Advanced Medium Ship Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonAdvancedMediumShipManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
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
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonAdvancedSmallShipManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getAdvancedFrigates()  );
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getAdvancedBattlecruisers() );
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getT3Destroyers() ); 
                        
        return effectRigs;
    }
    
    /**
     * Init Standup Common Ammunition Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonAmmunitionManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ammunitionCarges().getAmmunitionCarges() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Capital Component Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonBasicCapitalComponentManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Large Ship Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonBasicLargeShipManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getStandardBattleships());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getFreighters()); 
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().industrialCommandShips().getIndustrialCommandShips() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Medium Ship Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonBasicMediumShipManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getStandardCruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getStandardBattlecruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().standardIndustrialShips().getStandardIndustrialShips() ); 
        effectRigs.add(GroupEffectRig.getInstance().ships().miningBarges().getMiningBarges());   
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Basic Small Ship Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonBasicSmallShipManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getStandardFrigates());
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getStandardDestroyers());
        effectRigs.add(GroupEffectRig.getInstance().ships().shuttles().getShuttles()); 
        
        return effectRigs;        
    }
        
    /**
     * init Standup Common Drone And Fighter Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonDroneAndFighterManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().droneFighters().getDroneFighters() );
        
        return effectRigs;        
    }
    
    /**
     * Init Standup Common Structure Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonStructureManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
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
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonThukkerAdvancedComponentManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );    
        
        return effectRigs;        
    }

    /**
     * Init Standup Common Thukker Basic Capital Component Manufacturing
     * @return List < RigRecusion >
     */
    public List < RigRecusion > initStandupCommonThukkerBasicCapitalComponentManufacturing(){
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents()  );    
        
        return effectRigs;        
    }

    /**
     * Add Effect Engineering Rig to DB
     * @param int typeId
     * @param List < RigRecusion > effectRigs 
     */
    public void addEffectEngineeringRig(int typeId, List < RigRecusion > effectRigs ){
        EffectEngineeringRigs_2 managerStructure = new EffectEngineeringRigs_2(typeId, effectRigs);
    }
 
}

/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/