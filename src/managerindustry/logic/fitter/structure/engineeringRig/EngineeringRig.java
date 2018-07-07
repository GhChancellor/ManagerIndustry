/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig;

import managerindustry.logic.enumName.RuleBonusRigEnum;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.ManagerErrorExecption;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.fitter.structure.logic.BaseStructure;

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
    private float materialEfficiencyAndSecurityStatus;
    private float timeEfficiencyAndSecurityStatus;
    private float costBonusAndSecurityStatus;
    private float rigSize; // 1547
    private int typeID;
    private float maxGroupFitted; // MAX_GROUP_FITTED(1544)

    public EngineeringRig(String nameRig, SecurityStatusEnum securityStatusEnum) {
        typeID = ManagerDB.getInstance().invTypes().getInvTypesByName(nameRig).getTypeID();
        
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
        if ( materialEfficiency != 0)
            materialEfficiencyAndSecurityStatus = 
                truncateToDecimal(materialEfficiency * securityStatusBonus, 2);
        
        if ( timeEfficiency != 0)
            timeEfficiencyAndSecurityStatus = 
                truncateToDecimal(timeEfficiency * securityStatusBonus, 2);
        
        if ( costBonus != 0)
            costBonusAndSecurityStatus = 
                truncateToDecimal(costBonus * securityStatusBonus, 2);
    }
    
    @Override
    public void displayAllValueCalculated() {
        System.out.println("StructureEngineeringRigs > displayAllValueCalculated()");
        if ( materialEfficiencyAndSecurityStatus != 0)
            System.out.println("materialEfficiencyAndSecurityStatus " + materialEfficiencyAndSecurityStatus);

        if ( timeEfficiencyAndSecurityStatus != 0)
            System.out.println("timeEfficiencyAndSecurityStatus " + timeEfficiencyAndSecurityStatus);

        if ( costBonusAndSecurityStatus != 0)
            System.out.println("costBonusAndSecurityStatus " + costBonusAndSecurityStatus);
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
    }

    /**
     * Converte un enum security status ( generico ) in un valore leggibile per la classe
     * @param SecurityStatusEnum securityStatusEnum
     * @return RuleBonusRigEnum
     */
    private RuleBonusRigEnum getSecurityStatus(SecurityStatusEnum securityStatusEnum){
        switch ( securityStatusEnum ){
            case HI_SEC:
                return RuleBonusRigEnum.HI_SEC;
            case LOW_SEC:
                return RuleBonusRigEnum.LOW_SEC;
            case NULL_SEC:
                return RuleBonusRigEnum.NULL_SEC;
            default:
                ManagerErrorExecption.getErrorExecption(ErrorExeption.ErrorExeptionEnum.SECURITY_STATUS_ERROR);
                return null;
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
    public float getMaterialEfficiencyAndSecurityStatus() {
        return materialEfficiencyAndSecurityStatus;
    }

    /**
     * Get multiplication between Time Efficiency and SecurityStatus
     * TimeEfficiency * SecurityStatus
     * @return float
     */
    public float getTimeEfficiencyAndSecurityStatus() {
        return timeEfficiencyAndSecurityStatus;
    }

    /**
     * Get multiplication between Cost Bonus and SecurityStatus
     * CostBonus * SecurityStatus
     * @return float
     */
    public float getCostBonusAndSecurityStatus() {
        return costBonusAndSecurityStatus;
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
