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
import managerindustry.logic.manager.ManagerDB;

/**
 *
 * @author lele
 */
public class StructureEngineeringRigs {
    // unused
    private String nameRig;
//    private String sizeRig;
//    private String tech;
//    private String securityStatus;
//    private String appliesTo;
    // ---------------------------
    
    
    private float calibration;
    private float securityStatusBonus;    
    private float materialEfficiency;
    private float timeEfficiency;          
    private float costBonus;          
    private float timeBonus;                 
    
    public StructureEngineeringRigs(){
        
    }
    
    public StructureEngineeringRigs(String name) {   
        
        InvTypes invTypes = ManagerDB.getInstance().getInvTypes_IdByName(name);

        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDB.getInstance().getDgmTypeAttributes(invTypes.getTypeID());
        
//        System.out.println(""+ invTypes.getTypeName());
        
        nameRig = invTypes.getTypeName();
        
        // DBG NON mi piace creare una cache con una mappa        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
             ManagerDB.getInstance().getDgmAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());


            float bonusRig = getBonusRig(dgmTypeAttribute);
            float bonusSecurityStatus = getSecurityStatus(dgmTypeAttribute, 2357);
            float calibration = getCalibration(dgmTypeAttribute);
                    
            if ( bonusRig != 0)
//                System.out.println(""+ dgmAttributeTypes.getDisplayName() + " "  + bonusRig);
            
            if ( bonusSecurityStatus != 0 ){
//                System.out.println(""+ dgmAttributeTypes.getDisplayName() + " "  + bonusSecurityStatus);
            }
            
            if ( calibration != 0 ){
//                System.out.println(""+ dgmAttributeTypes.getDisplayName() + " "  + calibration);
            }

        }          
    }                   
    
    /**
     * Get Security Status
     * @param DgmTypeAttributes dgmTypeAttribute
     * @param Int idSecurity
     * @return float
     */
    private float getSecurityStatus(DgmTypeAttributes dgmTypeAttribute, int idSecurity){
        /*
        dgmAttributeTypes
        hiSecModifier 2355 null 1.0
        lowSecModifier 2356 null 1.9
        nullSecModifier 2357 null 2.1
        securityModifier 2358 null 1.0        
        */
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();
        
        
        if ( idSecurity == attributeID ){
            securityStatusBonus = dgmTypeAttribute.getValueFloat();
            return securityStatusBonus;
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
        if ( dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID() == 1153 ){
            calibration =  dgmTypeAttribute.getValueFloat();
            return calibration;
        }
        return 0;
    }
    
    /**
     * Get Bonus Rig
     * @param dgmTypeAttribute
     * @return float
     */
    private float getBonusRig(DgmTypeAttributes dgmTypeAttribute){
    /*
        // secondo me ne manca uno il time bonus
        attributeEngRigTimeBonus 2593 
        attributeEngRigMatBonus 2594
        attributeEngRigCostBonus 2595
    */
        
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();
        
        if ( dgmTypeAttribute.getValueFloat() != 0.0 ){
            if ( attributeID == 2593 ){
                timeEfficiency = dgmTypeAttribute.getValueFloat();
                return timeEfficiency;
            }
            
            if ( attributeID == 2594 ){
                materialEfficiency = dgmTypeAttribute.getValueFloat();
                return materialEfficiency;
            }
            
            if ( attributeID == 2595 ){
                costBonus = dgmTypeAttribute.getValueFloat();
                return costBonus;
            }
        }
        return 0;
    }
    
    /**
     * DBG
     */
    public void rigAttibutes(){
        String bpoName = "Standup M-Set Advanced Component Manufacturing Material Efficiency I";
        InvTypes invTypes = ManagerDB.getInstance().getInvTypes_IdByName(bpoName);
        
        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDB.getInstance().getDgmTypeAttributes(invTypes.getTypeID());
        System.out.println(""+ bpoName + " " + invTypes.getTypeID());
        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
             ManagerDB.getInstance().getDgmAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());

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
    
//   /**
//     * Set Applies To
//     * @return String
//     */
//    public String getAppliesTo() {
//        return appliesTo;
//    }
//
//    /**
//     * Get Applies To
//     * @param String appliesTo 
//     */
//    public void setAppliesTo(String appliesTo) {
//        this.appliesTo = appliesTo;
//    }
//   
//    
//    /**
//     * Get Tech
//     * @return String
//     */
//    public String getTech() {
//        return tech;
//    }
//
//    /**
//     * Set Tech
//     * @param String tech 
//     */
//    private void setTech(String tech) {
//        this.tech = tech;
//    }    
//    
//    /**
//     * Get Size Rig
//     * @return String
//     */
//    public String getSizeRig() {
//        return sizeRig;
//    }
//
//    /**
//     * Set Size Rig
//     * @param String sizeRig 
//     */
//    public void setSizeRig(String sizeRig) {
//        this.sizeRig = sizeRig;
//    }
//
//    /**
//     * Get Security Bonus
//     * @return String
//     */
//    public String getSecurityStatus() {
//        return securityStatus;
//    }
//
//    /**
//     * Set Security Bonus
//     * @param String securityStatus 
//     */
//    public void setSecurityStatus(String securityStatus) {
//        this.securityStatus = securityStatus;
//    }
    
}

       // value rigs
        /*
            // 43867 Standup M-Set Advanced Component Manufacturing Material Efficiency I
            hiSecModifier 2355 1.0
            lowSecModifier 2356 1.9
            nullSecModifier 2357 2.1
            securityModifier 2358 1.0
            attributeEngRigTimeBonus 2593 0.0
            attributeEngRigMatBonus 2594 -2.0
            attributeEngRigCostBonus 2595 0.0
            invCategories Category 66 - invGroups Structure Engineering Rig
        
            Standup M-Set Advanced Component Manufacturing Material Efficiency I 
            Standup M-Set Advanced Component Manufacturing Material Efficiency II 

            Standup M-Set Advanced Component Manufacturing Time Efficiency I
            Standup M-Set Advanced Component Manufacturing Time Efficiency II 

            Standup M-Set Blueprint Copy Accelerator I
            Standup M-Set Blueprint Copy Accelerator II 

            Standup M-Set Blueprint Copy Cost Optimization I 
            Standup M-Set Blueprint Copy Cost Optimization II 

            Standup M-Set ME Research Accelerator I  
            Standup M-Set ME Research Accelerator II 

            Standup M-Set TE Research Accelerator I 
            Standup M-Set TE Research Accelerator II 

            Standup M-Set Invention Accelerator I 
            Standup M-Set Invention Accelerator II

            Calcolo Manufactoring ME
            materialReductionManufactoringBonusME_T1 = 2.0 / 100 = 2%
            materialReductionManufactoringBonusME_T2 = 2.4 / 100 = 2,4%
            
            Calcolo Manufactoring TE
            timeReductionManufactoringBonusTE_T1 = materialReductionManufactoringBonusME_T1 * 10 =  20%
            timeReductionManufactoringBonusTE_T2 = materialReductionManufactoringBonusME_T2 * 10 = 24%
        
            Calcolo Cost Reduction
            costReductionBonus_T1 = materialReductionManufactoringBonusME_T1 * 5 = 10%
            costReductionBonus_T2 = materialReductionManufactoringBonusME_T1 * 6 = 12%
        
            Calcolo time reduction
            timeReductionBonus_T1 = timeReductionManufactoringBonusTE_T1 = 20%
            timeReductionBonus_T2 = timeReductionManufactoringBonusTE_T2 = 24%
        */