/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.battleships;

import managerindustry.logic.prove.invMarketGroups.items.battleCruiser.*;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class Battleships extends Category<Object>{

    private enum BattleshipsEnum{
        STANDARD_BATTLESHIPS(7),
        FACTION_BATTLESHIPS(1378),

        ADVANCED_BATTLESHIPS(1377),
            BLACK_OPS(1075),
            MARAUDERS(1080);
            
        private BattleshipsEnum(BattleshipsEnum battleships) {
            this.battleships = battleships;
        }

        private BattleshipsEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private BattleshipsEnum battleships;

        public int getCode() {
            return code;
        }
        
    }

    public Battleships(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public Battleships() {
        xxx(BattleshipsEnum.FACTION_BATTLESHIPS, "");    
        display(getItems());
    }
    
    @Override
    public void initItems(Object t) {
        switch ((BattleshipsEnum)t){
            case ADVANCED_BATTLESHIPS:
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((BattleshipsEnum) t).BLACK_OPS.getCode(), true ));
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((BattleshipsEnum) t).MARAUDERS.getCode(), true ));
                break;
            case FACTION_BATTLESHIPS:
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID( ((BattleshipsEnum) t).getCode(), true ) );                
                break;                
            case STANDARD_BATTLESHIPS:
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID( ((BattleshipsEnum) t).getCode(), true ) );
                break;                
        }
    }

}
