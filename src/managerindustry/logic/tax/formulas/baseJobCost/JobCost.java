/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.baseJobCost;

import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.managerCache.ManagerPrice;

/**
 *
 * @author lele
 */
public class JobCost {
    public static float getJobCost(int baseQuantity, String typeId) throws PriceNotExistsException {
        String adjustedPrice = ManagerPrice.getInstance().getAdjustedPriceEntity(typeId);
        return Float.valueOf(adjustedPrice)  * baseQuantity;
    }  
}    
// Integer.valueOf(adjusted_price);