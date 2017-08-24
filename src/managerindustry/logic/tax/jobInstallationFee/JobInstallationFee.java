/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee;

import java.math.BigDecimal;
import java.util.Map;
import managerindustry.logic.tax.jobInstallationFee.baseJobCost.JobCost;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SystemCostIndex;

/**
 * jobFee = baseJobCost ∗ systemCostIndex ∗ runs
 * @author lele
 */
public class JobInstallationFee {
    private float jobFee ;
    
    public JobInstallationFee( int typeId, int runs ) {
        try {
            SystemCostIndex systemCostIndex = new SystemCostIndex();
            Map<String, SolarSystem > solarSystemMap = systemCostIndex.getSystemCostIndexs();
            
            
//            JobCost basePrice = new JobCost(typeId);
//
//            float baseJobCost = basePrice.getBasePriceCost().floatValue();
//            float systemCostIndex = 1;
//
//            this.jobFee = baseJobCost * systemCostIndex * runs;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
}

/*
JobCost
 recupero id (string)
 
systemCostIndex
*/