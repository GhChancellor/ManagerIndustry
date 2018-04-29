/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.DgmAttributeTypes;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.enumName.RuleBonusRigEnum;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.enumName.TierEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.ManagerErrorExecption;
import managerindustry.logic.manager.managerDB.ManagerDB;
//import managerindustry.logic.manager.old.managerDB.ManagerDBEve;
import managerindustry.logic.structure.fakeRig.FakeRig;

/**
 * https://community.eveonline.com/news/dev-blogs/building-dreams-introducing-engineering-complexes/
 * dgmAttributeTypes Securiy status 
 * hiSecModifier 2355 null 1.0
 * lowSecModifier 2356 null 1.9
 * nullSecModifier 2357 null 2.1
 * securityModifier 2358 null 1.0  ????
 * attributeEngRigTimeBonus 2593 0.0
 * attributeEngRigMatBonus 2594 -2.0
 * attributeEngRigCostBonus 2595 0.0
 * maxGroupFitted 1544
 * @author lele
 */
public class StructureEngineeringRigs {
    private List<FakeRig> rigCouples = new ArrayList<>();   
    
    private float calibration;
    private float securityStatusBonus;    
    private float materialEfficiency; // RIG_MATERIAL_EFFICIENCY(2594)
    private float timeEfficiency; // RIG_TIME_EFFICIENCY(2593)
    private float costBonus; // RIG_COST_BONUS(2595)      
    private float materialEfficiencyAndSecurityStatus;
    private float timeEfficiencyAndSecurityStatus;
    private float costBonusAndSecurityStatus;
    private int typeID;
    private float maxGroupFitted; // MAX_GROUP_FITTED(1544)
    boolean bonusRigBln = true;
    boolean securityStatusBln = true;
    boolean calibrationBln = true;
    boolean maxGroupFittedBln = true;    
//    private String nameRig;
    
    /**
     * Gestione dei rig
     * @param String nameRig
     * @param SecurityStatusEnum securityStatusEnum 
     */
    public StructureEngineeringRigs(String nameRig, SecurityStatusEnum securityStatusEnum){
        typeID = ManagerDB.getInstance().invTypes().getIdByName(nameRig).getTypeID();
               
        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getTypeAttributes(typeID);
        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
              ManagerDB.getInstance().dgmAttributeTypes().getAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());

            if ( bonusRigBln )
                setBonusRig(dgmTypeAttribute);
            
            if ( securityStatusBln )
                setSecurityStatus(dgmTypeAttribute, securityStatus(securityStatusEnum));
            
            if ( calibrationBln )
                setCalibration(dgmTypeAttribute);
            
            if ( maxGroupFittedBln )
                setMaxGroupFitted(dgmTypeAttribute);
        } 

        calculedSecuryStatusWithRig();
//        displayAllValueCalculated();
        displayValue();        
    }
    
    /**
     * @deprecated 
     * DBG DA OTTIMIZZARE
     * @param TierEnum tier
     * @param RuleBonusRigEnum materialTimeCostBonus
     * @param SecurityStatusEnum securityStatusEnum 
     */
    public StructureEngineeringRigs(TierEnum tier, RuleBonusRigEnum materialTimeCostBonus, SecurityStatusEnum securityStatusEnum) {
        initDbBackUp();
        
        typeID = getFakeRig( tier, materialTimeCostBonus);
               
        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getTypeAttributes(typeID);
        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
              ManagerDB.getInstance().dgmAttributeTypes().getAttributeTypes(dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());

            if ( bonusRigBln )
                setBonusRig(dgmTypeAttribute);
            
            if ( securityStatusBln )
                setSecurityStatus(dgmTypeAttribute, securityStatus(securityStatusEnum));
            
            if ( calibrationBln )
                setCalibration(dgmTypeAttribute);
            
            if ( maxGroupFittedBln )
                setMaxGroupFitted(dgmTypeAttribute);
        } 

        calculedSecuryStatusWithRig();
//        displayAllValueCalculated();
        displayValue();
    }

    /**
     * Set Max Group Fitted
     * @param DgmTypeAttributes dgmTypeAttribute 
     */
    private void setMaxGroupFitted(DgmTypeAttributes dgmTypeAttribute){
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();
        
        if (attributeID == RuleBonusRigEnum.MAX_GROUP_FITTED.getCode()){
            this.maxGroupFitted = dgmTypeAttribute.getValueFloat();
            maxGroupFittedBln = false;
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
     * @param SecurityStatusEnum securityStatusEnum
     * @return RuleBonusRigEnum
     */
    public RuleBonusRigEnum securityStatus(SecurityStatusEnum securityStatusEnum){
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
     * Get Calibration from DB
     * @param DgmTypeAttributes dgmTypeAttribute
     */
    private void setBonusRig(DgmTypeAttributes dgmTypeAttribute){
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();
        
        if ( dgmTypeAttribute.getValueFloat() != 0.0 ){
            if ( attributeID == RuleBonusRigEnum.RIG_TIME_EFFICIENCY.getCode() ){ // 2593
                timeEfficiency = dgmTypeAttribute.getValueFloat();
                bonusRigBln = false;
                return;
            }
            
            if ( attributeID == RuleBonusRigEnum.RIG_MATERIAL_EFFICIENCY.getCode() ){ // 2594
                materialEfficiency = dgmTypeAttribute.getValueFloat();
                bonusRigBln = false;
                return;
            }
            
            if ( attributeID == RuleBonusRigEnum.RIG_COST_BONUS.getCode() ){ // 2595
                costBonus = dgmTypeAttribute.getValueFloat();
                bonusRigBln = false;
                return;
            }            
        }
    }
     
    /**
     * Get Calibration from DB
     * @param DgmTypeAttributes dgmTypeAttribute
     */
    private void setCalibration(DgmTypeAttributes dgmTypeAttribute){
        if ( dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID() == 
                RuleBonusRigEnum.CALIBRATION.getCode() ){ // 1153
            calibration =  dgmTypeAttribute.getValueFloat();
            calibrationBln = false;
        }
    }    
    
    /**
     * Get Security Status
     * @param DgmTypeAttributes dgmTypeAttribute
     * @param RuleBonusRigEnum idSecurity
     */
    private void setSecurityStatus(DgmTypeAttributes dgmTypeAttribute, RuleBonusRigEnum idSecurity){
        int attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();

        if ( idSecurity.getCode() == attributeID ){
            securityStatusBonus = dgmTypeAttribute.getValueFloat();
            securityStatusBln = false;
        }
    }        
    
    public StructureEngineeringRigs() {
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
        
        System.out.println("Max Group Fitted " + maxGroupFitted);
    }
    
    /**
     * Display all value of the rig
     */
    private void displayAllValue(){
        String bpoName = "Standup M-Set Blueprint Copy Accelerator II";
        int typeId = ManagerDB.getInstance().invTypes().getIdByName(bpoName).getTypeID();
        
        List < DgmTypeAttributes > dgmTypeAttributes = ManagerDB.getInstance().dgmTypeAttributes().getTypeAttributes(typeId);

        System.out.println(""+ bpoName + " " + typeId);
        
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
           
            DgmAttributeTypes dgmAttributeTypes = 
               ManagerDB.getInstance().dgmAttributeTypes().getAttributeTypes
              (dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID());

            System.out.println("" + dgmAttributeTypes.getAttributeName() + " " + dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID() 
             + " " + dgmTypeAttribute.getValueFloat() );           
        }
    }    
    
//    /**
//     * Chooce tier ( T1 or T2 )
//     * @param TierEnum tier
//     * @return RuleBonusRigEnum
//     */
//    private RuleBonusRigEnum getTier(TierEnum tier){
//        RuleBonusRigEnum tierX;
//        
//        if (tier == TierEnum.T1){
//            tierX = RuleBonusRigEnum.T1;
//        }else{
//            tierX = RuleBonusRigEnum.T2;
//        }
//        return tierX;
//    }
    
    /**
    * Create DB
    * Manufacturing Material Efficiency T1 43920 - 37156 / T2 43921 - 37157
    * Manufacturing Time Efficiency T1 37160 - 37148 / T2 37161 - 37149
    * Cost Optimization T1 43891 - 43885 / T2 43884 - 43890
    */
    private void initDbBackUp(){
        // Manufacturing Material Efficiency T1
        rigCouples.add(new FakeRig(43920, 37156, TierEnum.T1, RuleBonusRigEnum.RIG_MATERIAL_EFFICIENCY));        
        // Manufacturing Material Efficiency T2
        rigCouples.add(new FakeRig(43921, 37156, TierEnum.T2, RuleBonusRigEnum.RIG_MATERIAL_EFFICIENCY));
        
        // Manufacturing Time Efficiency T1
        rigCouples.add(new FakeRig(37160, 37148, TierEnum.T1, RuleBonusRigEnum.RIG_TIME_EFFICIENCY));        
        // Manufacturing Time Efficiency T2
        rigCouples.add(new FakeRig(37161, 37149, TierEnum.T2, RuleBonusRigEnum.RIG_TIME_EFFICIENCY)) ;
        
        // Cost Optimization T1
        rigCouples.add(new FakeRig(43891, 43885, TierEnum.T1, RuleBonusRigEnum.RIG_COST_BONUS));         
        // Cost Optimization T2
        rigCouples.add(new FakeRig(43884, 43890, TierEnum.T2, RuleBonusRigEnum.RIG_COST_BONUS));         
    }
    
    /**
     * Take a value of rig t1 or t2
     * @param TierEnum tier
     * @param RuleBonusRigEnum typeBonus
     * @return 
     */
    private int getFakeRig(TierEnum tier, RuleBonusRigEnum typeBonus){
        for (FakeRig rigCouple : rigCouples) {
            if ( rigCouple.getTier() == tier && rigCouple.getRule_bonus() == typeBonus ){
                Integer typeId = ManagerDB.getInstance().invTypes().getNameById(rigCouple.getId()).getTypeID();

                if ( typeId != null ){
                    return typeId;
                }
                
                typeId = ManagerDB.getInstance().invTypes().getNameById(rigCouple.getId()).getTypeID();
                return typeId;
            }
        }
        return -33333;
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
