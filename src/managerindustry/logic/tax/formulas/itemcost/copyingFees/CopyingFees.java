/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.copyingFees;

import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.itemcost.ItemCost;
import managerindustry.logic.tax.formulas.itemcost.baseJobCost.BaseJobCost;
import managerindustry.logic.tax.formulas.itemcost.systemCostIndex.SystemCostIndex;

/**
 * Copying Fees
 * @author lele
 */
public class CopyingFees extends ItemCost{
    private int runPerCopy;
    
    /**
     * Coping Fee
     * @param Map<String, ReportCalculatedComponentX> totalCalculatedComponentXMap
     * @param String solarSystemID
     * @param String actvity
     * @param int run
     * @param float facilityTax
     * @param int runPerCopy
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */    
    public CopyingFees(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int run ,float taxRate, int runPerCopy) 
         throws SolarSystemNotExistsException, PriceNotExistsException {
        
        setReportCalculatedComponentX(reportCalculatedComponentXMap);
        setSolarSystemID(solarSystemID);
        setActvity(actvity);
        setRun(run);
        setTaxRate(taxRate);
        this.runPerCopy = runPerCopy;
        
        // ManagerSystemCostIndex > SolarSystemCost > getCostIndexEntity() 
         setSystemCostIndex( SystemCostIndex.SystemCostIndexDBG(solarSystemID, actvity) );
//        setSystemCostIndex( SystemCostIndex.SystemCostIndex(solarSystemID, actvity) );
        
        BaseJobCost baseJobCost = new BaseJobCost();
        
        // BaseJobCost > getBaseJobCostDBG
        setBaseJobCost( baseJobCost.getBaseJobCostDBG(reportCalculatedComponentXMap) );        
//        setBaseJobCost( baseJobCost.getBaseJobCost(reportCalculatedComponentXMap) );   

        setSumOfEachJobcosts( baseJobCost.getsumOfEachJobcosts() );
        calculateCopyingFee();
        calculateFacilityTaxes( getSumOfEachJobcosts() );
        calculateTotalInstallationCost();
    }
    
    /**
     * Calculate Copying Fee
     */
    public void calculateCopyingFee(){
        setJobFee( getBaseJobCost() * getSystemCostIndex() * getRun() * getPercent() * runPerCopy  );
    }
    
    /**
     * Get Coping Fee
     * @return float
     */
    public float getCopingFee(){
        return getJobFee();
    }
    // Copying fees
    // jobF ee = baseJobCost ∗ systemCostIndex ∗ 0.02 ∗ runs ∗ runsPerCopy
    
    
}
