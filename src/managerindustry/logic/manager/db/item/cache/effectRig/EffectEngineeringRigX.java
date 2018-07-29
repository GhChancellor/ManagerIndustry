/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.cache.effectRig;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import managerindustry.db.controllers.EffectEngineeringRigEntityJpaController;
import managerindustry.db.entities.cache.EffectEngineeringRigEntity;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecursionA;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRercsionLibrary;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigsXXX;

/**
 *
 * @author lele
 */
public class EffectEngineeringRigX {
    private EntityManager entityManager;
    private EffectEngineeringRigEntityJpaController effectRigEntityJpaController = 
        new EffectEngineeringRigEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));
        
    public EffectEngineeringRigX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Add Effect Rig Entity
     * @param EffectRigEntity effectRigEntity 
     */
    private void addEffectRigEntity(EffectEngineeringRigEntity effectRigEntity){
        try {
            effectRigEntityJpaController.create(effectRigEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }        
    }
    
    /**
     * Add Effect Rigs
     * @param StructureRig structureRig 
     */
    public void addEffectRigs(EffectEngineeringRigsXXX structureRig){
        List<ItemRecusion> itemRecusions = structureRig.getItemRecusions();
        ItemRercsionLibrary library = new ItemRercsionLibrary();

        for (ItemRecusion itemRecusion : itemRecusions) {
            ItemRecursionA itemRecursionReport = itemRecusion.getItemRecursionReport();
            
            List<Integer> effects = library.getConversionToList(itemRecursionReport);
            
            for (Integer effect : effects) {
                EffectEngineeringRigEntity effectRigEntity = new EffectEngineeringRigEntity(structureRig.getTypeID(), effect);
                addEffectRigEntity(effectRigEntity);                
            }            
        }        
    }

    /**
     * Get Effect Rig Entity by typeId and effectID
     * @param int typeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     * @param int effectID, has effect on item to build like ammunition
     * @return EffectEngineeringRigEntity
     */
    public EffectEngineeringRigEntity getEffectEngineeringRigEntity(int typeID, int effectID){
        try {
            TypedQuery < EffectEngineeringRigEntity > effectsTQ = 
                entityManager.createNamedQuery("EffectEngineeringRigEntity.getByEffectID_ByID", EffectEngineeringRigEntity.class);

            effectsTQ.setParameter("typeID", typeID );
            effectsTQ.setParameter("effectID", effectID );            
            
            List<EffectEngineeringRigEntity> resultList = effectsTQ.getResultList();
            
            if ( resultList.isEmpty()){
                return null;
            }else{
                return resultList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * Get Effect Engineering Rig entity by typeId
     * @param typeID typeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     * @return EffectEngineeringRigEntity
     */
    public EffectEngineeringRigEntity getEffectEngineeringRigEntity(int typeID){
        try {
            TypedQuery < EffectEngineeringRigEntity > effectsTQ = 
                entityManager.createNamedQuery("EffectEngineeringRigEntity.getByID", EffectEngineeringRigEntity.class);

            effectsTQ.setParameter("typeID", typeID );           
            List<EffectEngineeringRigEntity> resultList = effectsTQ.getResultList();
            
            if ( resultList.isEmpty()){
                return null;
            }else{
                return resultList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
}