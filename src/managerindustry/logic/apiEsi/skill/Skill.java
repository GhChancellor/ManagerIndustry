/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsi.skill;

import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.apiEsi.skill.characterSkills.CharacterSkills;
import managerindustry.logic.apiEsi.skill.characterSkills.SkillParser;
import managerindustry.logic.apiEsi.skill.charactersSkillQueue.CharactersSkillQueue;

/**
 * It's a class container
 * @author lele
 */
public class Skill {
    public SkillParser getCharacterSkills(UserApiEntity userApiEntity){  
        CharacterSkills characterSkills = new CharacterSkills();
        return characterSkills.getCharacterSkills(userApiEntity);
    }
    
    private void getCharactersSkillQueue(){
        CharactersSkillQueue charactersSkillQueue = new CharactersSkillQueue();
        charactersSkillQueue.xxx();
    }
}
