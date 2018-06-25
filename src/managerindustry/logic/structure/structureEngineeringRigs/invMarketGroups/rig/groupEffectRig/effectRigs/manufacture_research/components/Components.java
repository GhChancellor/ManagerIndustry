/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.manufacture_research.components;

import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.manufacture_research.components.outpostComponent.OutpostComponent;

/**
 * marketGroupID 1035
 * parentGroupID 1035
 * @author lele
 */
public class Components {
    
    /**
     * Station Components for Citadel, Engineering Complexes, Refineries
     * @return OutpostComponent
     */
    public OutpostComponent outpostComponent(){
        OutpostComponent outpostComponent = new OutpostComponent();
        return outpostComponent;
    }
    
    /**
     * Standard Capital Ship Componets
     * @return StandardCapitalShipComponets
     */
    public StandardCapitalShipComponets standardCapitalShipComponets(){
        StandardCapitalShipComponets standardCapitalShipComponets = new StandardCapitalShipComponets();
        return standardCapitalShipComponets;
    }
    
    /**
     * Advanced Capital Componets
     * @return AdvancedCapitalComponets
     */
    public AdvancedCapitalComponets advancedCapitalComponets(){
        AdvancedCapitalComponets advancedCapitalComponets = new AdvancedCapitalComponets();
        return advancedCapitalComponets;
    }        
    
    /**
     * Advanced Components for T2 ships
     * @return AdvancedComponets
     */
    public AdvancedComponets advancedComponets(){
        AdvancedComponets advancedComponets = new AdvancedComponets();
        return advancedComponets;
    }
    
    /**
     * Fuel Blocks for structure
     * @return FuelBlocks
     */
    public FuelBlocks fuelBlocks(){
        FuelBlocks fuelBlocks = new FuelBlocks();
        return fuelBlocks;
    }
    
    /**
     * Subsystem Components for T3 ships
     * @return SubsystemComponets
     */
    public SubsystemComponets subsystemComponets(){
        SubsystemComponets subsystemComponets = new SubsystemComponets();
        return subsystemComponets;
    }

    /**
     * Ram - Tools
     * @return Ram
     */
    public Ram ram(){
        Ram ram = new Ram();
        return ram;
    }
}
