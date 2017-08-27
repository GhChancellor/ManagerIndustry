/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.rule.ManagerDB;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import managerindustry.db.controllers.AdjustedPriceEntityJpaController;
import managerindustry.db.controllers.TaxCostIndexEntityJpaController;
import managerindustry.db.controllers.TaxSolarSystemEntityJpaController;
import managerindustry.db.entities.cache.AdjustedPriceEntity;
import managerindustry.db.entities.cache.TaxCostIndexEntity;
import managerindustry.db.entities.cache.TaxSolarSystemEntity;

/**
 *
 * @author lele
 */
public class ManagerDBCache {
    private static ManagerDBCache instance = null;
    
    private EntityManager entityManager = Persistence.createEntityManagerFactory("ManagerIndustryPU").createEntityManager();
    
    private AdjustedPriceEntityJpaController adjustedPriceEntityJpaController =
     new AdjustedPriceEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));
    
    private TaxSolarSystemEntityJpaController taxSolarSystemEntityJpaController = 
     new TaxSolarSystemEntityJpaController (Persistence.createEntityManagerFactory("ManagerIndustryPU"));
    
    private TaxCostIndexEntityJpaController taxCostIndexEntityJpaController = 
     new TaxCostIndexEntityJpaController (Persistence.createEntityManagerFactory("ManagerIndustryPU"));
    
    
    public static ManagerDBCache getInstance(){
        if ( instance == null )
            instance = new ManagerDBCache();
        return instance;
    }
    
    /**
     * Add new solar system in DB
     * @param TaxSolarSystemEntity taxSolarSystemEntity 
     */
    public void addTaxSolarSystemEntity(TaxSolarSystemEntity taxSolarSystemEntity){
        try {
            taxSolarSystemEntityJpaController.create(taxSolarSystemEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    
    /**
     * Update solar system in DB
     * @param TaxSolarSystemEntity taxSolarSystemEntity 
     */
    public void updateTaxSolarSystemEntity(TaxSolarSystemEntity taxSolarSystemEntity){
        try {
            taxSolarSystemEntityJpaController.edit(taxSolarSystemEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
    
    /**
     * Update Tax Cost Index
     * @param TaxCostIndexEntity taxCostIndexEntity 
     */
    public void updateTaxCostIndex(TaxCostIndexEntity taxCostIndexEntity){
        try {
            taxCostIndexEntityJpaController.edit(taxCostIndexEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return;            
        }
    }
    
    /**
     * Check into DB if solar System exists
     * @param solarSystemID
     * @return 
     */
    public TaxSolarSystemEntity getSolarSystem(String solarSystemID){
        try {
            EntityManager taxSolarSystemEntityEM = entityManager;
            TypedQuery < TaxSolarSystemEntity > taxSolarSystemEntityQT = 
             taxSolarSystemEntityEM.createNamedQuery("TaxSolarSystemEntity.getSolarSystem", TaxSolarSystemEntity.class);
            
            taxSolarSystemEntityQT.setParameter("solarSystemID", solarSystemID);
            
            List < TaxSolarSystemEntity > taxSolarSystemEntitys = taxSolarSystemEntityQT.getResultList();
            
            if ( taxSolarSystemEntitys.isEmpty()){
                return null;
            }else{
                return taxSolarSystemEntitys.get(0);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get All value Except Specific Solar Sysem
     * @param solarSystemID
     * @return List < TaxSolarSystemEntity >
     */
    public List < TaxSolarSystemEntity > getAllExceptSpecificSolarSysem( String solarSystemID){
        try {
            EntityManager allExceptSpecificSolarSysemEM = entityManager;
            TypedQuery < TaxSolarSystemEntity > allExceptSpecificSolarSysemQT = 
             allExceptSpecificSolarSysemEM.createNamedQuery("TaxSolarSystemEntity.getAllExceptSpecificSolarSysem", TaxSolarSystemEntity.class);
            
            allExceptSpecificSolarSysemQT.setParameter("solarSystemID", solarSystemID);
            return allExceptSpecificSolarSysemQT.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }    
    
    /**
     * Delete solar system in DB
     * @param taxSolarSystemEntity 
     */
    public void deleteTaxSolarSystemEntity(TaxSolarSystemEntity taxSolarSystemEntity){
        try {
            unlinkCostIndex(taxSolarSystemEntity);
            taxSolarSystemEntityJpaController.destroy(taxSolarSystemEntity.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Unlink CostIndex from SolarSystemEntity and delete it
     * @param TaxSolarSystemEntity taxSolarSystemEntity 
     */
    private void unlinkCostIndex(TaxSolarSystemEntity taxSolarSystemEntity){
        
        try {
            taxSolarSystemEntity.getTaxCostIndexEntities().clear();
            taxSolarSystemEntityJpaController.edit(taxSolarSystemEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
//        try {
//            List < TaxCostIndexEntity > costIndexEntitys = taxSolarSystemEntity.getTaxCostIndexEntities();
//            for (TaxCostIndexEntity costIndexEntity : costIndexEntitys) {
//
//                costIndexEntity.setActivity(null);
//                costIndexEntity.setCostIndex(null);
//                taxCostIndexEntityJpaController.edit(costIndexEntity);
//            }
//            
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    /**
     * Get All Tax Solar System Entity
     * @return List < TaxSolarSystemEntity >
     */
    public List < TaxSolarSystemEntity > getAllTaxSolarSystemEntity(){
        try {
            EntityManager allTaxSolarSystemEntityEM = entityManager;
        
            TypedQuery < TaxSolarSystemEntity > allTaxSolarSystemEntityTQ = 
             allTaxSolarSystemEntityEM.createNamedQuery("TaxSolarSystemEntity.getAll", TaxSolarSystemEntity.class );

            return allTaxSolarSystemEntityTQ.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }      
    
    // ----------------------------------------------------------------------
    
    /**
     * Add Adjusted Price Entity
     * @param AdjustedPriceEntity adjustedPriceEntity 
     */
    public void addAdjustedPriceEntity( AdjustedPriceEntity adjustedPriceEntity){
        try {
            adjustedPriceEntityJpaController.create(adjustedPriceEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return;        
        }
    }
    
    /**
     * Get All Adjusted Price Entity
     * @return AdjustedPriceEntity
     */
    public List < AdjustedPriceEntity > getAllAdjustedPriceEntity(){
        try {
            EntityManager allAdjustedPriceEntityEM = entityManager;
            
            TypedQuery < AdjustedPriceEntity > allAdjustedPriceEntityTQ =
             allAdjustedPriceEntityEM.createNamedQuery("AdjustedPriceEntity.getAll", AdjustedPriceEntity.class);
            
            return allAdjustedPriceEntityTQ.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }
    }
    
    /**
     * Get Adjusted Price Entity
     * @param typeId
     * @return AdjustedPriceEntity
     */
    public AdjustedPriceEntity getAdjustedPriceEntity(String typeId){
        try {
            EntityManager adjustedPriceEntityEM = entityManager;
            
            TypedQuery < AdjustedPriceEntity > adjustedPriceEntityTQ = 
             adjustedPriceEntityEM.createNamedQuery("AdjustedPriceEntity.getTypeId", AdjustedPriceEntity.class);
             
            adjustedPriceEntityTQ.setParameter("type_id", typeId);
            
            List < AdjustedPriceEntity > adjustedPriceEntitys = 
             adjustedPriceEntityTQ.getResultList();
            
            if (adjustedPriceEntitys.isEmpty()){
                return null;
            }else{
                return adjustedPriceEntitys.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;            
        }
    }
}
