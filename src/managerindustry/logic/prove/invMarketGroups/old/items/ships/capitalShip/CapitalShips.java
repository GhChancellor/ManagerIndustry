/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.old.items.ships.capitalShip;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.old.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class CapitalShips extends Category<Object>{
    private enum CapitalShipsEnum{
        ALL(0),
        DREADNOUGHTS(761),
        FREIGHTERS(766),
        TITANS(812),
        CARRIERS(817),
        CAPITAL_INDUSTRIAL_SHIPS(1047),
        JUMP_FREIGHTERS(1089),
        FORCE_AUXILIARIES(2271);

        private CapitalShipsEnum(CapitalShipsEnum capitalShips) {
            this.capitalShips = capitalShips;
        }

        private CapitalShipsEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private CapitalShipsEnum capitalShips;

        public int getCode() {
            return code;
        }
        
    }

    public CapitalShips(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public CapitalShips() {
        xxx(CapitalShipsEnum.ALL, "");    
        display(getItems());
    }
    
    @Override
    public void initItems(Object t) {
        switch ((CapitalShipsEnum)t){
            case ALL:
            case DREADNOUGHTS:
            case FREIGHTERS:
            case TITANS:
            case CARRIERS:
            case CAPITAL_INDUSTRIAL_SHIPS:
            case JUMP_FREIGHTERS:
            case FORCE_AUXILIARIES:
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CapitalShipsEnum) t).DREADNOUGHTS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CapitalShipsEnum) t).FREIGHTERS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CapitalShipsEnum) t).TITANS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CapitalShipsEnum) t).CARRIERS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CapitalShipsEnum) t).CAPITAL_INDUSTRIAL_SHIPS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CapitalShipsEnum) t).JUMP_FREIGHTERS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CapitalShipsEnum) t).FORCE_AUXILIARIES.getCode(), true ) );
                break;                
        }
    }
    
}
