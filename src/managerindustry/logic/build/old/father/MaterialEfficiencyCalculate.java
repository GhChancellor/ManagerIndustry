/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.old.father;

import managerindustry.logic.build.buildItem.old.materialEfficiency.MaterialEfficiency;

/**
 * Calculate material Efficiency
 * @author lele
 */
public class MaterialEfficiencyCalculate {
    private static final float platformModifier = 1;    
    private int singleItemMaterial;
    private double totalItemsMaterials;
  
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
    public double getTotalItemsMaterials(){
        return totalItemsMaterials;
    }

    /**
     * Init - Calculate Material Efficiency
     * job * Math.ceil( ((quantityBaseMarial * run) * materialEfficiencyRate) * platformModifier );
     * @param int run
     * @param int job
     * @byte int bpoME or componentMe 
     * @param int quantityBaseMarial 
     */
    public MaterialEfficiencyCalculate( int run, int job, byte bpoME, int quantityBaseMarial ) {
        double materialEfficiencyRate = new MaterialEfficiency(bpoME).getRateBpo();
                
//        // quando il valore è 1 non si fanno calcoli su ME
//        // WHen value is 1 not calculated ME
        if ( quantityBaseMarial == 1 ){
            singleItemMaterial = quantityBaseMarial;
            totalItemsMaterials = job * singleItemMaterial * run;
            return;
        }
        
        // Calculate ME by One Object
        Double itemMaterialDbl = Math.ceil(quantityBaseMarial * materialEfficiencyRate * platformModifier);
        singleItemMaterial = itemMaterialDbl.intValue();
        
        // Calculate ME all items
        itemMaterialDbl = job * Math.ceil( ((quantityBaseMarial * run) * materialEfficiencyRate) * platformModifier );
        totalItemsMaterials = itemMaterialDbl;        
    }

    public MaterialEfficiencyCalculate() {
    }
    
}
