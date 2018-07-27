/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.old;

import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.skill.old.specificSkill.BrokerFee_OLD;

/**
 * @deprecated 
  SELECT invTypes.typeName, invTypes.typeID, invTypes.description, dgmTypeAttributes.valueFloat, dgmTypeAttributes.valueInt, dgmAttributeTypes.attributeName,
  dgmAttributeTypes.attributeID  
  FROM invTypes, dgmTypeAttributes, dgmAttributeTypes 
  WHERE invTypes.typeName="Advanced Industrial Ship Construction"   and invTypes.typeID=dgmTypeAttributes.typeID and invTypes.typeID=dgmTypeAttributes.typeID 
  and dgmTypeAttributes.attributeID = dgmAttributeTypes.attributeID;
 *
 * 
 * https://wiki.eveuniversity.org/Skills:Production#Advanced_Industrial_Ship_Construction
 * @author lele
 */
public class Skill_OLD {
    private Map < String, SkillX_OLD > skillMap = new HashMap<>();

    private enum SkillProductionEnum{
        INDUSTRY(3380),
        ADVANCED_SMALL_SHIP_CONSTRUCTION(3395),
        ADVANCED_MEDIUM_SHIP_CONSTRUCTION(3397),
        ADVANCED_LARGE_SHIP_CONSTRUCTION(3398),
        ADVANCED_INDUSTRIAL_SHIP_CONSTRUCTION(3396),
        Broker_Relations(3446); //broker fee
        
        private int skillID;
        private SkillProductionEnum skillProduction;

        private SkillProductionEnum(SkillProductionEnum skillProduction) {
            this.skillProduction = skillProduction;
        }
        
        private SkillProductionEnum(int skillID) {
            this.skillID = skillID;
        }

        public int getSkillID() {
            return skillID;
        }

    }

    public Skill_OLD() {
//        init();
    }

    private void init(){
        initSkill(SkillProductionEnum.INDUSTRY, true, 440); // 440 attributeID
        initSkill(SkillProductionEnum.ADVANCED_SMALL_SHIP_CONSTRUCTION, true, 1982); // 1982 attributeID
        initSkill(SkillProductionEnum.ADVANCED_MEDIUM_SHIP_CONSTRUCTION, true, 1982); // 1982 attributeID
        initSkill(SkillProductionEnum.ADVANCED_LARGE_SHIP_CONSTRUCTION, true, 1982); // 1982 attributeID
        initSkill(SkillProductionEnum.ADVANCED_INDUSTRIAL_SHIP_CONSTRUCTION, true, 1982); // 1982 attributeID
        manuallyAddedNames();          
    }
    
    public boolean maxSkill(byte level){
        if (level <= 5 ){
            return true;
        }
        return false;
    }

    public void setSkillMap(Map<String, SkillX_OLD> skillMap) {
        this.skillMap = skillMap;
    }

    public void addSkillMap( String nameSkill, SkillX_OLD skill) {
        this.skillMap.put(nameSkill, skill);
    }

    public Map<String, SkillX_OLD> getSkillMap() {
        return skillMap;
    }
    
    public SkillX_OLD getSkillMap(String nameSkill) {
        return this.skillMap.get(nameSkill);
    }
    
    /**
     * @deprecated 
     * Init Skill_OLD
     * @param SkillProduction skillProduction
     * @param boolean flag
     * @param int attributeID 
     */
    private void initSkill(SkillProductionEnum skillProductionEnum, boolean published, int attributeID){
        
        
        SkillX_OLD skill =                 
            Manager.getInstance().db().item().invTypes().getSkillValues // QUERY DISABLE!!!!!!!!! DANGER!!!!!!
            (skillProductionEnum.getSkillID(), published, attributeID );
        
        addSkillMap(skill.getName(), new SkillX_OLD(skill.getName()));
    }
    
    private void manuallyAddedNames(){
//        SkillX_OLD accounting = new SkillX_OLD("Accounting");
//        accounting.setValueFloat(0.1f);
//        accounting.setStartingValue(0.02f);
//        addSkillMap(accounting.getName(), accounting);
//        
        BrokerFee_OLD brokerRelations = new BrokerFee_OLD("Broker Relations");
        brokerRelations.setStartingValue(0.03f); // starting value
        brokerRelations.setInitTaxCorparationStanding(0.0002f);
        brokerRelations.setValueFloat(0.001f);  // reduceFeePerLevel
        brokerRelations.setFactionStandingTax(0.0003f);
        addSkillMap(brokerRelations.getName(), brokerRelations);
        
    }

}
