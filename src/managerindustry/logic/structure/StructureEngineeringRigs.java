/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure;

import java.util.List;
import managerindustry.db.entities.DgmAttributeTypes;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 * dgmAttributeTypes Securiy status 
 * hiSecModifier 2355 null 1.0
 * lowSecModifier 2356 null 1.9
 * nullSecModifier 2357 null 2.1
 * securityModifier 2358 null 1.0  
 * @author lele
 */
public class StructureEngineeringRigs {
    protected enum RULE_BONUS{
        HI_SEC(2355), // 
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
    private Float securityStatusBonus;    
    private float materialEfficiency;
    private float timeEfficiency;          
    private float costBonus;          
    private float timeBonus;
    private String nameRig;

    private float getBonusRig(DgmTypeAttributes dgmTypeAttribute){
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();
        
        if ( dgmTypeAttribute.getValueFloat() != 0.0 ){
            if ( attributeID == RULE_BONUS.RIG_TIME_EFFICIENCY.code ){ // 2593
                timeEfficiency = dgmTypeAttribute.getValueFloat();
                return timeEfficiency;
            }
            
            if ( attributeID == RULE_BONUS.RIG_MATERIAL_EFFICIENCY.code ){ // 2594
                materialEfficiency = dgmTypeAttribute.getValueFloat();
                return materialEfficiency;
            }
            
            if ( attributeID == RULE_BONUS.RIG_COST_BONUS.code ){ // 2595
                costBonus = dgmTypeAttribute.getValueFloat();
                return costBonus;
            }            
        }
        return 0;
    }
     
    /**
     * Get Calibration from DB
     * @param dgmTypeAttribute
     * @param typeId
     * @return float
     */
    private float getCalibration(DgmTypeAttributes dgmTypeAttribute){
        /*
        dgmAttributeTypes 
        calibration 1153
        */
        if ( dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID() == 
                RULE_BONUS.CALIBRATION.code ){ // 1153
            calibration =  dgmTypeAttribute.getValueFloat();
            return calibration;
        }
        return 0;
    }    
    
    /**
     * Get Security Status
     * @param DgmTypeAttributes dgmTypeAttribute
     * @param Int idSecurity
     * @return float
     */
    private float getSecurityStatus(DgmTypeAttributes dgmTypeAttribute, RULE_BONUS idSecurity){
        /*
        dgmAttributeTypes
        hiSecModifier 2355 null 1.0
        lowSecModifier 2356 null 1.9
        nullSecModifier 2357 null 2.1
        securityModifier 2358 null 1.0        
        */
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();

        if ( idSecurity.getCode() == attributeID ){
            securityStatusBonus = dgmTypeAttribute.getValueFloat();
            return securityStatusBonus;
        }
        return 0;       
    }    
    
    
    public StructureEngineeringRigs() {
        displayAllValue();
    }
    
    private void displayValue(){
        if ( securityStatusBonus != null ){
            System.out.println("Sicurity status " + securityStatusBonus);
        }
        
    }
    
    /**
     * Display all value of the rig
     */
    private void displayAllValue(){
        String bpoName = "Standup M-Set Advanced Component Manufacturing Material Efficiency I";
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
     * Get Cost Bonus
     * @return Double
     */
    public float getCostBonus() {
        return costBonus;
    }
    
    /**
     * Set Cost Bonus
     * @param Double costBonus 
     */
    public void setCostBonus(float costBonus) {
        this.costBonus = costBonus;
    }

    /**
     * Get Time Bonus
     * @return Double
     */
    public float getTimeBonus() {
        return timeBonus;
    }

    /**
     * Set Time Bonus
     * @param float timeBonus 
     */
    public void setTimeBonus(int timeBonus) {
        this.timeBonus = timeBonus;
    }
   
    /**
     * Get Calibration
     * @return float
     */
    public float getCalibration() {
        return calibration;
    }

    /**
     * Set Calibration
     * @param float calibration 
     */
    public void setCalibration(float calibration) {
        this.calibration = calibration;
    }

    /**
     * Get Material Efficiency
     * @return float
     */
    public float getMaterialEfficiency() {
        return materialEfficiency;
    }

    /**
     * Set Material Efficiency
     * @param Double materialEfficiency 
     */
    public void setMaterialEfficiency(float materialEfficiency) {
        this.materialEfficiency = materialEfficiency;
    }

    /**
     * Get Time Efficiency
     * @return float
     */
    public Float getTimeEfficiency() {
        return timeEfficiency;
    }

    /**
     * Set Time Efficiency
     * @param float timeEfficiency 
     */
    public void setTimeEfficiency(Float timeEfficiency) {
        this.timeEfficiency = timeEfficiency;
    }
    
    /**
     * Get Bonus Security Status
     * @return float
     */
    public float getSecurityStatusBonus() {
        return securityStatusBonus;
    }

    /**
     * Set Bonus Security Status
     * @param float securityStatusBonus 
     */
    public void setSecurityStatusBonus(float securityStatusBonus) {
        this.securityStatusBonus = securityStatusBonus;
    }    

    /**
     * Get NameRig
     * @return String
     */
    public String getNameRig() {
        return nameRig;
    }

    /**
     * Set Name Rig
     * @param String nameRig 
     */
    public void setNameRig(String nameRig) {
        this.nameRig = nameRig;
    }     
}
