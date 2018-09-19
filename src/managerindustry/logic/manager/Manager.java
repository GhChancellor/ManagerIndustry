/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import managerindustry.logic.manager.apiEsi.ApiEsi;
import managerindustry.logic.manager.db.Db;
import managerindustry.logic.manager.game.Game;

/**
 *
 * @author lele
 */
public class Manager {
    private static Manager instance = null;
    private EntityManager entityManager = 
        Persistence.createEntityManagerFactory("ManagerIndustryPU").createEntityManager();
    
    private Db db = null;
    
    public static Manager getInstance(){
        if ( instance == null )
            instance = new Manager();
        return instance;
    }

    public Manager() {
        this.db = new Db(entityManager);
    }

    /**
     * Manager DB
     * @return Db
     */
    public Db db(){
        return db;
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
     * Game
     * @return Game
     */
    public Game game(){
        Game game = new Game();
        return game;
    }
    
        
    
//    public SystemCostXXX systemCost(){
//        SystemCostXXX systemCost = new SystemCostXXX();
//        return systemCost;
//        
//    }

}
