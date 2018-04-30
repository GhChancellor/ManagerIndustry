/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.jobInstallationCosts;

import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.itemcost.ItemCost;

/**
 *
 * @author lele
 */
public class JobInstallationCosts extends ItemCost{

    /**
     * Calculate Job Installation Cost
     * @param reportCalculatedComponentXMap
     * @param solarSystemID
     * @param actvity
     * @param run
     * @param taxRate
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */
    public JobInstallationCosts(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int run ,float taxRate) throws SolarSystemNotExistsException, PriceNotExistsException {
        super(reportCalculatedComponentXMap, solarSystemID, actvity, run, taxRate);
        
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
