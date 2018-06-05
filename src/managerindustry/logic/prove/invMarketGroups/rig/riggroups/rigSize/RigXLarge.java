/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.InvTypes;

/**
 * marketGroupID 2349 
 * parentGroupID 2340
 * @author lele
 */
public class RigXLarge extends RigSize{
    /**
     * Get Standup XL Set Equipment And Consumable Manufacturing
     * @return List<InvTypes>
     */    
    public List<InvTypes> getStandupXLSetEquipmentAndConsumableManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(37178); // Standup XL-Set Equipment and Consumable Manufacturing Efficiency I
        rigGroups.add(37179); // Standup XL-Set Equipment and Consumable Manufacturing Efficiency II
        return getInvTypes(rigGroups);
    }      
    
    /**
     * Get Standup XL Set Ship Manufacturing
     * @return List<InvTypes>
     */    
    public List<InvTypes> getStandupXLSetShipManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(37180); // Standup XL-Set Ship Manufacturing Efficiency I
        rigGroups.add(37181); // Standup XL-Set Ship Manufacturing Efficiency II
        return getInvTypes(rigGroups);
    }      
    
    /**
     * Get Standup XL Set Laboratory
     * @return List<InvTypes>
     */    
    public List<InvTypes> getStandupXLSetLaboratory(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(37182); // Standup XL-Set Laboratory Optimization II
        rigGroups.add(37183); // Standup XL-Set Laboratory Optimization I
        return getInvTypes(rigGroups);
    }      
    
    /**
     * Get Standup XL Set Structure And Component Manufacturing
     * @return List<InvTypes>
     */    
    public List<InvTypes> getStandupXLSetStructureAndComponentManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(43704); // Standup XL-Set Structure and Component Manufacturing Efficiency I
        rigGroups.add(43705); // Standup XL-Set Structure and Component Manufacturing Efficiency II
        return getInvTypes(rigGroups);
    }      
    
    /**
     * Get Standup XL Set Thukker Structure And Component Manufacturing
     * @return List<InvTypes>
     */    
    public List<InvTypes> getStandupXLSetThukkerStructureAndComponentManufacturing(){
        List<Integer> rigGroups = new ArrayList<>();
        rigGroups.add(45548); // Standup XL-Set Thukker Structure and Component Manufacturing Efficiency
        return getInvTypes(rigGroups);
    }      
    
}
