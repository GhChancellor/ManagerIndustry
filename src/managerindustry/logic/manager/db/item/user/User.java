/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.user;

import javax.persistence.EntityManager;
import managerindustry.logic.manager.db.item.user.login.LoginSql;
import managerindustry.logic.manager.db.item.user.sqlUser.SqlUser;

/**
 *
 * @author lele
 */
public class User {
    private EntityManager entityManager;

    public User(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /**
     * Get all values of the SqlUserX ( entities )
     * @return SqlUser
     */    
    public SqlUser sqlUser(){
        SqlUser sqlUser = new SqlUser(entityManager);
        return sqlUser;
    }    
    
    /**
     * Login Sql
     * @return LoginSql
     */
    public LoginSql loginSql(){
        LoginSql loginSql = new LoginSql();
        return loginSql;
    }
}
