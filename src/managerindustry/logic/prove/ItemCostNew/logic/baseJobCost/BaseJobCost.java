/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ItemCostNew.logic.baseJobCost;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.nameBase.NameBase;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.ItemCostNew.logic.ItemCost.ItemCostBase;

/**
 *
 * @author lele
 */
public class BaseJobCost {
    private List < Float > sumOfEachJobcosts = new ArrayList<>();
    
    public BaseJobCost() {
    }
    
    /**
     * Get Base Job Cost
     * @param ItemCostBase itemCostBase
     * @return float
     * @throws ErrorExeption 
     */
    public float getBaseJobCost(ItemCostBase itemCostBase) throws ErrorExeption{
        float sumJobcost = 0f;
        float jobCost = 0f;
        
        List<NameBase> nameBases = itemCostBase.getNameBases();
        
        for (NameBase nameBase : nameBases) {
            jobCost = getJobCost(nameBase);
                
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
    
    /**
     * Get Job Cost JobCost = adjustedPrice * baseQuantity
     * @param NameBase nameBase
     * @return float
     * @throws ErrorExeption 
     */
    private float getJobCost(NameBase nameBase) throws ErrorExeption{    
        String adjustedPrice = Manager.getInstance().db().item().price().
            getAdjustedPriceEntity( String.valueOf( nameBase.getTypeId() ) );
        return Float.valueOf(adjustedPrice) * nameBase.getQuanityI();        
    }
}
