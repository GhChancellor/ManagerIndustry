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
        ADVANCED_FRIGATES(1364),
            INTERCEPTORS(399),
            COVERT_OPS(420),
            ASSAULT_FRIGATES(432),
            ELECTRONIC_ATTACK_FRIGATES(1065),
            EXPEDITION_FRIGATES(1924),
            LOGISTICS_FRIGATES(2146);


        private FrigateEnum(FrigateEnum frigateEnum) {
            this.frigateEnum = frigateEnum;
        }

        private FrigateEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private FrigateEnum frigateEnum;

        public int getCode() {
            return code;
        }
        
    }
    
    public Frigate(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public Frigate() {
        xxx(FrigateEnum.STANDARD_FRIGATES , "");
        display(getItems());
    }
        
    @Override
    public void initItems(Object t) {
        switch ((FrigateEnum)t){
            case STANDARD_FRIGATES:
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((FrigateEnum) t).getCode(), true ) );
                break;
            case ADVANCED_FRIGATES:
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((FrigateEnum) t).INTERCEPTORS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((FrigateEnum) t).COVERT_OPS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((FrigateEnum) t).ASSAULT_FRIGATES.getCode(), true  ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((FrigateEnum) t).ELECTRONIC_ATTACK_FRIGATES.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getMarketGroupID( ((FrigateEnum) t).EXPEDITION_FRIGATES.getCode(), true  ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((FrigateEnum) t).LOGISTICS_FRIGATES.getCode(), true  ) );
                break;
            case FACTION_FRIGATES:
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID( ((FrigateEnum) t).getCode(), true ) );
                break;
        }
    }
    
}
