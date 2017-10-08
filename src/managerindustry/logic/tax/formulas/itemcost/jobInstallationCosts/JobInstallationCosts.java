/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.jobInstallationCosts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.itemcost.ItemCost;
import managerindustry.logic.tax.formulas.itemcost.baseJobCost.BaseJobCost;
import managerindustry.logic.tax.formulas.itemcost.systemCostIndex.SystemCostIndex;

/**
 *Job Installation Costs
 * @author lele
 */
public class JobInstallationCosts extends ItemCost{   
    /**
     * Calculate Job Installation Cost
     * @param Map<String, ReportCalculatedComponentX> totalCalculatedComponentXMap
     * @param String solarSystemID
     * @param String actvity
     * @param int run
     * @param float facilityTax
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */    
    public JobInstallationCosts(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int run ,float taxRate) 
         throws SolarSystemNotExistsException, PriceNotExistsException {

        setReportCalculatedComponentX(reportCalculatedComponentXMap);
        setSolarSystemID(solarSystemID);
        setActvity(actvity);
        setTaxRate(taxRate);

        setRun(run);
        // ManagerSystemCostIndex > SolarSystemCost > getCostIndexEntity() 
         setSystemCostIndex( SystemCostIndex.SystemCostIndexDBG(solarSystemID, actvity) );
       // setSystemCostIndex( SystemCostIndex.SystemCostIndex(solarSystemID, actvity) );
        
        BaseJobCost baseJobCost = new BaseJobCost();
        
        // BaseJobCost > getBaseJobCostDBG
        setBaseJobCost( baseJobCost.getBaseJobCostDBG(reportCalculatedComponentXMap) );        
//        setBaseJobCost( baseJobCost.getBaseJobCost(reportCalculatedComponentXMap) );


        setSumOfEachJobcosts( baseJobCost.getsumOfEachJobcosts() );
        calculateJobInstallationCost();
        calculateFacilityTaxes( getSumOfEachJobcosts() );
        calculateTotalInstallationCost();
    }
    
    /**
     * Calculate Job Installation Cost
     */
    public void calculateJobInstallationCost(){
        setJobFee( getBaseJobCost() * getSystemCostIndex() * getRun() * getAdjustment() ); 
    }
    
    /**
     * Get Job Installation Cost
     * @return float
     */
    public float getJobInstallationCost(){
        return getJobFee();
    }
}
