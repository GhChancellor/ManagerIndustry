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
    /**
     * BONUS ATTRIBUTE
     */
    private enum ATTRIBUTE_ID_ENUM{
        MANUFACTURING_MATERIAL(2600), // 1% reduction in manufacturing job required materials 2600
        MANUFACTURING_SCIENCE_JOB_TIME(2602), // 15% reduction in manufacturing and science job required time 2602
        MANUFACTURING_SCIENCE_JOB_ISK_COST(2601), // 3% reduction in manufacturing and science job required ISK cost 2601
        FUEL_CONSUMPTIOM(2339), // 25% reduction in Engineering Service Module fuel consumption 2339
        MAX_CALIBRATION_COMPLEX(1132), // Calibration complex 1132
        RIG_SLOTS(1137), // RIG SLOTS 1137
        RIG_SIZE(1547);  // RIG SIZE 1547               
        private int code;
        
        private ATTRIBUTE_ID_ENUM(int code){
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
    private float rigSize;
    private final float baseValue = 1.0f;
    
    public EngineeringComplex() {
    }

    public EngineeringComplex(PlatformEnum nameEngineeringComplex){
        // float roundOff = Math.round(value * 100.0) / 100.0;
        // Math.floor(value * 100) / 100;
        
        int typeId = ManagerDB.getInstance().invTypes().getInvTypesByName(nameEngineeringComplex.getName()).getTypeID();
        
        // MANUFACTURING_MATERIAL
        DgmTypeAttributes dgmTypeAttribute = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.MANUFACTURING_MATERIAL); // 2600               
        reductionManufacturingMaterial = 
          truncateDecimal(baseValue - dgmTypeAttribute.getValueFloat(), 2).floatValue();
        
        // MANUFACTURING_SCIENCE_JOB_ISK_COST
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.MANUFACTURING_SCIENCE_JOB_ISK_COST); // 2601        
        reductionManufacturingScienceJobIskCost = 
          truncateDecimal(baseValue - dgmTypeAttribute.getValueFloat(), 2).floatValue();
        
        // MANUFACTURING_SCIENCE_JOB_TIME
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.MANUFACTURING_SCIENCE_JOB_TIME);// 2602        
        reductionManufacturingScienceJobTime = 
          truncateDecimal(baseValue - dgmTypeAttribute.getValueFloat(), 2).floatValue();
        
        // FUEL_CONSUMPTIOM
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.FUEL_CONSUMPTIOM); // 2339       
        reductionFuelConsumption = dgmTypeAttribute.getValueFloat();

        // MAX_CALIBRATION_COMPLEX 
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.MAX_CALIBRATION_COMPLEX); // 1132
        maxCalibrationComplex = dgmTypeAttribute.getValueFloat();

        // RIG_SLOTS
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.RIG_SLOTS); // 1137       
        maxRigSlot = dgmTypeAttribute.getValueFloat();
        
        // RIG_SIZE
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.RIG_SIZE); // 1547
        rigSize = dgmTypeAttribute.getValueFloat();
                
        this.nameEngineeringComplex = nameEngineeringComplex.getName();        
    }
    
    /**
     * Get bonus station like fuel consumption, manufacturing and science job required time 
     * @param int typeName
     * @param ATTRIBUTE_ID_ENUM attribute_id
     * @return DgmTypeAttributes
     */
    private DgmTypeAttributes getDgmTypeAttributes(int typeId, ATTRIBUTE_ID_ENUM attribute_id){
        return ManagerDB.getInstance().dgmTypeAttributes().getTypeAttributesByTypeId_ByAttributeID(typeId, attribute_id.getCode());
    }
    
    /**
     * Truncate to decimal
     * @param float x
     * @param int numberofDecimals
     * @return BigDecimal
     */
    private static BigDecimal truncateDecimal(float x, int numberofDecimals) {        
//        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        if (x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }        
    }
    
    /**
     * Display Value
     */
    public void displayValue(){
        System.out.println("nameEngineeringComplex " + nameEngineeringComplex);
        System.out.println("reductionManufacturingMaterial " + reductionManufacturingMaterial);
        System.out.println("reductionManufacturingScienceJobIskCost " + reductionManufacturingScienceJobIskCost);
        System.out.println("reductionManufacturingScienceJobTime " + reductionManufacturingScienceJobTime);
        System.out.println("reductionFuelConsumption " + reductionFuelConsumption);
        System.out.println("maxCalibrationComplex " + maxCalibrationComplex);
        System.out.println("rigslot " + maxRigSlot);
        System.out.println("rigsize " + rigSize);
        
        System.out.println("");
    }

    /**
     * Get Rig Size
     * @return float
     */
    public float getRigSize() {
        return rigSize;
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
