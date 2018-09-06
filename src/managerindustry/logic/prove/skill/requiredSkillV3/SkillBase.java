/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.requiredSkillV3;

import managerindustry.logic.prove.skill.requiredSkillV2.*;
import managerindustry.logic.generic.recursion.ItemRecursion;

/**
 * 
 * @author lele
 */
public class SkillBase extends ItemRecursion {
    private int typeIdSkill;
    private String typeNameSkill;
    private byte activityID;
    
    private int requiredSKillId;
    private String requiredSKillName;
    private byte requiredLevel;    

    public SkillBase() {
    }

    public SkillBase(int typeIdSkill, String typeNameSkill, byte activityID, 
        int requiredSKillId, String requiredSKillName, byte requiredLevel) {
        
        this.typeIdSkill = typeIdSkill;
        this.typeNameSkill = typeNameSkill;
        this.activityID = activityID;
        this.requiredSKillId = requiredSKillId;
        this.requiredSKillName = requiredSKillName;
        this.requiredLevel = requiredLevel;
    }

        
    /**
     * Get Type Id Skill
     * @return int
     */
    public int getTypeIdSkill() {
        return typeIdSkill;
    }

    /**
     * Get Type Name Skill
     * @return String
     */
    public String getTypeNameSkill() {
        return typeNameSkill;
    }
    
    /**
     * Get Required SKill Id
     * @return int
     */
    public int getRequiredSKillId() {
        return requiredSKillId;
    }

    /**
     * Get Required Level
     * @return byte
     */
    public byte getRequiredLevel() {
        return requiredLevel;
    }

    /**
     * Get Required SKill Name
     * @return String
     */
    public String getRequiredSKillName() {
        return requiredSKillName;
    }

    /**
     * Get Activity ID
     * @return byte
     */
    public byte getActivityID() {
        return activityID;
    }

    /**
     * Set Activity ID
     * @param byteactivityID 
     */
    public void setActivityID(byte activityID) {
        this.activityID = activityID;
    }
    
    
}
