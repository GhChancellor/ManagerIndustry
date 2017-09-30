/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.baseJobCost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.managerCache.ManagerPrice;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *
 * @author lele
 */
public class BaseJobCostX1 {
    private List < SingleJobCost > singleJobCosts = new ArrayList<>();

    public float getBaseJobCost(Map<String, ReportCalculatedComponentX> totalCalculatedComponentXMap) throws PriceNotExistsException{
        float totSumJobcost = 0f;

    for (Map.Entry<String, ReportCalculatedComponentX> entry : totalCalculatedComponentXMap.entrySet()) {
//            String key = entry.getKey();
        ReportCalculatedComponentX value = entry.getValue();
        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(value.getName());

        float singleJobCost = getSingleJobCost( String.valueOf(value.getId()) , value.getQuanityInt());
        
        SingleJobCost singleJobCostX1 = new SingleJobCost(value.getName(), singleJobCost );

        totSumJobcost += singleJobCostX1.getSingleJobCost();

        singleJobCosts.add(singleJobCostX1);
    }
        return totSumJobcost;
    }
      
    public BaseJobCostX1() {
    }
    
    private float getSingleJobCost(String typeId, int baseQuantity) throws PriceNotExistsException {
        String adjustedPrice = ManagerPrice.getInstance().getAdjustedPriceEntity(typeId);
        return Float.valueOf(adjustedPrice) * baseQuantity;
    }  

    public List<SingleJobCost> getSingleJobCosts() {
        return singleJobCosts;
    } 
    
}
