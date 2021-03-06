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
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion_Init;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic.EffectEngineeringRig;
import managerindustry.logic.generic.fatherClass.RigMarketGroup;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class EffectEngineeringRigX {
    private EntityManager entityManager;
    private EffectEngineeringRigEntityJpaController effectRigEntityJpaController = 
        new EffectEngineeringRigEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));
        
    public EffectEngineeringRigX() {
        entityManager = Manager.getInstance().db().getEntityManager();
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
     * structureRig.getTypeID() is rig 
     * effectId has effect on items of the same category
     * @param StructureRig structureRig 
     */
    public void addEffectRigs(EffectEngineeringRig structureRig){
        // 43875 Standup M-Set Structure Manufacturing Material Efficiency I for fuel blocks
        // fuel blocks 4051 4246 4247 4312
  
//        System.err.print(" >>>> ATTENZIONE <<<< EffectEngineeringRigX > addEffectRigs DISABILITATA!!!!!!!" );
        
        for (RigRecusion_Init rigRecusion : structureRig.getRigRecusions() ) {
            List<Integer> groupRecursions = rigRecusion.getList();
            
            for (Integer effectId : groupRecursions) {
                EffectEngineeringRigEntity effectRigEntity = 
                    new EffectEngineeringRigEntity(
                    structureRig.getRigTypeID(), effectId );
                
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
    public EffectEngineeringRigEntity getEffectEngineeringRigEntity(int rigTypeID, int groupEffectID){
        try {
            TypedQuery < EffectEngineeringRigEntity > effectsTQ = 
                entityManager.createNamedQuery("EffectEngineeringRigEntity.getByEffectID_ByID", EffectEngineeringRigEntity.class);

            effectsTQ.setParameter("rigTypeID", rigTypeID );
            effectsTQ.setParameter("groupEffectID", groupEffectID );            
            
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
     * Get Effect Engineering Rig typeId
     * @param rigTypeID typeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     * @return EffectEngineeringRigEntity
     */
    public EffectEngineeringRigEntity getEffectEngineeringRigEntity(int rigTypeID){
        try {
            TypedQuery < EffectEngineeringRigEntity > effectsTQ = 
                entityManager.createNamedQuery("EffectEngineeringRigEntity.getByID", EffectEngineeringRigEntity.class);

            effectsTQ.setParameter("rigTypeID", rigTypeID );           
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
