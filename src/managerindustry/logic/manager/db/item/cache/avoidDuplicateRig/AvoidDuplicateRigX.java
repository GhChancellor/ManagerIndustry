/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.cache.avoidDuplicateRig;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import managerindustry.db.controllers.AvoidDuplicateRigEntityJpaController;
import managerindustry.db.entities.cache.AvoidDuplicateRigEntity;

/**
 * da valutare gli enum
 * @deprecated 
 * @author lele
 */
public class AvoidDuplicateRigX {
    private EntityManager entityManager;
    private AvoidDuplicateRigEntityJpaController avoidDuplicateRigEntityJpaController = 
        new AvoidDuplicateRigEntityJpaController(Persistence.createEntityManagerFactory("ManagerIndustryPU"));    

    public enum NamedQueryEnum{
        QUERY_1("AvoidDuplicateRigEntity.NotMountableById_T1"),
        QUERY_2("AvoidDuplicateRigEntity.NotMountableById_T2");    
        
        private String value;
        private NamedQueryEnum namedQueryEnum;

        private NamedQueryEnum(NamedQueryEnum namedQueryEnum) {
            this.namedQueryEnum = namedQueryEnum;
        }

        private NamedQueryEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
    }
    
    public enum Parameter{        
        PARAMETER_1("typeId_T1"),
        PARAMETER_2("typeId_T2");
        
        private String value;
        private Parameter parameter;

        private Parameter(Parameter parameter) {
            this.parameter = parameter;
        }

        private Parameter(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
        
    }
    
    public AvoidDuplicateRigX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    public void addEffectRigs(AvoidDuplicateRigEntity avoidDuplicateRigEntity){
        try {
            avoidDuplicateRigEntityJpaController.create(avoidDuplicateRigEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return;            
        }       
    }
    
    /**    
     * Get Avoid Duplicate Rig
     * @param NamedQueryEnum namedQueryEnum
     * @param Parameter parameter
     * @param int value
     * @return AvoidDuplicateRigEntity
     */
    public AvoidDuplicateRigEntity getAvoidDuplicateRig(NamedQueryEnum namedQueryEnum, Parameter parameter, int value){
        try {
            TypedQuery < AvoidDuplicateRigEntity > queryTq = 
                entityManager.createNamedQuery(namedQueryEnum.getValue(), AvoidDuplicateRigEntity.class);
            
            queryTq.setParameter(parameter.getValue(), value);
            List < AvoidDuplicateRigEntity > avoidDuplicateRigEntitys =
                queryTq.getResultList();
            
            if ( avoidDuplicateRigEntitys.isEmpty()){
                return null;
            }else{
                return avoidDuplicateRigEntitys.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }
}
