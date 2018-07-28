/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringComplex;

import managerindustry.logic.generic.enumName.PlatformEnum;
import managerindustry.logic.manager.db.Db;
import managerindustry.logic.fitter.structure.logic.BaseStructure;
import managerindustry.logic.manager.Manager;

/**
 * https://www.eveonline.com/article/building-dreams-introducing-engineering-complexes/
 * @author lele
 */
public class EngineeringComplex extends BaseStructure{
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

    public EngineeringComplex(PlatformEnum nameEngineeringComplex) {
        int typeId = Manager.getInstance().db().item().invTypes().getInvTypesByName(nameEngineeringComplex.getName()).getTypeID();
        
        // MANUFACTURING_MATERIAL
        reductionManufacturingMaterial = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.MANUFACTURING_MATERIAL.getCode()); // 2600  
        
        // MANUFACTURING_SCIENCE_JOB_ISK_COST
        reductionManufacturingScienceJobTime = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.MANUFACTURING_SCIENCE_JOB_ISK_COST.getCode()); // 2601  
        
        // MANUFACTURING_SCIENCE_JOB_TIME
        reductionManufacturingScienceJobIskCost = 
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.MANUFACTURING_SCIENCE_JOB_TIME.getCode()); // 2602
        
        // FUEL_CONSUMPTIOM
        reductionFuelConsumption =
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.FUEL_CONSUMPTIOM.getCode()); // 2339
        
        // MAX_CALIBRATION_COMPLEX 
        maxCalibrationComplex =
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.MAX_CALIBRATION_COMPLEX.getCode()); // 1132
        
        // RIG_SLOTS
        maxRigSlot =
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.RIG_SLOTS.getCode()); // 1137
        
        // RIG_SIZE
        rigSize =
            getDgmTypeAttributes(typeId, ATTRIBUTE_ID_ENUM.RIG_SIZE.getCode()); // 1547        
        
        this.nameEngineeringComplex = nameEngineeringComplex.getName();
        
        calculedBonus();
    }
   
    /**
     * Calculate bouns engineering complex
     * value bonus = baseValue - reductionManufacturingMaterial
     */
    @Override
    protected void calculedBonus() {       
        byte numberofDecimals = 2;
        
        if (reductionManufacturingMaterial != 0)
            reductionManufacturingMaterial = 
            truncateToDecimal(baseValue - reductionManufacturingMaterial,numberofDecimals);
            
        if (reductionManufacturingScienceJobTime != 0)
            reductionManufacturingScienceJobTime = 
            truncateToDecimal(baseValue - reductionManufacturingScienceJobTime, numberofDecimals);
                    
        if (reductionManufacturingScienceJobIskCost != 0)
            reductionManufacturingScienceJobIskCost = 
            truncateToDecimal(baseValue - reductionManufacturingScienceJobIskCost, numberofDecimals);
    }

    @Override
    /**
     * Display All Value Calculated
     */
    public void displayAllValueCalculated() {
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

    @Override
    public void displayValue() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
