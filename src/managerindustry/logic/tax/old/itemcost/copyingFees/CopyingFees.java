/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.old.itemcost.copyingFees;

import java.util.Map;
import managerindustry.logic.build.old.ReportCalculatedComponentX;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.old.itemcost.ItemCost;

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
        String solarSystemID, String actvity, int run, float facilityTax, int runPerCopy) throws SolarSystemNotExistsException, ErrorExeption{
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
