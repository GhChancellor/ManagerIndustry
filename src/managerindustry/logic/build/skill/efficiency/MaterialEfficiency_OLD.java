/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.skill.efficiency;

import managerindustry.logic.generic.fatherClass.Efficiency;

/**
 * Material Efficiency Research, ME 1-10 == 1-10%
 * Basic Structure ME multiplier: 0.01 == 1%
 * Engineering Rig ME multiplier: 2% (T1) and 2.4% (T2)
 * Security Multiplier: 1, 1.9 or 2.1 == Highsec, Lowsec or Null/WH
 * Minerals Needed = Roundup(BaseMinerals * ((1 - ME-Reserch) * (1 - structureMultiplier) * (1 - (EngineeringRigME * SecurityMultiplier))))
 * https://forums.eveonline.com/t/math-is-hard-between-eve-and-the-sheets/70360/2
 * @author lele
 */
public class MaterialEfficiency_OLD extends Efficiency{
    private float materialEfficiencyRate;
   
    /**
     * Material Efficiency
     * @param byte bpoLevel
     * @param float structureRate
     * @param float engineeringRigRate
     * @param float securityStatusRate 
     */
    public MaterialEfficiency_OLD(byte bpoLevel, float structureRate, 
            float engineeringRigRate, float securityStatusRate) {
        
        super(bpoLevel, structureRate, engineeringRigRate, securityStatusRate);
        calculateMaterialEfficiencyRate();
    }

    /**
     * Init - Calculate Material Efficiency
     * job * Math.ceil( ((quantityBaseMarial * run) * materialEfficiencyRate) * structureMultiplier );
     * @param int run
     * @param int job
     * @byte int bpoME or componentMe 
     * @param int quantityBaseMarial 
     */    
    public void materialEfficiencyCalculate(int run, int job, byte bpoME, 
            int baseQuantityMarial){
        
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
            ( int ) Math.ceil(baseQuantity * materialEfficiencyRate * run);

        /* Calculate ME all items */
        totalItemsQuantity = 
            ( long ) ( job * Math.ceil( ((baseQuantity * run) * materialEfficiencyRate) ) );  
        
    }
    
    /**
     * calculate Material Efficiency Rate
     */
    private void calculateMaterialEfficiencyRate(){
        materialEfficiencyRate = efficiencyResearchRate * structureMultiplier * 
            securityStatusMultiplier;
    }

}
