/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ItemCostNew.logic.ItemCost;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.nameBase.NameBase;

/**
 *
 * @author lele
 */
public class ItemCostBase {
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
    private List<NameBase> nameBases = new ArrayList();  
    private String solarSystemID;
    private RamActivitiesEnum activitiesEnum;

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
     * Get Actvity Enum
     * @return RamActivitiesEnum
     */
    public RamActivitiesEnum getActivitiesEnum() {
        return activitiesEnum;
    }

    /**
     * Set Actvity Enum
     * @param RamActivitiesEnum activitiesEnum 
     */
    public void setActivitiesEnum(RamActivitiesEnum activitiesEnum) {
        this.activitiesEnum = activitiesEnum;
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

    /**
     * Get Name Bases
     * @return List<NameBase>
     */
    public List<NameBase> getNameBases() {
        return nameBases;
    }

    /**
     * Set Name Bases
     * @param List<NameBase> nameBases 
     */
    public void setNameBases(List<NameBase> nameBases) {
        this.nameBases = nameBases;
    }

    
}
