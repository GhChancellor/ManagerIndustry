/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.managerDB.GenericManager;

import java.util.List;
import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.prove.managerDB.ManagerDBX;


//import managerindustry.logic.manager.managerDB.ManagerSQLUser;


/**
 * DBG Forse da cancellare
 * @author lele
 */
public class ManagerLoginSqlX {
    // http://www.objectdb.com/java/jpa/persistence/update
    
    private static ManagerLoginSqlX instance = null;
    
    public static ManagerLoginSqlX getInstance (){
        if ( instance == null ) {
            instance = new ManagerLoginSqlX();
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
          ManagerDBX.getInstance().sqlUserX().getUserApiEntities();
//         ManagerSQLUser.getInstance().getUserApiEntities();

        return userApiEntities;     
    }
    /**
     * Get User Api Entities without parameters userEnable
     * @return List < UserApiEntity > 
     */
    public List < UserApiEntity > getAllUserApiEntities(){
        List < UserApiEntity > userApiEntities =
          ManagerDBX.getInstance().sqlUserX().getUserApiEntities();
//         ManagerSQLUser.getInstance().getUserApiEntities();

        return userApiEntities;     
    }
    
    /**
     * add write DB User Api from login
     * @param  
     */
    public void addUserApiIndex(UserApiEntity userApiEntity){
          ManagerDBX.getInstance().sqlUserX().addUserApiEntity(userApiEntity);
//        ManagerSQLUser.getInstance().addUserApiEntity(userApiEntity);
    }
    
    /**
     * Delete from DB User Api
     * @param Integer id 
     */
    public void deleteUserApi(UserApiEntity userApiEntity){
        ManagerDBX.getInstance().sqlUserX().deleteUserApiEntity(userApiEntity);
//        ManagerSQLUser.getInstance().deleteUserApiEntity(userApiEntity);
    }
    
    /**
     * Update value of User Api Entity
     * @param userApiEntity 
     */
    public void updateUserApiEntity(UserApiEntity userApiEntity){
          ManagerDBX.getInstance().sqlUserX().updateUserApiEntity(userApiEntity);
//        ManagerSQLUser.getInstance().updateUserApiEntity(userApiEntity);
    }
}
