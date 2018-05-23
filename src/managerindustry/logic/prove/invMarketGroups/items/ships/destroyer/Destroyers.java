/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.ships.destroyer;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class Destroyers extends Category<Object>{
    private enum DestroyersEnum{
        STANDARD_DESTROYERS(464),
        ADVANCED_DESTROYERS(1373),
            COMMAND_DESTROYERS(2125),
            TACTICAL_DESTROYERS(1951),
            INTERDICTORS_DESTROYERS(823);

        private DestroyersEnum(DestroyersEnum destroyer) {
            this.destroyer = destroyer;
        }

        private DestroyersEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private DestroyersEnum destroyer;

        public int getCode() {
            return code;
        }
        
    }

    public Destroyers(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public Destroyers() {
        xxx(DestroyersEnum.ADVANCED_DESTROYERS, "");    
        display(getItems());
    }
    
    @Override
    public void initItems(Object t) {
        switch ((DestroyersEnum)t){
            case ADVANCED_DESTROYERS:
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID(((DestroyersEnum) t).INTERDICTORS_DESTROYERS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID(((DestroyersEnum) t).COMMAND_DESTROYERS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID(((DestroyersEnum) t).TACTICAL_DESTROYERS.getCode(), true ) );
                break;                                
            case STANDARD_DESTROYERS:
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID(((DestroyersEnum) t).getCode(), true ) );
                break;                
        }
    }
    
}
