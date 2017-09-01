/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.baseJobCost;

import java.math.BigDecimal;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *
 * @author lele
 */
public class JobCost {

    private String nameItem;
    private int baseQuantity;
    private Integer adjusted_price;

    public JobCost() {
    }

    public JobCost(String nameObject, int baseQuantity, Integer adjusted_price) {
        this.nameItem = nameObject;
        this.baseQuantity = baseQuantity;
        this.adjusted_price = adjusted_price; 
    }

    /**
     * Get Name Item
     * @return String
     */
    public String getNameItem() {
        return nameItem;
    }

    /**
     * Set Name Item
     * @param String nameItem 
     */
    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    /**
     * Get Base Quantity
     * @return Integer
     */
    public int getBaseQuantity() {
        return baseQuantity;
    }

    /**
     * Set Base Quantity
     * @param Integer baseQuantity 
     */
    public void setBaseQuantity(int baseQuantity) {
        this.baseQuantity = baseQuantity;
    }

    /**
     * Get Adjusted price
     * @return Integer
     */
    public Integer getAdjusted_price() {
        return adjusted_price;
    }

    /**
     * Set Adjusted price
     * @param Integer adjusted_price 
     */
    public void setAdjusted_price(Integer adjusted_price) {
        this.adjusted_price = adjusted_price;
    }

    
}
// Integer.valueOf(adjusted_price);