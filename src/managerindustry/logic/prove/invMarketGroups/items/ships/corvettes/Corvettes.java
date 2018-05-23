/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.ships.corvettes;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class Corvettes extends Category<Object>{
    private enum CorvettesEnum{
        CORVETTES(1815);

        private CorvettesEnum(CorvettesEnum corvettes) {
            this.corvettes = corvettes;
        }

        private CorvettesEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private CorvettesEnum corvettes;

        public int getCode() {
            return code;
        }
        
    }
    
    public Corvettes(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public Corvettes() {
        xxx(CorvettesEnum.CORVETTES , "");
        display(getItems());
    }
        
    @Override
    public void initItems(Object t) {
        switch ((CorvettesEnum)t){
            case CORVETTES:
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CorvettesEnum) t).getCode(), true ) );
                break;
        }
    }
    
}
