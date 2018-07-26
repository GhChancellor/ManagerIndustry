/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.eve;

import managerindustry.logic.manager.db.Db;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;
//import managerindustry.logic.manager.db.ManagerDBEve;

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
    public List < IndustryActivityMaterials > getMaterialsID( int typeID, RamActivitiesEnum activitiesEnum){
        try {
            TypedQuery < IndustryActivityMaterials > materialsTQ = 
             entityManager.createNamedQuery("IndustryActivityMaterials.findByTypeID", IndustryActivityMaterials.class);
            
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
        InvTypes typeID = Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName);
        
        if ( typeID == null ){
            return null;            
            // return new ArrayList<>();
        }
        
        // convert name ( from InvTypes ) to Materials Needed ( from  IndustryActivityMaterials )
        List < IndustryActivityMaterials > invTypeMaterialses = 
           Manager.getInstance().db().item().industryActivityMaterials().getMaterialsID(typeID.getTypeID(), activitiesEnum );

        if ( invTypeMaterialses.isEmpty() ){
            return null;
        }
        
        return invTypeMaterialses;       
    }      
}
