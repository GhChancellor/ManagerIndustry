/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import managerindustry.logic.apiEsiJson.ApiEsi;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.manager.build.Build;
import managerindustry.logic.manager.managerDB.Db;
import managerindustry.logic.manager.tax.SystemCostXXX;

/**
 *
 * @author lele
 */
public class Manager {
    private static Manager instance = null;
    private EntityManager entityManager = 
        Persistence.createEntityManagerFactory("ManagerIndustryPU").createEntityManager();
    
    public static Manager getInstance(){
        if ( instance == null )
            instance = new Manager();
        return instance;
    }
    
    /**
     * Manager DB
     * @return Db
     */
    public Db db(){
        Db managerDB = new Db(entityManager);
        return managerDB;
    }
    
    /**
     * Api Esi
     * @return ApiEsi
     */
    public ApiEsi apiEsi(){
        ApiEsi apiEsi = new ApiEsi();
        return apiEsi;
    }
    
    /**
     * Build
     * @return Build
     */
    public Build build(){
        Build build = new Build();
        return build;
    }
    
//    public SystemCostXXX systemCost(){
//        SystemCostXXX systemCost = new SystemCostXXX();
//        return systemCost;
//        
//    }
      
}
