/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.itemcost.installationCost.researchCosts;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.tax.itemcost.logic.ItemCost.InstallationCost;
import managerindustry.logic.generic.fatherClass.ItemCostBase;

/**
 *
 * @author lele
 */
public class ResearchCosts extends InstallationCost {
    private float tempJobFee;
    private List < Byte > values = new ArrayList<>();
    private List < ItemCostBase > itemCosts = new ArrayList<>();
    private List< Integer > levels = new ArrayList<>();
    
//    private enum SubtractionEnum{
//        FIRST_VALUE( (byte) 0),
//        SECOND_VALUE( (byte) 1);
//        
//        private SubtractionEnum(byte value) {
//            this.value = value;
//        }
//                
//        private byte value;
//
//        public byte getValue() {
//            return value;
//        }
//    }
    
    public ResearchCosts(ItemCostBase itemCostBase) throws SolarSystemNotExistsException, ErrorExeption {
        super(itemCostBase);
        initLevelValue(); 
        init();        
    }

    @Override
    protected void init() {
        if ( itemCostBase.getLevelStar() >= itemCostBase.getLevelFinish())
            return;            
        
        if (itemCostBase.getLevelStar() == 0){
            calculateInstallationCost(itemCostBase.getLevelFinish());
            calculateFacilityTaxes();
            calculateTotalInstallationCost();
            return;
        }
        
        for (byte value : values) {
            calculateInstallationCost(value);
            ItemCostBase itemCostBase_ = new ItemCostBase();
            itemCostBase_.setJobFee( itemCostBase.getJobFee() );
            itemCostBase_.setFacilityTaxes( itemCostBase.getFacilityTaxes() );
            itemCostBase_.setTotalInstallationCost( itemCostBase.getTotalInstallationCost());
            itemCosts.add( itemCostBase_);
        }  
    }
    
    /**
     * Init Level value
     */
    private void initLevelValue(){
        values.add(itemCostBase.getLevelStar());
        values.add(itemCostBase.getLevelFinish());
        
        levels.add(0); levels.add(105); levels.add(250); levels.add(595);
        levels.add(1414); levels.add(3360); levels.add(8000); levels.add(19000);
        levels.add(45255); levels.add(107700); levels.add(256000);        
    }
    /**
     * Calculate Facility Taxes
     */
    @Override
    protected void calculateFacilityTaxes() {
        itemCostBase.setFacilityTaxes( 
            itemCostBase.getJobFee() * itemCostBase.getTaxRateStation() );
    }
        
    /**
     * Get Research Costs
     * @return float
     */
    public float getResearchCosts(){
        return itemCostBase.getJobFee();
    }    

    /**
     * Research cost
     * @param level 
     */
    private void calculateInstallationCost(byte level) {
        tempJobFee = itemCostBase.getBaseJobCost() * 
            itemCostBase.getSystemCostIndex() *
            itemCostBase.getPercent() * itemCostBase.getAdjustment() * 
            levels.get(level) / 105;
        itemCostBase.setJobFee(tempJobFee);        
    }    
    
    @Override
    protected void calculateInstallationCost() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void subtraction(){
        byte firstValue = 0;
        byte secondValue = 1;
        
        float tempJobFee = itemCosts.get( secondValue ).getJobFee() -
            itemCosts.get( firstValue ).getJobFee();
        
        float facilityTax = itemCosts.get( secondValue ).getFacilityTaxes() -
            itemCosts.get( firstValue ).getFacilityTaxes();
        
        float totalInstallationCost = 
            itemCosts.get( secondValue ).getTotalInstallationCost() -
            itemCosts.get( firstValue ).getTotalInstallationCost();
        
        itemCostBase.setJobFee(tempJobFee);
        itemCostBase.setFacilityTaxes(facilityTax);
        itemCostBase.setTotalInstallationCost(totalInstallationCost);
    }
}
