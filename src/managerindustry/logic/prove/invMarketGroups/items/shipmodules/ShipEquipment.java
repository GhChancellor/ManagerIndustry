/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.shipmodules;

import managerindustry.logic.prove.invMarketGroups.items.ships.cruisers.*;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class ShipEquipment extends Category<Object>{
    private enum ShipEquipmentEnum{
        ELECTRONIC_WARFARE(0),
            // ELECTRONIC_COUNTER_MEASURES
                GRAVIMETRIC_JAMMERS(0),
                LADAR_JAMMERS(0),
                MAGNETOMETRIC_JAMMERS(0),
                MULTI_SPECTRUM_JAMMERS(0),
                RADAR_JAMMERS(0),
                SIGNAL_DISTORTION_AMPLIFIERS(0),
            BURST_PROJECTORS(0),
            EMC_BURSTS(0),
                // FACTION_STORYLINE
                // OFFICER
            INTERDICTION_SPHERE_LAUNCHERS(0),
            REMOTE_SENSOR_DAMPENERS(0),
            STASIS_GRAPPLERS(0),
            STASIS_WEBIFIERS(0),
            TARGET_BREAKERS(0),
            TARGET_PAINTERS(0),
            WARP_DISRUPTION_FIELD_GENERATORS(0),
                // FACTION_STORYLINE
            WARP_DISRUPTORS(0),
                // FACTION_STORYLINE
                // OFFICER
            WARP_SCRAMBLERS(0),
                // FACTION_STORYLINE
                // OFFICER
            WEAPON_DISRUPTOR(0),
                // FACTION_STORYLINE            
            ELECTRONICS_AND_SENSOR_UPGRADES(0), 
                AUTOMATED_TARGETING_SYSTEM(0),
                CLOAKING_DEVICES(0),

                STANDARD_CRUISERS(0),
                FACTION_CRUISERS(0),
                T3_CRUISERS(0);
        
        private ShipEquipmentEnum(ShipEquipmentEnum shipEquipment) {
            this.shipEquipment = shipEquipment;
        }

        private ShipEquipmentEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private ShipEquipmentEnum shipEquipment;

        public int getCode() {
            return code;
        }
        
    }
    
    public ShipEquipment(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public ShipEquipment() {
        xxx(ShipEquipmentEnum.AUTOMATED_TARGETING_SYSTEM , "");
        display(getItems());
    }
        
    @Override
    public void initItems(Object t) {
//        switch ((ShipEquipmentEnum)t){
//            case STANDARD_CRUISERS:
//                setItems(ManagerDB.getInstance().invTypes().getParentGroupID(((ShipEquipmentEnum) t).getCode(), true ));
//                break;
//            case ADVANCED_CRUISERS:
//                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((ShipEquipmentEnum) t).LOGISTICS.getCode(), true ) );
//                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((ShipEquipmentEnum) t).HEAVY_ASSAULT_CRUISERS.getCode(), true ) );
//                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((ShipEquipmentEnum) t).RECON_SHIPS.getCode(), true  ) );
//                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((ShipEquipmentEnum) t).HEAVY_INTERDICTION_CRUISERS.getCode(), true ) );
//                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((ShipEquipmentEnum) t).FLAG_CRUISERS.getCode(), true  ) );
//                break;
//            case FACTION_CRUISERS:
//                setItems( ManagerDB.getInstance().invTypes().getParentGroupID( ((ShipEquipmentEnum) t).getCode(), true ) );
//                break;
//            case T3_CRUISERS:
//                setItems(ManagerDB.getInstance().invTypes().getParentGroupID(((ShipEquipmentEnum) t).STRATEGIC_CRUISERS.getCode(), true  ) );
//                break;
//        }
    }
    
}
