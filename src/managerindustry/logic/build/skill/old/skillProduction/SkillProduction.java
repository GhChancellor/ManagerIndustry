/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.skill.old.skillProduction;

import managerindustry.logic.build.skill.old.skillProduction.logic.specificSkill.BrokerFee;
import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.manager.Manager;

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
public class SkillProduction {
    private Map < String, SkillInfo > skillMap = new HashMap<>();

    private enum SkillProductionEnum{
        INDUSTRY(3380),
        ADVANCED_INDUSTRY(3388),
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

    public SkillProduction() {
        init();
    }

    private void init(){
        initSkill(SkillProductionEnum.INDUSTRY, true, 440); // 440 attributeID
        initSkill(SkillProductionEnum.ADVANCED_INDUSTRY, true, 1982); // 1982 attributeID
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

    public void setSkillMap(Map<String, SkillInfo> skillMap) {
        this.skillMap = skillMap;
    }

    public void addSkillMap( String nameSkill, SkillInfo skill) {
        this.skillMap.put(nameSkill, skill);
    }

    public Map<String, SkillInfo> getSkillMap() {
        return skillMap;
    }
    
    public SkillInfo getSkillMap(String nameSkill) {
        return this.skillMap.get(nameSkill);
    }
    
    /**
     * Init Skill
     * @param SkillProduction skillProduction
     * @param boolean flag
     * @param int attributeID 
     */
    private void initSkill(SkillProductionEnum skillProductionEnum, boolean published, int attributeID){
        SkillInfo skill =                 
            Manager.getInstance().db().item().invTypes().getSkillValues 
            (skillProductionEnum.getSkillID(), published, attributeID );
        
        addSkillMap(skill.getTypeName(), new SkillInfo(skill.getTypeName()));
    }
    
    private void manuallyAddedNames(){
//        SkillX_OLD accounting = new SkillX_OLD("Accounting");
//        accounting.setValueFloat(0.1f);
//        accounting.setStartingValue(0.02f);
//        addSkillMap(accounting.getName(), accounting);
//        
        BrokerFee brokerRelations = new BrokerFee("Broker Relations");
        brokerRelations.setStartingValue(0.03f); // starting value
        brokerRelations.setInitTaxCorparationStanding(0.0002f);
        brokerRelations.setValueFloat(0.001f);  // reduceFeePerLevel
        brokerRelations.setFactionStandingTax(0.0003f);
        addSkillMap(brokerRelations.getTypeName(), brokerRelations);
        
    }

}
