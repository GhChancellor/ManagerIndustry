/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.eve;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.eve.IndustryActivityProducts;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;

/**
 *
 * @author lele
 */
public class IndustryActivityProductsX {
    private EntityManager entityManager;

    public IndustryActivityProductsX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Get Industry Activity Products By ID and activityID
     * @param int typeID
     * @param RamActivitiesEnum ramActivitiesEnum
     * @return IndustryActivityProducts
     */
    public IndustryActivityProducts getIndustryActivityProductsByID(int typeID, RamActivitiesEnum ramActivitiesEnum){
        try {
            TypedQuery < IndustryActivityProducts > typedQuery = 
                entityManager.createNamedQuery("IndustryActivityProducts.findByTypeID_ActivityID", IndustryActivityProducts.class);
            
            typedQuery.setParameter("typeID", typeID);
            typedQuery.setParameter("activityID", ramActivitiesEnum.getCode());
            
            List< IndustryActivityProducts > industryActivityProducts = typedQuery.getResultList();
            
            if (industryActivityProducts.isEmpty()){
                return null;
            }else{
                return industryActivityProducts.get(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
