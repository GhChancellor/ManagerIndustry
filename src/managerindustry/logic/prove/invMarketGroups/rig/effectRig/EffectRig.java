/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig;

import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ammunitionCarges.AmmunitionCarges;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.structure.deployableStructures.DeployableStructures;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.droneFighters.DroneFighters;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.shipEquipment.ShipEquipment;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.Ships;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship_ModuleModifications.Subsystems;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.implants_boosters.ImplantsBoosters;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.manufacture_research.Manufacture_research;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.manufacture_research.components.Components;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship_ModuleModifications.Ship_ModuleModifications;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.structureEquipment.StructureEquipment;

/**
 *
 * @author lele
 */
public class EffectRig {
    private static EffectRig instance = null;

    public static EffectRig getInstance(){
        if ( instance == null )
            instance = new EffectRig();
        return instance;
    }     
    
    public AmmunitionCarges ammunitionCarges(){
        AmmunitionCarges ammunitionCarges = new AmmunitionCarges();
        return ammunitionCarges;
    }
    
    public ShipEquipment shipEquipments(){
        ShipEquipment shipEquipment = new ShipEquipment();
        return shipEquipment;
    }
 
    public Subsystems t3subsystems(){
        Subsystems t3subsystems = new Subsystems();
        return t3subsystems;
    }

    public DroneFighters droneFighters(){
        DroneFighters droneFighters = new DroneFighters();
        return droneFighters;
    }

    public Ships ships(){
        Ships ships = new Ships();
        return ships;
    }

    public Manufacture_research manufacture_research(){
        Manufacture_research manufacture_research = new Manufacture_research();
        return manufacture_research;
    }
    
    public Components components(){
        Components components = new Components();
        return components;
    }
    
    public ImplantsBoosters implantsBoosters(){
        ImplantsBoosters implantsBoosters = new ImplantsBoosters();
        return implantsBoosters;
    }
    
    public Ship_ModuleModifications ship_ModuleModifications(){
        Ship_ModuleModifications ship_ModuleModifications = new Ship_ModuleModifications();
        return ship_ModuleModifications;
    }
    
    public StructureEquipment structureEquipment(){
       StructureEquipment structureEquipment = new StructureEquipment();
       return structureEquipment;
    }
    
    public DeployableStructures deployableStructures(){
        DeployableStructures deployableStructures = new DeployableStructures();
        return deployableStructures;
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