/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import managerindustry.logic.manager.rule.ManagerDB.ManagerDB;
import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.skill.Skill;
import managerindustry.logic.skill.specificSkill.BrokerFee;

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

    public ManagerSkill() {
        initSkill();
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
        Skill skill = ManagerDB.getInstance().getInvTypes_SkillValues(3380, true, 440);
        addSkillMap(skill.getName(), new Skill(skill.getName()) );                
        
        skill = ManagerDB.getInstance().getInvTypes_SkillValues(3388, true, 1961);
        addSkillMap(skill.getName(), skill);
        
        skill = ManagerDB.getInstance().getInvTypes_SkillValues(3395, true, 1982);
        addSkillMap(skill.getName(), skill);
        
        skill = ManagerDB.getInstance().getInvTypes_SkillValues(3396, true, 1982);
        addSkillMap(skill.getName(), skill);
        
        skill = ManagerDB.getInstance().getInvTypes_SkillValues(3397, true, 1982);
        addSkillMap(skill.getName(), skill);
        
        skill = ManagerDB.getInstance().getInvTypes_SkillValues(3398, true, 1982);
        addSkillMap(skill.getName(), skill);
        
        manuallyAddedNames();
        
    }
    
    private void manuallyAddedNames(){
        Skill accounting = new Skill("Accounting");
        accounting.setValueFloat(0.1f);
        accounting.setStartingValue(0.02f);
        addSkillMap(accounting.getName(), accounting);
        
        BrokerFee brokerRelations = new BrokerFee("Broker Relations");
        brokerRelations.setStartingValue(0.03f); // starting value
        brokerRelations.setInitTaxCorparationStanding(0.0002f);
        brokerRelations.setValueFloat(0.001f);  // reduceFeePerLevel
        brokerRelations.setFactionStandingTax(0.0003f);
        addSkillMap(brokerRelations.getName(), brokerRelations);
        
    }

}
