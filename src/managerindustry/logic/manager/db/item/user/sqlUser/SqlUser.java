/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.user.sqlUser;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import managerindustry.db.controllers.UserApiEntityJpaController;
import managerindustry.db.controllers.exceptions.NonexistentEntityException;
import managerindustry.db.entities.user.UserApiEntity;
//import managerindustry.logic.manager.managerDB.ManagerSQLUser;

/**
 *
 * @author lele
 */
public class SqlUser {
    private EntityManager entityManager;
    
    private EntityManagerFactory entityManagerFactoryEMF =
     Persistence.createEntityManagerFactory("ManagerIndustryPU"); 
    
//    private UserApiEntityJpaController 
//     userKeyIDJpaController = new UserApiEntityJpaController
//     (Persistence.createEntityManagerFactory("ManagerIndustryPU"));   

    public SqlUser() {
    }

    public SqlUser(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Get User Api Entities with parameters userEnable
     * @return List < UserApiEntity > UserApiEntity
     */
    public List < UserApiEntity > getUserApiEntities(){
        try {
            TypedQuery < UserApiEntity > getUserApiEntityTQ =
             entityManager.createNamedQuery("getUserApiEntities", UserApiEntity.class);
            
            getUserApiEntityTQ.setParameter("userEnable", true);

            return getUserApiEntityTQ.getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }
    }
    
    /**
     * Get User Api Entities without parameters userEnable
     * @return List < UserApiEntity > UserApiEntity
     */
    public List < UserApiEntity > getAllUserApiEntities(){
        try {
            TypedQuery < UserApiEntity > getUserApiEntityTQ =
             entityManager.createNamedQuery("getUserApiEntities", UserApiEntity.class);

            return getUserApiEntityTQ.getResultList();            
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }
    }
    
    /**
     * Add User Api Inde xEntity
     * @param userApiEntity 
     */
    public void addUserApiEntity(UserApiEntity userApiEntity){
        try {
            UserApiEntityJpaController userApiEntityJpaController = new UserApiEntityJpaController(entityManagerFactoryEMF);            
            userApiEntityJpaController.create(userApiEntity);        
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }    
    
    /**
     * Update User Api Index 
     * @param UserApiIndexEntity userApiIndexEntity 
     */
    public void updateUserApiEntity(UserApiEntity userApiEntity){
        try {
            UserApiEntityJpaController userApiEntityJpaController = 
             new UserApiEntityJpaController(entityManagerFactoryEMF);

            userApiEntityJpaController.edit(userApiEntity);            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Delete User Api Entity
     * @param UserApiEntity userApiEntity 
     */
    public void deleteUserApiEntity(UserApiEntity userApiEntity){
        UserApiEntityJpaController userApiEntityJpaController = 
         new UserApiEntityJpaController(entityManagerFactoryEMF);

        try {
            userApiEntityJpaController.destroy(userApiEntity.getId());
        } catch (NonexistentEntityException ex) {
            ex.printStackTrace();
        }
    }
       
    /**
     * Get User Api Entity
     * @return UserApiEntity UserApiEntity
     */
    public UserApiEntity getUserApiEntity(){
        try {
            TypedQuery < UserApiEntity > getUserApiEntityTQ =
             entityManager.createNamedQuery("getUserApiEntities", UserApiEntity.class);
            
            getUserApiEntityTQ.setParameter("userEnable", true);

            List < UserApiEntity > userApiEntitys = getUserApiEntityTQ.getResultList();

            if ( userApiEntitys.isEmpty()){
                return null;
            }else{
                return userApiEntitys.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }

    }        
}
