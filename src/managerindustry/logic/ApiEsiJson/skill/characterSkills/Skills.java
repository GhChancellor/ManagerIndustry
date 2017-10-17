/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.ApiEsiJson.skill.characterSkills;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class Skills {

    private String total_sp;
    private SkillRaw[] skills;
    
    /**
     * Init skills
     * @param SkillRaw[] skills
     * @param total_sp 
     */
    public Skills(SkillRaw[] skills, String total_sp) {
        this.total_sp = total_sp;
        this.skills = skills;
    }
    
    /**
     * Get Skills
     * @return SkillRaw[]
     */
    public SkillRaw[] getSkills() {
        return skills;
    }

    /**
     * Set Skills
     * @param SkillRaw[] skills 
     */
    public void setSkillsRaw(SkillRaw[] skills) {
        this.skills = skills;
    }
    
    /**
     * Get Total_sp
     * @return String
     */
    public String getTotal_sp() {
        return total_sp;
    }

    /**
     * Set Total_sp
     * @param String total_sp 
     */
    public void setTotal_sp(String total_sp) {
        this.total_sp = total_sp;
    }
}
