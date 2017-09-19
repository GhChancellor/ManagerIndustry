/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost;

import java.util.Map;
import managerindustry.logic.buiild.SingleCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;

/**
 *
 * @author lele
 */
public class MainItemCost {
    private float jobFee = 0f;
    private float facilityTax = 0f;
    private float totalcostjob = 0f;
    
    
    public void calculateJobInstallationCost(Map<String, SingleCalculatedComponentX>  singleCalculatedComponentXMap, 
            String solarSystemID, 
            String actvity, float facilityTax) throws SolarSystemNotExistsException, PriceNotExistsException{
        ItemCost itemCost = new ItemCost(singleCalculatedComponentXMap, solarSystemID, actvity);
 
        jobFee = itemCost.getJobInstallationCost();
        this.facilityTax = itemCost.getFacilityTaxes(facilityTax);
        totalcostjob = itemCost.getTotalInstallationCost(jobFee, this.facilityTax);
        
        System.out.printf("jobFee %f\n", jobFee);
        System.out.printf("facilityTax %f\n", this.facilityTax);
        System.out.printf("Tot cost job %f\n", totalcostjob);
        
        float total = this.facilityTax + totalcostjob;
        System.out.printf("Total Installation Cost %f ", total );
        
        System.out.println("");
        double aggiustamento = (total * 0.1152681) + total; // 0.1152681
        System.out.printf("Con aggiustamento %f\n", aggiustamento);
    }
}
