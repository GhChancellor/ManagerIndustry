/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.DgmAttributeTypes;
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvNames;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.skill.Skill;


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
public class ManagerDB {
    private static ManagerDB instance = null;
    private EntityManager entityManager = Persistence.createEntityManagerFactory("ManagerIndustryPU").createEntityManager();
    
    public static ManagerDB getInstance (){
        if ( instance == null ){
            instance = new ManagerDB();
        }
        return instance;
    }    
    
    /**
     * Get value skill like description or name....
     * @return List <InvTypes>
     */
    public Skill getInvTypeSkillValues(int typeID, boolean published, int attributeID){
        try {
            EntityManager getInvTypeGroupAndNameEM = entityManager;
            
            // Devo recupareare i valori misti di più taballe e metterle nella lista Skill
            TypedQuery < Skill > typedQueryTQ = 
              getInvTypeGroupAndNameEM.createNamedQuery("InvTypes.findByTypeId-Published-AttributeID", Skill.class);
            
            typedQueryTQ.setParameter("typeID", typeID);
            typedQueryTQ.setParameter("published", published);
            typedQueryTQ.setParameter("attributeID", attributeID);
            
            List < Skill > skills = typedQueryTQ.getResultList();
            
            if ( skills.isEmpty() ){
                return null;
            }else{
                
//                Skill skill = new Skill();
//                skill.setName( skills.get(0).getName() );
                
                
//                skill.setDescription(skills.get(0).getDescription() );
//                skill.setValueFloat(skills.get(0).getValueFloat() );
//                skill.setValueInt(skills.get(0).getValueInt() );
                
                System.out.println("");
                return skills.get(0);
            }            
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }            
    }       
    
    
    /**
     * Get solar system ID
     * @param String solarSystem
     * @return InvNames
     */
    public InvNames getInvNamesSolarSystemID(String solarSystem){
        try {
            EntityManager getInvNamesSolarSystemID = entityManager;
            
            TypedQuery < InvNames > typedQueryTQ = 
             getInvNamesSolarSystemID.createNamedQuery("InvNames.findByItemName", InvNames.class);
            
            typedQueryTQ.setParameter("itemName", solarSystem);
            
            List < InvNames > invNameses = typedQueryTQ.getResultList();
            
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
    
    /**
     * Get name, convert ID to Name Drake ID 24698
     * @param int name
     * @return InvTypes
     */    
    public InvTypes getInvTypesNameById ( int typeID ){
        try {
            EntityManager getInvTypesNameEM = entityManager;             

            TypedQuery < InvTypes > getInvTypesNameTQ = 
             getInvTypesNameEM.createNamedQuery("InvTypes.findByTypeID", InvTypes.class);
            
            getInvTypesNameTQ.setParameter("typeID", typeID);
            List < InvTypes > invTypeses = getInvTypesNameTQ.getResultList();
            
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
     * @return List < InvTypes >
     */   
    public InvTypes getInvTypesIdByName(String name){
        try {
            EntityManager getInvTypesEM = entityManager;
        
            TypedQuery < InvTypes > getInvTypesTQ = 
             getInvTypesEM.createNamedQuery("InvTypes.findByTypeName", InvTypes.class);
        
            getInvTypesTQ.setParameter("typeName", name);
            List < InvTypes > invTypeses = getInvTypesTQ.getResultList();
            
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
     * Get name attribute like min Range, Medium Slot, CPU...
     * @param DgmTypeAttributesPK dgmTypeAttributesPK
     * @return DgmAttributeTypes 
     */
    public DgmAttributeTypes getDgmAttributeTypes( int attributeID ){
        try {
            EntityManager getDgmAttributeTypesEM = entityManager;

            TypedQuery < DgmAttributeTypes > getDgmAttributeTypesTQ = 
             getDgmAttributeTypesEM.createNamedQuery("DgmAttributeTypes.findByAttributeID", DgmAttributeTypes.class);

            getDgmAttributeTypesTQ.setParameter("attributeID", attributeID);
            
            List < DgmAttributeTypes > attributeTypeses = getDgmAttributeTypesTQ.getResultList();

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
    
    /**
     * Get value typeID, AttributedId, ValueInt and ValueFloat
     * @param invTypes
     * @return List < DgmTypeAttributes >
     */
    public List < DgmTypeAttributes > getDgmTypeAttributes( int typeID ){
        try {
            EntityManager getDgmTypeAttributesEM = entityManager;

            TypedQuery < DgmTypeAttributes > getDgmTypeAttributesTQ =
             getDgmTypeAttributesEM.createNamedQuery("DgmTypeAttributes.findByTypeID", DgmTypeAttributes.class);

            getDgmTypeAttributesTQ.setParameter("typeID", typeID);
            return getDgmTypeAttributesTQ.getResultList();        
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }   
        
    /**
     * Get Type Materials, show Which and how many material need to build an Object
     * 10 di tritanium, 20 zydrine.....
     * @param int invType
     * @return List < InvTypeMaterials >
     */
    public List < IndustryActivityMaterials > getIndustryActivityMaterialsID( int typeID){
        
        try {
            EntityManager getInvTypeMaterialsEM = entityManager;
            
            TypedQuery < IndustryActivityMaterials > getInvTypeMaterialsTQ = 
             getInvTypeMaterialsEM.createNamedQuery("IndustryActivityMaterials.findByTypeID", IndustryActivityMaterials.class);
            
            getInvTypeMaterialsTQ.setParameter("typeID", typeID);
            getInvTypeMaterialsTQ.setParameter("activityID", 1);
            
            return getInvTypeMaterialsTQ.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }            
    
    /**
     * DBG Da unificare in un unica query
     * Get all material and Value needed for build an object like ID, quantity, name ecc
     * @param String nameBPO
     * @return < IndustryActivityMaterials >
     */
    public List < IndustryActivityMaterials > getMaterialNeedByName(String bpoName){
        /*
         SELECT * FROM industryDB.industryActivityMaterials, industryDB.invTypes
        WHERE industryActivityMaterials.typeID = invTypes.typeID  AND
        invTypes.typeName = CONCAT(( SELECT invTypes.typeName FROM industryDB.invTypes where invTypes.typeID ="11530" ), " Blueprint") AND
        industryActivityMaterials.activityID = "1";
        */
        
////         Convert name to Id
        InvTypes invTypes = ManagerDB.getInstance().getInvTypesIdByName(bpoName);
        
        if ( invTypes == null ){
            return null;
            
            // return new ArrayList<>();
        }
        
        // convert name ( from InvTypes ) to Materials Needed ( from  IndustryActivityMaterials )
        List < IndustryActivityMaterials > invTypeMaterialses  = ManagerDB.getInstance().getIndustryActivityMaterialsID( invTypes.getTypeID() );
        if ( invTypeMaterialses.isEmpty() ){
            return null;
        }
        
        return invTypeMaterialses;       
    }             

    /**
     * DBG Da unificare in un unica query
     * Convert Name to ID and Get value typeID, AttributedId, ValueInt and ValueFloat
     * @param String bpoName
     * @return List < DgmTypeAttributes >
     */
    public DgmTypeAttributes getItemDescription(String bpoName, int attributeID){
        /*
        SELECT * FROM industryDB.dgmTypeAttributes, industryDB.dgmAttributeTypes, industryDB.invTypes
        WHERE invTypes.typeID = dgmTypeAttributes.typeID 
        AND dgmAttributeTypes.attributeID = dgmTypeAttributes.attributeID
        AND dgmTypeAttributes.attributeID="2600" AND invTypes.typeID="35825";
        */

        ////         Convert name to Id
        InvTypes invTypes = ManagerDB.getInstance().getInvTypesIdByName(bpoName);
        
        if ( invTypes == null ){
            return null;
        }
        
        DgmTypeAttributes  dgmTypeAttributes = 
         ManagerDB.getInstance().getValueStation(invTypes.getTypeID(), attributeID );
        
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
    
    
    
    
    
//    --------------------------------------------------------------------
    /**
     * UNUSED
     * @param invTypes
     * @param industryActivityMaterials
     * @return 
     */
    public List < IndustryActivityMaterials > getMaterialNeedByNameDBG(InvTypes invTypes, IndustryActivityMaterials industryActivityMaterials){
        industryActivityMaterials.setActivityID(1);
        
        try {
            EntityManager getInvTypeMaterialsEM = entityManager;
            
            TypedQuery < IndustryActivityMaterials > getInvTypeMaterialsTQ = 
             getInvTypeMaterialsEM.createNamedQuery("IndustryActivityMaterials.findByTypeName", IndustryActivityMaterials.class);
            
            getInvTypeMaterialsTQ.setParameter("typeName", invTypes.getTypeName());
            getInvTypeMaterialsTQ.setParameter("activityID", industryActivityMaterials.getActivityID());
            
            return getInvTypeMaterialsTQ.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * UNUSED
     * Get Material Need By Id
     * @param industryActivityMaterials
     * @return List < IndustryActivityMaterials > 
     */
    public List < IndustryActivityMaterials > getMaterialNeedById( IndustryActivityMaterials industryActivityMaterials){
        
        InvTypes invTypes = ManagerDB.getInstance().getInvTypesNameById(industryActivityMaterials.getMaterialTypeID());
        
        industryActivityMaterials.setActivityID(1);
        
        try {
            EntityManager getInvTypeMaterialsEM = entityManager;
            
            TypedQuery < IndustryActivityMaterials > getInvTypeMaterialsTQ = 
             getInvTypeMaterialsEM.createNamedQuery("IndustryActivityMaterials.findByTypeName", IndustryActivityMaterials.class);
            
            getInvTypeMaterialsTQ.setParameter("typeName", invTypes.getTypeName() + " Blueprint");
            getInvTypeMaterialsTQ.setParameter("activityID", industryActivityMaterials.getActivityID());
            
            return getInvTypeMaterialsTQ.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
    
}
