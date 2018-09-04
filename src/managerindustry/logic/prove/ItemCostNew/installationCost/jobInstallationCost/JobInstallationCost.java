/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ItemCostNew.installationCost.jobInstallationCost;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.prove.ItemCostNew.installationCost.InstallationCost;
import managerindustry.logic.prove.ItemCostNew.logic.ItemCost.ItemCostBase;


/**
 *
 * @author lele
 */
public class JobInstallationCost extends InstallationCost{
    private ItemCostBase itemCostBase;

    public JobInstallationCost(ItemCostBase itemCostBase) throws SolarSystemNotExistsException, ErrorExeption {
        super(itemCostBase);
        this.itemCostBase = itemCostBase;
    }  

    /**
     * Calculate Job Installation Cost
     */
    @Override
    protected void calculateJobInstallationCost() {
        itemCostBase.setJobFee( itemCostBase.getBaseJobCost() * 
            itemCostBase.getSystemCostIndex() * itemCostBase.getRun() * 
            itemCostBase.getAdjustment() );
    }
}
