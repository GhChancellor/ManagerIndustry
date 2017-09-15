/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.baseJobCost;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *  
 * basecost = ( BaseQuantity * adjusted_price ) + ( prezzo oggetto 2 * adjusted_price )
 * @author lele
 */
public class BaseJobCost {
    private List < Float > sumOfEachJobcosts = new ArrayList<>();
    
    public BaseJobCost() {
    
    }
        
    /**
     * Get Base Job Cost
     * @param totalCalculatedComponentXMap
     * @return float
     * @throws PriceNotExistsException 
     */
    public float getBaseJobCost(Map<String, TotalCalculatedComponentX> totalCalculatedComponentXMap) throws PriceNotExistsException{
        Float sumJobcost = 0f;
        
        for (Map.Entry<String, TotalCalculatedComponentX> entry : totalCalculatedComponentXMap.entrySet()) {
//            String key = entry.getKey();
            TotalCalculatedComponentX value = entry.getValue();
            InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(value.getName());
            
            Float tempSumJobcost = JobCost.getJobCost(value.getQuanity(), String.valueOf(invTypes.getTypeID()));
            sumJobcost += tempSumJobcost; 
            
            sumOfEachJobcosts.add(tempSumJobcost);
        }

        return sumJobcost;
    }

    /**
     * Get sum Of Each Job costs
     * @return List < Float >
     */
    public List < Float > getsumOfEachJobcosts(){
        float x = 0f;
        for (Float sumOfEachJobcost : sumOfEachJobcosts) {
            x += sumOfEachJobcost;
            
        }
        System.out.printf("sumOfEachJobcost %f ", x);
        return sumOfEachJobcosts;
    }
    
//    /**
//     * Add Sum Of Each Job cost
//     * @param float sumJobcost 
//     */
//    private void addSumOfEachJobcost(float sumJobcost){
//        sumOfEachJobcosts.add(sumJobcost);
//    }
}


