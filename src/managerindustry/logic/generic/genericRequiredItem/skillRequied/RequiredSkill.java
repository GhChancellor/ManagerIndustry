/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem.skillRequied;

import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.generic.genericRequiredItem.AGenericItemRequired;

/**
 *
 * @author lele
 */
public class RequiredSkill < A, B, C, D, E, F, G > 
    extends AGenericItemRequired < A, B, C, D, E, F, G > {

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
    private void displayRequiredSkill( SkillInfo requiredSkill, String tab){ 
        if (requiredSkill.getTypeID() != null){
            System.out.println(requiredSkill.getTypeID() + " " +
                requiredSkill.getTypeName() + ": " +
                requiredSkill.getRequireSkillNameLevel() + " " +
                requiredSkill.getValueInt() + " " +
                requiredSkill.getRequiredSkillLevel() );            
                
        }

        tab += " ";
        
        for (Object recursionA : requiredSkill.getItemRecursions()) {
            displayRequiredSkill((SkillInfo) recursionA, tab);
        }    
    }    
    
    @Override
    public void requiredItem(A a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requiredItem(A a1, B b2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requiredItem(A a1, B b2, C c3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public F requiredItemMoreInfo(D d1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public F requiredItemMoreInfo(D d1, E e1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public G getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
