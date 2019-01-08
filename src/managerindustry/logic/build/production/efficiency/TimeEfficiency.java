/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.efficiency;

import managerindustry.logic.generic.fatherClass.Efficiency;

/**
 *
 * @author lele
 */
public class TimeEfficiency extends Efficiency {
    /**
     * Time Efficiency
     * @param byte bpoLevel
     * @param float structureRate
     * @param float engineeringRigRate
     * @param float securityStatusRate
     * @param float implantRate 
     */
    public TimeEfficiency(byte bpoLevel, float structureRate, float engineeringRigRate, float securityStatusRate, float implantRate) {
        super(bpoLevel, structureRate, engineeringRigRate, securityStatusRate, implantRate);
    }
    
    /**
     * Get Time Efficiency Rate
     * @return float
     */
    public float getProductionTime(){
        return timeEffiencyResearchRate * structureMultiplier * securityStatusMultiplier * implantMultiplier;
    }

    public void getResearchTime(){
        
    }
    
    public void getCopyTime(){
        
    }
    
    public void getInventionTime(){
        
    }
}
