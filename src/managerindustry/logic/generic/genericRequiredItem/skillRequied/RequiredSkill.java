/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem.skillRequied;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.genericRequiredItem.AGenericRequiredItem;
import managerindustry.logic.generic.fatherClass.SkillInfo;

/**
 *
 * @author lele
 */
public class RequiredSkill < A, B > extends AGenericRequiredItem {
    protected SkillInfo requiredSkill = new SkillInfo();

    public RequiredSkill() {
    }
    
    /**
     * Display
     */
    @Override
    public void display() {
        displayRequiredSkill(requiredSkill, "");
    }  
    
    /**
     * Display Required Skill
     * @param SkillInfo requiredSkillA
     * @param String tab 
     */
    private void displayRequiredSkill( SkillInfo requiredSkillA, String tab){        
        System.out.println("" + 
            requiredSkillA.getTypeID() + " " +
            requiredSkillA.getRequiredSkillLevel() + " " +
            requiredSkillA.getValueInt() );

        tab += " ";
        
        for (Object recursionA : requiredSkillA.getItemRecursions()) {
            displayRequiredSkill( (SkillInfo) recursionA, tab);
        }    
    }
    
    /**
     * Get Map
     * @return Map < String, SkillInfo > 
     */
    public Map < A, B > getMap(){
        addListElement(requiredSkill);
        return super.getMap();
    }
    
    /**
     * Get List
     * @return List < SkillInfo >
     */
    public List < A > getList(){
        convertToList(requiredSkill.getItemRecursions());
        return super.getList();
    }

    /**
     * Convert to list
     * @param List requiredSkills 
     */
    @Override
    public void convertToList(List requiredSkills) {
        for (SkillInfo skillBase : ( List < SkillInfo > ) requiredSkills) {
            if ( skillBase.getTypeID() != 0){
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
