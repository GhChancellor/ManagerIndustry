/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.baseJobCost;

import managerindustry.db.entities.cache.PriceEntity;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.managerCache.ManagerPrice;
import managerindustry.logic.manager.managerDB.ManagerDBCache;

/**
 * Get Job Cost
 * JobCost = adjustedPrice * baseQuantity
 * DBG int baseQuantity = potrebbe essere troppo piccolo valutare di sostituirlo con float
 * @author lele
 */
public class JobCost {
    public static float getJobCost(int baseQuantity, String typeId) throws PriceNotExistsException {
        String adjustedPrice = ManagerPrice.getInstance().getAdjustedPriceEntity(typeId);
        return Float.valueOf(adjustedPrice) * baseQuantity;
    }  

    public static float getJobCostDBG(int baseQuantity, String typeId) throws PriceNotExistsException {
        PriceEntity priceEntity = ManagerDBCache.getInstance().getPriceEntity(typeId); 
        String adjustedPrice = priceEntity.getAdjusted_price();
        
        return Float.valueOf(adjustedPrice) * baseQuantity;
    }  
}    
