/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.initRigGroupSize.logic;

import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ammunitionCarges.AmmunitionCarges;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.droneFighters.DroneFighters;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.shipEquipment.ShipEquipment;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.Ships;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship_ModuleModifications.Subsystems;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.implants_boosters.ImplantsBoosters;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.manufacture_research.Manufacture_research;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship_ModuleModifications.Ship_ModuleModifications;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.structure.Structures;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.structureEquipment.StructureEquipment;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.structureModifications.StructureModifications;

/**
 * SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=2347; -- Advanced Frigates
 * SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=2340;	-- vuoto
 * SELECT * FROM invTypes, invMarketGroups where invMarketGroups.marketGroupID=invTypes.marketGroupID and invMarketGroups.marketGroupID=2347;
 *  
 * @author lele
 */
public class GroupEffectRig {
    private static GroupEffectRig instance = null;

    public static GroupEffectRig getInstance(){
        if ( instance == null )
            instance = new GroupEffectRig();
        return instance;
    }     
    
    /**
     * * Get Ammunition Carges
     * @return AmmunitionCarges
     */
    public AmmunitionCarges ammunitionCarges(){
        AmmunitionCarges ammunitionCarges = new AmmunitionCarges();
        return ammunitionCarges;
    }
    
    /**
     * Get ship Equipments / ship modules
     * @return ShipEquipment
     */
    public ShipEquipment shipEquipments(){
        ShipEquipment shipEquipment = new ShipEquipment();
        return shipEquipment;
    }
 
    /**
     * Get t3 subsystems
     * @return Subsystems
     */
    public Subsystems t3subsystems(){
        Subsystems t3subsystems = new Subsystems();
        return t3subsystems;
    }

    /**
     * Get Drone and Fighters
     * @return DroneFighters
     */
    public DroneFighters droneFighters(){
        DroneFighters droneFighters = new DroneFighters();
        return droneFighters;
    }

    /**
     * Get ship
     * @return Ships
     */
    public Ships ships(){
        Ships ships = new Ships();
        return ships;
    }

    /**
     * Get Component 
     * @return Manufacture_research
     */
    public Manufacture_research manufacture_research(){
        Manufacture_research manufacture_research = new Manufacture_research();
        return manufacture_research;
    }

    /**
     * Implants Boosters
     * @return ImplantsBoosters
     */
    public ImplantsBoosters implantsBoosters(){
        ImplantsBoosters implantsBoosters = new ImplantsBoosters();
        return implantsBoosters;
    }
    
    /**
     * Ship rigs - Module Modifications
     * @return Ship_ModuleModifications
     */
    public Ship_ModuleModifications ship_ModuleModifications(){
        Ship_ModuleModifications ship_ModuleModifications = new Ship_ModuleModifications();
        return ship_ModuleModifications;
    }
    
//    /**
//     * Blueprints_OLD: Copy, Invention, ME Research, TE Research
//     * @return Blueprints_OLD
//     */
//    public Blueprints_OLD blueprints(){
//        Blueprints_OLD blueprints = new Blueprints_OLD();
//        return blueprints;
//    }    
        
    /**
     * Structure Equipment / Structure modules
     * @return StructureEquipment
     */
    public StructureEquipment structureEquipment(){
       StructureEquipment structureEquipment = new StructureEquipment();
       return structureEquipment;
    }
    
    /**
     * Structures: Base Structures, Personal Deployables, Citadels, Engineering Complexes, Refineries
     * @return Structures
     */
    public Structures structures(){
        Structures structures = new Structures();
        return structures;
    }
    
    /**
     * Structure Modifications: rig
     * @return StructureModifications
     */
    public StructureModifications structureModifications(){
        StructureModifications structureModifications = new StructureModifications();
        return structureModifications;
    }
}

//        ItemRecusion ammunitionCarges = new ItemRecusion(11);
//        ItemRecusion shipEquipment = new ItemRecusion(9);
//        ItemRecusion rigs = new ItemRecusion(1111);
//        ItemRecusion subsystemsT3 = new ItemRecusion(1112);
//        ItemRecusion droneFighter = new ItemRecusion(157);
//        ItemRecusion shuttle = new ItemRecusion(391);
//        
//        ItemRecusion standardFrigate = new ItemRecusion(5);
//        ItemRecusion advancedFrigate = new ItemRecusion(1364);
//        
//        ItemRecusion standardDestroyers = new ItemRecusion(464);
//        ItemRecusion advancedDestroyers = new ItemRecusion(1373); // *
//        ItemRecusion t3Destroyers = new ItemRecusion(1951); // <----
//        
//        ItemRecusion standardCruisers = new ItemRecusion(6);
//        ItemRecusion advancedCruisers = new ItemRecusion(1368); // *
//        ItemRecusion t3Cruisers = new ItemRecusion(1138); // <----
//        
//        ItemRecusion standardBattlecruisers = new ItemRecusion(469);
//        ItemRecusion advancedBattlecruisers = new ItemRecusion(822);

//        ItemRecusion standardBattleships = new ItemRecusion(7);
//        ItemRecusion advancedBattleships = new ItemRecusion(1377);

//        ItemRecusion jumpFreighters = new ItemRecusion(1089); // <----

////        Industrial
//        ItemRecusion exhumers = new ItemRecusion(874);
//        ItemRecusion miningBarges = new ItemRecusion(494);
//        ItemRecusion standardIndustrialShips = new ItemRecusion(8);
//        ItemRecusion IndustrialCommandShips = new ItemRecusion(2335);
//        ItemRecusion t2HaulersTransportShips = new ItemRecusion(629); // ADVANCED_INDUSTRIAL_SHIPS(1373)


//        ItemRecusion advancedComponents = new ItemRecusion(65); 

//        ItemRecusion standardCapitalShipComponents = new ItemRecusion(781); 
//        ItemRecusion advancedCapitalComponents = new ItemRecusion(1883); 
    
//        ItemRecusion subsystemComponents = new ItemRecusion(1147); 
//        
//        ItemRecusion fuelBlocks = new ItemRecusion(1870);         
//        ItemRecusion structureEquipment = new ItemRecusion(2202); 
//        ItemRecusion structureModifications = new ItemRecusion(2203); 

/*
    ship modules = ships equipment
    t2 component = advancedComponents 
    Capital construction compoent = standardCapitalShipComponents
    t2 capital component = advancedCapitalComponents
    Deployable structure = personal deployable? Cargo containers ??
    implants = Attribute enhancers/ skill hardwiring
    t3 component = Subsystem Components ( Electromechanical Interface Nexus )
    tools ????
    data Interface ??
    structure component = structure equipment
    upwell structure ??

*/  

/*
SELECT * FROM invTypes where invTypes.typeName="Standup M-Set Equipment Manufacturing Material Efficiency I";
-- 43920

   SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=2347; -- Advanced Frigates
   SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=2340;	-- vuoto
            
    SELECT * FROM invTypes, invMarketGroups where invMarketGroups.marketGroupID=invTypes.marketGroupID and
    invMarketGroups.marketGroupID=2347;  
*/