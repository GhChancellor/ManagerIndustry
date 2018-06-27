/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.cache.effectRig;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import managerindustry.db.controllers.EffectRigEntityJpaController;
import managerindustry.db.entities.cache.EffectRigEntity;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecursionA;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRercsionLibrary;
import managerindustry.logic.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRigsXXX;

/**
 *
 * @author lele
 */
public class EffectRigX {
    private EntityManager entityManager;
    private EffectRigEntityJpaController effectRigEntityJpaController = 
        new EffectRigEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));
        
    public EffectRigX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    /**
     * Add Effect Rig Entity
     * @param EffectRigEntity effectRigEntity 
     */
    private void addEffectRigEntity(EffectRigEntity effectRigEntity){
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
                EffectRigEntity effectRigEntity = new EffectRigEntity(structureRig.getTypeID(), effect);
                addEffectRigEntity(effectRigEntity);                
            }            
        }        
    }

    /**
     * Get Effect Rig Entity
     * @param int typeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     * @param int effectID, has effect on item to build like ammunition
     * @return EffectRigEntity
     */
    public EffectRigEntity getEffectRigEntity(int typeID, int effectID){
        try {
            TypedQuery < EffectRigEntity > effectsTQ = 
                entityManager.createNamedQuery("EffectRigEntity.getEffectByID", EffectRigEntity.class);

            effectsTQ.setParameter("typeID", typeID );
            effectsTQ.setParameter("effectID", effectID );            
            
            List<EffectRigEntity> resultList = effectsTQ.getResultList();
            
            if ( resultList.isEmpty()){
                return null;
            }else{
                return resultList.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();;
            return null;
        }
    }
    
}
