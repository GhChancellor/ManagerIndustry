/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig.manufacture_research.components;

/**
 *
 * @author lele
 */
public class Components {
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
     * Advanced Componets
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
