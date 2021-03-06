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

    /**
     * Get all values of the InvTypes ( entities )
     * @return InvTypesX
     */
    public InvTypesX invTypes(){
        return new InvTypesX();
    }
    
    /**
     * Get all values of the InvNames ( entities )
     * @return InvNamesX
     */
    public InvNamesX invNames(){
        return new InvNamesX();
    }
    
    /**
     * Get all values of the DgmAttributeTypes ( entities )
     * @return DgmAttributeTypesX
     */
    public DgmAttributeTypesX dgmAttributeTypes(){
        return new DgmAttributeTypesX();
    }
    
    /**
     * Get all values of the DgmTypeAttributesX ( entities )
     * @return DgmTypeAttributesX
     */
    public DgmTypeAttributesX dgmTypeAttributes(){
        return new DgmTypeAttributesX();
    }
    
    /**
     * Get all values of the IndustryActivityMaterialsX ( entities )
     * @return IndustryActivityMaterialsX
     */
    public IndustryActivityMaterialsX industryActivityMaterials(){
        return new IndustryActivityMaterialsX();
    }
    
    /**
     * Get all values of the MapSolarSystemsX ( entities )
     * @return MapSolarSystemsX
     */
    public MapSolarSystemsX mapSolarSystems(){
        return new MapSolarSystemsX();
    }
    
    /**
     * Get all values of the Cache ( entities )
     * @return TaxSolarSystem
     */    
    public TaxSolarSystem taxSolarSystem(){
        return new TaxSolarSystem();
    }
    
    /**
     * Get all values of the PriceX ( entities )
     * @return PriceX
     */
    public PriceX price() throws ErrorExeption{
        return new PriceX();
    }
    
    /**
     * Get all values of the industryBlueprints ( entities ) Max production limit
     * @return IndustryBlueprintsX
     */
    public IndustryBlueprintsX industryBlueprints(){
        return new IndustryBlueprintsX();
    }
    
    /**
     * Get all values of the industryActivitySkills ( entities ) like Required Skill
     * @return IndustryActivitySkillsX
     */
    public IndustryActivitySkillsX industryActivitySkills(){
        return new IndustryActivitySkillsX();
    }
    
    /**
     * Get all values of the InvMarketGroups ( entities ) like parent group of object
     * @return InvMarketGroupsX
     */    
    public InvMarketGroupsX invMarketGroups(){
        return new InvMarketGroupsX();
    }
    
    /**
     * Get industry Activity Id
     * @return IndustryActivityX
     */
    public IndustryActivityX industryActivity(){
        return new IndustryActivityX();
    }
    
    /**
     * get industry Activity Products
     * @return IndustryActivityProductsX
     */
    public IndustryActivityProductsX industryActivityProducts(){
        return new IndustryActivityProductsX();
    }
    
    /**
     * Get Effect Rig
     * @return EffectEngineeringRigX
     */
    public EffectEngineeringRigX effectRig(){
        return new EffectEngineeringRigX();
    }
    
    /**
     * Avoid Duplicate Rig Entity
     * @return AvoidDuplicateRigX
     */
    public AvoidDuplicateRigX avoidDuplicateRigEntity(){
        return new AvoidDuplicateRigX();
    }    
}
