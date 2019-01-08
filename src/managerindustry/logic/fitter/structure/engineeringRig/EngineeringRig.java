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
 * https://forums.eveonline.com/t/math-is-hard-between-eve-and-the-sheets/70360/2
 * https://community.eveonline.com/news/dev-blogs/eve-industry-all-you-want-to-know/
 * https://www.eveonline.com/article/building-dreams-introducing-engineering-complexes/
 * 
 * Material Efficiency Formula
    Material Efficiency Research, ME 1-10 == 1-10%
    Basic Structure ME multiplier: 0.01 == 1%
    Rig ME multiplier: 2% (T1) and 2.4% (T2) == 0,02 or 0,024
    Security Multiplier: 1, 1.9 or 2.1 == Highsec, Lowsec or Null/WH
* 
    Minerals Needed = Roundup(BaseMinerals * ((1 - ME-Reserch) * (1 - BS_ME) * (1 - (RigME * SM))))
    Example T2 Sotiyo in Null/WH: Mineral Needed = Roundup(BaseMenirals * (0.9 * 0.99 * 0.9496)) = Roundup(BaseMinerals * 0.8461)

    note: Total ME reduction is 15.39% approximate
* 
    * Time Efficiency Formula
        Time Efficiency Research, TE 2-20 == 2-20%
        Basic Structure TE multiplier: 0.15, 0.2 and 0.3 == 15, 20 and 30%
        Rig TE multiplier: 20% (T1) or 24% (T2) = 0.2 or 0.24
        Security Multiplier: 1, 1.9 or 2.1 == Highsec, Lowsec or Null/WH
        Implant Multiplier: 0.01, 0.02 or 0.04 == 1%, 2% or 4%
        Job Time = Roundup(BaseJobTime * ((1 - TE-Reserch) * (1 - BS_TE) * (1 - IM) * (1 - (RigME * SM))))
* 
    Example T2 Sotiyo in Null/WH: Job Time = Roundup(BaseJobTime * (0.8 * 0.7 * 0.96 * (1 - (0.24 * 2.1)))) = Roundup(BaseJobTime * 0,2666496)

    note: Total TE reduction is 73.34% approximatel
 * @author lele
 */
public class EngineeringRig extends BaseStructure{
    private final float baseValue = 1.0f;    
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
        
        /* Init and add to db if not exits */
        ChooseRig chooseRig = new ChooseRig(typeID);
        
        /* RIG_TIME_EFFICIENCY */
        timeEfficiency = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_TIME_EFFICIENCY.getCode()); // 2593
        
        /* RIG_MATERIAL_EFFICIENCY */
        materialEfficiency = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_MATERIAL_EFFICIENCY.getCode()); // 2594 
                
        /* RIG_COST_BONUS */
        costBonus = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_COST_BONUS.getCode()); // 2595 
        
        /* CALIBRATION */
        calibration = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.CALIBRATION.getCode()); // 1153 
        
        /* MAX_GROUP_FITTED */
        maxGroupFitted = 
            getDgmTypeAttributes(typeID, RuleBonusRigEnum.MAX_GROUP_FITTED.getCode()); // 1544 
        
        /* Security Status */
        securityStatusBonus = 
            getDgmTypeAttributes(typeID, getSecurityStatus(securityStatusEnum).getCode() ); // HI 2355, Low 2356, Null 2357

        /* Rig Size */
        rigSize = getDgmTypeAttributes(typeID, RuleBonusRigEnum.RIG_SIZE.getCode()); // Rig size 1547();
        
        calculedBonus();     
    }

    /**
     * Calculed Secury Status With Rig
     * il database da un val
     * value rig = materialEfficiency * securityStatusBonus
     */
    @Override
    protected void calculedBonus() {
//        byte numberOfDecimals = 2;
        
        if ( materialEfficiency != 0){
            /* il database da un valore di -2 (negativo) invece di 2 (positivo) */
            materialEfficiency = -materialEfficiency;

            materialEfficiency_SecurityStatus = 
                baseValue - (((materialEfficiency / 100 ) *  securityStatusBonus )  );                    
        }

        
//        if ( materialEfficiency != 0){
//            materialEfficiency = -materialEfficiency;
//        
//            tempValue = baseValue - (((materialEfficiency / 100 ) *  securityStatusBonus )  );        
//            materialEfficiency_SecurityStatus = 
//                truncateToDecimal(tempValue, numberOfDecimals);            
//        }


//        if ( timeEfficiency != 0){
//            tempValue = baseValue - (timeEfficiency * securityStatusBonus);
//            timeEfficiency_SecurityStatus = 
//                truncateToDecimal(tempValue, numberOfDecimals);           
//        }
//
//        
//        if ( costBonus != 0){
//            tempValue = baseValue - (costBonus * securityStatusBonus);
//            costBonus_SecurityStatus = 
//                truncateToDecimal(tempValue * securityStatusBonus, numberOfDecimals);            
//        }

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
