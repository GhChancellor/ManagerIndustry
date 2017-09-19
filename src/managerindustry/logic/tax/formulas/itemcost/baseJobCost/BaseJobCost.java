/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.baseJobCost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.buiild.SingleCalculatedComponentX;
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
     * @param singleCalculatedComponentXMap
     * @return float
     * @throws PriceNotExistsException 
     */
    public float getBaseJobCost(Map<String, SingleCalculatedComponentX>  singleCalculatedComponentXMap) throws PriceNotExistsException{
        Float sumJobcost = 0f;
        
        for (Map.Entry<String, SingleCalculatedComponentX> entry : singleCalculatedComponentXMap.entrySet()) {
//            String key = entry.getKey();
            SingleCalculatedComponentX singleCalculatedComponent = entry.getValue();
            InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(singleCalculatedComponent.getName());
            
            Float tempSumJobcost = JobCost.getJobCost(singleCalculatedComponent.getQuanityInt(), String.valueOf(invTypes.getTypeID()));
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

