/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsi.skill.characterSkills;

/**
 *
 * @author lele
 */
public class SkillParser {
    private SkillRaw[] skillsRaws;
    private String total_sp;

    public SkillParser() {
    }

    public SkillParser(SkillRaw[] skillsRaws, String total_sp) {
        this.skillsRaws = skillsRaws;
        this.total_sp = total_sp;
    }
    
    /**
     * Get SkillParser
     * @return SkillRaw[]
     */
    public SkillRaw[] getSkillsRaws() {
        return skillsRaws;
    }

    /**
     * Set SkillParser
     * @param skillsRaws 
     */
    public void setSkillsRaws(SkillRaw[] skillsRaws) {
        this.skillsRaws = skillsRaws;
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
