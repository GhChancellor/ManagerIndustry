/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.requiredSkillV2;

import java.util.List;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.db.entities.eve.IndustryActivitySkills;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;


/**
 * Calculate which skills you need to build an item 
 * @author lele
 */
public class SkillLogic extends SkillRequired{
    private SkillBase requiredSkill = new SkillBase();
    //SkillBase requiredSkillA, RamActivitiesEnum activitiesEnum

    public SkillLogic(int typeID, RamActivitiesEnum activitiesEnum) {
        List<IndustryActivitySkills> industryActivitySkills = 
            Manager.getInstance().db().item().industryActivitySkills().
            getRequiredSkill(typeID, activitiesEnum);   

        if ( industryActivitySkills.isEmpty())
            return;
        
        for (IndustryActivitySkills industryActivitySkill : industryActivitySkills) {
            SkillBase requiredSkill_ = 
                (SkillBase) requiredItemMoreInfo(industryActivitySkill);
            
            requiredItem02(requiredSkill_);
            
//            requiredItem(industryActivitySkill, requiredSkill, activitiesEnum);
        }
    }
    
    private void requiredItem02(SkillBase requiredSkill){

        
        System.out.println("");
    }
    
    
    private void requiredItem(IndustryActivitySkills industryActivitySkill, 
        SkillBase requiredSkillA, RamActivitiesEnum activitiesEnum){
        
        SkillBase requiredSkill = 
            (SkillBase) requiredItemMoreInfo(industryActivitySkill);

        ((SkillBase)requiredSkillA).addItemRecursions(requiredSkill); 
        
        int skillRequired = getSkillRequired(requiredSkill.getTypeIdSkill(), 
                requiredSkill.getRequiredSKillId());
        
        System.out.println("");
    }
    


    @Override
    public void requiredItem(Object industryActivitySkills, Object requiredSkillA, 
            Object activitiesEnum) {
        
        for (IndustryActivitySkills industryActivitySkill : 
                (List < IndustryActivitySkills >) industryActivitySkills) {
             
            SkillBase requiredSkill = 
                (SkillBase) requiredItemMoreInfo(industryActivitySkill);
            
            ((SkillBase)requiredSkillA).addItemRecursions(requiredSkill);
            
            List<IndustryActivitySkills> recursions = 
                Manager.getInstance().db().item().industryActivitySkills().getRequiredSkill(
                industryActivitySkill.getSkillID(), (RamActivitiesEnum) activitiesEnum);
            
            if (!recursions.isEmpty())
                requiredItem(recursions, requiredSkill, activitiesEnum);            
        }        
    }

    /**
     * Required Item More Info
     * @param Object industryActivitySkill_
     * @return Object
     */
    @Override
    public Object requiredItemMoreInfo(Object industryActivitySkill_) {
        IndustryActivitySkills industryActivitySkill = 
            (IndustryActivitySkills) industryActivitySkill_;
                
        SkillBase requiredSkill = 
            new SkillBase( industryActivitySkill.getTypeID(), 
                getName(industryActivitySkill.getTypeID() ),
                industryActivitySkill.getActivityID().byteValue(),
                industryActivitySkill.getSkillID(), 
                getName(industryActivitySkill.getSkillID()),
                industryActivitySkill.getLevel().byteValue() );

        return requiredSkill;
    }

    /**
     * Get Name
     * @param int typeId
     * @return String
     */
    private String getName(int typeId){
        InvTypes invTypes = 
            Manager.getInstance().db().item().invTypes().getInvTypesById(typeId);
        return invTypes.getTypeName();
    }     
    
    /**
     * Skill Required
     * @param int typeID
     * @param int skillRequired
     * @return 
     */
    private int getSkillRequired(int typeID, int skillRequired){
        DgmTypeAttributes dgmTypeAttributes = Manager.getInstance().db().item().dgmTypeAttributes().
                getTypeAttributesByTypeId_ByAttributeID(typeID, skillRequired);
        
        return dgmTypeAttributes.getValueInt();
    }      
}
/*
    public SkillLogic(int typeID, RamActivitiesEnum activitiesEnum) {
        
        // list skill required to build an item
        List<IndustryActivitySkills> industryActivitySkills = 
            Manager.getInstance().db().item().industryActivitySkills().
            getRequiredSkill(typeID, activitiesEnum);   
        
        if ( industryActivitySkills.isEmpty())
            return;

        requiredItem(industryActivitySkills, requiredSkill, activitiesEnum);
    }
*/


/*
    @Override
    public void requiredItem(Object industryActivitySkills, Object requiredSkillA, 
            Object activitiesEnum) {
        
        for (IndustryActivitySkills industryActivitySkill : 
                (List < IndustryActivitySkills >) industryActivitySkills) {
             
            SkillBase requiredSkill = 
                (SkillBase) requiredItemMoreInfo(industryActivitySkill);
            
            ((SkillBase)requiredSkillA).addItemRecursions(requiredSkill);
                        
            List<IndustryActivitySkills> recursions = 
                Manager.getInstance().db().item().industryActivitySkills().getRequiredSkill(
                industryActivitySkill.getSkillID(), (RamActivitiesEnum) activitiesEnum);
            
            if (!recursions.isEmpty())
                requiredItem(recursions, requiredSkill, activitiesEnum);            
        }        
    }
*/