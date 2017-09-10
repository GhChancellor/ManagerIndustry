/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.itemcost.baseJobCost.BaseJobCost;
import managerindustry.logic.tax.formulas.itemcost.systemCostIndex.SystemCostIndex;



/**
 *
 * @author lele
 */
public class ItemCost {    
    private float percent = 0.02f; // 2%
    private float systemCostIndex = 0f;
    private float baseJobCost = 0f;
    private float jobFee = 0f;
                
    public ItemCost(Map<String, TotalCalculatedComponentX> totalCalculatedComponentXMap, 
            String solarSystemID, 
            String actvity) throws SolarSystemNotExistsException, PriceNotExistsException {
        
        this.systemCostIndex = SystemCostIndex.SystemCostIndex(solarSystemID, actvity);
        this.baseJobCost = new BaseJobCost().getBaseJobCost(totalCalculatedComponentXMap);
    }
    
    /**
     * Get job Installation Cost
     * @return float
     */
    public float getJobInstallationCost(){
    // Il runs viene GIÀ calcolato in ManagerBuild > buildItem
    // int firstStep = MaterialCalc.calculateMaterialEfficiency(job, run, componentX.getQuanity(), meBPO);
        int run = 1;
        jobFee = baseJobCost * systemCostIndex * run;
        return jobFee;
    }
    
    /**
     * Get Facility Tax 
     * jobFee * taxRate / 100;
     * The taxRate is 10 for NPC Stations and can be set for each facility 
     * individually for corporation owned
     * @param jobFee
     * @param taxRate
     * @return float
     */
    public float getFacilityTax(float taxRate){
        return jobFee * taxRate / 100;
    }
    
    /**
     * Get Total Installation Cost
     * jobFee + facilityTax;
     * @param jobFee
     * @param facilityTax
     * @return float
     */
    public float getTotalInstallationCost(float facilityTax){
        return jobFee + facilityTax;
    }
    
    /**
     * Get Copying Fees
     * jobFee = baseJobCost * systemCostIndex * percent * run * runsPerCopy;
     * @param runsPerCopy
     * @return float 
     */
    public float getCopyingFees(int run, int runsPerCopy){
        return jobFee = baseJobCost * systemCostIndex * percent * run * runsPerCopy;
    }
    
    /**
     * Get Invention Fees
     * jobFee = baseJobCost ∗ systemCostIndex ∗ 0.02 ∗ runs
     * @param runs
     * @return float
     */
    public float getInventionFees(int runs){
        jobFee = baseJobCost * systemCostIndex * percent * runs;
        return jobFee;
    }
    
    /**
     * Get Research Costs
     * @param levelModfier
     * @return int float
     */
    public float getResearchCosts(int levelModfier){
        List< Integer > levels = new ArrayList<>();
        levels.add(0); levels.add(105); levels.add(250); levels.add(595);
        levels.add(1414); levels.add(3360); levels.add(8000); levels.add(19000);
        levels.add(45255); levels.add(107700); levels.add(256000);
        
        if (levels.size() <= levelModfier){
            jobFee = baseJobCost * systemCostIndex * percent * levels.get(levelModfier);
            return jobFee;              
        }
        return 0f;
    }
}
