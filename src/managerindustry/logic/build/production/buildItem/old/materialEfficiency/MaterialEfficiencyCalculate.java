/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.buildItem.old.materialEfficiency;

import managerindustry.logic.generic.fatherClass.NameBase;

/**
 * Calculate material Efficiency
 * @author lele
 */
public class MaterialEfficiencyCalculate extends NameBase{
    
    /**
     * Init - Calculate Material Efficiency
     * job * Math.ceil( ((quantityBaseMarial * run) * materialEfficiencyRate) * platformModifier );
     * @param int run
     * @param int job
     * @byte int bpoME or componentMe 
     * @param int quantityBaseMarial 
     */    
    public MaterialEfficiencyCalculate( int run, int job, byte bpoME, 
            int baseQuantityMarial ) {
        
        float materialEfficiencyRate = new MaterialEfficiency(bpoME).getRateBpo();

        baseQuantity = baseQuantityMarial;
        /*
         quando il valore è 1 non si fanno calcoli su ME
         WHen value is 1 not calculated ME        
        */
        if ( baseQuantityMarial == 1 ){
            singleItemQuantity = baseQuantity;
            totalItemsQuantity = job * singleItemQuantity * run;
            return;
        }

        /* Calculate ME by One Object */
        singleItemQuantity = 
            ( int ) Math.ceil(baseQuantity * materialEfficiencyRate );

        /* Calculate ME all items */
        totalItemsQuantity = 
            ( long ) ( job * Math.ceil( ((baseQuantity * run) * materialEfficiencyRate) ) );            
    }

    public MaterialEfficiencyCalculate() {
    }
        
}