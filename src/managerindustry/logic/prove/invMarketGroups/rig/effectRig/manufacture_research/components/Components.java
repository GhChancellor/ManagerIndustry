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
    public StandardCapitalShipComponets standardCapitalShipComponets(){
        StandardCapitalShipComponets standardCapitalShipComponets = new StandardCapitalShipComponets();
        return standardCapitalShipComponets;
    }
    
    public AdvancedCapitalComponets advancedCapitalComponets(){
        AdvancedCapitalComponets advancedCapitalComponets = new AdvancedCapitalComponets();
        return advancedCapitalComponets;
    }        
    
    public AdvancedComponets advancedComponets(){
        AdvancedComponets advancedComponets = new AdvancedComponets();
        return advancedComponets;
    }
    
    public FuelBlocks fuelBlocks(){
        FuelBlocks fuelBlocks = new FuelBlocks();
        return fuelBlocks;
    }
    
    public SubsystemComponets subsystemComponets(){
        SubsystemComponets subsystemComponets = new SubsystemComponets();
        return subsystemComponets;
    }

    public Ram ram(){
        Ram ram = new Ram();
        return ram;
    }
}
