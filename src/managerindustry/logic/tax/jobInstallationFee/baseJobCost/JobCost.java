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

    private String nameObject;
    private int baseQuantity;
    private Integer adjusted_price;

    public JobCost(String nameObject, int baseQuantity, Integer adjusted_price) {
        this.nameObject = nameObject;
        this.baseQuantity = baseQuantity;
        this.adjusted_price = adjusted_price; 
    }

}
// Integer.valueOf(adjusted_price);