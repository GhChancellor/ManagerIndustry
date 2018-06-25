/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.eve;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.eve.IndustryActivitySkills;
import managerindustry.logic.enumName.RamActivitiesEnum;

/**
 *
 * @author lele
 */
public class IndustryActivitySkillsX {
    private EntityManager entityManager;

    public IndustryActivitySkillsX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Get Required Skill
     * @param typeID
     * @param ramActivitiesEnum
     * @return IndustryActivitySkills
     */
    public List < IndustryActivitySkills > getRequiredSkill( int typeID, RamActivitiesEnum activitiesEnum){
        try {
            TypedQuery < IndustryActivitySkills > requiredSkill = 
             entityManager.createNamedQuery("IndustryActivitySkills.findByTypeID", IndustryActivitySkills.class);
            
            requiredSkill.setParameter("typeID", typeID);
            requiredSkill.setParameter("activityID", activitiesEnum.getCode());
            
            return requiredSkill.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }  

}
//     private EntityManager entityManager;