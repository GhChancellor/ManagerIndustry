/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.manager.managerDB.cache.effectRig.EffectRigX;
import managerindustry.logic.manager.managerDB.cache.price.PriceX;
import managerindustry.logic.manager.managerDB.cache.taxCostIndex.TaxSolarSystem;
import managerindustry.logic.manager.managerDB.eve.DgmAttributeTypesX;
import managerindustry.logic.manager.managerDB.eve.DgmTypeAttributesX;
import managerindustry.logic.manager.managerDB.eve.IndustryActivityMaterialsX;
import managerindustry.logic.manager.managerDB.eve.IndustryActivityProductsX;
import managerindustry.logic.manager.managerDB.eve.IndustryActivitySkillsX;
import managerindustry.logic.manager.managerDB.eve.IndustryActivityX;
import managerindustry.logic.manager.managerDB.eve.IndustryBlueprintsX;
import managerindustry.logic.manager.managerDB.eve.InvMarketGroupsX;
import managerindustry.logic.manager.managerDB.eve.InvNamesX;
import managerindustry.logic.manager.managerDB.eve.InvTypesX;
import managerindustry.logic.manager.managerDB.eve.MapSolarSystemsX;
import managerindustry.logic.manager.managerDB.sqlUser.SqlUser;

/**
 *
 * @author lele
 */
public class ManagerDB {
    private static ManagerDB instance = null;
    private EntityManager entityManager = 
        Persistence.createEntityManagerFactory("ManagerIndustryPU").createEntityManager();
     
    public static ManagerDB getInstance(){
        if ( instance == null )
            instance = new ManagerDB();
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
    public SqlUser sqlUser(){
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
    
    /**
     * Get all values of the PriceX ( entities )
     * @return PriceX
     */
    public PriceX price() throws PriceNotExistsException{
        PriceX price = new PriceX(entityManager);
        return price;
    }
    
    /**
     * Get all values of the industryBlueprints ( entities ) Max production limit
     * @return IndustryBlueprintsX
     */
    public IndustryBlueprintsX industryBlueprints(){
        IndustryBlueprintsX industryBlueprintsX = new IndustryBlueprintsX(entityManager);
        return industryBlueprintsX;
    }
    
    /**
     * Get all values of the industryActivitySkills ( entities ) like Required Skill
     * @return IndustryActivitySkillsX
     */
    public IndustryActivitySkillsX industryActivitySkills(){
        IndustryActivitySkillsX industryActivitySkillsX = 
            new IndustryActivitySkillsX(entityManager);
        return industryActivitySkillsX;
    }
    
    /**
     * Get all values of the InvMarketGroups ( entities ) like parent group of object
     * @return InvMarketGroupsX
     */    
    public InvMarketGroupsX invMarketGroups(){
        InvMarketGroupsX invMarketGroups = new InvMarketGroupsX(entityManager);
        return invMarketGroups;
    }
    
    /**
     * Get industry Activity Id
     * @return IndustryActivityX
     */
    public IndustryActivityX industryActivity(){
        IndustryActivityX industryActivityX = new IndustryActivityX(entityManager);
        return industryActivityX;
    }
    
    /**
     * get industry Activity Products
     * @return IndustryActivityProductsX
     */
    public IndustryActivityProductsX industryActivityProducts(){
        IndustryActivityProductsX industryActivityProductsX = 
            new IndustryActivityProductsX(entityManager);
        return industryActivityProductsX;
    }
    
    /**
     * Get Effect Rig
     * @return EffectRigX
     */
    public EffectRigX effectRig(){
        EffectRigX effectRigX = new EffectRigX(entityManager);
        return effectRigX;
    }
}
