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
import managerindustry.db.entities.eve.DgmTypeAttributes;

/**
 * 
 * @author lele
 */
public class DgmTypeAttributesX {
    private EntityManager entityManager;

    public DgmTypeAttributesX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Get value typeID, AttributedId, ValueInt and ValueFloat
     * @param int typeID
     * @return List < DgmTypeAttributes >
     */
    public List < DgmTypeAttributes > getTypeAttributesByTypeId( int typeID ){
        try {
            TypedQuery < DgmTypeAttributes > dgmTypeAttributesTQ =
             entityManager.createNamedQuery("DgmTypeAttributes.findByTypeID", DgmTypeAttributes.class);

            dgmTypeAttributesTQ.setParameter("typeID", typeID);
            return dgmTypeAttributesTQ.getResultList();        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    /**
     * Get value station/rig like bonus, reductionManufacturingMaterial, calibration....
     * @param int typeID
     * @param int attributeID
     * @return DgmTypeAttributes
     */
    public DgmTypeAttributes getTypeAttributesByTypeId_ByAttributeID( int typeID, int attributeID){
        /*
        SELECT * FROM industryDB.dgmTypeAttributes, industryDB.dgmAttributeTypes, industryDB.invTypes
        WHERE invTypes.typeID = dgmTypeAttributes.typeID 
        AND dgmAttributeTypes.attributeID = dgmTypeAttributes.attributeID
        AND invTypes.typeID="35825";                
        */

        try {
            TypedQuery < DgmTypeAttributes > typeAttributes = 
             entityManager.createNamedQuery("DgmTypeAttributes.findByTypeId_ByAttributeID", DgmTypeAttributes.class);
            
            typeAttributes.setParameter("attributeID", attributeID);
            typeAttributes.setParameter("typeID", typeID);
            
            List < DgmTypeAttributes > dgmTypeAttributeses = typeAttributes.getResultList();
            
            if ( dgmTypeAttributeses.isEmpty()){
                return null;
            }else{
                return dgmTypeAttributeses.get(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;        
        }
        
    }
    
}
