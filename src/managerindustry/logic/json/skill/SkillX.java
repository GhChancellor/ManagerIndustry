/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.json.skill;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class SkillX {

    private String total_sp;
    private Skills[] skills;

    public SkillX(Skills[] skills, String total_sp) {
        this.total_sp = total_sp;
        this.skills = skills;
    }

    
    
    public Skills[] getSkills() {
        return skills;
    }

    public void setSkills(Skills[] skills) {
        this.skills = skills;
    }
    
    public String getTotal_sp() {
        return total_sp;
    }

    public void setTotal_sp(String total_sp) {
        this.total_sp = total_sp;
    }
    
    
}
