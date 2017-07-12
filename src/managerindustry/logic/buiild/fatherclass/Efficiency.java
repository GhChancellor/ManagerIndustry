/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.buiild.fatherclass;

/**
 *
 * @author lele
 */
public abstract class Efficiency {
    private String name;
    private double ratePercent;
    private Integer level;
    private double baseValue = 1; 

    public Efficiency() {
    }

    /**
     * DBG non come chiamarlo per il momento
     * Di base è 1
     * @return double
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
     * @return Double
     */
    public Double getRatePercent() {
        return ratePercent;
    }

    /**
     * Set Rate Percent
     * @param Double ratePercent 
     */
    public void setRatePercent(Double ratePercent) {
        this.ratePercent = ratePercent;
    }

    /**
     * Get Level
     * @return int
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * Set Level
     * @param int level 
     */
    public void setLevel(int level) {
        this.level = level;
    }

    public abstract double calculateRateBpo();
}
