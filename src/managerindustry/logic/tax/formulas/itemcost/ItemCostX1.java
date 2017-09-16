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
import managerindustry.logic.tax.formulas.itemcost.baseJobCost.BaseJobCostX1;
import managerindustry.logic.tax.formulas.itemcost.baseJobCost.SingleJobCost;
import managerindustry.logic.tax.formulas.itemcost.systemCostIndex.SystemCostIndex;

/**
 *
 * @author lele
 */
public class ItemCostX1 {
    private float percent = 0.02f; // 2%
    private float systemCostIndex = 0f;
    private float baseJobCost = 0f;
    
    private float jobFee = 0f;
    private float facilityTax = 0f;
    private float totalInstallationCost = 0f;
    
    private float taxRate = 0f;
    private int runs = 0;
    private int levelOrRuns = 0;
    
    private  List<SingleJobCost> singleJobCosts = new ArrayList<>();
    
    /**
     * Init item cost ( tax facility, jobfee, sysemCost ... ) 
     * @param -----> totalCalculatedComponentXMap <-------
     * @param String solarSystemID
     * @param String actvity
     * @param int runs
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */
    public ItemCostX1(Map<String, TotalCalculatedComponentX> totalCalculatedComponentXMap, 
     String solarSystemID, String actvity, int runs, int levelOrRuns, float taxRate 
     ) throws SolarSystemNotExistsException, PriceNotExistsException {
        
        this.taxRate = taxRate;
        this.runs = runs;
        this.levelOrRuns = levelOrRuns;
        
//        float xxx = 0.0099453514521152f;
//        this.systemCostIndex = xxx;
        this.systemCostIndex = SystemCostIndex.SystemCostIndex(solarSystemID, actvity);
        
        BaseJobCostX1 jobCost = new BaseJobCostX1();
        baseJobCost = jobCost.getBaseJobCost(totalCalculatedComponentXMap);
        singleJobCosts = jobCost.getSingleJobCosts();
    }
    
    /**
     * Calculate JobInstallation Cost
     * jobFee = baseJobCost * systemCostIndex * runs
     */
    private void calculateJobInstallationCost(){
        jobFee = baseJobCost * systemCostIndex * runs;
        calculateFacilityTax();
        calculateTotalInstallationCost();
    }
    
    /**
     * Calculate Total Installation Cost
     * otalInstallationCost = jobFee + facilityTax
     */
    private void calculateTotalInstallationCost(){
        totalInstallationCost = jobFee + facilityTax;
    }
    
    /**
     * Calculate Facility Tax
     * facilityTax = jobFee ∗ taxRate / 100
     * The taxRate is 10 for NPC Stations and can be set for each facility 
     * individually for corporation owned
     */
    public void  calculateFacilityTax(){
        for (SingleJobCost singleJobCost : singleJobCosts) {            
            facilityTax = jobFee * taxRate / 100;
        }
    }    
    
    /**
     * Calculate Copying Fees
     * jobFee = baseJobCost * systemCostIndex * percent * run * runsPerCopy;
     */
    private void calculateCopyingFees(){
        int runsPerCopy = levelOrRuns; // <---- runsPerCopy
        jobFee = baseJobCost * systemCostIndex * percent * runs * runsPerCopy;
    }
    
    /**
     * Calculate Invention Fees
     * jobFee = baseJobCost ∗ systemCostIndex ∗ 0.02 ∗ runs
     */
    private void calculateInventionFees(){
        jobFee = baseJobCost * systemCostIndex * percent * runs;
    }
    
    /**
     * Calculate Research Costs
     * jobFee = baseJobCost ∗ systemCostIndex ∗ 0.02 ∗ levelModifier n /105
     */
    private void calculateResearchCosts(){
        List< Integer > levels = new ArrayList<>();
        levels.add(0); levels.add(105); levels.add(250); levels.add(595);
        levels.add(1414); levels.add(3360); levels.add(8000); levels.add(19000);
        levels.add(45255); levels.add(107700); levels.add(256000);
        int levelModifier = levelOrRuns; // <--- levelModifier
        
        if (levels.size() <= levelModifier){
            jobFee = baseJobCost * systemCostIndex * percent * levels.get(levelModifier);          
        }
    }

    /**
     * Get Job Fee
     * @return float
     */
    public float getJobFee() {
        return jobFee;
    }

    /**
     * Get Facility Tax
     * @return float
     */
    public float getFacilityTax() {
        return facilityTax;
    }

    /**
     * Get Total Installation Cost
     * @return float
     */
    public float getTotalInstallationCost() {
        return totalInstallationCost;
    }


    
}
