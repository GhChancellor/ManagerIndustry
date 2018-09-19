/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.eve;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.eve.InvNames;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class InvNamesX {
    private EntityManager entityManager;    

    public InvNamesX() {
        entityManager = Manager.getInstance().db().getEntityManager();
    }

    /**
     * Get solar system ID
     * @param String solarSystem
     * @return InvNames
     */
    public InvNames getSolarSystemID(String solarSystem){
        try {
            TypedQuery < InvNames > solarSystemTQ = 
             entityManager.createNamedQuery("InvNames.findByItemName", InvNames.class);
            
            solarSystemTQ.setParameter("itemName", solarSystem);
            
            List < InvNames > invNameses = solarSystemTQ.getResultList();
            
            if (invNameses.isEmpty()){
                return null;
            }else{
                return invNameses.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
}
