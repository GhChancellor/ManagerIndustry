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
import managerindustry.logic.tax.formulas.itemcost.baseJobCost.BaseJobCost;
import managerindustry.logic.tax.formulas.itemcost.systemCostIndex.SystemCostIndex;

/**
 * Research Costs
 * @author lele
 */
public class ResearchCosts extends ItemCost{
    int startLevel;
    int finishLevel;
    
    /**
     * Research Costs
     * Map<String, ReportCalculatedComponentX>
     * @param reportCalculatedComponentXMap
     * @param String solarSystemID
     * @param String actvity
     * @param int startLevel
     * @param int finishLevel
     * @throws SolarSystemNotExistsException
     * @throws PriceNotExistsException 
     */
    public ResearchCosts(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
        String solarSystemID, String actvity, float facilityTax, int startLevel, int finishLevel ) throws SolarSystemNotExistsException, PriceNotExistsException {
        
        setReportCalculatedComponentX(reportCalculatedComponentXMap);
        setSolarSystemID(solarSystemID);
        setActvity(actvity);
        setRun(startLevel);
        setTaxRate(facilityTax);
        this.finishLevel = finishLevel;
        
// ManagerSystemCostIndex > SolarSystemCost > getCostIndexEntity() 
         setSystemCostIndex( SystemCostIndex.SystemCostIndexDBG(solarSystemID, actvity) );
//        setSystemCostIndex( SystemCostIndex.SystemCostIndex(solarSystemID, actvity) );
        
        BaseJobCost baseJobCost = new BaseJobCost();
        
        // BaseJobCost > getBaseJobCostDBG
        setBaseJobCost( baseJobCost.getBaseJobCostDBG(reportCalculatedComponentXMap) );        
//        setBaseJobCost( baseJobCost.getBaseJobCost(reportCalculatedComponentXMap) );

        setSumOfEachJobcosts( baseJobCost.getsumOfEachJobcosts() );
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
        // float xxx = getBaseJobCost() * getSystemCostIndex() * getPercent() * levels.get(finishLevel);
        
        float tempJobFee = getBaseJobCost() * getSystemCostIndex() * getPercent() * levels.get(finishLevel) / 105;
//        for (int i = 0; i < this.finishLevel; i++) {
//           tempJobFee += getBaseJobCost() * getSystemCostIndex() * getPercent() * levels.get(finishLevel);
//        }
        setJobFee( tempJobFee );
        
    }

    @Override
    public void calculateFacilityTaxes(List<Float> sumOfEachJobcosts) {
        float facilityTaxes = 0f;
                
        for (Float sumOfEachJobcost : sumOfEachJobcosts) {
            facilityTaxes += ( sumOfEachJobcost * getSystemCostIndex() * getAdjustment() * getRun() ) * getTaxRate(); // / 100;
        }
        
        System.out.println("");
    }
    
    
    
    /**
     * Get Research Costs
     * @return float
     */
    public float getResearchCosts(){
        return getJobFee();
    }
}