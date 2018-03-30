/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure;

import java.math.BigDecimal;
import java.math.RoundingMode;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 * https://community.eveonline.com/news/dev-blogs/building-dreams-introducing-engineering-complexes/
 * raitaru '35825', '2339' structureServiceRoleBonus, NULL, '-25' 
 *  
 * Material bonus for Engineering Complexes Structures 2600 0.99 ( 1 - 0.99 = 0.1 )
 * 1% reduction in manufacturing job required materials 2600
 * 
 * Cost bonus for Engineering Complexes Structures 2601 null 0.97 ( 1 - 0.97 = 0.3 )
 * 3% reduction in manufacturing and science job required ISK cost 2601
 * 
 * Time bonus for Engineering Complexes Structures 2602 null 0.85 ( 1 - 0.85 = 0.15 )
 * 15% reduction in manufacturing and science job required time 2602 
 * 
 * 25% reduction in Engineering Service Module fuel consumption 2339
 * 
 * Calibration station 1132
 * @author lele
 */
public class EngineeringComplex {
    
    public enum RULE_BONUS{
        MANUFACTURING_MATERIAL(2600), // 1% reduction in manufacturing job required materials 2600
        MANUFACTURING_SCIENCE_JOB_TIME(2602), // 15% reduction in manufacturing and science job required time 2602
        MANUFACTURING_SCIENCE_JOB_ISK_COST(2601), // 3% reduction in manufacturing and science job required ISK cost 2601
        FUEL_CONSUMPTIOM(2339), // 25% reduction in Engineering Service Module fuel consumption 2339
        MAX_CALIBRATION_COMPLEX(1132); // Calibration station 1132// Calibration station 1132
                
        private int code;
        
        private RULE_BONUS(int code){
            this.code = code;
        }
        
        public int getCode() {
            return code;
        }    
    }   
    
    private String nameEngineeringComplex;
    // DBG il Double è più che suffiencente
    private float reductionManufacturingMaterial; // 2600
    private float reductionManufacturingScienceJobTime; // 2602
    private float reductionManufacturingScienceJobIskCost; // 2601
    private float reductionFuelConsumption; // 2339
    private float maxCalibrationComplex; // 1132
    private final float baseValue = 1.0f;
    
    public EngineeringComplex() {
    }

    public EngineeringComplex(String nameEngineeringComplex){
        
        // float roundOff = Math.round(value * 100.0) / 100.0;
        // Math.floor(value * 100) / 100;
        DgmTypeAttributes dgmTypeAttributes = ManagerDBEve.getInstance().getItemDescription(nameEngineeringComplex, RULE_BONUS.MANUFACTURING_MATERIAL.code); // 2600
        reductionManufacturingMaterial = truncateDecimal(baseValue -dgmTypeAttributes.getValueFloat(), 2).floatValue();
        
        dgmTypeAttributes = ManagerDBEve.getInstance().getItemDescription(nameEngineeringComplex, RULE_BONUS.MANUFACTURING_SCIENCE_JOB_ISK_COST.code); // 2601
        reductionManufacturingScienceJobIskCost = truncateDecimal(baseValue -dgmTypeAttributes.getValueFloat(), 2).floatValue();
        
        dgmTypeAttributes = ManagerDBEve.getInstance().getItemDescription(nameEngineeringComplex, RULE_BONUS.MANUFACTURING_SCIENCE_JOB_TIME.code); // 2602
        
        reductionManufacturingScienceJobTime = truncateDecimal(baseValue -dgmTypeAttributes.getValueFloat(), 2).floatValue();
        
        dgmTypeAttributes = ManagerDBEve.getInstance().getItemDescription(nameEngineeringComplex, RULE_BONUS.FUEL_CONSUMPTIOM.code); // 2339
        reductionFuelConsumption = dgmTypeAttributes.getValueFloat();
        
        dgmTypeAttributes = ManagerDBEve.getInstance().getItemDescription(nameEngineeringComplex, RULE_BONUS.MAX_CALIBRATION_COMPLEX.code); // 1132
        maxCalibrationComplex = dgmTypeAttributes.getValueFloat();
        
        this.nameEngineeringComplex = nameEngineeringComplex;
        
//         displayValue();
    } 
    
    private static BigDecimal truncateDecimal(float x, int numberofDecimals) {
        
//        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        if (x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
        
    }
    
    private void displayValue(){
        System.out.println("nameEngineeringComplex " + this.nameEngineeringComplex);
        System.out.println("reductionManufacturingMaterial " + reductionManufacturingMaterial);
        System.out.println("reductionManufacturingScienceJobIskCost " + reductionManufacturingScienceJobIskCost);
        System.out.println("reductionManufacturingScienceJobTime " + reductionManufacturingScienceJobTime);
        System.out.println("reductionFuelConsumption " + reductionFuelConsumption);
        System.out.println("maxCalibrationComplex " + maxCalibrationComplex);
        
        System.out.println("");
    }
    
    /**
     * Get Calibration Max
     * @return int
     */
    public float getMaxCalibrationComplex() {
        return maxCalibrationComplex;
    }

    /**
     * Set Calibration max
     * @param int maxCalibrationComplex 
     */
    public void setMaxCalibrationComplex(float maxCalibrationComplex) {
        this.maxCalibrationComplex = maxCalibrationComplex;
    }
 
    /**
     * Get Name Engineering Complex
     * @return String
     */
    public String getNameEngineeringComplex() {
        return nameEngineeringComplex;
    }

    /**
     * Set Name Engineering Complex
     * @param String nameEngineeringComplex 
     */
    private void setNameEngineeringComplex(String nameEngineeringComplex) {
        this.nameEngineeringComplex = nameEngineeringComplex;
    }

    /**
     * Get Reduction Manufacturing Job
     * @return Double
     */
    public float getReductionManufacturingMaterial() {
        return reductionManufacturingMaterial;
    }

    /**
     * Set Reduction Manufacturing Job
     * @param Double reductionManufacturingMaterial 
     */
    private void setReductionManufacturingMaterial(float reductionManufacturingMaterial) {
        this.reductionManufacturingMaterial = reductionManufacturingMaterial;
    }

    /**
     * Get Reduction Manufacturing Science Job time
     * @return Double
     */
    public float getReductionManufacturingScienceJobTime() {
        return reductionManufacturingScienceJobTime;
    }

    /**
     * Set Reduction Manufacturing Science Job time
     * @param Double reductionManufacturingScienceJobTime 
     */
    private void setReductionManufacturingScienceJobTime(float reductionManufacturingScienceJobTime) {
        this.reductionManufacturingScienceJobTime = reductionManufacturingScienceJobTime;
    }

    /**
     * Get Reduction Manufacturing Science Job Isk Cost
     * @return Double
     */
    public float getReductionManufacturingScienceJobIskCost() {
        return reductionManufacturingScienceJobIskCost;
    }

    /**
     * Set Reduction ManufacturingS cience Job Isk Cost
     * @param Double reductionManufacturingScienceJobIskCost 
     */
    private void setReductionManufacturingScienceJobIskCost(float reductionManufacturingScienceJobIskCost) {
        this.reductionManufacturingScienceJobIskCost = reductionManufacturingScienceJobIskCost;
    }

    /**
     * Get Reduction Fuel Consumption
     * @return Double
     */
    public float getReductionFuelConsumption() {
        return reductionFuelConsumption;
    }

    /**
     * Get Reduction Fuel Consumption
     * @param Double reductionFuelConsumption 
     */
    private void setReductionFuelConsumption(float reductionFuelConsumption) {
        this.reductionFuelConsumption = reductionFuelConsumption;
    }  
}
