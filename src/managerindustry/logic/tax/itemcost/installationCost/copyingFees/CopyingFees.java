/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.itemcost.installationCost.copyingFees;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.itemcost.logic.ItemCost.InstallationCost;
import managerindustry.logic.generic.fatherClass.ItemCostBase;

/**
 *
 * @author lele
 */
public class CopyingFees extends InstallationCost{

    public CopyingFees(ItemCostBase itemCostBase) throws SolarSystemNotExistsException, ErrorExeption {
        super(itemCostBase);
        init();
    }

    /**
     * Calculate Copying Fee
     */
    @Override
    protected void calculateInstallationCost() {
        itemCostBase.setJobFee( itemCostBase.getBaseJobCost() * 
            itemCostBase.getSystemCostIndex() * itemCostBase.getRun() * 
            itemCostBase.getPercent() * itemCostBase.getRunPerCopy()  );
    }
    
    /**
     * Get Job Fee
     * @return float
     */    
    public float getCopingFee(){
        return itemCostBase.getJobFee();
    }
}
