/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ItemCostNew.installationCost.jobInstallationCost;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.prove.ItemCostNew.logic.ItemCost.ItemCost;
import managerindustry.logic.prove.ItemCostNew.logic.ItemCost.ItemCostBase;


/**
 *
 * @author lele
 */
public class JobInstallationCost_001 extends ItemCost{
    private ItemCostBase itemCostBase;

    public JobInstallationCost_001(ItemCostBase itemCostBase) throws SolarSystemNotExistsException, ErrorExeption {
        super(itemCostBase);
        this.itemCostBase = itemCostBase;
        calculateJobInstallationCost();
        calculateFacilityTaxes();     
        calculateTotalInstallationCost();
    }

    /**
     * Calculate Job Installation Cost
     */
    private void calculateJobInstallationCost(){
        itemCostBase.setJobFee( itemCostBase.getBaseJobCost() * 
            itemCostBase.getSystemCostIndex() * itemCostBase.getRun() * 
            itemCostBase.getAdjustment() );
    }
    
    /**
     * Get Job Installation Cost
     * @return float
     */
    public float getJobInstallationCost(){
        return itemCostBase.getJobFee();
    }    
}
