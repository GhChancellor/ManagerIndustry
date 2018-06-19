/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.initRigGroupSize.largeRig;

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
public class InitLargeRigGroups {

    public InitLargeRigGroups() {
        initStandupLSetAmmunitionManufacturing();
        initStandupLSetBasicLargeShipManufacturing();
        initStandupLSetAdvancedLargeShipManufacturing();
        initStandupLSetEquipmentManufacturing();
        initStandupLSetCapitalShipManufacturing();
        initStandupLSetAdvancedComponentManufacturing();
        initStandupLSetAdvancedSmallShipManufacturing();
        initStandupLSetAdvancedMediumShipManufacturing();
        initStandupLSetDroneAndFighterManufacturing();
        initStandupLSetBasicSmallShipManufacturing();
        initStandupLSetBasicMediumShipManufacturing();
        initStandupLSetBasicCapitalComponentManufacturing();
        initStandupLSetStructureManufacturing();
        initStandupLSetInvention();
        initStandupLSetMEResearch();
        initStandupLSetTEResearch();
        initStandupLSetBlueprintCopy();
        initStandupLSetThukkerBasicCapitalComponentManufacturing();
    }
    
    /**
     * Get Standup LSet Ammunition Manufacturing
     */
    private void initStandupLSetAmmunitionManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().shipEquipments().getshipEquipments());
        effectRigs.add(GroupEffectRig.getInstance().ship_ModuleModifications().rigs().getRigs());
        effectRigs.add(GroupEffectRig.getInstance().structures().deployableStructures().getPersonalDeployables()); // <-- include cargo container  
        effectRigs.add(GroupEffectRig.getInstance().implantsBoosters().implants().getImplants());   
        
        structureRig(37164, effectRigs); // Standup L-Set Ammunition Manufacturing Efficiency I 
        structureRig(37165, effectRigs); // Standup L-Set Ammunition Manufacturing Efficiency II
    }
    
    /**
     * Get Standup LSet Basic Large Ship Manufacturing
     */
    private void initStandupLSetBasicLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);        
    }
    
    /**
     * Get Standup LSet Advanced Large Ship Manufacturing
     */
    private void initStandupLSetAdvancedLargeShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Equipment Manufacturing
     */
    private void initStandupLSetEquipmentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Capital Ship Manufacturing
     */
    private void initStandupLSetCapitalShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Advanced Component Manufacturing
     */
    private void initStandupLSetAdvancedComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Advanced Small Ship Manufacturing
     */
    private void initStandupLSetAdvancedSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Advanced Medium Ship Manufacturing
     */
    private void initStandupLSetAdvancedMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Drone And Fighter Manufacturing
     */
    private void initStandupLSetDroneAndFighterManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Basic Small Ship Manufacturing
     */
    private void initStandupLSetBasicSmallShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Basic Medium Ship Manufacturing
     */
    private void initStandupLSetBasicMediumShipManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Basic Capital Component Manufacturing
     */
    private void initStandupLSetBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Structure Manufacturing
     */
    private void initStandupLSetStructureManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Invention
     */
    private void initStandupLSetInvention(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet ME Research
     */
    private void initStandupLSetMEResearch(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet TE Research
     */
    private void initStandupLSetTEResearch(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Blueprint Copy
     */
    private void initStandupLSetBlueprintCopy(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    /**
     * Get Standup LSet Thukker Basic Capital Component Manufacturing
     */
    private void initStandupLSetThukkerBasicCapitalComponentManufacturing(){
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }
    
    private void structureRig(int typeId, List < ItemRecusion > effectRigs){
        StructureRig rig = new StructureRig(typeId, effectRigs );   
        ManagerDB.getInstance().effectRig().addEffectRigs(rig);
    }       
}
