/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.baseJobCost;

import java.util.HashMap;
import java.util.Map;

/**
 *  
 * basecost = ( BaseQuantity * adjusted_price ) + ( prezzo oggetto 2 * adjusted_price )
 * @author lele
 */
public class BaseJobCost {
    private Map < String, JobCost > jobCostMap = new HashMap<>();
    
    public Map<String, JobCost> getJobCostMap() {
        return jobCostMap;
    }
    
    public void setJobCostMap(Map<String, JobCost> jobCostMap) {
        this.jobCostMap = jobCostMap;
    }
    
}
