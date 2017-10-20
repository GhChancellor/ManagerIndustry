/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson.skill.characterSkills;

import java.util.List;
import java.util.Map;
import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.apiEsiJson.ApiEsi;

/**
 *
 * @author lele
 */
public class MainSkill {
    public static void main(String[] args) {
        UserApiEntity userApiEntity = new UserApiEntity();
        userApiEntity.setNameCharacter("asss");
        Map < String, Skills > map = ApiEsi.getInstance().skillJson().getCharacterSkills(userApiEntity);
                
        for (Map.Entry<String, Skills> entry : map.entrySet()) {
            String key = entry.getKey();
            Skills value = entry.getValue();
            
            SkillRaw[] skillRaws = value.getSkillsRaws();
            
            for (int i = 0; i < skillRaws.length; i++) {
                System.out.println("" +skillRaws[i].getCurrent_skill_level());
            }
        }
            
    }
}
