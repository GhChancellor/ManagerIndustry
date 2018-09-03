/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.gui.display;

import managerindustry.logic.tax.formulas.itemcost.jobInstallationCosts.JobInstallationCosts;
import java.util.Map;
import managerindustry.logic.build.old.ReportCalculatedComponentX;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.itemcost.copyingFees.CopyingFees;
import managerindustry.logic.tax.formulas.itemcost.researchCosts.ResearchCosts;

/**
 *
 * @author lele
 */
public class DisplayItemCost{

    public DisplayItemCost() {
    }
    
    /**
     * 
     * @param ap<String, ReportCalculatedComponentX> reportCalculatedComponentXMap
     * @param String solarSystemID
     * @param String actvity Viene preso dai server MANUFACTORING, COPYING FEE, RESEARCH COST
     * @param int run
     * @param float taxRate
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */
    public static void calculateJobInstallationCost(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int run ,float taxRate) throws SolarSystemNotExistsException, ErrorExeption{ 
        
        JobInstallationCosts buildItem = new JobInstallationCosts(reportCalculatedComponentXMap, solarSystemID, actvity, run, taxRate);
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
    public static void calculateCopingFee(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int run ,float taxRate, int runPerCopy) 
            throws SolarSystemNotExistsException, ErrorExeption{
        
        CopyingFees copyingFees = new CopyingFees
         (reportCalculatedComponentXMap, solarSystemID, actvity, run, taxRate, runPerCopy);        
        
        System.out.println("\nCOPYING FEE");
        System.out.printf("CopyingFee / JobFee %f\n", copyingFees.getCopingFee());
        System.out.printf("Total facilityTax %f\n", copyingFees.getFacilityTaxes() );
        System.out.printf("Tot cost job %f\n", copyingFees.getTotalInstallationCost());        
    }      
    
    /**
     * Calculate Research Costs
     * @param Map<String, ReportCalculatedComponentX> reportCalculatedComponentXMap
     * @param String solarSystemID
     * @param String actvity
     * @param int run
     * @param float facilityTax
     * @param int startLevel
     * @param int finishLevel
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */     
    public static void calculateResearchCosts(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, int run ,float taxRate, int startLevel, int finishLevel) throws SolarSystemNotExistsException, ErrorExeption{
        
        ResearchCosts researchCosts = new ResearchCosts(reportCalculatedComponentXMap, solarSystemID, actvity, run, taxRate, startLevel, finishLevel);
        
        System.out.println("\nRESEARCH COST ");
        System.out.println("Start Level");
//        researchCosts.xxx(0);
        
        System.out.printf("researching_material_efficiency / researching_time_efficiency %f\n", researchCosts.getResearchCosts());
        System.out.printf("Total facilityTax %f\n", researchCosts.getFacilityTaxes() );
        System.out.printf("Tot cost job %f\n", researchCosts.getTotalInstallationCost());            

        System.out.println("\nFinish Level");
        researchCosts.xxx(1);        

        System.out.printf("researching_material_efficiency / researching_time_efficiency %f\n", researchCosts.getResearchCosts());
        System.out.printf("Total facilityTax %f\n", researchCosts.getFacilityTaxes() );
        System.out.printf("Tot cost job %f\n", researchCosts.getTotalInstallationCost());    
        
        System.out.println("\nDifferent");
        researchCosts.xxx2();
        System.out.printf("researching_material_efficiency / researching_time_efficiency %f\n", researchCosts.getResearchCosts());
        System.out.printf("Total facilityTax %f\n", researchCosts.getFacilityTaxes() );
        System.out.printf("Tot cost job %f\n", researchCosts.getTotalInstallationCost());          
    
    }
}
