/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.eve;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.IndustryActivity;
import managerindustry.logic.enumName.RamActivitiesEnum;

/**
 *
 * @author lele
 */
public class IndustryActivityX {
    private EntityManager entityManager;

    public IndustryActivityX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public IndustryActivity getIndustryActivity(int typeID, RamActivitiesEnum ramActivitiesEnum){
        try {
            TypedQuery < IndustryActivity > typedQueryTQ = 
                entityManager.createNamedQuery("IndustryActivity.findByTypeID_ActivityID", IndustryActivity.class);

            typedQueryTQ.setParameter("typeID", typeID);
            typedQueryTQ.setParameter("activityID", ramActivitiesEnum.getCode());

            List<IndustryActivity> resultList = typedQueryTQ.getResultList();

            if ( resultList.isEmpty()){
                return null;
            }else{
                return resultList.get(0);
            }            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}
