/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.old;

import java.util.List;
import managerindustry.db.entities.user.UserApiEntity;


import managerindustry.logic.manager.old.managerDB.ManagerSQLUser_OLD;


/**
 * DBG Forse da cancellare
 * @deprecated 
 * @author lele
 */
public class ManagerLoginSql_OLD {
    // http://www.objectdb.com/java/jpa/persistence/update
    
    private static ManagerLoginSql_OLD instance = null;
    
    public static ManagerLoginSql_OLD getInstance (){
        if ( instance == null ) {
            instance = new ManagerLoginSql_OLD();
        }
        return instance;
    }
            
    public void initDBLogin(){
    }
    
    /**
     * Get User Api Index
     * @return List < UserApiIndexEntity >
     */
    public List < UserApiEntity > getUserApiEntities(){
        List < UserApiEntity > userApiEntities = 
         ManagerSQLUser_OLD.getInstance().getUserApiEntities();

        return userApiEntities;     
    }
    /**
     * Get User Api Entities without parameters userEnable
     * @return List < UserApiEntity > 
     */
    public List < UserApiEntity > getAllUserApiEntities(){
        List < UserApiEntity > userApiEntities = 
         ManagerSQLUser_OLD.getInstance().getUserApiEntities();

        return userApiEntities;     
    }
    
    /**
     * add write DB User Api from login
     * @param  
     */
    public void addUserApiIndex(UserApiEntity userApiEntity){
        ManagerSQLUser_OLD.getInstance().addUserApiEntity(userApiEntity);
    }
    
    /**
     * Delete from DB User Api
     * @param Integer id 
     */
    public void deleteUserApi(UserApiEntity userApiEntity){
        ManagerSQLUser_OLD.getInstance().deleteUserApiEntity(userApiEntity);
    }
    
    /**
     * Update value of User Api Entity
     * @param userApiEntity 
     */
    public void updateUserApiEntity(UserApiEntity userApiEntity){
        ManagerSQLUser_OLD.getInstance().updateUserApiEntity(userApiEntity);
    }
}
