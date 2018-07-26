/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.cache.taxCostIndex;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import managerindustry.db.controllers.TaxCostIndexEntityJpaController;
import managerindustry.db.controllers.TaxSolarSystemEntityJpaController;
import managerindustry.db.entities.cache.TaxCostIndexEntity;
import managerindustry.db.entities.cache.TaxSolarSystemEntity;

/**
 *
 * @author lele
 */
public class TaxSolarSystem {
    private EntityManager entityManager;
    
    private TaxSolarSystemEntityJpaController taxSolarSystemEntityJpaController = 
     new TaxSolarSystemEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));
    
    private TaxCostIndexEntityJpaController taxCostIndexEntityJpaController = 
     new TaxCostIndexEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));
    
    public TaxSolarSystem(EntityManager entityManager) {
        this.entityManager = entityManager;
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
    public void updateTaxCostIndexEntity(TaxCostIndexEntity taxCostIndexEntity){
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
    public TaxSolarSystemEntity getSolarSystemEntity(String solarSystemID){
        try {
            TypedQuery < TaxSolarSystemEntity > taxSolarSystemEntityQT = 
             entityManager.createNamedQuery("TaxSolarSystemEntity.getSolarSystem", TaxSolarSystemEntity.class);
            
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
    public List < TaxSolarSystemEntity > getAllExceptSpecificSolarSysemEntity( String solarSystemID){
        try {
            TypedQuery < TaxSolarSystemEntity > allExceptSpecificSolarSysemQT = 
             entityManager.createNamedQuery("TaxSolarSystemEntity.getAllExceptSpecificSolarSysem", TaxSolarSystemEntity.class);
            
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
            TypedQuery < TaxSolarSystemEntity > allTaxSolarSystemEntityTQ = 
             entityManager.createNamedQuery("TaxSolarSystemEntity.getAll", TaxSolarSystemEntity.class );

            return allTaxSolarSystemEntityTQ.getResultList();
            
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }      

}
