/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.drone;

import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.fatherclass.Category;

/**
 *
 * @author lele
 */
public class Drone extends Category<Object>{
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

    public Drone(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public Drone() {
        xxx(DroneEnum.ALL, "Ice Harvesting Drone I");
        display(getItems());
    }

    @Override
    public void initItems(Object t) {        
        switch ((DroneEnum) t){
            case ALL:
            case COMBAT:
            case ELECTRONIC_WARFARE:
            case LOGISTIC:              
                setItems( ManagerDB.getInstance().invTypes().getAllItems( ((DroneEnum) t).getCode()) );
                break;
            case FIGHTERS:      
            case MINING:      
            case COMBAT_UTILITY:    
            case SALVAGE:
                setItems( ManagerDB.getInstance().invTypes().getAllCategory(((DroneEnum) t).getCode()) );
                break;
        }
    }
    
}
