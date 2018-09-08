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

    private List < SkillInfo > skillInfos = new ArrayList<>();
    private SkillInfo skillInfo = new SkillInfo();    

    public SkillRequired_Logic(int typeID) {
        calculateSkillInfo(typeID);        
        skillInfo.setTypeID(typeID);
        requiredItem( skillInfos, requiredSkill );   

    }

    /**
     * @deprecated 
     * Required Item
     * @param Object skillInfos
     * @param Object skillInfo 
     */
    @Override
    public void requiredItem(Object skillInfos, Object skillInfo) {
        for (SkillInfo skillInfo_ : (List < SkillInfo > ) skillInfos) {
            
            ((SkillInfo) skillInfo).addItemRecursions(skillInfo_);
            
            if ( skillInfo_.getRequiredSkillLevel() != null){
                 requiredItem( skillInfo_.getItemRecursions(), skillInfo_);
            }
        }
    }
        
    /**
     * Calculate Skill Info
     * @param int typeId 
     */
    private void calculateSkillInfo(int typeId){
        // PRIMARY_SKILL
        DgmTypeAttributes attributeID_1 = getDgmTypeAttributes(typeId,
            SkillEnum.PRIMARY_SKILL.getAttributeID_1());     

        if (attributeID_1 == null)
            return;        

        DgmTypeAttributes attributeID_2 = getDgmTypeAttributes(typeId,
            SkillEnum.PRIMARY_SKILL.getAttributeID_2());     
        
        skillInfos.add( getSkillInfo(attributeID_1, attributeID_2) );

        // -----------------------------------------------------------------
        
        // SECONDARY_SKILL
        attributeID_1 = getDgmTypeAttributes(typeId,
            SkillEnum.SECONDARY_SKILL.getAttributeID_1());   

        if (attributeID_1.equals(null))
            return;        
        
        attributeID_2 = getDgmTypeAttributes(typeId,
            SkillEnum.SECONDARY_SKILL.getAttributeID_2());
        
        skillInfos.add( getSkillInfo(attributeID_1, attributeID_2) );
        
        // -----------------------------------------------------------------        
        
        // TERTIARY_SKILL
        attributeID_1 = getDgmTypeAttributes(typeId,
            SkillEnum.TERTIARY_SKILL.getAttributeID_1());    
        
        if (attributeID_1 == null)
            return;        
        
        attributeID_2 = getDgmTypeAttributes(typeId,
            SkillEnum.TERTIARY_SKILL.getAttributeID_2());        

        skillInfos.add( getSkillInfo(attributeID_1, attributeID_2) );        
    }    
    /**
     * Add Skill Info
     * @param DgmTypeAttributes attributeID_1
     * @param DgmTypeAttributes attributeID_2 
     */
    private SkillInfo getSkillInfo(DgmTypeAttributes attributeID_1, 
            DgmTypeAttributes attributeID_2){       
        
        SkillInfo skillInfo = new SkillInfo(
            attributeID_1.getDgmTypeAttributesPK().getTypeID(),
            attributeID_1.getValueInt(), 
            attributeID_2.getValueInt() );
        
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
