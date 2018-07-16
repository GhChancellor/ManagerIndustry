/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.oneToMany;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author lele
 */
public class Manager {
    private static Manager instance = null;
    private EntityManager entityManager = 
        Persistence.createEntityManagerFactory("ManagerIndustryPU").createEntityManager();
    
    private ManagerUserEntityJpaController AvoidDuplicateRigEntityJpaController = 
        new ManagerUserEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));       
     
    public static Manager getInstance(){
        if ( instance == null )
            instance = new Manager();
        return instance;
    }

    public void add(){
        UserEntity userEntity = new UserEntity();
        userEntity.setNane("Lele");
        userEntity.setSurname("Marty");
        
        ManagerUserEntity managerUserEntity = new ManagerUserEntity();
        managerUserEntity.addUsers(userEntity);
        
        AvoidDuplicateRigEntityJpaController.create(managerUserEntity);
    }
    
}
