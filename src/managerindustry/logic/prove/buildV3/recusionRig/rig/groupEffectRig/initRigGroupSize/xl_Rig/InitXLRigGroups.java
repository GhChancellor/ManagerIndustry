/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3.recusionRig.rig.groupEffectRig.initRigGroupSize.xl_Rig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.prove.buildV3.recusionRig.rig.groupEffectRig.initRigGroupSize.logic.GroupEffectRig;
import managerindustry.logic.prove.buildV3.recusionRig.rig.groupEffectRig.initRigGroupSize.logic.InitCommonRigGroups;
import managerindustry.logic.prove.buildV3.recusionRig.safe.RigRecusion;

/**
 *
 * @author lele
 */
public class InitXLRigGroups{
    private InitCommonRigGroups initCommonRigGroups = new InitCommonRigGroups();
    
    public InitXLRigGroups() {
    }
    
    /**
     * Get Standup XL Set Equipment And Consumable Manufacturing
     * @param int typeId 
     */
    public void initStandupXLSetEquipmentAndConsumableManufacturing(int typeId){ 
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().shipEquipments().getshipEquipments());
        effectRigs.add(GroupEffectRig.getInstance().structures().deployableStructures().getPersonalDeployables()); // <-- include cargo container 
        effectRigs.add(GroupEffectRig.getInstance().ammunitionCarges().getAmmunitionCarges() );
        effectRigs.add(GroupEffectRig.getInstance().droneFighters().getDroneFighters() );
      
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);
    }    
    
    /**
     * Get Standup XL Set Ship Manufacturing
     * @param int typeId 
     */
    public void initStandupXLSetShipManufacturing(int typeId){   
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getAdvancedBattlecruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().battlecruisers().getStandardBattlecruisers());
        
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getAdvancedBattleships());
        effectRigs.add(GroupEffectRig.getInstance().ships().battleships().getStandardBattleships());
        
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getFreighters());
        effectRigs.add(GroupEffectRig.getInstance().ships().capitalShips().getJumpFreighters());
        
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getAdvancedCruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getStandardCruisers());
        effectRigs.add(GroupEffectRig.getInstance().ships().cruisers().getT3Cruisers());
        
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getAdvancedDestroyers());
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getStandardDestroyers());
        effectRigs.add(GroupEffectRig.getInstance().ships().destroyers().getT3Destroyers());
        
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getAdvancedFrigates());
        effectRigs.add(GroupEffectRig.getInstance().ships().frigates().getStandardFrigates());
        
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().advancedIndustrialShips().getTransportShips());
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().industrialCommandShips().getIndustrialCommandShips());
        effectRigs.add(GroupEffectRig.getInstance().ships().industrialShips().standardIndustrialShips().getStandardIndustrialShips());
        
        effectRigs.add(GroupEffectRig.getInstance().ships().miningBarges().getExhumers());
        effectRigs.add(GroupEffectRig.getInstance().ships().miningBarges().getMiningBarges());
        
        effectRigs.add(GroupEffectRig.getInstance().ships().shuttles().getShuttles());
        
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);            
    }    
    
    /**
     * Get Standup XL Set Structure And Component Manufacturing
     * @param int typeId 
     */
    public void initStandupXLSetStructureAndComponentManufacturing(int typeId){    
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().fuelBlocks().getFuelBlocks() );  
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().outpostComponent().getStationComponents());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents());        
        
        // upwell Structure
        effectRigs.add(GroupEffectRig.getInstance().structures().citadels().getCitadels() );   
        effectRigs.add(GroupEffectRig.getInstance().structures().engineeringComplexes().getEngineeringComplexes() );   
        effectRigs.add(GroupEffectRig.getInstance().structures().refineries().getRefineries() );          
        
        effectRigs.add(GroupEffectRig.getInstance().structureEquipment().getStructureEquipment() );
        effectRigs.add(GroupEffectRig.getInstance().structureModifications().getStructureModifications() ); 
        
        effectRigs.add(GroupEffectRig.getInstance().structures().starbaseStructures().getStarbaseStructures() );   
        
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);            
    }    
    
    /**
     * Get Standup XL Set Thukker Structure And Component Manufacturing
     * @param int typeId 
     */
    public void initStandupXLSetThukkerStructureAndComponentManufacturing(int typeId){ 
        List < RigRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().fuelBlocks().getFuelBlocks() );  
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().outpostComponent().getStationComponents());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().ram().getRam());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().standardCapitalShipComponets().getStandardCapitalShipComponents());
        effectRigs.add(GroupEffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents());        
        
        // upwell Structure
        effectRigs.add(GroupEffectRig.getInstance().structures().citadels().getCitadels() );   
        effectRigs.add(GroupEffectRig.getInstance().structures().engineeringComplexes().getEngineeringComplexes() );   
        effectRigs.add(GroupEffectRig.getInstance().structures().refineries().getRefineries() );          
        
        effectRigs.add(GroupEffectRig.getInstance().structureEquipment().getStructureEquipment() );
        effectRigs.add(GroupEffectRig.getInstance().structureModifications().getStructureModifications() ); 
        
        effectRigs.add(GroupEffectRig.getInstance().structures().starbaseStructures().getStarbaseStructures() );  
        
        initCommonRigGroups.addEffectEngineeringRig(typeId, effectRigs);             
    }       
    
    /**
     * Get Standup XL Set Laboratory
     * @param int typeId 
     */
    public void initStandupXLSetLaboratory(int typeId){      
        // new ArrayList<>() must be empty
        initCommonRigGroups.addEffectEngineeringRig(typeId, new ArrayList<>());             
    }        
}
