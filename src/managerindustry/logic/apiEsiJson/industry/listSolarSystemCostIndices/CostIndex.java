/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson.industry.listSolarSystemCostIndices;

/**
 *
 * @author lele
 */
public class CostIndex {
    private String activity;
    private String costIndex;

    public CostIndex(String activity, String costIndex) {
        this.activity = activity;
        this.costIndex = costIndex;
    }
    
    public CostIndex() {
    }

    /**
     * Set Activity
     * @return String
     */
    public String getActivity() {
        return activity;
    }

    /**
     * Get Activity
     * @param String activity 
     */
    public void setActivity(String activity) {
        this.activity = activity;
    }

    /**
     * Get CostIndex
     * @return String
     */
    public String getCostIndex() {
        return costIndex;
    }

    /**
     * Set CostIndex
     * @param String costIndex 
     */
    public void setCostIndex(String costIndex) {
        this.costIndex = costIndex;
    }
    
    
}
