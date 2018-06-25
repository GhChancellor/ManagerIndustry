/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.engineeringComplex;

import java.math.BigDecimal;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.logic.enumName.PlatformEnum;
import managerindustry.logic.manager.managerDB.ManagerDB;

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
        MAX_CALIBRATION_COMPLEX(1132), // Calibration complex 1132
        RIG_SLOTS(1137); // RIG SLOTS 1137
                
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
    private float maxRigSlot;
    private final float baseValue = 1.0f;
    
    public EngineeringComplex() {
    }

    // DA OTTIMIZZARE
    public EngineeringComplex(PlatformEnum nameEngineeringComplex ){
        
        // float roundOff = Math.round(value * 100.0) / 100.0;
        // Math.floor(value * 100) / 100;
        DgmTypeAttributes dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getItemDescription(nameEngineeringComplex.getName(), RULE_BONUS.MANUFACTURING_MATERIAL.code); // 2600
        reductionManufacturingMaterial = truncateDecimal(baseValue -dgmTypeAttributes.getValueFloat(), 2).floatValue();
        
        dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getItemDescription(nameEngineeringComplex.getName(), RULE_BONUS.MANUFACTURING_SCIENCE_JOB_ISK_COST.code); // 2601
        reductionManufacturingScienceJobIskCost = truncateDecimal(baseValue -dgmTypeAttributes.getValueFloat(), 2).floatValue();
        
        dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getItemDescription(nameEngineeringComplex.getName(), RULE_BONUS.MANUFACTURING_SCIENCE_JOB_TIME.code); // 2602
        
        reductionManufacturingScienceJobTime = truncateDecimal(baseValue -dgmTypeAttributes.getValueFloat(), 2).floatValue();
        
        dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getItemDescription(nameEngineeringComplex.getName(), RULE_BONUS.FUEL_CONSUMPTIOM.code); // 2339
        reductionFuelConsumption = dgmTypeAttributes.getValueFloat();
        
        dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getItemDescription(nameEngineeringComplex.getName(), RULE_BONUS.MAX_CALIBRATION_COMPLEX.code); // 1132
        maxCalibrationComplex = dgmTypeAttributes.getValueFloat();
        
        dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getItemDescription(nameEngineeringComplex.getName(), RULE_BONUS.RIG_SLOTS.code); // 1137
        maxRigSlot = dgmTypeAttributes.getValueFloat();
        
        this.nameEngineeringComplex = nameEngineeringComplex.getName();
        
        displayValue();
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
        System.out.println("rigslot " + maxRigSlot);
        
        System.out.println("");
    }

    /**
     * Get Max rig Slot
     * @return float
     */
    public float getMaxRigSlot() {
        return maxRigSlot;
    }
        
    /**
     * Get Calibration Max
     * @return float
     */
    public float getMaxCalibrationComplex() {
        return maxCalibrationComplex;
    }
 
    /**
     * Get Name Engineering Complex
     * @return String
     */
    public String getNameEngineeringComplex() {
        return nameEngineeringComplex;
    }

    /**
     * Get Reduction Manufacturing Job
     * @return float
     */
    public float getReductionManufacturingMaterial() {
        return reductionManufacturingMaterial;
    }

    /**
     * Get Reduction Manufacturing Science Job time
     * @return float
     */
    public float getReductionManufacturingScienceJobTime() {
        return reductionManufacturingScienceJobTime;
    }

    /**
     * Get Reduction Manufacturing Science Job Isk Cost
     * @return float
     */
    public float getReductionManufacturingScienceJobIskCost() {
        return reductionManufacturingScienceJobIskCost;
    }

    /**
     * Get Reduction Fuel Consumption
     * @return float
     */
    public float getReductionFuelConsumption() {
        return reductionFuelConsumption;
    }

    /**
     * Get Reduction Fuel Consumption
     * @param float reductionFuelConsumption 
     */
    private void setReductionFuelConsumption(float reductionFuelConsumption) {
        this.reductionFuelConsumption = reductionFuelConsumption;
    }  
}
