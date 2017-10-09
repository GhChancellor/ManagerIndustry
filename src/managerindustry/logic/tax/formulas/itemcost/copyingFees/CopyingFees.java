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

/**
 *
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
    public CopyingFees(Map<String, ReportCalculatedComponentX> reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int run, float facilityTax, int runPerCopy) throws SolarSystemNotExistsException, PriceNotExistsException {
        super(reportCalculatedComponentXMap, solarSystemID, actvity, run, facilityTax);
        this.runPerCopy = runPerCopy;
        
        calculateCopyingFee();
        calculateFacilityTaxes( getSumOfEachJobcosts() );
        calculateTotalInstallationCost();        
    }
    /**
     * Calculate Copying Fee
     */
    public void calculateCopyingFee(){
        setJobFee( getBaseJobCost() * getSystemCostIndex() * getRun() * getPercent() * this.runPerCopy  );
    }
    
    /**
     * Get Coping Fee
     * @return float
     */
    public float getCopingFee(){
        return getJobFee();
    }    
}