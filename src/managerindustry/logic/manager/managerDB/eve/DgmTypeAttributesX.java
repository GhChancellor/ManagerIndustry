/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.eve;

import java.util.ArrayList;
import managerindustry.logic.manager.managerDB.ManagerDB;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.db.entities.eve.InvTypes;
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
        AND dgmTypeAttributes.attributeID="2600" AND invTypes.typeID="35825";                
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
    
    /**
     * @deprecated 
     * Get Required Skill
     * @param typeID
     * @return List < DgmTypeAttributes >
     */
    public List < DgmTypeAttributes > getRequiredSkills(int typeID){
        try {
            TypedQuery < DgmTypeAttributes > requiredSkill =
             entityManager.createNamedQuery("DgmTypeAttributes.findAttrybuteRequiredSkill", DgmTypeAttributes.class);
            requiredSkill.setParameter("typeID", typeID);
            return requiredSkill.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * @deprecated 
     * Get Required Skill give only attributeID 182-183-184
     * @param typeID
     * @return List < Integer >
     */
    public List < Integer > getRequiredSkillAttribute(int typeID){
        List < DgmTypeAttributes > dgmTypeAttributes = getRequiredSkills(typeID);
        
        List < Integer > attributeIds = new ArrayList<>();

        int attributeID;
        for (DgmTypeAttributes dgmTypeAttribute : dgmTypeAttributes) {
            attributeID = dgmTypeAttribute.getDgmTypeAttributesPK().getAttributeID();
            
            if (attributeID == 182 || attributeID == 183 || attributeID == 184 ){
                attributeIds.add(dgmTypeAttribute.getValueInt());
            }
        }
        return attributeIds;
    }
}
