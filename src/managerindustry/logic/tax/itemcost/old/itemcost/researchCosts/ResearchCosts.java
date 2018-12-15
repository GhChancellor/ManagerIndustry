/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.itemcost.old.itemcost.researchCosts;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.logic.build.production.old.ReportCalculatedComponentX;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.itemcost.old.itemcost.ItemCost;

/**
 *
 * @author lele
 */
public class ResearchCosts extends ItemCost{
    private List < Integer > values = new ArrayList<>();
    private List < ItemCost > itemCosts = new ArrayList<>();
    private int startLevel;
    private int finishLevel;

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
      throws SolarSystemNotExistsException, ErrorExeption {
        
        // DBG controllare questa funzione
        super(reportCalculatedComponentXMap, solarSystemID, actvity, run, facilityTax);
        this.startLevel = startLevel;
        this.finishLevel = finishLevel;
        
        calculateResearchCosts();
//        calculateFacilityTaxes( getSumOfEachJobcosts() );
//        calculateTotalInstallationCost();        
    }

    /**
     * Calculate Research Costs
     */
    public void calculateResearchCosts(){
        values.add(startLevel);
        values.add(finishLevel);
        
        List< Integer > levels = new ArrayList<>();
        levels.add(0); levels.add(105); levels.add(250); levels.add(595);
        levels.add(1414); levels.add(3360); levels.add(8000); levels.add(19000);
        levels.add(45255); levels.add(107700); levels.add(256000);
        
        if ( startLevel >= finishLevel)
            return;        

        if ( startLevel == 0){
            float tempJobFee = getBaseJobCost() * getSystemCostIndex() 
                    * getPercent() * getAdjustment() * levels.get(finishLevel) / 105;
            setJobFee( tempJobFee );
            calculateFacilityTaxes( getSumOfEachJobcosts() );
            calculateTotalInstallationCost();            
            return;
        }
                
        for (Integer value : values) {
            ItemCost itemCost = new ItemCost();
            float tempJobFee = getBaseJobCost() * getSystemCostIndex() 
                    * getPercent() * getAdjustment() * levels.get(value) / 105;
            
            setJobFee(tempJobFee);
            calculateFacilityTaxes( getSumOfEachJobcosts() );
            calculateTotalInstallationCost();
            
            itemCost.setJobFee( getJobFee() );
            itemCost.setFacilityTaxes( getFacilityTaxes() );
            itemCost.setTotalInstallationCost( getTotalInstallationCost()  );
            itemCosts.add(itemCost);
        }
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

    public void xxx(int i){
        setJobFee( itemCosts.get(i).getJobFee() );
        setFacilityTaxes( itemCosts.get(i).getFacilityTaxes() );
        setTotalInstallationCost( itemCosts.get(i).getTotalInstallationCost()  );
    }
    
    public void xxx2(){
        float tempJobFee = itemCosts.get(1).getJobFee() - itemCosts.get(0).getJobFee();
        float facilityTax = 
          itemCosts.get(1).getFacilityTaxes() - itemCosts.get(0).getFacilityTaxes();
        
        float totalInstallationCost = 
          itemCosts.get(1).getTotalInstallationCost() - 
          itemCosts.get(0).getTotalInstallationCost();
        
        setJobFee(tempJobFee);
        setFacilityTaxes(facilityTax);
        setTotalInstallationCost(totalInstallationCost);
        System.out.println("");
    }
}
