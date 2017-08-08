/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.baseJobCost;

import java.math.BigDecimal;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.ManagerDB;

/**
 *
 * @author lele
 */
public class BaseJobCost {
    private BigDecimal basePriceCost;

    public BaseJobCost(int typeId) {
        InvTypes invTypes = ManagerDB.getInstance().getInvTypes_NameById(typeId);
        basePriceCost = invTypes.getBasePrice();
    }

    public BigDecimal getBasePriceCost() {
        return basePriceCost;
    }
    
}
