/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost;

import managerindustry.logic.tax.formulas.itemcost.jobInstallationCosts.JobInstallationCosts;
import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.itemcost.copyingFees.CopyingFees;
import managerindustry.logic.tax.formulas.itemcost.researchCosts.ResearchCosts;

/**
 *
 * @author lele
 */
public class MainItemCost {
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
    public void calculateJobInstallationCost(
     Map<String, ReportCalculatedComponentX>  totalCalculatedComponentXMap, 
     String solarSystemID, String actvity, int run, float facilityTax )
     throws SolarSystemNotExistsException, PriceNotExistsException{
        
        JobInstallationCosts buildItem = new JobInstallationCosts(totalCalculatedComponentXMap, solarSystemID, actvity, run, facilityTax);
        System.out.println("\nMANUFACTORING");
        System.out.printf("Job Installation Cost / JobFee %f\n", buildItem.getJobInstallationCost());
        System.out.printf("Total facilityTax %f\n", buildItem.getFacilityTaxes() );
        System.out.printf("Tot cost job %f\n", buildItem.getTotalInstallationCost());        
    }
    
    /**
     * Calculate Coping Fee
     * @param Map<String, ReportCalculatedComponentX> totalCalculatedComponentXMap
     * @param String solarSystemID
     * @param String actvity
     * @param int run
     * @param float facilityTax
     * @param int runPerCopy
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */
    public void calculateCopingFee(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int run ,float taxRate, int runPerCopy) throws SolarSystemNotExistsException, PriceNotExistsException{
        CopyingFees copyingFees = 
         new CopyingFees
         (reportCalculatedComponentXMap, solarSystemID, actvity, run, taxRate, runPerCopy);
        
        System.out.println("\nCOPYING FEE");
        System.out.printf("CopyingFee / JobFee %f\n", copyingFees.getCopingFee());
        System.out.printf("Total facilityTax %f\n", copyingFees.getFacilityTaxes() );
        System.out.printf("Tot cost job %f\n", copyingFees.getTotalInstallationCost());        
    }
    
    /**
     * Calculate ResearchCosts
     * Map<String, ReportCalculatedComponentX>
     * @param reportCalculatedComponentXMap
     * @param String solarSystemID
     * @param String actvity
     * @param int startLevel
     * @param int finishLevel
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */    
    public void calculateResearchCosts(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int startLevel, int finishLevel) throws SolarSystemNotExistsException, PriceNotExistsException{
        ResearchCosts researchCosts = new ResearchCosts(reportCalculatedComponentXMap, solarSystemID, actvity, startLevel, finishLevel);
        
        System.out.println("\nRESEARCH COST");
        System.out.printf("Research cost / JobFee %f\n", researchCosts.getResearchCosts());
        System.out.printf("Total facilityTax %f\n", researchCosts.getFacilityTaxes() );
        System.out.printf("Tot cost job %f\n", researchCosts.getTotalInstallationCost()); 
    }
}
