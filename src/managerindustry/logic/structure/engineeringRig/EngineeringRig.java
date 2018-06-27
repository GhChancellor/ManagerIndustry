/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.engineeringRig;

import java.math.BigDecimal;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.logic.enumName.RuleBonusRigEnum;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.ManagerErrorExecption;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class EngineeringRig {
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
        DgmTypeAttributes dgmTypeAttribute = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_TIME_EFFICIENCY); // 2593 
        timeEfficiency = dgmTypeAttribute.getValueFloat();
        
        // RIG_MATERIAL_EFFICIENCY
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_MATERIAL_EFFICIENCY); // 2594 
        materialEfficiency = dgmTypeAttribute.getValueFloat();
        
        // RIG_COST_BONUS
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_COST_BONUS); // 2595 
        costBonus = dgmTypeAttribute.getValueFloat();
        
        // CALIBRATION
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.CALIBRATION); // 1153 
        calibration = dgmTypeAttribute.getValueFloat();
        
        // MAX_GROUP_FITTED
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.MAX_GROUP_FITTED); // 1544 
        maxGroupFitted = dgmTypeAttribute.getValueFloat();
        
        // SecurityStatus
        dgmTypeAttribute = 
            getDgmTypeAttributes(typeID, getSecurityStatus(securityStatusEnum)); // HI 2355, Low 2356, Null 2357
        securityStatusBonus = dgmTypeAttribute.getValueFloat();
        
        calculedSecuryStatusWithRig();
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
     * Calculed Secury Status With Rig
     */
    private void calculedSecuryStatusWithRig(){
        if ( materialEfficiency != 0)
            materialEfficiencyAndSecurityStatus = truncateDecimal(materialEfficiency * securityStatusBonus, 1).floatValue() ;
        
        if ( timeEfficiency != 0)
            timeEfficiencyAndSecurityStatus = truncateDecimal(timeEfficiency * securityStatusBonus, 1).floatValue() ;
        
        if ( costBonus != 0)
            costBonusAndSecurityStatus = truncateDecimal(costBonus * securityStatusBonus, 1).floatValue();
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
    
    
    public void displayAllValueCalculated(){
        System.out.println("StructureEngineeringRigs > displayAllValueCalculated()");
        if ( materialEfficiencyAndSecurityStatus != 0)
            System.out.println("materialEfficiencyAndSecurityStatus " + materialEfficiencyAndSecurityStatus);

        if ( timeEfficiencyAndSecurityStatus != 0)
            System.out.println("timeEfficiencyAndSecurityStatus " + timeEfficiencyAndSecurityStatus);

        if ( costBonusAndSecurityStatus != 0)
            System.out.println("costBonusAndSecurityStatus " + costBonusAndSecurityStatus);        
    }
    
    public void displayValue(){
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
        
        System.out.println("Max Group Fitted " + maxGroupFitted);
    }    
    
    /**
     * Get bonus station like fuel consumption, manufacturing and science job required time 
     * @param int typeName
     * @param ATTRIBUTE_ID_ENUM attribute_id
     * @return DgmTypeAttributes
     */
    private DgmTypeAttributes getDgmTypeAttributes(int typeId, RuleBonusRigEnum attribute_id){
        return ManagerDB.getInstance().dgmTypeAttributes().getTypeAttributesByTypeId_ByAttributeID(typeId, attribute_id.getCode());
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
    public float getMaxGroupFitted() {
        return maxGroupFitted;
    }
    
}
