/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.ApiEsiJson.skill;

import java.util.Map;
import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.ApiEsiJson.skill.characterSkills.CharacterSkills;
import managerindustry.logic.ApiEsiJson.skill.characterSkills.Skills;
import managerindustry.logic.ApiEsiJson.skill.charactersSkillQueue.CharactersSkillQueue;

/**
 *
 * @author lele
 */
public class SkillJson {
    private CharacterSkills characterSkills;
    private CharactersSkillQueue charactersSkillQueue;
    
    private UserApiEntity userApiEntity;

    public SkillJson(UserApiEntity userApiEntity) {
        this.userApiEntity = userApiEntity;
    }
    
    public Map < String, Skills > getCharacterSkills(){
        return characterSkills.getCharacterSkills(userApiEntity);
    }
    
    private void getCharactersSkillQueue(){
        charactersSkillQueue.xxx();
    }
}
