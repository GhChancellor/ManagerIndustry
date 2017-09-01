/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.baseJobCost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.logic.buiild.TotalCalculatedComponentX;

/**
 *  
 * basecost = ( BaseQuantity * adjusted_price ) + ( prezzo oggetto 2 * adjusted_price )
 * @author lele
 */
public class BaseJobCost {

    private List < JobCostTotalItem > jobCostTotalItems = new ArrayList<>();
    
    private JobCost jobCost = new JobCost();
    
    public int getJobCost(Map<String, TotalCalculatedComponentX> totalCalculatedComponentXMap, Integer adjusted_price){
        
        for (Map.Entry<String, TotalCalculatedComponentX> entry : totalCalculatedComponentXMap.entrySet()) {
            String key = entry.getKey();
            TotalCalculatedComponentX value = entry.getValue();
            
        }
        
//        jobCost.setAdjusted_price(adjusted_price);
//        jobCost.setBaseQuantity(totalCalculatedComponentXMap.);
//        jobCost.setNameItem(nameObject);
        

        return  sumJobCost();
    }
    
    public int sumJobCost(){
        return 0;
    }
}
