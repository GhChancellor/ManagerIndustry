/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill;

import managerindustry.logic.build.fatherclass.NameBase;

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
        super.setName(name);
        this.currentLevel = currentLevel;
        this.requiredLevel = requiredLevel;
    }
    
    public Skill(int typeId, String name, byte requiredLevel ) {
        super.setTypeId(typeId);
        super.setName(name);
        this.requiredLevel = requiredLevel;
    }

    public Skill(int typeId, byte requiredLevel ) {
        super.setTypeId(typeId);
        this.requiredLevel = requiredLevel;
    }

    public Skill(int typeId, int requiredSKillId, byte level){
        super.setTypeId(typeId);
        super.setQuanityInt(requiredSKillId); // it's required SKill Id skill!!!!!!
        this.requiredLevel = level;        
    }
    
    public byte getCurrentLevel() {
        return currentLevel;
    }

    public byte getRequiredLevel() {
        return requiredLevel;
    }

    
    
}
