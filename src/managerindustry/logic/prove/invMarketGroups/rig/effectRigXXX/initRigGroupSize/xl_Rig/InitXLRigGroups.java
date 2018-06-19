/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.initRigGroupSize.xl_Rig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.StructureRig;
import managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.GroupEffectRig;

/**
 *
 * @author lele
 */
public class InitXLRigGroups {

    public InitXLRigGroups() {
        initStandupXLSetEquipmentAndConsumableManufacturing();
        initStandupXLSetShipManufacturing();
        initStandupXLSetLaboratory();
        initStandupXLSetStructureAndComponentManufacturing();
        initStandupXLSetThukkerStructureAndComponentManufacturing();
    }
    
    /**
     * Get Standup XL Set Equipment And Consumable Manufacturing
     */
    private void initStandupXLSetEquipmentAndConsumableManufacturing(){ 
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().shipEquipments().getshipEquipments());
        effectRigs.add(GroupEffectRig.getInstance().structures().deployableStructures().getPersonalDeployables()); // <-- include cargo container 
        effectRigs.add(GroupEffectRig.getInstance().ammunitionCarges().getAmmunitionCarges() );
        effectRigs.add(GroupEffectRig.getInstance().droneFighters().getDroneFighters() );
        
        structureRig(37178, effectRigs); // Standup XL-Set Equipment and Consumable Manufacturing Efficiency I              
        structureRig(37179, effectRigs); // Standup XL-Set Equipment and Consumable Manufacturing Efficiency II              
    }    
    
    /**
     * Get Standup XL Set Ship Manufacturing
     */
    private void initStandupXLSetShipManufacturing(){   
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
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
        
        structureRig(37180, effectRigs); // Standup XL-Set Ship Manufacturing Efficiency I              
        structureRig(37181, effectRigs); // Standup XL-Set Ship Manufacturing Efficiency II              
    }    
    
    /**
     * Get Standup XL Set Laboratory
     */
    private void initStandupXLSetLaboratory(){      
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(37182, effectRigs); // Standup XL-Set Laboratory Optimization II              
        structureRig(37183, effectRigs); // Standup XL-Set Laboratory Optimization I              
    }    
    
    /**
     * Get Standup XL Set Structure And Component Manufacturing
     */
    private void initStandupXLSetStructureAndComponentManufacturing(){    
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
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
        
        structureRig(43704, effectRigs); // Standup XL-Set Structure and Component Manufacturing Efficiency I              
        structureRig(43705, effectRigs); // Standup XL-Set Structure and Component Manufacturing Efficiency II              
    }    
    
    /**
     * Get Standup XL Set Thukker Structure And Component Manufacturing
     */
    private void initStandupXLSetThukkerStructureAndComponentManufacturing(){ 
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
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
        
        structureRig(45548, effectRigs); // Standup XL-Set Thukker Structure and Component Manufacturing Efficiency               
    }       
    
    private void structureRig(int typeId, List < ItemRecusion > effectRigs){
        StructureRig rig = new StructureRig(typeId, effectRigs );   
        ManagerDB.getInstance().effectRig().addEffectRigs(rig);
    }     
}
