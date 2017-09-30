/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost;

import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;

/**
 *
 * @author lele
 */
public class MainItemCost {
    private float jobFee = 0f;
    private float totalFacilityTax = 0f;
    private float totalcostjob = 0f;
    
    
    public void calculateJobInstallationCost(
     Map<String, ReportCalculatedComponentX>  totalCalculatedComponentXMap, 
     String solarSystemID, String actvity, float facilityTax, int run)
     throws SolarSystemNotExistsException, PriceNotExistsException{
        
        ItemCost itemCost = new ItemCost(totalCalculatedComponentXMap, solarSystemID, actvity);
 
        jobFee = itemCost.getJobInstallationCost(run);
        this.totalFacilityTax = itemCost.getFacilityTaxesPerItem(facilityTax);
        totalcostjob = itemCost.getTotalInstallationCost(jobFee, this.totalFacilityTax);
        
        System.out.printf("jobFee %f\n", jobFee);
        System.out.printf("Total facilityTax %f\n", this.totalFacilityTax);
        System.out.printf("Tot cost job %f\n", totalcostjob);
        
        float total = this.totalFacilityTax + totalcostjob;
        System.out.printf("Total Installation Cost %f ", total );
        
        System.out.println("");
        double aggiustamento = (total * 1.1) + total; // 0.1152681
        System.out.printf("Con aggiustamento %f\n", aggiustamento);
    }
}
