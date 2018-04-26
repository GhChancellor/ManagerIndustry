/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.unused.structure.Rig_GroupId;

import java.math.BigDecimal;
import java.util.List;
import managerindustry.db.entities.DgmAttributeTypes;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.manager.old.managerDB.ManagerDBEve;

/**
 * dgmAttributeTypes Securiy status 
 * hiSecModifier 2355 null 1.0
 * lowSecModifier 2356 null 1.9
 * nullSecModifier 2357 null 2.1
 * securityModifier 2358 null 1.0  ????
 * attributeEngRigTimeBonus 2593 0.0
 * attributeEngRigMatBonus 2594 -2.0
 * attributeEngRigCostBonus 2595 0.0
 * @author lele
 */
public class UNUSED_StructureEngineeringRigs {
    protected enum RULE_BONUS{
        HI_SEC(2355), 
        LOW_SEC(2356),
        NULL_SEC(2357),
        RIG_TIME_EFFICIENCY(2593),
        RIG_MATERIAL_EFFICIENCY(2594),
        RIG_COST_BONUS(2595),
        CALIBRATION(1153);
        
        private final int code;
        
        private RULE_BONUS rule_bonus;

        private RULE_BONUS(int code) {
            this.code = code;
        }

        private int getCode() {
            return code;
        }
    }    
    
    private float calibration;
    private float securityStatusBonus;    
    private float materialEfficiency; // RIG_MATERIAL_EFFICIENCY(2594),
    private float timeEfficiency; // RIG_TIME_EFFICIENCY(2593),     
    private float costBonus; // RIG_COST_BONUS(2595),          
    private float materialEfficiencyAndSecurityStatus;
    private float timeEfficiencyAndSecurityStatus;
    private float costBonusAndSecurityStatus;
    private String nameRig;
    

    public UNUSED_StructureEngineeringRigs(String name, SecurityStatusEnum securityStatusEnum) {
        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(name);
        nameRig = invTypes.getTypeName();
        
        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDBEve.getInstance().getDgmTypeAttributes(invTypes.getTypeID());
        
        // DBG NON mi piace creare una cache con una mappa        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
             ManagerDBEve.getInstance().getDgmAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());

            setBonusRig(dgmTypeAttribute);
            setSecurityStatus(dgmTypeAttribute, securityStatus(securityStatusEnum));
            setCalibration(dgmTypeAttribute);

        } 
        calcolaValoriSecurityStatusConRig();
//        displayAllValueCalculated();
        displayValue();
    }

    /**
     * DBG
     */
    public void calcolaValoriSecurityStatusConRig(){
        if ( materialEfficiency != 0)
            materialEfficiencyAndSecurityStatus = truncateDecimal(materialEfficiency * securityStatusBonus, 1).floatValue() ;
        
        if ( timeEfficiency != 0)
            timeEfficiencyAndSecurityStatus = truncateDecimal(timeEfficiency * securityStatusBonus, 1).floatValue() ;
        
        if ( costBonus != 0)
            costBonusAndSecurityStatus = truncateDecimal(costBonus * securityStatusBonus, 1).floatValue();
    }

    private static BigDecimal truncateDecimal(float x, int numberofDecimals) {
//        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        if (x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }    
    
    /**
     * dbg
     * Converte un enum security status ( generico ) in un valore leggibile per la classe
     * @param securityStatusEnum
     * @return 
     */
    public RULE_BONUS securityStatus(SecurityStatusEnum securityStatusEnum){
        switch ( securityStatusEnum ){
            case HI_SEC:
                return RULE_BONUS.HI_SEC;
            case LOW_SEC:
                return RULE_BONUS.LOW_SEC;
            case NULL_SEC:
                return RULE_BONUS.NULL_SEC;
            default:
                System.out.println("qualcosa non va RULE_BONUS securityStatus(SecurityStatusEnum securityStatusEnum)");
                return null;
        }
    }
    
    /**
     * Get Calibration from DB
     * @param dgmTypeAttribute
     * @param typeId
     */
    private void setBonusRig(DgmTypeAttributes dgmTypeAttribute){
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();
        
        if ( dgmTypeAttribute.getValueFloat() != 0.0 ){
            if ( attributeID == RULE_BONUS.RIG_TIME_EFFICIENCY.code ){ // 2593
                timeEfficiency = dgmTypeAttribute.getValueFloat();
            }
            
            if ( attributeID == RULE_BONUS.RIG_MATERIAL_EFFICIENCY.code ){ // 2594
                materialEfficiency = dgmTypeAttribute.getValueFloat();
            }
            
            if ( attributeID == RULE_BONUS.RIG_COST_BONUS.code ){ // 2595
                costBonus = dgmTypeAttribute.getValueFloat();
            }            
        }
    }
     
    /**
     * Get Calibration from DB
     * @param dgmTypeAttribute
     * @param typeId
     */
    private void setCalibration(DgmTypeAttributes dgmTypeAttribute){
        if ( dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID() == 
                RULE_BONUS.CALIBRATION.code ){ // 1153
            calibration =  dgmTypeAttribute.getValueFloat();
        }
    }    
    
    /**
     * Get Security Status
     * @param DgmTypeAttributes dgmTypeAttribute
     * @param Int idSecurity
     */
    private void setSecurityStatus(DgmTypeAttributes dgmTypeAttribute, RULE_BONUS idSecurity){
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();

        if ( idSecurity.getCode() == attributeID ){
            securityStatusBonus = dgmTypeAttribute.getValueFloat();
        }
    }        
    
    public UNUSED_StructureEngineeringRigs() {
        displayAllValue();
    }
    
    private void displayAllValueCalculated(){
        System.out.println("StructureEngineeringRigs > displayAllValueCalculated()");
        if ( materialEfficiencyAndSecurityStatus != 0)
            System.out.println("materialEfficiencyAndSecurityStatus " + materialEfficiencyAndSecurityStatus);

        if ( timeEfficiencyAndSecurityStatus != 0)
            System.out.println("timeEfficiencyAndSecurityStatus " + timeEfficiencyAndSecurityStatus);

        if ( costBonusAndSecurityStatus != 0)
            System.out.println("costBonusAndSecurityStatus " + costBonusAndSecurityStatus);        
    }
    
    private void displayValue(){

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
    }
    
    /**
     * Display all value of the rig
     */
    private void displayAllValue(){
        String bpoName = "Standup M-Set Blueprint Copy Accelerator II";
        InvTypes invTypes = ManagerDBEve.getInstance().getInvTypes_IdByName(bpoName);
        
        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDBEve.getInstance().getDgmTypeAttributes(invTypes.getTypeID());
        System.out.println(""+ bpoName + " " + invTypes.getTypeID());
        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
             ManagerDBEve.getInstance().getDgmAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());

            System.out.println("" + dgmAttributeTypes.getAttributeName() + " " + dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID() 
             + " " + dgmTypeAttribute.getValueFloat() );           
        }
    }    
    
    /**
     * Get Cost Bonus without security status
     * @return Double
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
     * Get Name Rig
     * @return String
     */
    public String getNameRig() {
        return nameRig;
    }

}
