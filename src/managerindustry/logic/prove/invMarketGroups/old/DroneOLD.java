/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.old;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.old.ItemClass;

/**
 *
 * @author lele
 */
public class DroneOLD {
    private enum DroneEnum{
        ALL(157),        
        MINING(158),
        ELECTRONIC_WARFARE(841),
        LOGISTIC(842),
        COMBAT_UTILITY(843), 
        SALVAGE(1646),        
        COMBAT(159), // si sotto classe 
        FIGHTERS(1310); // sotto classe
        
        private int code;
        private DroneEnum drone;

        private DroneEnum(DroneEnum drone) {
            this.drone = drone;
        }

        private DroneEnum(int code) {
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }
        
    }
    private List<InvTypes> allDrone = new ArrayList<>();

    /**
     * Medium Shield Maintenance Bot I
     * Ice Harvesting Drone I minining
     */
    public DroneOLD() {
        initCategory(DroneEnum.COMBAT);
        InvTypes invTypes = ManagerDB.getInstance().invTypes().getIdByName("Ice Harvesting Drone I");        
        
        for (InvTypes allDrones : allDrone) {
            if ( allDrones.getMarketGroupID() == invTypes.getMarketGroupID() ){
                System.out.println("Si");
            }else{
                System.out.println("NO");
            }
        }
        
        display(allDrone);
        // System.out.println(""+ invTypes.getTypeID());
    }
    
    /**
     * Fighters > Carrier-based Fighters > heavy fighter or light fighter or support fighter
     * @param drone 
     */
    private void initCategory(DroneEnum drone){
        switch (drone){
            case ALL:
            case COMBAT:
            case ELECTRONIC_WARFARE:
            case LOGISTIC:              
                allDrone = ManagerDB.getInstance().invTypes().getParentGroupID(drone.getCode(), true );
                break;
            case FIGHTERS:      
            case MINING:      
            case COMBAT_UTILITY:    
            case SALVAGE:                
                allDrone = ManagerDB.getInstance().invTypes().getMarketGroupID(drone.getCode(), true );
                break;
        }
//        display(allDrone); 
 
    }
    
    private void display(List<InvTypes> items){
        for (InvTypes item : items) {
            System.out.println(""+item.getTypeID()+ " " + item.getTypeName() );
        }
    }
    
    /*
    Fighters > Carrier-based Fighters > heavy fighter or light fighter or support fighter
    
    Structure-based Fighters marketGroupID 2409, ParentGroupID 2236
      Standup heavy fighters Standup Ametat I 47124, marketGroupID 2412
      Standup light fighters Standup Dragonfly I
      Standup support fighters Standup Cenobite I 
    
    Carrier-based Fighters marketGroupID 2410, ParentGroupID 2236  
      heavy fighter Ametat I ID=40362, MarketGroupID=1310
      light fighter Dragonfly I ID= 23057, MarketGroupID=840
      support fighter Cenobite I ID=37599, MarketGroupID=2239
    */
    
}
