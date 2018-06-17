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
import managerindustry.db.entities.cache.EffectRigEntity;

/**
 *
 * @author lele
 */
public class EffectRigEntityJpaController implements Serializable {

    public EffectRigEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(EffectRigEntity effectRigEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(effectRigEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(EffectRigEntity effectRigEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            effectRigEntity = em.merge(effectRigEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = effectRigEntity.getId();
                if (findEffectRigEntity(id) == null) {
                    throw new NonexistentEntityException("The effectRigEntity with id " + id + " no longer exists.");
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
            EffectRigEntity effectRigEntity;
            try {
                effectRigEntity = em.getReference(EffectRigEntity.class, id);
                effectRigEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The effectRigEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(effectRigEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<EffectRigEntity> findEffectRigEntityEntities() {
        return findEffectRigEntityEntities(true, -1, -1);
    }

    public List<EffectRigEntity> findEffectRigEntityEntities(int maxResults, int firstResult) {
        return findEffectRigEntityEntities(false, maxResults, firstResult);
    }

    private List<EffectRigEntity> findEffectRigEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(EffectRigEntity.class));
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

    public EffectRigEntity findEffectRigEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(EffectRigEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getEffectRigEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<EffectRigEntity> rt = cq.from(EffectRigEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
