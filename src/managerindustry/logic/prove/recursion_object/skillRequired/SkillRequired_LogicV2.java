/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.skillRequired;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.db.entities.eve.IndustryActivitySkills;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.recursion_object.genericRequiredItem.requiredMaterial.RequiredSkillV2;

/**
 *
 * @author lele
 */
public class SkillRequired_LogicV2 < C, D, E, F, G > 
    extends RequiredSkillV2 < List<SkillInfo>, SkillInfo, C, D, E, F, G >{
    
    private enum SkillEnum{
        PRIMARY_SKILL(182, 277),
        SECONDARY_SKILL(183, 278), 
        TERTIARY_SKILL(184, 279);
        
        private int attributeID_1; // father skill
        private int attributeID_2; // child skill;
        private SkillEnum skillEnum;

        private SkillEnum(SkillEnum skillEnum) {
            this.skillEnum = skillEnum;
        }

        private SkillEnum(int attributeID_1, int attributeID_2) {
            this.attributeID_1 = attributeID_1;
            this.attributeID_2 = attributeID_2;
        }

        public int getAttributeID_1() {
            return attributeID_1;
        }

        public int getAttributeID_2() {
            return attributeID_2;
        }        
    }
    
    public SkillRequired_LogicV2(int typeId, RamActivitiesEnum activitiesEnum ){
        
        // required Skill_
        List<IndustryActivitySkills> requiredSkill_ = 
            getRequiredSkill(typeId, activitiesEnum);    
        
        // skill Infos
        for (IndustryActivitySkills industryActivitySkills : requiredSkill_) {
            
            List<SkillInfo> skillInfos = 
                getSkillAttribute(industryActivitySkills.getSkillID());       
            
            requiredItem(skillInfos, requiredSkill); 
        }
    }   
    
    /**
     * Get Required Skill
     * @param int typeID
     * @param RamActivitiesEnum activitiesEnum
     * @return 
     */
    private List < IndustryActivitySkills > getRequiredSkill(
        int typeID, RamActivitiesEnum activitiesEnum){
        return Manager.getInstance().db().item().industryActivitySkills().
            getRequiredSkill(typeID, activitiesEnum);
    }
    
    /**
     * Required Item
     * @param List<SkillInfo>  skillInfos
     * @param SkillInfo skillInfo 
     */
    @Override
    public void requiredItem(List<SkillInfo> skillInfos, SkillInfo skillInfo_) {
        
        for (SkillInfo skillInfo : skillInfos) {
            skillInfo_.addItemRecursions(skillInfo);
             
            List<SkillInfo> skillInfoB = getSkillAttribute(skillInfo.getValueInt());
            
            if ( skillInfoB != null ){
                requiredItem( skillInfoB , skillInfo);
            }
        }
    }     
    
    /**
     * Calculate Skill Attribute
     * @param int typeId 
     */
    private List < SkillInfo > getSkillAttribute(int typeId){
        List < SkillInfo > skillInfos = new ArrayList<>();
        // PRIMARY_SKILL
        DgmTypeAttributes attributeID_1 = getDgmTypeAttributes(typeId,
            SkillEnum.PRIMARY_SKILL.getAttributeID_1());     

        if (attributeID_1 == null)
            return new ArrayList<>();        

        DgmTypeAttributes attributeID_2 = getDgmTypeAttributes(typeId,
            SkillEnum.PRIMARY_SKILL.getAttributeID_2());     
             
        skillInfos.add( getSkillInfo(attributeID_1, attributeID_2) );

        // -----------------------------------------------------------------
        
        // SECONDARY_SKILL
        attributeID_1 = getDgmTypeAttributes(typeId,
            SkillEnum.SECONDARY_SKILL.getAttributeID_1());   

        if (attributeID_1 == null)
            return skillInfos;       
        
        attributeID_2 = getDgmTypeAttributes(typeId,
            SkillEnum.SECONDARY_SKILL.getAttributeID_2());
        
        skillInfos.add( getSkillInfo(attributeID_1, attributeID_2) );
        
        // -----------------------------------------------------------------        
        
        // TERTIARY_SKILL
        attributeID_1 = getDgmTypeAttributes(typeId,
            SkillEnum.TERTIARY_SKILL.getAttributeID_1());    
        
        if (attributeID_1 == null)
            return skillInfos;
        
        attributeID_2 = getDgmTypeAttributes(typeId,
            SkillEnum.TERTIARY_SKILL.getAttributeID_2());        

        skillInfos.add( getSkillInfo(attributeID_1, attributeID_2) );        
        
        return skillInfos;
    }    
    
    /**
     * Add Skill Info
     * @param DgmTypeAttributes attributeID_1
     * @param DgmTypeAttributes attributeID_2 
     */
    private SkillInfo getSkillInfo(DgmTypeAttributes attributeID_1, 
            DgmTypeAttributes attributeID_2){       

        // id skill
        int typeID = attributeID_1.getDgmTypeAttributesPK().getTypeID();
        
        // id child skill
        int childSkill = attributeID_1.getValueInt(); 
        
        // id required Skill Level
        int requiredSkillLevel = attributeID_2.getValueInt();
        
        // name skill
        String typeName = 
            getInvTypesById( typeID ).getTypeName();
        
        // require Skill Name Level
        String requireSkillNameLevel = 
            getInvTypesById( childSkill ).getTypeName();
        
        // skill info
        SkillInfo skillInfo = new SkillInfo(
            typeID, typeName, childSkill, requireSkillNameLevel, requiredSkillLevel );
        
        return skillInfo;
    }  
    
    /**
     * Skill Required
     * @param int typeID
     * @param int skillRequired
     * @return 
     */
    private DgmTypeAttributes getDgmTypeAttributes(int typeID, int skillRequired){
        DgmTypeAttributes dgmTypeAttributes = Manager.getInstance().db().item().dgmTypeAttributes().
                getTypeAttributesByTypeId_ByAttributeID(typeID, skillRequired);
        
        return dgmTypeAttributes;
    }      
}
