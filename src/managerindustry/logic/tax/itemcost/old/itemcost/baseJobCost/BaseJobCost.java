/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.itemcost.old.itemcost.baseJobCost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.build.production.old.ReportCalculatedComponentX;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.manager.Manager;
//import managerindustry.logic.manager.old.db.ManagerDBEve_OLD;
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
     * @deprecated 
     * @param reportCalculatedComponentXMap
     * @return
     * @throws PriceNotExistsException 
     */
    public float getBaseJobCostDBG(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap) {
        Float sumJobcost = 0f;
        
        for (Map.Entry<String, ReportCalculatedComponentX> entry : reportCalculatedComponentXMap.entrySet()) {
//            String key = entry.getKey();
            ReportCalculatedComponentX totalCalculatedComponent = entry.getValue();
            InvTypes invTypes = 
             Manager.getInstance().db().item().invTypes().getInvTypesByName(totalCalculatedComponent.getTypeName());
            
            Float jobCost = 
             JobCost.getJobCostDBG(totalCalculatedComponent.getQuanityI(), String.valueOf(invTypes.getTypeID()));
            
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
    public float getBaseJobCost(Map<String, ReportCalculatedComponentX>  
            reportCalculatedComponentXMap) throws ErrorExeption{
        Float sumJobcost = 0f;
        
        for (Map.Entry<String, ReportCalculatedComponentX> entry :
                reportCalculatedComponentXMap.entrySet()) {
            
//            String key = entry.getKey();
            ReportCalculatedComponentX totalCalculatedComponent = entry.getValue();
            int typesId = 
                Manager.getInstance().db().item().invTypes().getInvTypesByName
                (totalCalculatedComponent.getTypeName()).getTypeID();
            
//            Float jobCost = 
//             JobCost.getJobCostDBG(totalCalculatedComponent.getQuanityInt(), String.valueOf(invTypes.getTypeID()));
            
            Float jobCost = 
             JobCost.getJobCost(totalCalculatedComponent.getQuanityI(), String.valueOf(typesId));
            
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


