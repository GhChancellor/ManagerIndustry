/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.baseJobCost;

import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.Manager;

/**
 * Get Job Cost
 * JobCost = adjustedPrice * baseQuantity
 * DBG int baseQuantity = potrebbe essere troppo piccolo valutare di sostituirlo con float
 * @author lele
 */
public class JobCost {
    public static float getJobCost(int baseQuantity, String typeId) throws ErrorExeption {
        String adjustedPrice = Manager.getInstance().db().item().price().getAdjustedPriceEntity(typeId);
        return Float.valueOf(adjustedPrice) * baseQuantity;
    }  

    /**
     * @deprecated 
     * DGB da controllare con attenzione nella originale uso " getAdjustedPriceEntity(typeId); "
     * mentre qui  " getPriceEntity(typeId) "
     * @param baseQuantity
     * @param typeId
     * @return
     * @throws PriceNotExistsException 
     */
    public static float getJobCostDBG(int baseQuantity, String typeId) {
        Exception e = new Exception();
        e.printStackTrace();
        return 0.0F;
//        PriceEntity priceEntity = Db.getInstance().taxSolarSystem().getPriceEntity(typeId);
//        String adjustedPrice = priceEntity.getAdjusted_price();
//        
//        return Float.valueOf(adjustedPrice) * baseQuantity;
    }  
}    
