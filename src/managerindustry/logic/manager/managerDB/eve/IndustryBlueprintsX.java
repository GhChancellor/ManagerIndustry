/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.eve;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.eve.IndustryBlueprints;

/**
 *
 * @author lele
 */
public class IndustryBlueprintsX {
    private EntityManager entityManager;

    public IndustryBlueprintsX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public IndustryBlueprints getMaxProductionLimit(int typeId){
        TypedQuery < IndustryBlueprints > industryBlueprintsTQ =
         entityManager.createNamedQuery("IndustryBlueprints.findByTypeID", IndustryBlueprints.class);
        
        industryBlueprintsTQ.setParameter("typeID", typeId);
        
        List<IndustryBlueprints> resultList = industryBlueprintsTQ.getResultList();
        
        if (resultList.isEmpty()){
            return null;
        }else{
            return resultList.get(0);
        }
    }
}
