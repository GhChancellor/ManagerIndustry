/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ItemCostNew.installationCost;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.prove.ItemCostNew.logic.ItemCost.ItemCost;
import managerindustry.logic.prove.ItemCostNew.logic.ItemCost.ItemCostBase;

/**
 *
 * @author lele
 */
public abstract class InstallationCost extends ItemCost{
    private ItemCostBase itemCostBase;
    
    public InstallationCost(ItemCostBase itemCostBase) throws SolarSystemNotExistsException, ErrorExeption {    
        super(itemCostBase);
        this.itemCostBase = itemCostBase;
        calculateJobInstallationCost();
        calculateFacilityTaxes();     
        calculateTotalInstallationCost();        
    }

    /**
     * Get Job Installation Cost
     * @return float
     */
    public float getJobInstallationCost(){
        return itemCostBase.getJobFee();
    }

    protected abstract void calculateJobInstallationCost();    
    
}
