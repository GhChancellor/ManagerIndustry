/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem.skillRequied;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.generic.genericRequiredItem.AGenericRequiredItem;


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
        if (requiredSkillA.getTypeID() != null){
            System.out.println(requiredSkillA.getTypeID() + " " +
                requiredSkillA.getTypeName() + ": " +
                requiredSkillA.getRequireSkillNameLevel() + " " +
                requiredSkillA.getValueInt() + " " +
                requiredSkillA.getRequiredSkillLevel() );            
                
        }

        tab += " ";
        
        for (Object recursionA : requiredSkillA.getItemRecursions()) {
            displayRequiredSkill((SkillInfo) recursionA, tab);
        }    
    }
    
    /**
     * Get Map
     * @return Map < A, B > 
     */
    public Map < A, B > getMap(){
        addListElement(requiredSkill);
        return super.getMap();
    }
    
    /**
     * Get List
     * @return List < A >
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
