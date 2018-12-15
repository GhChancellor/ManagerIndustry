/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.controllers;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import managerindustry.db.controllers.exceptions.NonexistentEntityException;
import managerindustry.db.entities.cache.EffectEngineeringRigEntity;

/**
 *
 * @author lele
 */
public class EffectEngineeringRigEntityJpaController1 implements Serializable {

    public EffectEngineeringRigEntityJpaController1(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EffectEngineeringRigEntity effectEngineeringRigEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(effectEngineeringRigEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EffectEngineeringRigEntity effectEngineeringRigEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            effectEngineeringRigEntity = em.merge(effectEngineeringRigEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = effectEngineeringRigEntity.getId();
                if (findEffectEngineeringRigEntity(id) == null) {
                    throw new NonexistentEntityException("The effectEngineeringRigEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            EffectEngineeringRigEntity effectEngineeringRigEntity;
            try {
                effectEngineeringRigEntity = em.getReference(EffectEngineeringRigEntity.class, id);
                effectEngineeringRigEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The effectEngineeringRigEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(effectEngineeringRigEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EffectEngineeringRigEntity> findEffectEngineeringRigEntityEntities() {
        return findEffectEngineeringRigEntityEntities(true, -1, -1);
    }

    public List<EffectEngineeringRigEntity> findEffectEngineeringRigEntityEntities(int maxResults, int firstResult) {
        return findEffectEngineeringRigEntityEntities(false, maxResults, firstResult);
    }

    private List<EffectEngineeringRigEntity> findEffectEngineeringRigEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EffectEngineeringRigEntity.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public EffectEngineeringRigEntity findEffectEngineeringRigEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EffectEngineeringRigEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getEffectEngineeringRigEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EffectEngineeringRigEntity> rt = cq.from(EffectEngineeringRigEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
