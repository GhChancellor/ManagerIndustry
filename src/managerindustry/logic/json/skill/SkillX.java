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
    private String skills;
    private String total_sp;
    private List < Parameter > parameters = new ArrayList<>();
    
    public SkillX(String skills, String total_sp) {
        this.skills = skills;
        this.total_sp = total_sp;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getTotal_sp() {
        return total_sp;
    }

    public void setTotal_sp(String total_sp) {
        this.total_sp = total_sp;
    }

    public List<Parameter> getParameters() {
        return parameters;
    }

    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }
    
    public void addParameters( Parameter parameter) {
        this.parameters.add(parameter);
    }
    
    
}
