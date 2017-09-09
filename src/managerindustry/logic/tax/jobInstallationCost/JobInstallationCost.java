/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationCost;

import java.math.BigDecimal;
import java.util.Map;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.manager.managerCache.ManagerPrice;
import managerindustry.logic.manager.managerCache.ManagerSystemCostIndex;
import managerindustry.logic.tax.formulas.baseJobCost.BaseJobCost;
import managerindustry.logic.tax.formulas.baseJobCost.JobCost;
import managerindustry.logic.tax.formulas.json.systemCostIndices.SolarSystemCost;
import managerindustry.logic.tax.formulas.json.systemCostIndices.SystemCostFetch;

/**
 * jobFee = baseJobCost ∗ systemCostIndex ∗ runs
 * @author lele
 */
public class JobInstallationCost {
    private float jobFee ;
    
    public JobInstallationCost( String solarSystemID, String actvity, Map<String,TotalCalculatedComponentX> totalCalculatedComponentXMap ) {
    // Il runs viene GIÀ calcolato in ManagerBuild > buildItem
    // int firstStep = MaterialCalc.calculateMaterialEfficiency(job, run, componentX.getQuanity(), meBPO);
        int runs = 1; 
        
        try {
            // get value from DB
            float systemCostIndex = ManagerSystemCostIndex.getInstance().getCostIndexEntity(solarSystemID, actvity);
            BaseJobCost baseJobCost = new BaseJobCost();
            
            float baseJobCostFlt = baseJobCost.getBaseJobCost(totalCalculatedComponentXMap);

            this.jobFee = baseJobCostFlt * systemCostIndex * runs;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public float getJobInstallationFee(){
        return this.jobFee;
    }
}

/*
JobCost
 recupero id (string)
 0
systemCostIndex
*/