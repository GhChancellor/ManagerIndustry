/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.items.cruisers;

import managerindustry.logic.prove.invMarketGroups.items.frigate.*;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class Cruisers extends Category<Object>{
    private enum CruisersEnum{
        ADVANCED_CRUISERS(1368),
            LOGISTICS(437),
            HEAVY_ASSAULT_CRUISERS(448),
            RECON_SHIPS(824),
            HEAVY_INTERDICTION_CRUISERS(1070),
            STRATEGIC_CRUISERS(1138),
            FLAG_CRUISERS(2416), // ???
        STANDARD_CRUISERS(6),
        FACTION_CRUISERS(1369);

        private CruisersEnum(CruisersEnum cruisers) {
            this.cruisers = cruisers;
        }

        private CruisersEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private CruisersEnum cruisers;

        public int getCode() {
            return code;
        }
        
    }
    
    public Cruisers(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public Cruisers() {
        xxx(CruisersEnum.ADVANCED_CRUISERS , "");
        display(getItems());
    }
        
    @Override
    public void initItems(Object t) {
        switch ((CruisersEnum)t){
            case STANDARD_CRUISERS:
                setItems(ManagerDB.getInstance().invTypes().getParentGroupID(((CruisersEnum) t).getCode(), true ));
                break;
            case ADVANCED_CRUISERS:
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CruisersEnum) t).LOGISTICS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CruisersEnum) t).HEAVY_ASSAULT_CRUISERS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CruisersEnum) t).RECON_SHIPS.getCode(), true  ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CruisersEnum) t).HEAVY_INTERDICTION_CRUISERS.getCode(), true ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID(((CruisersEnum) t).STRATEGIC_CRUISERS.getCode(), true  ) );
                addAllItems(ManagerDB.getInstance().invTypes().getParentGroupID( ((CruisersEnum) t).FLAG_CRUISERS.getCode(), true  ) );
                break;
            case FACTION_CRUISERS:
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID( ((CruisersEnum) t).getCode(), true ) );
                break;
        }
    }
    
}
