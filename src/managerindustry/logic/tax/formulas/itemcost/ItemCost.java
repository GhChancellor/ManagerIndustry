/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost;

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
    
    private Map<String, ReportCalculatedComponentX>  reportCalculatedComponentX;
    private String solarSystemID;
    private String actvity;

    public Map<String, ReportCalculatedComponentX> getReportCalculatedComponentX() {
        return reportCalculatedComponentX;
    }

    public void setReportCalculatedComponentX(Map<String, ReportCalculatedComponentX> reportCalculatedComponentX) {
        this.reportCalculatedComponentX = reportCalculatedComponentX;
    }

    public float getRun() {
        return run;
    }

    public void setRun(float run) {
        this.run = run;
    }

    public float getSystemCostIndex() {
        return systemCostIndex;
    }

    public void setSystemCostIndex(float systemCostIndex) {
        this.systemCostIndex = systemCostIndex;
    }

    public float getBaseJobCost() {
        return baseJobCost;
    }

    public void setBaseJobCost(float baseJobCost) {
        this.baseJobCost = baseJobCost;
    }

    public float getJobFee() {
        return jobFee;
    }

    public void setJobFee(float jobFee) {
        this.jobFee = jobFee;
    }  
    
    public String getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(String solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public String getActvity() {
        return actvity;
    }

    public void setActvity(String actvity) {
        this.actvity = actvity;
    }

    public float getAdjustment() {
        return adjustment;
    }

    public float getPercent() {
        return percent;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public void setTaxRate(float taxRate) {
        this.taxRate = taxRate;
    }

    public float getFacilityTaxes() {
        return facilityTaxes;
    }

    public void calculateFacilityTaxes(List < Float > sumOfEachJobcosts) {
        for (Float sumOfEachJobcost : sumOfEachJobcosts) {
            this.facilityTaxes += ( sumOfEachJobcost * getSystemCostIndex() * getAdjustment() * getRun() ) * getTaxRate() / 100;
        }
    }

    public void setFacilityTaxes(float facilityTaxes) {
        this.facilityTaxes = facilityTaxes;
    }

    public float getTotalInstallationCost() {
        return totalInstallationCost;
    }

    public void setTotalInstallationCost(float totalInstallationCost) {
        this.totalInstallationCost = totalInstallationCost;
    }

    public void calculateTotalInstallationCost() {
        totalInstallationCost = jobFee + facilityTaxes;
    }

    
}
