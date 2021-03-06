/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.eve;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.eve.InvMarketGroups;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class InvMarketGroupsX {
    private EntityManager entityManager;

    public InvMarketGroupsX() {
        entityManager = Manager.getInstance().db().getEntityManager();
    }    
    
    /**
     * Get Parent Group ID
     * @param int code
     * @return List < InvMarketGroups >
     */
    public List < InvMarketGroups > getParentGroupID(int code){
        try {
            TypedQuery < InvMarketGroups > typedQuery = 
                entityManager.createNamedQuery("InvMarketGroups.findByParentGroupID", InvMarketGroups.class);
            typedQuery.setParameter("parentGroupID", code);
            if ( typedQuery.getResultList().isEmpty()){
                return new ArrayList<>();
            }else{
                return typedQuery.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Market GroupID
     * @param int code
     * @return < InvMarketGroups >
     */
    public List < InvMarketGroups > getMarketGroupID(int code){
        try {
            TypedQuery < InvMarketGroups > typedQuery = 
                entityManager.createNamedQuery("InvMarketGroups.findByMarketGroupID", InvMarketGroups.class);
            typedQuery.setParameter("marketGroupID", code);
            if ( typedQuery.getResultList().isEmpty()){
                return new ArrayList<>();
            }else{
                return typedQuery.getResultList();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
  
    }
}
