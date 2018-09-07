/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.fatherClass;

import managerindustry.logic.generic.fatherClass.recursion.ItemRecursion;

/**
 *
 * @author lele
 */
public class SkillInfo extends ItemRecursion {
    private int typeID;
    private int valueInt;
    private int requiredSkillLevel;

    public SkillInfo(int typeID, int childSkill, int requiredSkillLevel) {
        this.typeID = typeID;
        this.valueInt = childSkill;
        this.requiredSkillLevel = requiredSkillLevel;
    }

    public SkillInfo() {
    }
    
    /**
     * Father skill
     * @return int
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Child skill
     * @return int
     */
    public int getValueInt() {
        return valueInt;
    }

    /**
     * Get Required Skill Level
     * @return int
     */
    public Integer getRequiredSkillLevel() {
        return requiredSkillLevel;
    }    

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

    public void setRequiredSkillLevel(int requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }
    
}
