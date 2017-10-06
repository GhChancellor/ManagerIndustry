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
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.formulas.itemcost.baseJobCost.BaseJobCost;
import managerindustry.logic.tax.formulas.itemcost.systemCostIndex.SystemCostIndex;

/**
 *
 * @author lele
 */
public class BuildItem extends ItemCost{
    private float facilityTaxes = 0f;
    
    private List < Float > sumOfEachJobcosts = new ArrayList();    
    
    public BuildItem(Map<String, ReportCalculatedComponentX>  reportCalculatedComponentXMap, 
            String solarSystemID, String actvity, int run ,float taxRate) 
             throws SolarSystemNotExistsException, PriceNotExistsException {

        setReportCalculatedComponentX(reportCalculatedComponentXMap);
        setSolarSystemID(solarSystemID);
        setActvity(actvity);
        setRun(run);
        setTaxRate(taxRate);
        
        // ManagerSystemCostIndex > SolarSystemCost > getCostIndexEntity() 
        // setSystemCostIndex( SystemCostIndex.SystemCostIndexDBG(solarSystemID, actvity) );
        setSystemCostIndex( SystemCostIndex.SystemCostIndex(solarSystemID, actvity) );
        
        BaseJobCost baseJobCost = new BaseJobCost();
        
        // BaseJobCost > getBaseJobCostDBG
        setBaseJobCost( baseJobCost.getBaseJobCost(reportCalculatedComponentXMap) );

        sumOfEachJobcosts = baseJobCost.getsumOfEachJobcosts();
        calculateJobInstallationCost();
        calculateFacilityTaxes(sumOfEachJobcosts);
        calculateTotalInstallationCost();
    }
    
    public void calculateJobInstallationCost(){
        setJobFee( getBaseJobCost() * getSystemCostIndex() * getRun() * getAdjustment() ); 
    }
    
    public float getJobInstallationCost(){
        return getJobFee();
    }
}
