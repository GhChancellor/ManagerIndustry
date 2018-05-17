/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.frigate;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class Frigate extends Category<Object>{
    private enum FrigateEnum{
        STANDARD_FRIGATES(5),
        FACTION_FRIGATES(1362),
        ADVANCED_FRIGATES(1364); 

        private FrigateEnum(FrigateEnum ammunition) {
            this.ammunition = ammunition;
        }

        private FrigateEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private FrigateEnum ammunition;

        public int getCode() {
            return code;
        }
        
    }
    
    public Frigate(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public Frigate() {
        xxx(FrigateEnum.ADVANCED_FRIGATES , "");
        display(getItems());
    }
        
    @Override
    public void initItems(Object t) {
        switch ((FrigateEnum)t){
            case STANDARD_FRIGATES:
            case ADVANCED_FRIGATES:
            case FACTION_FRIGATES:
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID( ((FrigateEnum) t).getCode()) );
                break;
        }
    }
    
}
