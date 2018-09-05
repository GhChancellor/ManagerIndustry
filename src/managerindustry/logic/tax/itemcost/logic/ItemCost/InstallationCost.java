/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.itemcost.logic.ItemCost;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.itemcost.logic.ItemCost.ItemCost;
import managerindustry.logic.tax.itemcost.logic.ItemCost.ItemCostBase;

/**
 *
 * @author lele
 */
public abstract class InstallationCost extends ItemCost{
//    protected ItemCostBase itemCostBase;
    
    public InstallationCost(ItemCostBase itemCostBase) throws SolarSystemNotExistsException, ErrorExeption {    
        super(itemCostBase);
    }
    
    protected void init(){
        calculateInstallationCost();
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

    protected abstract void calculateInstallationCost();    
    
}
