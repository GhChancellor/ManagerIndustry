/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ItemCostNew.logic.ItemCost;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.prove.ItemCostNew.logic.baseJobCost.BaseJobCost;
import managerindustry.logic.tax.formulas.itemcost.systemCostIndex.SystemCostIndex;

/**
 *
 * @author lele
 */
public class ItemCost {
    private ItemCostBase itemCostBase;
    private BaseJobCost baseJobCost = new BaseJobCost();

    public ItemCost() {
    }
    
    public ItemCost(ItemCostBase itemCostBase_) throws SolarSystemNotExistsException, ErrorExeption {
        itemCostBase = itemCostBase_;
        
        // SystemCostIndex.SystemCostIndex da unificare 
        itemCostBase.setSystemCostIndex( SystemCostIndex.SystemCostIndex(
            itemCostBase.getSolarSystemID(), 
            itemCostBase.getActivitiesEnum().getActivity()) );  
        
        itemCostBase.setBaseJobCost( baseJobCost.getBaseJobCost(itemCostBase) );        
        itemCostBase.setSumOfEachJobcosts( baseJobCost.getsumOfEachJobcosts() ); 
    }
    
    /**
     * Calculate Facility Taxes 
     * è 10%  = 0,1 quindi se passi 0.1 nella formula NON fare " /100 "
     */
    protected void calculateFacilityTaxes() {
        for (Float sumOfEachJobcost : itemCostBase.getSumOfEachJobcosts()){

            float facilityTaxes = itemCostBase.getFacilityTaxes();
            facilityTaxes += 
                ( sumOfEachJobcost * itemCostBase.getSystemCostIndex() * 
                itemCostBase.getAdjustment() * itemCostBase.getRun() * 
                itemCostBase.getTaxRate()); // / 100;
                    
            itemCostBase.setFacilityTaxes(facilityTaxes);
        }
    }    
    
    /**
     * CalculateTotal Installation Cost
     */
    protected void calculateTotalInstallationCost() {
        itemCostBase.setTotalInstallationCost(itemCostBase.getJobFee() + itemCostBase.getFacilityTaxes());
    }
    
    /**
     * Get Facility Taxes
     * @return float
     */
    public float getFacilityTaxes() {
        return itemCostBase.getFacilityTaxes();
    }    
    
    /**
     * Get Total Installation Cost
     * @return float
     */
    public float getTotalInstallationCost() {
        return itemCostBase.getTotalInstallationCost();
    }    
}
