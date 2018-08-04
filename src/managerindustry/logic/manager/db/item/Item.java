/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item;

import javax.persistence.EntityManager;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.manager.db.item.cache.avoidDuplicateRig.AvoidDuplicateRigX;
import managerindustry.logic.manager.db.item.cache.effectRig.EffectEngineeringRigX;
import managerindustry.logic.manager.db.item.cache.effectRig.EffectEngineeringRigX;
import managerindustry.logic.manager.db.item.cache.price.PriceX;
import managerindustry.logic.manager.db.item.cache.taxCostIndex.TaxSolarSystem;
import managerindustry.logic.manager.db.item.eve.DgmAttributeTypesX;
import managerindustry.logic.manager.db.item.eve.DgmTypeAttributesX;
import managerindustry.logic.manager.db.item.eve.IndustryActivityMaterialsX;
import managerindustry.logic.manager.db.item.eve.IndustryActivityProductsX;
import managerindustry.logic.manager.db.item.eve.IndustryActivitySkillsX;
import managerindustry.logic.manager.db.item.eve.IndustryActivityX;
import managerindustry.logic.manager.db.item.eve.IndustryBlueprintsX;
import managerindustry.logic.manager.db.item.eve.InvMarketGroupsX;
import managerindustry.logic.manager.db.item.eve.InvNamesX;
import managerindustry.logic.manager.db.item.eve.InvTypesX;
import managerindustry.logic.manager.db.item.eve.MapSolarSystemsX;

/**
 *
 * @author lele
 */
public class Item {
    private EntityManager entityManager;

    public Item(EntityManager entityManager) {
        this.entityManager = entityManager;
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
    public PriceX price() throws ErrorExeption{
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
     * @return EffectEngineeringRigX
     */
    public EffectEngineeringRigX effectRig(){
        EffectEngineeringRigX effectRigX = new EffectEngineeringRigX(entityManager);
        return effectRigX;
    }
    
    public EffectEngineeringRigX effectRigX2(){
        EffectEngineeringRigX effectRigX = new EffectEngineeringRigX(entityManager);
        return effectRigX;
    }
    
    /**
     * Avoid Duplicate Rig Entity
     * @return AvoidDuplicateRigX
     */
    public AvoidDuplicateRigX avoidDuplicateRigEntity(){
        AvoidDuplicateRigX avoidDuplicateRigX = new AvoidDuplicateRigX(entityManager);
        return avoidDuplicateRigX;
    }    
}
