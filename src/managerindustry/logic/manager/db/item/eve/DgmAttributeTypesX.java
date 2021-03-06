/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.eve;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.eve.DgmAttributeTypes;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class DgmAttributeTypesX {
    private EntityManager entityManager;

    public DgmAttributeTypesX() {
        entityManager = Manager.getInstance().db().getEntityManager();
    }
    
    /**
     * Get name attribute like min Range, Medium Slot, CPU...
     * @param DgmTypeAttributesPK dgmTypeAttributesPK
     * @return DgmAttributeTypes 
     */
    public DgmAttributeTypes getAttributeTypes( int attributeID ){
        try {
            TypedQuery < DgmAttributeTypes > dgmAttributeTypesTQ = 
             entityManager.createNamedQuery("DgmAttributeTypes.findByAttributeID", DgmAttributeTypes.class);

            dgmAttributeTypesTQ.setParameter("attributeID", attributeID);
            
            List < DgmAttributeTypes > attributeTypeses = dgmAttributeTypesTQ.getResultList();

            if ( attributeTypeses.isEmpty() ){
                return null;
            }else{
                return attributeTypeses.get(0);
            }              
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }          
    }   
}
