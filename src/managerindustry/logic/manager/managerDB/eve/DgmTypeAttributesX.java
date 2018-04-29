/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.eve;

import managerindustry.logic.manager.managerDB.ManagerDB;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.InvTypes;
//import managerindustry.logic.manager.managerDB.ManagerDBEve;

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
    public List < DgmTypeAttributes > getTypeAttributes( int typeID ){
        try {
            EntityManager dgmTypeAttributesEM = entityManager;

            TypedQuery < DgmTypeAttributes > dgmTypeAttributesTQ =
             dgmTypeAttributesEM.createNamedQuery("DgmTypeAttributes.findByTypeID", DgmTypeAttributes.class);

            dgmTypeAttributesTQ.setParameter("typeID", typeID);
            return dgmTypeAttributesTQ.getResultList();        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
    
    /**
     * DBG Da unificare in un unica query
     * Convert Name to ID and Get value typeID, AttributedId, ValueInt and ValueFloat 
     * @param String bpoName
     * @param int attributeID
     * @return DgmTypeAttributes
     */
    public DgmTypeAttributes getItemDescription(String bpoName, int attributeID){
        /*
        SELECT * FROM industryDB.dgmTypeAttributes, industryDB.dgmAttributeTypes, industryDB.invTypes
        WHERE invTypes.typeID = dgmTypeAttributes.typeID 
        AND dgmAttributeTypes.attributeID = dgmTypeAttributes.attributeID
        AND dgmTypeAttributes.attributeID="2600" AND invTypes.typeID="35825";
        */

        ////         Convert name to Id
        InvTypes invTypes = ManagerDB.getInstance().invTypes().getIdByName(bpoName);
         // ManagerDBEve.getInstance().getInvTypes_IdByName(bpoName);
        
        if ( invTypes == null ){
            return null;
        }
        
        DgmTypeAttributes dgmTypeAttributes = 
          ManagerDB.getInstance().dgmTypeAttributes().getValueStation(attributeID, attributeID);
//         ManagerDBEve.getInstance().getValueStation(invTypes.getTypeID(), attributeID );
        
        if ( dgmTypeAttributes == null){
            return null;
        }else{
            return dgmTypeAttributes;
        }
    }

    /**
     * Get bonus station like fuel consumption, manufacturing and science job required time
     * @param int typeID
     * @param int attributeID
     * @return DgmTypeAttributes
     */
    private DgmTypeAttributes getValueStation( int typeID, int attributeID){
        try {
            EntityManager getValueStationEM = entityManager;
            
            TypedQuery < DgmTypeAttributes > getValueStationTQ = 
             getValueStationEM.createNamedQuery("DgmTypeAttributes.findByValueStation", DgmTypeAttributes.class);
            
            getValueStationTQ.setParameter("attributeID", attributeID);
            getValueStationTQ.setParameter("typeID", typeID);
            
            List < DgmTypeAttributes > dgmTypeAttributeses = getValueStationTQ.getResultList();
            
            if ( dgmTypeAttributeses.isEmpty()){
                return null;
            }else{
                return  dgmTypeAttributeses.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;        
        }
    }
    
    
}
