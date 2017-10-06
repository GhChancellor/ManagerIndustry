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
import managerindustry.logic.buiild.ReportCalculatedComponentX;
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

    public float getBaseJobCostDBG(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap) throws PriceNotExistsException{
        Float sumJobcost = 0f;
        
        for (Map.Entry<String, ReportCalculatedComponentX> entry : reportCalculatedComponentXMap.entrySet()) {
//            String key = entry.getKey();
            ReportCalculatedComponentX totalCalculatedComponent = entry.getValue();
            InvTypes invTypes = 
             ManagerDBEve.getInstance().getInvTypes_IdByName(totalCalculatedComponent.getName());
            
            Float jobCost = 
             JobCost.getJobCostDBG(totalCalculatedComponent.getQuanityInt(), String.valueOf(invTypes.getTypeID()));
            
            sumJobcost += jobCost;            
            sumOfEachJobcosts.add(jobCost);
        }

        return sumJobcost;
    }
    
    /**
     * Get Base Job Cost
     * tot = tritanium 30 isk + pyerite 50 isk + mexallon 25 isk
     * @param reportCalculatedComponentXMap
     * @return float
     * @throws PriceNotExistsException 
     */
    public float getBaseJobCost(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap) throws PriceNotExistsException{
        Float sumJobcost = 0f;
        
        for (Map.Entry<String, ReportCalculatedComponentX> entry : reportCalculatedComponentXMap.entrySet()) {
//            String key = entry.getKey();
            ReportCalculatedComponentX totalCalculatedComponent = entry.getValue();
            InvTypes invTypes = 
             ManagerDBEve.getInstance().getInvTypes_IdByName(totalCalculatedComponent.getName());
            
            Float jobCost = 
             JobCost.getJobCostDBG(totalCalculatedComponent.getQuanityInt(), String.valueOf(invTypes.getTypeID()));
            
//            Float jobCost = 
//             JobCost.getJobCost(totalCalculatedComponent.getQuanityInt(), String.valueOf(invTypes.getTypeID()));
            
            sumJobcost += jobCost;            
            sumOfEachJobcosts.add(jobCost);
        }

        return sumJobcost;
    }
    
    /**
     * Get sum Each Job costs
     * Mette in lista tutti i materiali per sapere ogni singolo costo 
     * tritanium 30 isk 
     * pyerite 50 isk 
     * mexallon 25 isk 
     * @return List < Float >
     */
    public List < Float > getsumOfEachJobcosts(){
        return sumOfEachJobcosts;
    }

}


