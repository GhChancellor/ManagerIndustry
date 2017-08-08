/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee;

import java.math.BigDecimal;
import managerindustry.logic.tax.jobInstallationFee.baseJobCost.BaseJobCost;

/**
 * jobFee = baseJobCost ∗ systemCostIndex ∗ runs
 * @author lele
 */
public class JobInstallationFee {
    private float jobFee ;
    
    public JobInstallationFee( int typeId, int runs ) {
        try {
            BaseJobCost basePrice = new BaseJobCost(typeId);

            float baseJobCost = basePrice.getBasePriceCost().floatValue();
            float systemCostIndex = 1;

            this.jobFee = baseJobCost * systemCostIndex * runs;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}

/*
BaseJobCost
 recupero id (string)
 
systemCostIndex
*/