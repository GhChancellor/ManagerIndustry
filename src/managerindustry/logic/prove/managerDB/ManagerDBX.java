/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.managerDB;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import managerindustry.logic.prove.managerDB.cache.taxCostIndex.TaxSolarSystem;
import managerindustry.logic.prove.managerDB.eve.DgmAttributeTypesX;
import managerindustry.logic.prove.managerDB.eve.DgmTypeAttributesX;
import managerindustry.logic.prove.managerDB.eve.IndustryActivityMaterialsX;
import managerindustry.logic.prove.managerDB.eve.InvNamesX;
import managerindustry.logic.prove.managerDB.eve.InvTypesX;
import managerindustry.logic.prove.managerDB.eve.MapSolarSystemsX;
import managerindustry.logic.prove.managerDB.sqlUser.SqlUser;

/**
 *
 * @author lele
 */
public class ManagerDBX {
    private static ManagerDBX instance = null;
    private EntityManager entityManager = Persistence.createEntityManagerFactory("ManagerIndustryPU").createEntityManager();
     
    public static ManagerDBX getInstance(){
        if ( instance == null )
            instance = new ManagerDBX();
        return instance;
    }
    
    /**
     * Get all values of the InvTypes ( entities )
     * @return InvTypesX
     */
    public InvTypesX invTypes(){
        InvTypesX invTypesX = new InvTypesX(entityManager);
        return invTypesX;
    }
    
    /**
     * Get all values of the InvNames ( entities )
     * @return InvNamesX
     */
    public InvNamesX invNames(){
        InvNamesX invNamesX = new InvNamesX(entityManager);
        return invNamesX;
    }
    
    /**
     * Get all values of the DgmAttributeTypes ( entities )
     * @return DgmAttributeTypesX
     */
    public DgmAttributeTypesX dgmAttributeTypes(){
        DgmAttributeTypesX dgmAttributeTypesX = new DgmAttributeTypesX(entityManager);
        return dgmAttributeTypesX;
    }
    
    /**
     * Get all values of the DgmTypeAttributesX ( entities )
     * @return DgmTypeAttributesX
     */
    public DgmTypeAttributesX dgmTypeAttributes(){
        DgmTypeAttributesX dgmTypeAttributesX = new DgmTypeAttributesX(entityManager);
        return dgmTypeAttributesX;
    }
    
    /**
     * Get all values of the IndustryActivityMaterialsX ( entities )
     * @return IndustryActivityMaterialsX
     */
    public IndustryActivityMaterialsX industryActivityMaterials(){
        IndustryActivityMaterialsX industryActivityMaterialsX = 
          new IndustryActivityMaterialsX(entityManager);
        return industryActivityMaterialsX;
    }
    
    /**
     * Get all values of the MapSolarSystemsX ( entities )
     * @return MapSolarSystemsX
     */
    public MapSolarSystemsX mapSolarSystems(){
        MapSolarSystemsX mapSolarSystemsX = new MapSolarSystemsX(entityManager);
        return mapSolarSystemsX;
    }
    
    /**
     * Get all values of the SqlUserX ( entities )
     * @return SqlUser
     */    
    public SqlUser sqlUserX(){
        SqlUser sqlUser = new SqlUser(entityManager);
        return sqlUser;
    }
    
    /**
     * Get all values of the Cache ( entities )
     * @return TaxSolarSystem
     */    
    public TaxSolarSystem taxSolarSystem(){
        TaxSolarSystem taxSolarSystem = new TaxSolarSystem(entityManager);
        return taxSolarSystem;
    }
}
