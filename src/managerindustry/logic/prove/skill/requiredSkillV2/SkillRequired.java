/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.requiredSkillV2;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.genericRequiredItem.AGenericRequiredItem;

/**
 *
 * @author lele
 */
public class SkillRequired extends AGenericRequiredItem {
    protected SkillBase requiredSkill = new SkillBase();
    
    /**
     * Display
     */
    @Override
    public void display() {
        displayRequiredSkill(requiredSkill, "");
    }  
    
    /**
     * Display Required Skill
     * @param SkillBase requiredSkillA
     * @param String tab 
     */
    private void displayRequiredSkill( SkillBase requiredSkillA, String tab){
        
        System.out.println("" + 
            requiredSkillA.getTypeIdSkill() + " " +
            requiredSkillA.getTypeNameSkill() + " - " +
            requiredSkillA.getRequiredSKillId() + " " +
            requiredSkillA.getRequiredSKillName() + " " +
            requiredSkillA.getRequiredLevel() );
        
        tab += tab;
        
        for (Object recursionA : requiredSkillA.getItemRecursions()) {
            displayRequiredSkill( requiredSkillA, tab);
        }    
    }
    
    /**
     * Get Map
     * @return Map < String, SkillBase > 
     */
    public Map < String, SkillBase > getMap(){
        addListElement(requiredSkill);
        return super.getMap();
    }
    
    /**
     * @deprecated finire
     * @return List < SkillBase >
     */
    public List < SkillBase > getList(){
        convertToList(requiredSkill.getItemRecursions());
        return super.getList();
    }

    /**
     * Convert to list
     * @param List requiredSkills 
     */
    @Override
    public void convertToList(List requiredSkills) {
        for (SkillBase skillBase : ( List < SkillBase > ) requiredSkills) {
            if ( skillBase.getTypeIdSkill() != 0){
                addListElement(skillBase);
            }
            
            if ( !requiredSkill.getItemRecursions().isEmpty() ){
                convertToList(requiredSkill.getItemRecursions());
            }
        }
    }
       
    /**
     * Get Object
     * @return Object
     */
    @Override
    public Object getObject() {
        return requiredSkill;
    }      
}
