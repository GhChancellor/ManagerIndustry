/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson.skill;

import java.util.Map;
import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.apiEsiJson.skill.characterSkills.CharacterSkills;
import managerindustry.logic.apiEsiJson.skill.characterSkills.Skills;
import managerindustry.logic.apiEsiJson.skill.charactersSkillQueue.CharactersSkillQueue;

/**
 *
 * @author lele
 */
public class SkillJson {
    public Skills getCharacterSkills(UserApiEntity userApiEntity){  
        CharacterSkills characterSkills = new CharacterSkills();
        return characterSkills.getCharacterSkills(userApiEntity);
    }
    
    private void getCharactersSkillQueue(){
        CharactersSkillQueue charactersSkillQueue = new CharactersSkillQueue();
        charactersSkillQueue.xxx();
    }
}
