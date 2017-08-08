/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.jobInstallationFee.systemCostIndex;

/**
 *
 * @author lele
 */
public class SolarSystem {
    private String solarSystem;
    private CostIndex[] costIndexs;
    
    public SolarSystem() {
    }

    public CostIndex[] getCostIndexs() {
        return costIndexs;
    }

    public void setCostIndexs(CostIndex[] costIndexs) {
        this.costIndexs = costIndexs;
    }

    public String getSolarSystem() {
        return solarSystem;
    }

    public void setSolarSystem(String SolarSystem) {
        this.solarSystem = SolarSystem;
    }
    
}
