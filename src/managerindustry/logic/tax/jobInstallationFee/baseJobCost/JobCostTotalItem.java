/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.baseJobCost;

/**
 *
 * @author lele
 */
public class JobCostTotalItem {
    private String nameItem;
    private int quantityMaterial;

    /**
     * Get Name Item
     * @return String
     */
    public String getNameItem() {
        return nameItem;
    }

    /**
     * Set Name Item
     * @param String nameItem 
     */
    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    /**
     * Get Quantity Material
     * @return int
     */
    public int getQuantityMaterial() {
        return quantityMaterial;
    }

    /**
     * Set Quantity Material
     * @param int quantityMaterial 
     */
    public void setQuantityMaterial(int quantityMaterial) {
        this.quantityMaterial = quantityMaterial;
    }
    
    
}
