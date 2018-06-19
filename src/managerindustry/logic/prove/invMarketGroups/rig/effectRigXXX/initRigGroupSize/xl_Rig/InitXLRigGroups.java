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
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }    
    
    /**
     * Get Standup XL Set Ship Manufacturing
     */
    private void initStandupXLSetShipManufacturing(){   
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }    
    
    /**
     * Get Standup XL Set Laboratory
     */
    private void initStandupXLSetLaboratory(){      
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }    
    
    /**
     * Get Standup XL Set Structure And Component Manufacturing
     */
    private void initStandupXLSetStructureAndComponentManufacturing(){    
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }    
    
    /**
     * Get Standup XL Set Thukker Structure And Component Manufacturing
     */
    private void initStandupXLSetThukkerStructureAndComponentManufacturing(){ 
        List < ItemRecusion > effectRigs = new ArrayList<>();
        
        effectRigs.add(GroupEffectRig.getInstance().);
        
        structureRig(, effectRigs);               
    }       
    
    private void structureRig(int typeId, List < ItemRecusion > effectRigs){
        StructureRig rig = new StructureRig(typeId, effectRigs );   
        ManagerDB.getInstance().effectRig().addEffectRigs(rig);
    }     
}
