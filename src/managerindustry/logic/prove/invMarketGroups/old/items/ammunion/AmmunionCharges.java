/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.old.items.ammunion;

import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.prove.invMarketGroups.old.items.fatherclass.Category;

/**
 *
 * @author lele
 */
public class AmmunionCharges extends Category<Object>{
    private enum AmmunitionEnum{
        ALL(11),
        PROJECTILE_AMMO(846),  // subclass 99 
        HYBRID_CHARGES(849), // subclass 100
        FREQUENCY_CRYSTALS(852), // subclass 101  
        MISSILES(114),
        PROBES(120),
        CAP_BOOSTER_CHARGES(139),
        MINING_CRYSTALS(593),
        BOMBS(1015),
        SCRIPTS(1094),
        NANITE_REPAIR_PASTE(1103),
        STRUCTURE_GUIDED_BOMBS(2198),
        COMMAND_BURST_CHARGES(2297);

        private AmmunitionEnum(AmmunitionEnum ammunition) {
            this.ammunition = ammunition;
        }

        private AmmunitionEnum(int code) {
            this.code = code;
        }
      
        private int code;
        private AmmunitionEnum ammunition;

        public int getCode() {
            return code;
        }
        
    }

    public AmmunionCharges(Object t, String typeName) {
        super(t, typeName);
        display(getItems());
    }

    public AmmunionCharges() {
        xxx(AmmunitionEnum.SCRIPTS, "");
        display(getItems());        
    }
    
    @Override
    public void initItems(Object t) {
        switch ((AmmunitionEnum)t){
            case ALL:
            case MISSILES: 
            case PROBES:      
            case COMMAND_BURST_CHARGES:
            case PROJECTILE_AMMO:
            case HYBRID_CHARGES:                                    
            case FREQUENCY_CRYSTALS:  
                setItems( ManagerDB.getInstance().invTypes().getParentGroupID( ((AmmunitionEnum) t).getCode(), true ) );
                break;
            case BOMBS:                
            case NANITE_REPAIR_PASTE:                  
            case MINING_CRYSTALS:          
            case STRUCTURE_GUIDED_BOMBS: 
            case CAP_BOOSTER_CHARGES:   
            case SCRIPTS:
                setItems( ManagerDB.getInstance().invTypes().getMarketGroupID( ((AmmunitionEnum) t).getCode(), true ) );
                break;                
        }
    }    
}
