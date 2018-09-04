/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ItemCostNew;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.prove.ItemCostNew.logic.ItemCost.ItemCostBase;
import managerindustry.logic.prove.ItemCostNew.installationCost.jobInstallationCost.JobInstallationCost;

/**
 *
 * @author lele
 */
public class DisplayItemCost {
    public void calculateJobInstallationCost(ItemCostBase itemCostBase) {
        try {
            JobInstallationCost buildItem = new JobInstallationCost(itemCostBase);
            System.out.println("\nMANUFACTORING");
            System.out.printf("Job Installation Cost / JobFee %f\n", buildItem.getJobInstallationCost());
            System.out.printf("Total facilityTax %f\n", buildItem.getFacilityTaxes() );
            System.out.printf("Tot cost job %f\n", buildItem.getTotalInstallationCost());              
        } catch ( ErrorExeption e ) {
            System.out.println(""+ e.getErrorEnum().getErrorMessage()  );
            return;
        } catch ( SolarSystemNotExistsException e){
            System.out.println(""+ e.getMessage());
            return;
        }
    }
}
