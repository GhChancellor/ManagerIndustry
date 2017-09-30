/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
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
    
//    private float jobFee = 0f;
    private List < Float > sumOfEachJobcosts = new ArrayList();
    
    public ItemCost(Map<String, ReportCalculatedComponentX>  totalCalculatedComponentXMap, 
            String solarSystemID, 
            String actvity) throws SolarSystemNotExistsException, PriceNotExistsException {
        
//        float xxx = 0.0099453514521152f;
//        this.systemCostIndex = xxx;
        this.systemCostIndex = SystemCostIndex.SystemCostIndex(solarSystemID, actvity);
        
        BaseJobCost baseJobCost = new BaseJobCost();
        this.baseJobCost = baseJobCost.getBaseJobCost(totalCalculatedComponentXMap);
        sumOfEachJobcosts = baseJobCost.getsumOfEachJobcosts();

        System.out.println("");
    }
    
    /**
     * Get job Installation Cost ( jobfee )
     * jobFee = baseJobCost ∗ systemCostIndex ∗ runs
     * baseJobCost = drake ( tritanium 30 isk + pyerite 50 isk + mexallon 25 isk )
     * @return double
     */
    public float getJobInstallationCost(int run){       
        return baseJobCost * systemCostIndex * run;
    }
    
    /**
     * Get Facility Tax ( jobfee ) 
     * facilityTax = jobFee ∗ taxRate / 100
     * The taxRate is 10 for NPC Stations and can be set for each facility 
     * individually for corporation owned
     * @param float taxRate
     * @return float
     */
    public float getFacilityTaxesPerItem(float taxRate){
        float jobfee = 0f;       
        for (Float sumOfEachJobcost : sumOfEachJobcosts) {
            jobfee += sumOfEachJobcost * taxRate / 100;
        }
        return jobfee;
    }

    /**
     * Get Facility Taxes Per Each Item
     * @param float taxRate
     * @return List < Float >
     */
    public List < Float > getFacilityTaxesPerEachItem(float taxRate){
        List < Float > jobfees = new ArrayList<>();
                
        for (Float sumOfEachJobcost : sumOfEachJobcosts) {
            jobfees.add( sumOfEachJobcost * taxRate / 100 ) ;
        }
        return jobfees;
    }
    
    /**
     * Get Total Installation Cost 
     * totalInstallationCost = jobFee + facilityTax
     * @param jobFee
     * @param facilityTax
     * @return float
     */
    public float getTotalInstallationCost(float jobFee, float facilityTax){
        return jobFee + facilityTax;
    }
    
    /**
     * Get Copying Fees
     * jobFee = baseJobCost * systemCostIndex * percent * run * runsPerCopy;
     * @param runsPerCopy
     * @return float 
     */
    public float getCopyingFees(int run, int runsPerCopy){
//        return jobFee = baseJobCost * systemCostIndex * percent * run * runsPerCopy;
        return 0f;
    }
    
    /**
     * Get Invention Fees
     * jobFee = baseJobCost ∗ systemCostIndex ∗ 0.02 ∗ runs
     * @param runs
     * @return float
     */
    public float getInventionFees(int runs){
//        jobFee = baseJobCost * systemCostIndex * percent * runs;
//        return jobFee;
        return 0f;
    }
    
    /**
     * Get Research Costs
     * @param levelModfier
     * @return int float
     */
    public float getResearchCosts(int levelModfier){
//        List< Integer > levels = new ArrayList<>();
//        levels.add(0); levels.add(105); levels.add(250); levels.add(595);
//        levels.add(1414); levels.add(3360); levels.add(8000); levels.add(19000);
//        levels.add(45255); levels.add(107700); levels.add(256000);
//        
//        if (levels.size() <= levelModfier){
//            jobFee = baseJobCost * systemCostIndex * percent * levels.get(levelModfier);
//            return jobFee;              
//        }
        return 0f;
    }
}
