/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups;

import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecursionA;
import managerindustry.logic.prove.invMarketGroups.old.items.ammunion.AmmunionCharges;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.battleCruiser.BattleCruiser;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.battleships.Battleships;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.capitalShip.CapitalShips;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.corvettes.Corvettes;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.cruisers.Cruisers;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.destroyer.Destroyers;
import managerindustry.logic.prove.invMarketGroups.old.items.drone.Drone;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.frigate.Frigate;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.industrialShips.IndustrialShips;
import managerindustry.logic.prove.invMarketGroups.old.items.ships.miningBarges.MiningBarges;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;
import managerindustry.logic.prove.invMarketGroups.old.DroneOLD;
import managerindustry.logic.prove.invMarketGroups.rig.RigDescription;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.EffectRig;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize.RigMedium;
import managerindustry.logic.prove.invMarketGroups.rig.StructureRig;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship_ModuleModifications.Rigs;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.RigGroups;

/**
 * http://evewiz.com/329-data-interfaces
 * @author lele
 */
public class MainInvGroup {
    public static void main(String[] args) {
        /*
        Standup M-Set Equipment Manufacturing Material Efficiency I
        decrease material requirements manufacturing ship modules, ship rigs, 
        personal deployables, implants and cargo containers
         */
//        InvTypes invTypes = ManagerDB.getInstance().invTypes().getInvTypesByName("Standup M-Set Equipment Manufacturing Material Efficiency I");
       
       

        StructureRig structureRig = new StructureRig();
//        structureRig.newRigGroups(RigGroups.getInstance().rigMedium().getStandupMSetAdvancedComponentManufacturing()); // rigGroups.getStandupMSetAdvancedComponentManufacturing()
//    
//        structureRig.getRigGroups().forEach((t) -> {
//            System.out.println(""+ t.getTypeName()  );
//
//        });

        structureRig.newEffect(EffectRig.getInstance().ships().cruisers().getAdvancedCruisers());

        
        structureRig.getEffects().forEach((t) -> {
//            System.out.println(""+ ((InvTypes)t.)  );
        });
    
        

    }
    
    public static void X001(){
        ItemRecusion ir = new ItemRecusion(1111);
            
//        Drone drone = new Drone();
//        AmmunionCharges ammunionCharges = new AmmunionCharges();
//        BattleCruiser battleCruiser = new BattleCruiser();
//        Frigate frigate = new Frigate();
//        Battleships battleships = new Battleships();
//        CapitalShips capitalShips = new CapitalShips();
//        Corvettes corvettes = new Corvettes();
//        Cruisers cruisers = new Cruisers();
//        Destroyers destroyers = new Destroyers();
//        IndustrialShips industrialShips = new IndustrialShips();
//        MiningBarges miningBarges = new MiningBarges();


//        ItemRecusion ammunitionCarges = new ItemRecusion(11);
//        ItemRecusion shipEquipment = new ItemRecusion(9);
//        ItemRecusion rigs = new ItemRecusion(1111);
//        ItemRecusion subsystemsT3 = new ItemRecusion(1112);
//        ItemRecusion droneFighter = new ItemRecusion(157);
//        ItemRecusion shuttle = new ItemRecusion(391);
//        ItemRecusion drone = new ItemRecusion(157);
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
    }
}
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