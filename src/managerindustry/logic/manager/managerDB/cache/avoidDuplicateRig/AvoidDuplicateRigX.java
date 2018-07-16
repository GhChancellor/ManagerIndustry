/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.cache.avoidDuplicateRig;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import managerindustry.db.controllers.EffectEngineeringRigEntityJpaController;

/**
 *
 * @author lele
 */
public class AvoidDuplicateRigX {
    private EntityManager entityManager;
    private EffectEngineeringRigEntityJpaController AvoidDuplicateRigEntityJpaController = 
        new EffectEngineeringRigEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));    

    public AvoidDuplicateRigX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
//    public void addEffectRigs(EffectEngineeringRigsXXX structureRig){
}
