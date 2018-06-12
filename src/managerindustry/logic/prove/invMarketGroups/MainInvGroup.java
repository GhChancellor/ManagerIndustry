/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups;

import java.util.List;
import java.util.Map;
import managerindustry.db.entities.IndustryActivity;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecursionA;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecursionB;
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
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRercsionLibrary;
import managerindustry.logic.prove.invMarketGroups.old.DroneOLD;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.RigDescription;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.EffectRig;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize.old.RigMedium_OLD;
import managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA.StructureRig;
import managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship_ModuleModifications.Rigs;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.RigGroups;
import managerindustry.logic.prove.ricorsione.skill.skillProduction.RecursionA;

/**
 * http://evewiz.com/329-data-interfaces
 * @author lele
 */
public class MainInvGroup {
    public static void main(String[] args) {

//        InvTypes invTypes = ManagerDB.getInstance().invTypes().getInvTypesByName("Standup M-Set Equipment Manufacturing Material Efficiency I");
       
        StructureRig structureRig = new StructureRig();
        structureRig.newEffect(EffectRig.getInstance().manufacture_research().components().ram().getRam());
//        structureRig.newEffect(EffectRig.getInstance().manufacture_research().components().fuelBlocks().getFuelBlocks());
//        structureRig.newEffect(EffectRig.getInstance().implantsBoosters().implants().getImplants());

        
        ItemRercsionLibrary itemRercsionLibrary = new ItemRercsionLibrary();
        itemRercsionLibrary.display(structureRig.getEffects().get(0), "");
       
        List<Integer> conversionToList = itemRercsionLibrary.getConversionToList(structureRig.getEffects().get(0));
        Map<Integer, Integer> conversionToMap = itemRercsionLibrary.getConversionToMap(structureRig.getEffects().get(0));
//        
        System.out.println("");
//        StructureRig structureRig = new StructureRig();
//        structureRig.newRigGroups(RigGroups.getInstance().rigMedium().getStandupMSetEquipmentManufacturing()); // rigGroups.getStandupMSetAdvancedComponentManufacturing()
//        
//        structureRig.getRigGroups().forEach((t) -> {
//            System.out.println(""+ t.getTypeName() + " " + t.getTypeID());
//        });
//        structureRig.newEffect(EffectRig.getInstance().shipEquipments().getshipEquipments());
//        structureRig.newEffect(EffectRig.getInstance().ship_ModuleModifications().rigs().getRigs() );
//        structureRig.newEffect(EffectRig.getInstance().deployableStructures().getPersonalDeployables()); // <-- include cargo container
//        structureRig.newEffect(EffectRig.getInstance().implantsBoosters().implants().getImplants());
//        structureRig.newEffect(EffectRig.getInstance().ships().cruisers().getStandardCruisers());
//        structureRig.newEffect(EffectRig.getInstance().ammunitionCarges().getAmmunitionCarges());
//        List<ItemRecursionA> effects = structureRig.getEffects();
//        display(effects);
//
//        System.out.println("");
//        ItemRecusion ir = new ItemRecusion(2203);
        
    }
    
    public static void display( List<ItemRecursionA> effects){
        for (ItemRecursionA effect : effects) {
            List<ItemRecursionB> recursionB02s = effect.getRecursionB02s();
            
            for (ItemRecursionB recursionB02 : recursionB02s) {
                ItemRecursionA recursionA02 = recursionB02.getRecursionA02();
                System.out.println("XXXXXXX "+recursionA02.getMarketGroupName() + " " + recursionA02.getMarketGroupID());
            }
        }  
    }
    
    public IndustryActivity getCopy(int typeID, RamActivitiesEnum ramActivitiesEnum){
        IndustryActivity industryActivity = 
          ManagerDB.getInstance().industryActivity().getIndustryActivity(typeID, ramActivitiesEnum);
        return industryActivity;
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