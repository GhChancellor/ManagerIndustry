/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig;

import managerindustry.logic.generic.enumName.RuleBonusRigEnum;
import managerindustry.logic.generic.enumName.SecurityStatusEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.ChooseRig;
import managerindustry.logic.fitter.structure.logic.BaseStructure;
import managerindustry.logic.manager.Manager;

/**
 * https://www.eveonline.com/article/building-dreams-introducing-engineering-complexes/
 * @author lele
 */
public class EngineeringRig extends BaseStructure{
    private float calibration; // CALIBRATION 1153
    private float securityStatusBonus; // HI 2355, Low 2356, Null 2357    
    private float materialEfficiency; // RIG_MATERIAL_EFFICIENCY(2594)
    private float timeEfficiency; // RIG_TIME_EFFICIENCY(2593)
    private float costBonus; // RIG_COST_BONUS(2595)      
    private float materialEfficiency_SecurityStatus;
    private float timeEfficiency_SecurityStatus;
    private float costBonus_SecurityStatus;
    private float rigSize; // 1547
    private int typeID;
    private float maxGroupFitted; // MAX_GROUP_FITTED(1544)

    public EngineeringRig() {
    }

    public EngineeringRig(String nameRig, SecurityStatusEnum securityStatusEnum) throws ErrorExeption {
        typeID = Manager.getInstance().db().item().invTypes().getInvTypesByName(nameRig).getTypeID();
        
        // Init and add to db if not exits
        ChooseRig chooseRig = new ChooseRig(typeID);
        
        // RIG_TIME_EFFICIENCY
        timeEfficiency = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_TIME_EFFICIENCY.getCode()); // 2593
        
        // RIG_MATERIAL_EFFICIENCY
        materialEfficiency = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_MATERIAL_EFFICIENCY.getCode()); // 2594 
                
        // RIG_COST_BONUS
        costBonus = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_COST_BONUS.getCode()); // 2595 
        
        // CALIBRATION
        calibration = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.CALIBRATION.getCode()); // 1153 
        
        // MAX_GROUP_FITTED
        maxGroupFitted = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.MAX_GROUP_FITTED.getCode()); // 1544 
        
        // SecurityStatus
        securityStatusBonus = 
            getDgmTypeAttributes(typeID, getSecurityStatus(securityStatusEnum).getCode() ); // HI 2355, Low 2356, Null 2357

        // Rig Size
        rigSize = getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_SIZE.getCode()); // Rig size 1547();
        
        calculedBonus();     
    }

    /**
     * Calculed Secury Status With Rig
     * value rig = materialEfficiency * securityStatusBonus
     */
    @Override
    protected void calculedBonus() {
        byte numberOfDecimals = 2;
        
        if ( materialEfficiency != 0)
            materialEfficiency_SecurityStatus = 
                truncateToDecimal(materialEfficiency * securityStatusBonus, numberOfDecimals);
        
        if ( timeEfficiency != 0)
            timeEfficiency_SecurityStatus = 
                truncateToDecimal(timeEfficiency * securityStatusBonus, numberOfDecimals);
        
        if ( costBonus != 0)
            costBonus_SecurityStatus = 
                truncateToDecimal(costBonus * securityStatusBonus, numberOfDecimals);
    }
    
    @Override
    public void displayAllValueCalculated() {
        System.out.println("StructureEngineeringRigs > displayAllValueCalculated()");
        if ( materialEfficiency_SecurityStatus != 0)
            System.out.println("materialEfficiencyAndSecurityStatus " + materialEfficiency_SecurityStatus);

        if ( timeEfficiency_SecurityStatus != 0)
            System.out.println("timeEfficiencyAndSecurityStatus " + timeEfficiency_SecurityStatus);

        if ( costBonus_SecurityStatus != 0)
            System.out.println("costBonusAndSecurityStatus " + costBonus_SecurityStatus);
    }

    @Override
    public void displayValue() {
        if ( materialEfficiency != 0)
            System.out.println("materialEfficiency " + materialEfficiency);

        if ( timeEfficiency != 0)
            System.out.println("timeEfficiency " + timeEfficiency);

        if ( costBonus != 0)
            System.out.println("costBonus " + costBonus);

        if ( securityStatusBonus != 0 ){
            System.out.println("securityStatusBonus " + securityStatusBonus);
        }

        if ( calibration != 0 ){
            System.out.println("calibration " + calibration);
        }
        
        if ( rigSize != 0 ){
            System.out.println("Rig Size " + rigSize);
        }
        System.out.println("Max Group Fitted " + maxGroupFitted);
        System.out.println("\n");
    }

    /**
     * Converte un enum security status ( generico ) in un valore leggibile per la classe
     * @param SecurityStatusEnum securityStatusEnum
     * @return RuleBonusRigEnum
     */
    private RuleBonusRigEnum getSecurityStatus(SecurityStatusEnum securityStatusEnum) throws ErrorExeption{
        switch ( securityStatusEnum ){
            case HI_SEC:
                return RuleBonusRigEnum.HI_SEC;
            case LOW_SEC:
                return RuleBonusRigEnum.LOW_SEC;
            case NULL_SEC:
                return RuleBonusRigEnum.NULL_SEC;
            default:
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.SECURITY_STATUS_ERROR); 
        }
    }

    /**
     * Get Cost Bonus without security status
     * @return float
     */
    public float getCostBonus() {
        return costBonus;
    }
   
    /**
     * Get Calibration without security status
     * @return float
     */
    public float getCalibration() {
        return calibration;
    }

    /**
     * Get Material Efficiency without security status
     * @return float
     */
    public float getMaterialEfficiency() {
        return materialEfficiency;
    }

    /**
     * Get Time Efficiency without security status
     * @return float
     */
    public float getTimeEfficiency() {
        return timeEfficiency;
    }

    /**
     * Get multiplication between Material Efficiency and SecurityStatus
     * MaterialEfficiency * SecurityStatus
     * @return float
     */
    public float getMaterialEfficiency_SecurityStatus() {
        return materialEfficiency_SecurityStatus;
    }

    /**
     * Get multiplication between Time Efficiency and SecurityStatus
     * TimeEfficiency * SecurityStatus
     * @return float
     */
    public float getTimeEfficiency_SecurityStatus() {
        return timeEfficiency_SecurityStatus;
    }

    /**
     * Get multiplication between Cost Bonus and SecurityStatus
     * CostBonus * SecurityStatus
     * @return float
     */
    public float getCostBonus_SecurityStatus() {
        return costBonus_SecurityStatus;
    }

    /**
    * Get Type ID
    * @return int
    */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Get max number of rig of the same type that can be installed
     * @return int
     */
    public Float getMaxGroupFitted() {
        return maxGroupFitted;
    }    

    /**
     * Get Rig Size
     * @return float
     */
    public float getRigSize() {
        return rigSize;
    }

}
