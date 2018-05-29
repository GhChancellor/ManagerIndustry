/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.old.items.ships.shuttle;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.old.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class Shuttle extends Category<Object>{
    private enum ShuttleEnum{
        SHUTTLE(391);

        private ShuttleEnum(ShuttleEnum shuttle) {
            this.shuttle = shuttle;
        }

        private ShuttleEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private ShuttleEnum shuttle;

        public int getCode() {
            return code;
        }
        
    }

    public Shuttle(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public Shuttle() {
        xxx(ShuttleEnum.SHUTTLE, "");    
        display(getItems());
    }
    
    @Override
    public void initItems(Object t) {
        switch ((ShuttleEnum)t){                              
            case SHUTTLE:                
                setItems( ManagerDB.getInstance().invTypes().getMarketGroupID(((ShuttleEnum) t).getCode(), true ) );
                break;
        }
    }
    
}
