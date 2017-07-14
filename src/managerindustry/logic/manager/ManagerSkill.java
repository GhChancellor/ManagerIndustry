/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.skill.Skill;

/**
 *
 * @author lele
 */
public class ManagerSkill {
    private static ManagerSkill instance = null;
    private Map < String, Skill > skillMap = new HashMap<>();
    
    public static ManagerSkill getInstance (){
        if ( instance == null )
            instance = new ManagerSkill();
        return instance;
    }

    public boolean maxSkill(int level){
        if (level <= 5 ){
            return true;
        }
        return false;
    }
    
    public Map<String, Skill> getSkillMap() {
        return skillMap;
    }

    public void setSkillMap(Map<String, Skill> skillMap) {
        this.skillMap = skillMap;
    }

    public void addSkillMap( String nameSkill, Skill skill) {
        this.skillMap.put(nameSkill, skill);
    }

    public Skill getSkillMap(String nameSkill) {
        return this.skillMap.get(nameSkill);
    }
    
    public void initSkill(){
        Skill skill = ManagerDB.getInstance().getInvTypeSkillValues(3380, true, 440);
        addSkillMap(skill.getName(), new Skill(skill.getName()) );                
        
//        skill = ManagerDB.getInstance().getInvTypeSkillValues(3388, true, 1961);
//        addSkillMap(skill.getName(), skill);
//        
//        skill = ManagerDB.getInstance().getInvTypeSkillValues(3395, true, 1982);
//        addSkillMap(skill.getName(), skill);
//        
//        skill = ManagerDB.getInstance().getInvTypeSkillValues(3396, true, 1982);
//        addSkillMap(skill.getName(), skill);
//        
//        skill = ManagerDB.getInstance().getInvTypeSkillValues(3397, true, 1982);
//        addSkillMap(skill.getName(), skill);
//        
//        skill = ManagerDB.getInstance().getInvTypeSkillValues(3398, true, 1982);
//        addSkillMap(skill.getName(), skill);
        
    }
    
    private void manuallyAddedNames(){
        Skill accounting = new Skill("Accounting");
        accounting.setValueFloat(0.1f);
        addSkillMap(accounting.getName(), accounting);
        
        Skill brokerRelations = new Skill("Broker Relations");
        brokerRelations.setValueFloat(0.001f);
        addSkillMap(brokerRelations.getName(), accounting);
    }

}
