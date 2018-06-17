/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.db.entities.InvTypes;
import managerindustry.db.entities.cache.EffectRigEntity;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.RigDescription;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.StructureRig;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.StructureRig_OLD;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.EffectRig;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.RigGroups;

/**
 *
 * @author lele
 */
public class InvMarketGroup {
//    List < StructureRig > rigs = new ArrayList<>();
    
    public InvMarketGroup() {
        initStandupMSetEquipmentManufacturing();
        initStandupMSetAdvancedComponentManufacturing();
        initStandupMSetAdvancedLargeShipManufacturing();
        initStandupMSetAdvancedMediumShipManufacturing();
    }
    
    /**
     * Init Standup MSet Equipment Manufacturing
     */
    private void initStandupMSetEquipmentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(EffectRig.getInstance().shipEquipments().getshipEquipments());
        effectRigs.add(EffectRig.getInstance().ship_ModuleModifications().rigs().getRigs());
        effectRigs.add(EffectRig.getInstance().deployableStructures().getPersonalDeployables()); // <-- include cargo container  
        effectRigs.add(EffectRig.getInstance().implantsBoosters().implants().getImplants());   
        
        structureRig(43920, effectRigs); // Standup M-Set Equipment Manufacturing Material Efficiency I
        structureRig(43921, effectRigs); // Standup M-Set Equipment Manufacturing Material Efficiency II
        structureRig(37160, effectRigs); // Standup M-Set Equipment Manufacturing Time Efficiency I
        structureRig(37161, effectRigs); // Standup M-Set Equipment Manufacturing Time Efficiency II

    }
    
    /**
     * @deprecated 
     * mancano i data interfaces
     * Init Standup MSet Advanced Component Manufacturing
     */
    private void initStandupMSetAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(EffectRig.getInstance().manufacture_research().components().advancedComponets().getAdvancedComponents() );
        effectRigs.add(EffectRig.getInstance().manufacture_research().components().advancedCapitalComponets().getAdvancedCapitalComponents() );
        effectRigs.add(EffectRig.getInstance().manufacture_research().components().ram().getRam() ); 
        effectRigs.add(EffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );   
        
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
        
        effectRigs.add(EffectRig.getInstance().ships().battleships().getAdvancedBattleships() );
        effectRigs.add(EffectRig.getInstance().ships().capitalShips().getJumpFreighters() );
        
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
        
        effectRigs.add(EffectRig.getInstance().ships().cruisers().getAdvancedCruisers() );
        effectRigs.add(EffectRig.getInstance().ships().cruisers().getT3Cruisers() ); 
        
        effectRigs.add(EffectRig.getInstance().ships().battlecruisers().getAdvancedBattlecruisers() );
        effectRigs.add(EffectRig.getInstance().ships().industrialShips().advancedIndustrialShips().getTransportShips() ); 
        effectRigs.add(EffectRig.getInstance().ships().miningBarges().getExhumers() );   
        effectRigs.add(EffectRig.getInstance().manufacture_research().components().subsystemComponets().getSubsystemComponents() );   
        
        structureRig(43858, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency I
        structureRig(43859, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Material Efficiency II
        structureRig(43860, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency I
        structureRig(43861, effectRigs); // Standup M-Set Advanced Medium Ship Manufacturing Time Efficiency II
    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
//    private void initStandupMSetAdvancedComponentManufacturing(){
//        List < ItemRecusion > effectRigs = new ArrayList<>();
//        
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). );
//        effectRigs.add(EffectRig.getInstance(). ); 
//        effectRigs.add(EffectRig.getInstance(). );   
//        
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//        structureRig( , effectRigs); 
//    }
    
    
    private void structureRig(int typeId, List < ItemRecusion > effectRigs){
        StructureRig rig = new StructureRig(typeId, effectRigs );   
        ManagerDB.getInstance().effectRig().addEffectRigs(rig);
    }    
    

    
}
/*
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=157;
SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=157; -- Si ferma qua 
SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=1646; -- parentGroupID 157
SELECT * from invTypes where invTypes.typeName ="Salvage Drone I"; -- typeID 32787 makertGroupID 1646 
*/