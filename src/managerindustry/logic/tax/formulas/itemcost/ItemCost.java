/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;

/**
 *
 * @author lele
 */
public class ItemCost {
    private final float adjustment = 1.1f;
    private final float percent = 0.02f; // 2%
    private float systemCostIndex = 0f;
    private float baseJobCost = 0f;    
    private float jobFee = 0f;
    private float run = 1f;
    private float taxRate = 0f;
    private float facilityTaxes = 0f;
    private float totalInstallationCost = 0f;
    private List < Float > sumOfEachJobcosts = new ArrayList();     
    private Map<String, ReportCalculatedComponentX>  reportCalculatedComponentX;
    private String solarSystemID;
    private String actvity;

    /**
     * Get Report Calculated ComponentX
     * @return Map<String, ReportCalculatedComponentX>
     */
    public Map<String, ReportCalculatedComponentX> getReportCalculatedComponentX() {
        return reportCalculatedComponentX;
    }

    /**
     * Set Report Calculated ComponentX
     * @param Map<String, ReportCalculatedComponentX> reportCalculatedComponentX 
     */
    public void setReportCalculatedComponentX(Map<String, ReportCalculatedComponentX> reportCalculatedComponentX) {
        this.reportCalculatedComponentX = reportCalculatedComponentX;
    }

    /**
     * Get Run
     * @return float
     */
    public float getRun() {
        return run;
    }

    /**
     * Set Run
     * @param float run 
     */
    public void setRun(float run) {
        this.run = run;
    }

    /**
     * Get System Cost Index
     * @return float
     */
    public float getSystemCostIndex() {
        return systemCostIndex;
    }

    /**
     * Set System Cost Index
     * @param float systemCostIndex 
     */
    public void setSystemCostIndex(float systemCostIndex) {
        this.systemCostIndex = systemCostIndex;
    }

    /**
     * Get Base Job Cost
     * @return float
     */
    public float getBaseJobCost() {
        return baseJobCost;
    }

    /**
     * Set Base Job Cost
     * @param float baseJobCost 
     */
    public void setBaseJobCost(float baseJobCost) {
        this.baseJobCost = baseJobCost;
    }

    /**
     * Get Job Fee
     * @return float
     */
    public float getJobFee() {
        return jobFee;
    }

    /**
     * Set Job Fee
     * @param float jobFee 
     */
    public void setJobFee(float jobFee) {
        this.jobFee = jobFee;
    }  
    
    /**
     * Get Solar System ID
     * @return String
     */
    public String getSolarSystemID() {
        return solarSystemID;
    }

    /**
     * Set Solar System ID
     * @param String solarSystemID 
     */
    public void setSolarSystemID(String solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    /**
     * Get Actvity
     * @return String
     */
    public String getActvity() {
        return actvity;
    }

    /**
     * Set Actvity
     * @param String actvity 
     */
    public void setActvity(String actvity) {
        this.actvity = actvity;
    }

    /**
     * Get Adjustment
     * @return float
     */
    public float getAdjustment() {
        return adjustment;
    }

    /**
     * Get Percent
     * @return float
     */
    public float getPercent() {
        return percent;
    }

    /**
     * Get Tax Rate
     * @return float
     */
    public float getTaxRate() {
        return taxRate;
    }

    /**
     * Set Tax Rate
     * @param float taxRate 
     */
    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    /**
     * Get Facility Taxes
     * @return float
     */
    public float getFacilityTaxes() {
        return facilityTaxes;
    }

    /**
     * è 10%  = 0,1 quindi se passi 0.1 nella formula NON fare " /100 "
     * @param List < Float > sumOfEachJobcosts 
     */
    public void calculateFacilityTaxes(List < Float > sumOfEachJobcosts) {
        for (Float sumOfEachJobcost : sumOfEachJobcosts) {
            this.facilityTaxes += ( sumOfEachJobcost * getSystemCostIndex() * getAdjustment() * getRun() ) * getTaxRate(); // / 100;
        }
    }

    /**
     * Set Facility Taxes
     * @param float facilityTaxes 
     */
    public void setFacilityTaxes(float facilityTaxes) {
        this.facilityTaxes = facilityTaxes;
    }

    /**
     * Get Total Installation Cost
     * @return float
     */
    public float getTotalInstallationCost() {
        return totalInstallationCost;
    }

    /**
     * Set Total Installation Cost
     * @param float totalInstallationCost 
     */
    public void setTotalInstallationCost(float totalInstallationCost) {
        this.totalInstallationCost = totalInstallationCost;
    }

    /**
     * CalculateTotal Installation Cost
     */
    public void calculateTotalInstallationCost() {
        totalInstallationCost = jobFee + facilityTaxes;
    }

    /**
     * Get Sum Of Each Job costs
     * @return List<Float>
     */
    public List<Float> getSumOfEachJobcosts() {
        return sumOfEachJobcosts;
    }

    /**
     * Set Sum Of Each Job costs
     * @param List<Float> sumOfEachJobcosts 
     */
    public void setSumOfEachJobcosts(List<Float> sumOfEachJobcosts) {
        this.sumOfEachJobcosts = sumOfEachJobcosts;
    }

}
