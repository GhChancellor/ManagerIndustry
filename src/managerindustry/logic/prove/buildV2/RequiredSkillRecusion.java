/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import managerindustry.logic.generic.recursion.ItemRecursionA;

/**
 *
 * @author lele
 */
public class RequiredSkillRecusion extends ItemRecursionA{
    private int typeIdSkill;
    private String nameSkill;
    
    private int requiredSKillId;
    private String requiredSKillName;

    private byte level;
    

    public RequiredSkillRecusion() {
    }

    public RequiredSkillRecusion(int typeIdSkill, String nameSkill, int requiredSKillId, String requiredSKillName, byte level) {
        this.typeIdSkill = typeIdSkill;
        this.nameSkill = nameSkill;
        this.requiredSKillId = requiredSKillId;
        this.requiredSKillName = requiredSKillName;
        this.level = level;
    }

    public int getTypeIdSkill() {
        return typeIdSkill;
    }

    public int getRequiredSKillId() {
        return requiredSKillId;
    }

    public byte getLevel() {
        return level;
    }

    public String getNameSkill() {
        return nameSkill;
    }

    public String getRequiredSKillName() {
        return requiredSKillName;
    }
 
}
