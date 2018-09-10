/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.itemcost.installationCost.jobInstallationCost;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.itemcost.logic.ItemCost.InstallationCost;
import managerindustry.logic.generic.fatherClass.ItemCostBase;


/**
 *
 * @author lele
 */
public class JobInstallationCost extends InstallationCost{

    public JobInstallationCost(ItemCostBase itemCostBase) throws SolarSystemNotExistsException, ErrorExeption {
        super(itemCostBase);
        init();
    }  
    
    /**
     * Calculate Job Installation Cost
     */
    @Override
    protected void calculateInstallationCost() {
        itemCostBase.setJobFee( itemCostBase.getBaseJobCost() * 
            itemCostBase.getSystemCostIndex() * itemCostBase.getRun() * 
            itemCostBase.getAdjustment() );
    }
}
