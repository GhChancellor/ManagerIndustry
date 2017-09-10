/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.baseJobCost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *  
 * basecost = ( BaseQuantity * adjusted_price ) + ( prezzo oggetto 2 * adjusted_price )
 * @author lele
 */
public class BaseJobCost {

    public BaseJobCost() {
    
    }
        
    /**
     * Get Base Job Cost
     * @param totalCalculatedComponentXMap
     * @return float
     * @throws PriceNotExistsException 
     */
    public float getBaseJobCost(Map<String, TotalCalculatedComponentX> totalCalculatedComponentXMap) throws PriceNotExistsException{
        float sumJobcost = 0f;
        
        for (Map.Entry<String, TotalCalculatedComponentX> entry : totalCalculatedComponentXMap.entrySet()) {
//            String key = entry.getKey();
            TotalCalculatedComponentX value = entry.getValue();
            InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(value.getName());

            sumJobcost += JobCost.getJobCost(value.getQuanity(), String.valueOf(invTypes.getTypeID()));
        }
        return sumJobcost;
    }

}
