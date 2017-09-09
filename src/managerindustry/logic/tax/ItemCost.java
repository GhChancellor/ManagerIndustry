/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax;

import java.util.Map;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.baseJobCost.BaseJobCost;
import managerindustry.logic.tax.formulas.systemCostIndex.SystemCostIndex;



/**
 *
 * @author lele
 */
public class ItemCost {    
    private float percent = 0.02f; // 2%
    
    public float jobInstallationCost(
            Map<String, TotalCalculatedComponentX> totalCalculatedComponentXMap, 
            String solarSystemID, 
            String actvity) throws SolarSystemNotExistsException, PriceNotExistsException{
    // Il runs viene GIÀ calcolato in ManagerBuild > buildItem
    // int firstStep = MaterialCalc.calculateMaterialEfficiency(job, run, componentX.getQuanity(), meBPO);
        int run = 1;
        float jobFee = 0f;
        
        float systemCostIndex = SystemCostIndex.SystemCostIndex(solarSystemID, actvity);
        float baseJobCost = new BaseJobCost().getBaseJobCost(totalCalculatedComponentXMap);
        jobFee = baseJobCost * systemCostIndex * run;
        
        return jobFee;
    }
    
    /**
     * Get Facility Tax
     * The taxRate is 10 for NPC Stations and can be set for each facility 
     * individually for corporation owned
     * @param jobFee
     * @param taxRate
     * @return float
     */
    public float getFacilityTax(float jobFee, float taxRate){
        // The taxRate is 10 for NPC Stations and can be set for each facility individually for corporation owned
        return jobFee * taxRate / 100;
    }
    
    public float getTotalInstallationCost(float jobFee, float facilityTax){
        return jobFee + facilityTax;
    }
    
    public float getCopyingFees(){
        return 0F;
    }
}
