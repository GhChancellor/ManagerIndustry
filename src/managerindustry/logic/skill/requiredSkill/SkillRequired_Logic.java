/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill.requiredSkill;

import managerindustry.logic.generic.genericRequiredItem.skillRequied.RequiredSkill;
import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class SkillRequired_Logic extends RequiredSkill{
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

    private NameBase pharseSkill = new NameBase();
    
    public SkillRequired_Logic(int i){
        List<SkillInfo> skillInfos = getSkillAttribute(i);
        requiredItem(skillInfos, requiredSkill);
    }   
     
    /**
     * Required Item
     * @param Object skillInfos
     * @param Object skillInfo 
     */
    @Override
    public void requiredItem(Object skillInfos, Object skillInfoA) {
        for (SkillInfo skillInfo_ : ( List<SkillInfo> ) skillInfos) {
            ((SkillInfo) skillInfoA).addItemRecursions(skillInfo_);
             
            List<SkillInfo> skillInfoB = getSkillAttribute(skillInfo_.getValueInt());
            
            if ( skillInfoB != null ){
                requiredItem( skillInfoB , skillInfo_);
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

        int typeID = attributeID_1.getDgmTypeAttributesPK().getTypeID();
        String typeName = 
            getInvTypesById( attributeID_1.getDgmTypeAttributesPK().getTypeID() ).getTypeName();
        
        int childSkill = attributeID_1.getValueInt();
        
        String requireSkillNameLevel = 
            getInvTypesById( attributeID_1.getValueInt() ).getTypeName();
        
        int requiredSkillLevel = attributeID_2.getValueInt();
        
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
