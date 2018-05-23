/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.ships;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class MiningBarges extends Category<Object>{
    private enum MiningBargesEnum{
        EXHUMERS(494),
        MINING_BARGES(874);

        private MiningBargesEnum(MiningBargesEnum miningBarges) {
            this.miningBarges = miningBarges;
        }

        private MiningBargesEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private MiningBargesEnum miningBarges;

        public int getCode() {
            return code;
        }
        
    }

    public MiningBarges(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public MiningBarges() {
        xxx(MiningBargesEnum.MINING_BARGES, "");    
        display(getItems());
    }
    
    @Override
    public void initItems(Object t) {
        switch ((MiningBargesEnum)t){                              
            case EXHUMERS:
            case MINING_BARGES:                
                setItems( ManagerDB.getInstance().invTypes().getMarketGroupID(((MiningBargesEnum) t).getCode(), true ) );
                break;
        }
    }
    
}
