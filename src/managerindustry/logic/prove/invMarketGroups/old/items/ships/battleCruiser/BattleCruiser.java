/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.old.items.ships.battleCruiser;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.old.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class BattleCruiser extends Category<Object>{
    private enum BattleCruiserEnum{
        STANDARD_BATTLECRUISERS(469),
        FACTION_BATTLECRUISERS(1703),
        ADVANCED_BATTLECRUISERS(822); 

        private BattleCruiserEnum(BattleCruiserEnum ammunition) {
            this.ammunition = ammunition;
        }

        private BattleCruiserEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private BattleCruiserEnum ammunition;

        public int getCode() {
            return code;
        }
        
    }

    public BattleCruiser(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public BattleCruiser() {
        xxx(BattleCruiserEnum.ADVANCED_BATTLECRUISERS, "");    
        display(getItems());
    }
    
    @Override
    public void initItems(Object t) {
        switch ((BattleCruiserEnum)t){
            case ADVANCED_BATTLECRUISERS:
            case FACTION_BATTLECRUISERS:
            case STANDARD_BATTLECRUISERS:
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID( ((BattleCruiserEnum) t).getCode(), true ) );
                break;                
        }
    }
    
}
