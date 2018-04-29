/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.manager.managerDB.ManagerDB;
import managerindustry.logic.skill.SkillV;
import managerindustry.logic.skill.specificSkill.BrokerFee;

/**
 *  SELECT invTypes.typeName, invTypes.typeID, invTypes.description, dgmTypeAttributes.valueFloat, dgmTypeAttributes.valueInt, dgmAttributeTypes.attributeName,
  dgmAttributeTypes.attributeID  
  FROM invTypes, dgmTypeAttributes, dgmAttributeTypes 
  WHERE invTypes.typeName="Advanced Industrial Ship Construction"   and invTypes.typeID=dgmTypeAttributes.typeID and invTypes.typeID=dgmTypeAttributes.typeID 
  and dgmTypeAttributes.attributeID = dgmAttributeTypes.attributeID;
 * https://wiki.eveuniversity.org/Skills:Production#Advanced_Industrial_Ship_Construction
 * @author lele
 */
public class ManagerSkill {
    private static ManagerSkill instance = null;
    private Map < String, SkillV > skillMap = new HashMap<>();

    public static ManagerSkill getInstance (){
        if ( instance == null )
            instance = new ManagerSkill();
        return instance;
    }

    private ManagerSkill() {
        initSkill();
    }

    public boolean maxSkill(int level){
        if (level <= 5 ){
            return true;
        }
        return false;
    }
    
    public Map<String, SkillV> getSkillMap() {
        return skillMap;
    }

    public void setSkillMap(Map<String, SkillV> skillMap) {
        this.skillMap = skillMap;
    }

    public void addSkillMap( String nameSkill, SkillV skill) {
        this.skillMap.put(nameSkill, skill);
    }

    public SkillV getSkillMap(String nameSkill) {
        return this.skillMap.get(nameSkill);
    }
    
    /**
     *   SELECT * FROM invTypes where invTypes.groupID=268;
     */
    private final void initSkill(){
        SkillV skill = ManagerDB.getInstance().invTypes().getSkillValues(3380, true, 440);
        addSkillMap(skill.getName(), new SkillV(skill.getName()) );       
                
//        SkillV skill = ManagerDBEve.getInstance().getInvTypes_SkillValues(3380, true, 440);
//        addSkillMap(skill.getName(), new SkillV(skill.getName()) );       

        skill = ManagerDB.getInstance().invTypes().getSkillValues(3395, true, 1982);
        addSkillMap(skill.getName(), new SkillV(skill.getName()) );       
     
        skill = ManagerDB.getInstance().invTypes().getSkillValues(3396, true, 1982);
        addSkillMap(skill.getName(), new SkillV(skill.getName()) );       
        
        skill = ManagerDB.getInstance().invTypes().getSkillValues(3397, true, 1982);
        addSkillMap(skill.getName(), new SkillV(skill.getName()) );       
        
        skill = ManagerDB.getInstance().invTypes().getSkillValues(3398, true, 1982);
        addSkillMap(skill.getName(), new SkillV(skill.getName()) );       
            
//        manuallyAddedNames();
        
    }
    
    private void manuallyAddedNames(){
//        SkillV accounting = new SkillV("Accounting");
//        accounting.setValueFloat(0.1f);
//        accounting.setStartingValue(0.02f);
//        addSkillMap(accounting.getName(), accounting);
//        
        BrokerFee brokerRelations = new BrokerFee("Broker Relations");
        brokerRelations.setStartingValue(0.03f); // starting value
        brokerRelations.setInitTaxCorparationStanding(0.0002f);
        brokerRelations.setValueFloat(0.001f);  // reduceFeePerLevel
        brokerRelations.setFactionStandingTax(0.0003f);
        addSkillMap(brokerRelations.getName(), brokerRelations);
        
    }

}
