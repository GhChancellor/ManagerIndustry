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
import managerindustry.db.entities.IndustryActivityMaterials;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.enumName.RamActivitiesEnum;
//import managerindustry.logic.manager.managerDB.ManagerDBEve;

/**
 *
 * @author lele
 */
public class IndustryActivityMaterialsX {
    private EntityManager entityManager;

    public IndustryActivityMaterialsX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    

    /**
     * Get Type Materials, show Which and how many material need to build an Object
     * 10 di tritanium, 20 zydrine.....
     * @param int invType
     * @return List < InvTypeMaterials >
     */
    public List < IndustryActivityMaterials > materialsID( int typeID, RamActivitiesEnum activitiesEnum){
        
        try {
            EntityManager materialsEM = entityManager;
            
            TypedQuery < IndustryActivityMaterials > materialsTQ = 
             materialsEM.createNamedQuery("IndustryActivityMaterials.findByTypeID", IndustryActivityMaterials.class);
            
            materialsTQ.setParameter("typeID", typeID);
            materialsTQ.setParameter("activityID", activitiesEnum.getCode());
            
            return materialsTQ.getResultList();
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
    public List < IndustryActivityMaterials > getMaterialNeedByName(String bpoName, RamActivitiesEnum activitiesEnum){
        /*
         SELECT * FROM industryDB.industryActivityMaterials, industryDB.invTypes
        WHERE industryActivityMaterials.typeID = invTypes.typeID  AND
        invTypes.typeName = CONCAT(( SELECT invTypes.typeName FROM industryDB.invTypes where invTypes.typeID ="11530" ), " Blueprint") AND
        industryActivityMaterials.activityID = "1";
        */
        
////         Convert name to Id
        InvTypes invTypes = ManagerDB.getInstance().invTypes().getIdByName(bpoName);
         // ManagerDBEve.getInstance().getInvTypes_IdByName(bpoName);
        
        if ( invTypes == null ){
            return null;
            
            // return new ArrayList<>();
        }
        
        // convert name ( from InvTypes ) to Materials Needed ( from  IndustryActivityMaterials )
        List < IndustryActivityMaterials > invTypeMaterialses = 
           ManagerDB.getInstance().industryActivityMaterials().materialsID(invTypes.getTypeID(), activitiesEnum );
        // ManagerDBEve.getInstance().getIndustryActivityMaterialsID( invTypes.getTypeID() );
        if ( invTypeMaterialses.isEmpty() ){
            return null;
        }
        
        return invTypeMaterialses;       
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
        
        InvTypes invTypes = ManagerDB.getInstance().invTypes().getNameById(industryActivityMaterials.getMaterialTypeID());
         // ManagerDBEve.getInstance().getInvTypes_NameById(industryActivityMaterials.getMaterialTypeID());
        
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
