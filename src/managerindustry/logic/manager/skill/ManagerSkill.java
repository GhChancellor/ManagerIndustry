/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.skill;

import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.manager.managerDB.Db;
import managerindustry.logic.skill.SkillX;
import managerindustry.logic.skill.specificSkill.BrokerFee;

/**
 * 
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
public class ManagerSkill {
    private static ManagerSkill instance = null;
    private Map < String, SkillX > skillMap = new HashMap<>();

    private enum SkillProduction{
        INDUSTRY(3380),
        ADVANCED_SMALL_SHIP_CONSTRUCTION(3395),
        ADVANCED_MEDIUM_SHIP_CONSTRUCTION(3397),
        ADVANCED_LARGE_SHIP_CONSTRUCTION(3398),
        ADVANCED_INDUSTRIAL_SHIP_CONSTRUCTION(3396);
        
        private int skillID;
        private SkillProduction skillProduction;

        private SkillProduction(SkillProduction skillProduction) {
            this.skillProduction = skillProduction;
        }
        
        private SkillProduction(int skillID) {
            this.skillID = skillID;
        }

        public int getSkillID() {
            return skillID;
        }

    }
    
    public static ManagerSkill getInstance (){
        if ( instance == null )
            instance = new ManagerSkill();
        return instance;
    }

    private ManagerSkill() {
        initSkill(SkillProduction.INDUSTRY, true, 440); // 440 attributeID
        initSkill(SkillProduction.ADVANCED_SMALL_SHIP_CONSTRUCTION, true, 1982); // 1982 attributeID
        initSkill(SkillProduction.ADVANCED_MEDIUM_SHIP_CONSTRUCTION, true, 1982); // 1982 attributeID
        initSkill(SkillProduction.ADVANCED_LARGE_SHIP_CONSTRUCTION, true, 1982); // 1982 attributeID
        initSkill(SkillProduction.ADVANCED_INDUSTRIAL_SHIP_CONSTRUCTION, true, 1982); // 1982 attributeID
        manuallyAddedNames();        
    }

    public boolean maxSkill(int level){
        if (level <= 5 ){
            return true;
        }
        return false;
    }

    public void setSkillMap(Map<String, SkillX> skillMap) {
        this.skillMap = skillMap;
    }

    public void addSkillMap( String nameSkill, SkillX skill) {
        this.skillMap.put(nameSkill, skill);
    }

    public Map<String, SkillX> getSkillMap() {
        return skillMap;
    }
    
    public SkillX getSkillMap(String nameSkill) {
        return this.skillMap.get(nameSkill);
    }
    
    /**
     * Init Skill
     * @param SkillProduction skillProduction
     * @param boolean flag
     * @param int attributeID 
     */
    private void initSkill(SkillProduction skillProduction, boolean flag, int attributeID){
        SkillX skill = Manager.getInstance().db().invTypes().getSkillValues
            (skillProduction.getSkillID(), flag, attributeID );
        
        addSkillMap(skill.getName(), new SkillX(skill.getName()));
    }
    
    private void manuallyAddedNames(){
//        SkillX accounting = new SkillX("Accounting");
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
