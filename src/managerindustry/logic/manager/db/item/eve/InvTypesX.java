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
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.prove.skill.old.Skill_OLD;
import managerindustry.logic.prove.skill.old.SkillX_OLD;

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
     * @deprecated DISABLE!!!!
     * Get value skill like description or name....
     * @param int typeID
     * @param Boolean published
     * @param int attributeID
     * @return SkillX_OLD
     */
    public SkillX_OLD getSkillValues(int typeID, Boolean published, int attributeID){
        return null;
//        try {
//            // Devo recupareare i valori misti di più taballe e metterle nella lista SkillX_OLD
//            TypedQuery < SkillX_OLD > typedQueryTQ = 
//              entityManager.createNamedQuery("InvTypes.findByTypeId-Published-AttributeID", SkillX_OLD.class);
//
//            typedQueryTQ.setParameter("typeID", typeID);
//            typedQueryTQ.setParameter("published", published);
//            typedQueryTQ.setParameter("attributeID", attributeID);
//
//            List < SkillX_OLD > skills = typedQueryTQ.setMaxResults(10).getResultList();
//                        
//            if ( skills.isEmpty() ){
//                return null;
//            }else{
//                return skills.get(0);
//            }            
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }            
    }
    
    /**
     * Get items from ID 
     * @param int typeID
     * @return InvTypes
     */    
    public InvTypes getInvTypesById ( int typeID ){
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
     * Get items from name
     * @param String name
     * @return InvTypes 
     */   
    public InvTypes getInvTypesByName(String name){
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
     * Get ParentGroupID
     * @param code
     * @return List < InvTypes >
     */
    public List < InvTypes > getParentGroupID(int code, boolean published){
        try {
            TypedQuery < InvTypes > typedQuery = 
                entityManager.createNamedQuery("InvTypes.findByParentGroupID", InvTypes.class);

            typedQuery.setParameter("parentGroupID", code);
            typedQuery.setParameter("published", published);
            
            List<InvTypes> resultList = typedQuery.getResultList();
            
            if (resultList.isEmpty()){
                return new ArrayList<>();
            }else{
                return resultList;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }   
    
    /**
     * @deprecated 
     * Get MarketGroupID
     * @param code
     * @return List < InvTypes >
     */
    public List < InvTypes > getMarketGroupID(int code, boolean published){
        try {
            TypedQuery < InvTypes > typedQuery = 
                entityManager.createNamedQuery("InvTypes.findByMarketGroupIDXXX", InvTypes.class);

            typedQuery.setParameter("marketGroupID", code);
            typedQuery.setParameter("published", published);
            
            List<InvTypes> resultList = typedQuery.getResultList();
            
            if (resultList.isEmpty()){
                return new ArrayList<>();
            }else{
                return resultList;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }   
    
}
