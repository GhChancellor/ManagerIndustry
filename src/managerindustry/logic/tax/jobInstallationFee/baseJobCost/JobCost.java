/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.baseJobCost;

import java.math.BigDecimal;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.managerCache.ManagerPrice;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *
 * @author lele
 */
public class JobCost {
    private int baseQuantity;
    private float adjusted_price;

    public JobCost() {
       
    }

    public JobCost(int baseQuantity, String typeId) throws PriceNotExistsException {
        ManagerPrice managerPrice = new ManagerPrice();
        String adjustedPrice = ManagerPrice.getInstance().getAdjustedPriceEntity(typeId);
        this.baseQuantity = baseQuantity;
        this.adjusted_price = Float.valueOf(adjustedPrice);   
    }

    /**
     * Get Job Cost adjusted_price * baseQuantity
     * @return float
     */
    public float getJobCost(){
        return this.adjusted_price * baseQuantity;
    }
    
}
// Integer.valueOf(adjusted_price);