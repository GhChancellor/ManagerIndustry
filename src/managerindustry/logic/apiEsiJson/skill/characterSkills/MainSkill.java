/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson.skill.characterSkills;

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
        Skills skills = ApiEsi.getInstance().skillJson().getCharacterSkills(userApiEntity);
                
        System.out.println("Total skill" + skills.getTotal_sp());
        SkillRaw[] skillRaws = skills.getSkillsRaws();
        
        for (SkillRaw skillRaw : skillRaws) {
            System.out.println("getCurrent_skill_level "+ skillRaw.getCurrent_skill_level());
            System.out.println("getSkillpoints_in_skill "+ skillRaw.getSkillpoints_in_skill());
            System.out.println("getSkill_id "+ skillRaw.getSkill_id());
            System.out.println("");
        }
            
    }
}
