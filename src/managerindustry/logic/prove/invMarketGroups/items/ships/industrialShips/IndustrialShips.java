/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.ships.industrialShips;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class IndustrialShips extends Category<Object>{
    private enum IndustrialShipsEnum{
        STANDARD_INDUSTRIAL_SHIPS(8),
        INDUSTRIAL_COMMAND_SHIPS(2335),
        ADVANCED_INDUSTRIAL_SHIPS(1373),
            TRANSPORT_SHIPS(629);

        private IndustrialShipsEnum(IndustrialShipsEnum industrialShips) {
            this.industrialShips = industrialShips;
        }

        private IndustrialShipsEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private IndustrialShipsEnum industrialShips;

        public int getCode() {
            return code;
        }
        
    }

    public IndustrialShips(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public IndustrialShips() {
        xxx(IndustrialShipsEnum.ADVANCED_INDUSTRIAL_SHIPS, "");    
        display(getItems());
    }
    
    @Override
    public void initItems(Object t) {
        switch ((IndustrialShipsEnum)t){
            case ADVANCED_INDUSTRIAL_SHIPS:
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID(((IndustrialShipsEnum) t).TRANSPORT_SHIPS.getCode(), true ) );
                break;                                
            case STANDARD_INDUSTRIAL_SHIPS:
            case INDUSTRIAL_COMMAND_SHIPS:                
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID(((IndustrialShipsEnum) t).getCode(), true ) );
                break;
        }
    }
    
}
