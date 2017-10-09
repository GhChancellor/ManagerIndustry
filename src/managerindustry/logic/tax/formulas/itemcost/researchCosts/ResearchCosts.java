/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.researchCosts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.logic.buiild.ReportCalculatedComponentX;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.itemcost.ItemCost;

/**
 *
 * @author lele
 */
public class ResearchCosts extends ItemCost{
    int startLevel;
    int finishLevel;
    
    /**
     * 
     * @param Map<String, ReportCalculatedComponentX> reportCalculatedComponentXMap
     * @param String solarSystemID
     * @param String actvity
     * @param int run
     * @param float facilityTax
     * @param int startLevel
     * @param int finishLevel
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */    
    public ResearchCosts(Map<String, ReportCalculatedComponentX> reportCalculatedComponentXMap, 
     String solarSystemID, String actvity, int run, float facilityTax,
     int startLevel, int finishLevel)
      throws SolarSystemNotExistsException, PriceNotExistsException {
        
        super(reportCalculatedComponentXMap, solarSystemID, actvity, run, facilityTax);
        this.startLevel = startLevel;
        this.finishLevel = finishLevel;
        
        calculateResearchCosts();
        calculateFacilityTaxes( getSumOfEachJobcosts() );
        calculateTotalInstallationCost();        
    }

    /**
     * Calculate Research Costs
     */
    public void calculateResearchCosts(){
        List< Integer > levels = new ArrayList<>();
        levels.add(0); levels.add(105); levels.add(250); levels.add(595);
        levels.add(1414); levels.add(3360); levels.add(8000); levels.add(19000);
        levels.add(45255); levels.add(107700); levels.add(256000);
        
        float tempJobFee = getBaseJobCost() * getSystemCostIndex() * getPercent() * getAdjustment() * levels.get(finishLevel) / 105;

        setJobFee( tempJobFee );
        
    }

    @Override
    public void calculateFacilityTaxes(List<Float> sumOfEachJobcosts) {
        setFacilityTaxes( getJobFee() * getTaxRate() );
    }
    
    /**
     * Get Research Costs
     * @return float
     */
    public float getResearchCosts(){
        return getJobFee();
    }    
}
