/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.genericRequiredItem.requiredMaterial;

import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.prove.recursion_object.genericRequiredItem.AGenericItemRequiredV2;

/**
 *
 * @author lele
 */
public class RequiredSkillV2 < A, B, C, D, E, F, G > 
    extends AGenericItemRequiredV2 < A, B, C, D, E, F, G > {

    protected SkillInfo requiredSkill = new SkillInfo();

    public RequiredSkillV2() {
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
