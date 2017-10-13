/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.json.skill;

/**
 *
 * @author lele
 */
public class Skills {
    private String current_skill_level;
    private String skill_id;
    private String skillpoints_in_skill;

    public Skills(String current_skill_level, String skill_id, String skillpoints_in_skill) {
        this.current_skill_level = current_skill_level;
        this.skill_id = skill_id;
        this.skillpoints_in_skill = skillpoints_in_skill;
    }
    
    public String getCurrent_skill_level() {
        return current_skill_level;
    }

    public void setCurrent_skill_level(String current_skill_level) {
        this.current_skill_level = current_skill_level;
    }

    public String getSkill_id() {
        return skill_id;
    }

    public void setSkill_id(String skill_id) {
        this.skill_id = skill_id;
    }

    public String getSkillpoints_in_skill() {
        return skillpoints_in_skill;
    }

    public void setSkillpoints_in_skill(String skillpoints_in_skill) {
        this.skillpoints_in_skill = skillpoints_in_skill;
    }
    
    
}
