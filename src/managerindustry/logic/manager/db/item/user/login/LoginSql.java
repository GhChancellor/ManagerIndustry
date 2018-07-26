/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.user.login;

import java.util.List;
import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.manager.Manager;

/**
 * DBG Forse da cancellare
 * @author lele
 */
public class LoginSql {
    // http://www.objectdb.com/java/jpa/persistence/update

    public LoginSql(){
    }

    /**
     * Get User Api Index
     * @return List < UserApiIndexEntity >
     */
    public List < UserApiEntity > getUserApiEntities() {
        List < UserApiEntity > userApiEntities =
                Manager.getInstance().db().user().sqlUser().getUserApiEntities();
        
        return userApiEntities;     
    }
    /**
     * Get User Api Entities without parameters userEnable
     * @return List < UserApiEntity > 
     */
    public List < UserApiEntity > getAllUserApiEntities(){
        List < UserApiEntity > userApiEntities =
          Manager.getInstance().db().user().sqlUser().getUserApiEntities();

        return userApiEntities;     
    }
    
    /**
     * add write DB User Api from login
     * @param  
     */
    public void addUserApiIndex(UserApiEntity userApiEntity){
          Manager.getInstance().db().user().sqlUser().addUserApiEntity(userApiEntity);
    }
    
    /**
     * Delete from DB User Api
     * @param Integer id 
     */
    public void deleteUserApi(UserApiEntity userApiEntity){
        Manager.getInstance().db().user().sqlUser().deleteUserApiEntity(userApiEntity);
    }
    
    /**
     * Update value of User Api Entity
     * @param userApiEntity 
     */
    public void updateUserApiEntity(UserApiEntity userApiEntity){
          Manager.getInstance().db().user().sqlUser().updateUserApiEntity(userApiEntity);
    }
}
