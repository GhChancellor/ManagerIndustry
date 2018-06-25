/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship;

import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Battlecruisers;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Battlecruisers;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Battleships;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Cruisers;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Cruisers;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Destroyers;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Destroyers;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Frigates;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Frigates;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.MiningBarges;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Shuttles;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.generic.Shuttles;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.capitalShips.CapitalShips;
import managerindustry.logic.structure.structureEngineeringRigs.invMarketGroups.rig.groupEffectRig.effectRigs.ship.industrialShips.IndustrialShips;

/**
 *
 * @author lele
 */
public class Ships {
    /**
     * Shuttles
     * @return Shuttles
     */
    public Shuttles shuttles(){
        Shuttles shuttles = new Shuttles();
        return shuttles;
    }
    
    /**
     * Frigates: Standard Frigates, Advanced Frigates
     * @return Frigates
     */
    public Frigates frigates(){
        Frigates frigates = new Frigates();
        return frigates;
    }

    /**
     * Destroyers: Standard Destroyers, Advanced Destroyers - T3 Destroyers
     * @return Destroyers
     */
    public Destroyers destroyers(){
        Destroyers destroyers = new Destroyers();
        return destroyers;
    }

    /**
     * Cruiser: Standard Cruisers, Advanced Cruisers exclude T3 Strategic cruiser, T3 Strategic cruiser
     * @return Cruisers
     */
    public Cruisers cruisers(){
        Cruisers cruisers = new Cruisers();
        return cruisers;
    }
    
    /**
     * Battlecruisers: Standard Battlecruisers, Advanced Battlecruisers
     * @return 
     */
    public Battlecruisers battlecruisers(){
        Battlecruisers battlecruisers = new Battlecruisers();
        return battlecruisers;
    }
    
    /**
     * Battleships, standard - advanced
     * @return Battleships
     */
    public Battleships battleships(){
        Battleships battleships = new Battleships();
        return battleships;
    }
    
    /**
     * MiningBarges: Mining Barges, Exhumers
     * @return MiningBarges
     */
    public MiningBarges miningBarges(){
        MiningBarges miningBarges = new MiningBarges();
        return miningBarges;
    }    
    
    /**
     * Capital Ships: Freighter, Jump Freighter
     * @return CapitalShips
     */
    public CapitalShips capitalShips(){
        CapitalShips capitalShips = new CapitalShips();
        return capitalShips;
    }
    
    /**
     * IndustrialShips: Standard Industrial Ships, Industrial Command Ships, Advanced Industrial Ships
     * @return IndustrialShips
     */
    public IndustrialShips industrialShips(){
        IndustrialShips industrialShips = new IndustrialShips();
        return industrialShips;
    }
}
