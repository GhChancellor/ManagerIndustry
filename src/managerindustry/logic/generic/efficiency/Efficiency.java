/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.efficiency;

/**
 *
 * @author lele
 */
public abstract class Efficiency {
    private String name;
    private float ratePercent;
    private Byte level;
    private final double baseValue = 1f; 

    public Efficiency() {
    
    }

    /**
     * DBG non come chiamarlo per il momento
     * Di base è 1
     * @return float
     */
    public double getBaseValue() {
        return baseValue;
    }
        
    /**
     * Get Name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name
     * @param String name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Rate Percent
     * @return float
     */
    public float getRatePercent() {
        return ratePercent;
    }

    /**
     * Set Rate Percent
     * @param float ratePercent 
     */
    public void setRatePercent(float ratePercent) {
        this.ratePercent = ratePercent;
    }

    /**
     * Get Level
     * @return int
     */
    public Integer getLevel() {
        return level.intValue();
    }

    /**
     * Set Level
     * @param int level 
     */
    public void setLevel(byte level) {
        this.level = level;
    }

    public double getRateBpo(){
        return calculateRateBpo();
    }

    protected abstract double calculateRateBpo(); 
}
