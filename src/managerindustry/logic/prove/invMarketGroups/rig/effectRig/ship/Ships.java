/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship;

import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Battlecruisers;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Battlecruisers;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Battleships;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Cruisers;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Cruisers;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Destroyers;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Destroyers;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Frigates;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Frigates;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.MiningBarges;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Shuttles;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.generic.Shuttles;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.capitalShips.CapitalShips;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.industrialShips.IndustrialShips;

/**
 *
 * @author lele
 */
public class Ships {
    public Shuttles shuttles(){
        Shuttles shuttles = new Shuttles();
        return shuttles;
    }
    
    public Frigates frigates(){
        Frigates frigates = new Frigates();
        return frigates;
    }

    public Destroyers destroyers(){
        Destroyers destroyers = new Destroyers();
        return destroyers;
    }

    public Cruisers cruisers(){
        Cruisers cruisers = new Cruisers();
        return cruisers;
    }
    
    public Battlecruisers battlecruisers(){
        Battlecruisers battlecruisers = new Battlecruisers();
        return battlecruisers;
    }
    
    public Battleships battleships(){
        Battleships battleships = new Battleships();
        return battleships;
    }
    
    public MiningBarges miningBarges(){
        MiningBarges miningBarges = new MiningBarges();
        return miningBarges;
    }    
    
    public CapitalShips capitalShips(){
        CapitalShips capitalShips = new CapitalShips();
        return capitalShips;
    }
    
    public IndustrialShips industrialShips(){
        IndustrialShips industrialShips = new IndustrialShips();
        return industrialShips;
    }
}
