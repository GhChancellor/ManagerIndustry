/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost;

import java.util.Map;
import managerindustry.logic.buiild.TotalCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;

/**
 *
 * @author lele
 */
public class MainItemCost {
    private float jobFee = 0f;
    private float facilityTax = 0f;
    private float totalInstalllationCost = 0f;
    
    
    public void calculateJobInstallationCost(Map<String, TotalCalculatedComponentX> totalCalculatedComponentXMap, 
            String solarSystemID, 
            String actvity, float facilityTax) throws SolarSystemNotExistsException, PriceNotExistsException{
        ItemCost itemCost = new ItemCost(totalCalculatedComponentXMap, solarSystemID, actvity);
        jobFee = itemCost.getJobInstallationCost();
        this.facilityTax = itemCost.getFacilityTax(facilityTax);
        totalInstalllationCost = itemCost.getTotalInstallationCost(this.facilityTax);
        
        System.out.println("jobFee "+ jobFee);
        System.out.println("facilityTax "+ this.facilityTax);
        System.out.println("totalInstalllationCost "+ totalInstalllationCost);
    }
}
