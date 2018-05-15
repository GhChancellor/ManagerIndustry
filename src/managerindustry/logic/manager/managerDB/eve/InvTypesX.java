/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.eve;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.skill.SkillX;

/**
 * SELECT * FROM industryDB.invTypes where invTypes.typeName = "scythe blueprint"; -- scythe typeID 976 scimitar 11979
 * 
 * 
 * SELECT * FROM industryDB.industryActivityMaterials, industryDB.invTypes
 * WHERE industryActivityMaterials.typeID = invTypes.typeID  AND
 * invTypes.typeName = CONCAT(( SELECT invTypes.typeName FROM industryDB.invTypes where invTypes.typeID ="11530" ), " Blueprint") AND
 * industryActivityMaterials.activityID = "1";
 * @author lele
 */
public class InvTypesX {
    private EntityManager entityManager;
    
    public InvTypesX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Get value skill like description or name....
     * @param int typeID
     * @param Boolean published
     * @param int attributeID
     * @return SkillX
     */
    public SkillX getSkillValues(int typeID, Boolean published, int attributeID){
        try {
            // Devo recupareare i valori misti di più taballe e metterle nella lista SkillX
            TypedQuery < SkillX > typedQueryTQ = 
              entityManager.createNamedQuery("InvTypes.findByTypeId-Published-AttributeID", SkillX.class);

            typedQueryTQ.setParameter("typeID", typeID);
            typedQueryTQ.setParameter("published", published);
            typedQueryTQ.setParameter("attributeID", attributeID);

            List < SkillX > skills = typedQueryTQ.setMaxResults(10).getResultList();
                        
            if ( skills.isEmpty() ){
                return null;
            }else{
                return skills.get(0);
            }            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }            
    }
    
    /**
     * Get name, convert ID to Name Drake ID 24698
     * @param int typeID
     * @return InvTypes
     */    
    public InvTypes getNameById ( int typeID ){
        try {
            TypedQuery < InvTypes > nameByIdTQ = 
             entityManager.createNamedQuery("InvTypes.findByTypeID", InvTypes.class);
            
            nameByIdTQ.setParameter("typeID", typeID);
            List < InvTypes > invTypeses = nameByIdTQ.getResultList();
            
            if ( invTypeses.isEmpty()){
                return null;
            }
            return invTypeses.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
    
    /**
     * Get Types Name, convert name to ID like Drake ID 24698
     * @param String name
     * @return InvTypes 
     */   
    public InvTypes getIdByName(String name){
        try {
            TypedQuery < InvTypes > idByNameTQ = 
             entityManager.createNamedQuery("InvTypes.findByTypeName", InvTypes.class);
        
            idByNameTQ.setParameter("typeName", name);
            List < InvTypes > invTypeses = idByNameTQ.getResultList();
            
            if ( invTypeses.isEmpty() ){
                return null ;
            }
            return invTypeses.get(0);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
    
    
    /**
     * DBG
     * @deprecated 
     * @param code
     * @return List < InvTypes >
     */
    public List < InvTypes > getAllDrone(int code){
        try {
            TypedQuery < InvTypes > typedQuery = 
                entityManager.createNamedQuery("InvTypes.findByParentGroupID_InvTypes", InvTypes.class);

            typedQuery.setParameter("parentGroupID", code);
            
            List<InvTypes> resultList = typedQuery.getResultList();
            
            if (resultList.isEmpty()){
                return null;
            }else{
                return resultList;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }   
    
    /**
     * DBG
     * Fighters > Carrier-based Fighters > heavy fighter or light fighter or support fighter
     * @deprecated 
     * @param code
     * @return List < InvTypes >
     */
    public List < InvTypes > getAllCategory(int code){
        try {
            TypedQuery < InvTypes > typedQuery = 
                entityManager.createNamedQuery("InvTypes.findByMarketGroupID_InvTypes", InvTypes.class);

            typedQuery.setParameter("marketGroupID", code);
            List<InvTypes> resultList = typedQuery.getResultList();
            
            if (resultList.isEmpty()){
                return null;
            }else{
                return resultList;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }   
    
    
}
