/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill;

import java.util.List;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.db.entities.eve.IndustryActivitySkills;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.recursion.ItemRecursionA;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class RequiredSkill {
    private RequiredSkillRecusion requiredSkill;
    
    public RequiredSkill(int typeID, RamActivitiesEnum activitiesEnum) {

        // list skill required to build an item
        List<IndustryActivitySkills> industryActivitySkills = 
            Manager.getInstance().db().item().industryActivitySkills().getRequiredSkill(typeID, activitiesEnum);   
        
        if ( industryActivitySkills.isEmpty())
            return;
        
        RequiredSkillRecusion requiredSkill = new RequiredSkillRecusion();
        init(industryActivitySkills, requiredSkill, activitiesEnum);
        
        this.requiredSkill = requiredSkill;        
    }
    
    private void init(List<IndustryActivitySkills> industryActivitySkills,
        RequiredSkillRecusion requiredA, RamActivitiesEnum activitiesEnum){
        
        RequiredSkillRecusion requiredSkill = new RequiredSkillRecusion();
        calculateRequiredSkill(industryActivitySkills, requiredSkill, activitiesEnum);        
    }
    
    /**
     * required skill to build object
     * @param List<IndustryActivitySkills> industryActivitySkills industryActivitySkills
     * @param RequiredSkillRecusion requiredA requiredA
     * @param RamActivitiesEnum activitiesEnum 
     */
    private void calculateRequiredSkill(List<IndustryActivitySkills> industryActivitySkills,
        RequiredSkillRecusion requiredA, RamActivitiesEnum activitiesEnum){
        
        for (IndustryActivitySkills industryActivitySkill : industryActivitySkills) {

            
            RequiredSkillRecusion requiredSkillRecusion = 
                new RequiredSkillRecusion(
                industryActivitySkill.getTypeID(), getName(industryActivitySkill.getTypeID()),
                        
                industryActivitySkill.getSkillID(), getName(industryActivitySkill.getSkillID()),
                industryActivitySkill.getLevel().byteValue() );            
            
            requiredA.addItemRecursionAs(new ItemRecursionA(requiredSkillRecusion));
            
            List<IndustryActivitySkills> recursion = 
                Manager.getInstance().db().item().industryActivitySkills().getRequiredSkill(
                industryActivitySkill.getSkillID(), activitiesEnum);
            
            if (!recursion.isEmpty())
                calculateRequiredSkill(recursion, requiredA, activitiesEnum);            
        }
    }
        
    
    private int getDgmTypeAttributes(int typeID, int attributeID){
        DgmTypeAttributes dgmTypeAttributes = Manager.getInstance().db().item().dgmTypeAttributes().
                getTypeAttributesByTypeId_ByAttributeID(typeID, attributeID);
        
        return dgmTypeAttributes.getValueInt();
    }    
    
    private String getName(int typeId){
        return Manager.getInstance().db().item().invTypes().getInvTypesById(
            typeId).getTypeName();
    } 
    
    private void displayRequiredSkill( ){
        displayRequiredSkill_(requiredSkill, "");
    }    
    
    private void displayRequiredSkill_( RequiredSkillRecusion requiredSkillA, String tab){
        
        System.out.println("" + 
            requiredSkillA.getTypeIdSkill() + " " +
            requiredSkillA.getNameSkill() + " - " +
            requiredSkillA.getRequiredSKillId() + " " +
            requiredSkillA.getRequiredSKillName() + " " +
            requiredSkillA.getLevel() );
        
        tab += tab;
        
        for (ItemRecursionA recursionA : requiredSkillA.getItemRecursionAs()) {
            displayRequiredSkill_( (RequiredSkillRecusion) recursionA.getRecursionA02(), tab);
        }
    }    
            
}
