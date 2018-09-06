/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.requiredSkillV1;

import managerindustry.logic.generic.nameBase.NameBase;

/**
 *
 * @author lele
 */
public class Skill extends NameBase{
    private byte currentLevel;
    private byte requiredLevel;
    private int requiredSKillId;
    
    public Skill(int typeId, String name, byte currentLevel, byte requiredLevel  ) {
        super.setTypeId(typeId);
        super.setTypeName(name);
        this.currentLevel = currentLevel;
        this.requiredLevel = requiredLevel;
    }
    
    public Skill(int typeId, String name, byte requiredLevel ) {
        super.setTypeId(typeId);
        super.setTypeName(name);
        this.requiredLevel = requiredLevel;
    }

    public Skill(int typeId, byte requiredLevel ) {
        super.setTypeId(typeId);
        this.requiredLevel = requiredLevel;
    }

    public Skill(int typeId, int requiredSKillId, byte level){
        super.setTypeId(typeId);
        super.setQuanityI(requiredSKillId); // it's required SKill Id skill!!!!!!
        this.requiredLevel = level;        
    }

    public Skill() {
    }    
    
    public byte getCurrentLevel() {
        return currentLevel;
    }

    public byte getRequiredLevel() {
        return requiredLevel;
    }

    
    
}
