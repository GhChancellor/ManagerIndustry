/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.itemcost;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.itemcost.installationCost.copyingFees.CopyingFees;
import managerindustry.logic.generic.fatherClass.ItemCostBase;
import managerindustry.logic.tax.itemcost.installationCost.jobInstallationCost.JobInstallationCost;
import managerindustry.logic.tax.itemcost.installationCost.researchCosts.ResearchCosts;

/**
 *
 * @author lele
 */
public class DisplayItemCost {   
    public void calculateJobInstallationCost(ItemCostBase itemCostBase){       
        try {
            JobInstallationCost buildItem = new JobInstallationCost(itemCostBase);
            System.out.println("\nMANUFACTORING");
            System.out.printf("Job Installation Cost / JobFee %f\n", buildItem.getJobInstallationCost());
            System.out.printf("Total facilityTax %f\n", buildItem.getFacilityTaxes() );
            System.out.printf("Tot cost job %f\n", buildItem.getTotalInstallationCost());               
        } catch (ErrorExeption e) {
            System.out.println(""+ e.getMessage());
        } catch (SolarSystemNotExistsException e) {
            System.out.println(""+ e.getMessage());
        }      
    }    
    
    public void calculateCopyingFees(ItemCostBase itemCostBase){  
        try {
            CopyingFees copyingFees = new CopyingFees(itemCostBase);
            System.out.println("\nCOPYING FEE");
            System.out.printf("CopyingFee / JobFee %f\n", copyingFees.getCopingFee());
            System.out.printf("Total facilityTax %f\n", copyingFees.getFacilityTaxes() );
            System.out.printf("Tot cost job %f\n", copyingFees.getTotalInstallationCost());                  
        } catch (ErrorExeption e) {
            System.out.println(""+ e.getMessage());
        } catch (SolarSystemNotExistsException e) {
            System.out.println(""+ e.getMessage());
        }      
    }
    
    /**
     * @deprecated 
     * NOn funziona bene da controllare le formule
     * @param itemCostBase 
     */
    public void calculateResearchCost(ItemCostBase itemCostBase){  
//        try {
//            ResearchCosts researchCosts = new ResearchCosts(itemCostBase);
//            System.out.println("\nRESEARCH COST ");
//            System.out.println("Start Level");
//            System.out.printf("researching_material_efficiency / researching_time_efficiency %f\n", researchCosts.getResearchCosts());
//            System.out.printf("Total facilityTax %f\n", researchCosts.getFacilityTaxes() );
//            System.out.printf("Tot cost job %f\n", researchCosts.getTotalInstallationCost()); 
//
//            System.out.println("\nDifferent");
//            researchCosts.subtraction();
//            System.out.printf("researching_material_efficiency / researching_time_efficiency %f\n", researchCosts.getResearchCosts());
//            System.out.printf("Total facilityTax %f\n", researchCosts.getFacilityTaxes() );
//            System.out.printf("Tot cost job %f\n", researchCosts.getTotalInstallationCost());               
//        } catch (ErrorExeption e) {
//            System.out.println(""+ e.getMessage());
//        } catch (SolarSystemNotExistsException e) {
//            System.out.println(""+ e.getMessage());
//        }        
    }    
}
