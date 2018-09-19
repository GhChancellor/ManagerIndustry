/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db;

import javax.persistence.EntityManager;
import managerindustry.logic.manager.db.item.Item;
import managerindustry.logic.manager.db.item.user.User;

/**
 *
 * @author lele
 */
public class Db {
    private EntityManager entityManager;
    
    public Db(EntityManager entityManager) {
        this.entityManager = entityManager;        
    }

    public EntityManager getEntityManager(){
        return entityManager;
    }
    
    /**
     * Item
     * @return Item
     */
    public Item item(){
        return new Item();
    }
    
    /**
     * User
     * @return User
     */
    public User user(){
        return new User();
    }
}
