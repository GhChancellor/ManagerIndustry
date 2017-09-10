/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.json.systemCostIndices;

/**
 *
 * @author lele
 */
public class SolarSystemCost {
    private String solar_system_id;
    private CostIndex[] costIndexs;
    
    public SolarSystemCost() {
    }

    /**
     * Get Cost Indexs
     * @return costIndexs[]
     */
    public CostIndex[] getCostIndexs() {
        return costIndexs;
    }

    /**
     * Set Cost Indexs
     * @param costIndexs[]  costIndexs
     */
    public void setCostIndexs(CostIndex[] costIndexs) {
        this.costIndexs = costIndexs;
    }

    /**
     * Get SolarSystemCost
     * @return String
     */
    public String getSolarSystem() {
        return solar_system_id;
    }

    /**
     * Set SolarSystemCost
     * @param String SolarSystemCost 
     */
    public void setSolarSystem(String SolarSystem) {
        this.solar_system_id = SolarSystem;
    }
    
}
