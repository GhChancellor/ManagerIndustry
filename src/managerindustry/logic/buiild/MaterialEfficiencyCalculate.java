/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.buiild;

import managerindustry.logic.buiild.MaterialEfficiency;

/**
 *
 * @author lele
 */
public class MaterialEfficiencyCalculate {
    private static final float platformModifier = 1;    
    private int singleItemMaterial;
    private float totalItemsMaterials;
  
    /**
     * Get Single Item Material
     * @return int
     */
    public int getSingleItemMaterial(){
        return singleItemMaterial;
    }
    
    /**
     * Get Total Item Material
     * @return float
     */
    public float getTotalItemsMaterials(){
        return totalItemsMaterials;
    }

    /**
     * Init - Calculate Material Efficiency
     * job * Math.ceil( ((quantityBaseMarial * run) * materialEfficiencyRate) * platformModifier );
     * @param job
     * @param run
     * @param quantityBaseMarial
     * @param bpoME 
     */    
    public MaterialEfficiencyCalculate( int run, int job, int bpoME, int quantityBaseMarial ) {
        float materialEfficiencyRate = new MaterialEfficiency(bpoME).getRateBpo();
                
        // quando il valore è 1 non si fanno calcoli su ME
        // WHen value is 1 not calculated ME
        if ( quantityBaseMarial == 1 && job == 1){
            singleItemMaterial = quantityBaseMarial;
            totalItemsMaterials = job * singleItemMaterial * run;
        }
        
        // Calculate ME by One Object
        Double itemMaterialDbl = Math.ceil(quantityBaseMarial * materialEfficiencyRate * platformModifier);
        singleItemMaterial = itemMaterialDbl.intValue();
        
        // Calculate ME all items
        itemMaterialDbl = job * Math.ceil( ((quantityBaseMarial * run) * materialEfficiencyRate) * platformModifier );
        totalItemsMaterials = itemMaterialDbl.floatValue();        
        
    }
}
