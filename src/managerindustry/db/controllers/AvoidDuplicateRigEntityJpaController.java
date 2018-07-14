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
import managerindustry.db.entities.cache.AvoidDuplicateRigEntity;

/**
 *
 * @author lele
 */
public class AvoidDuplicateRigEntityJpaController implements Serializable {

    public AvoidDuplicateRigEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AvoidDuplicateRigEntity avoidDuplicateRigEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(avoidDuplicateRigEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AvoidDuplicateRigEntity avoidDuplicateRigEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            avoidDuplicateRigEntity = em.merge(avoidDuplicateRigEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = avoidDuplicateRigEntity.getId();
                if (findAvoidDuplicateRigEntity(id) == null) {
                    throw new NonexistentEntityException("The avoidDuplicateRigEntity with id " + id + " no longer exists.");
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
            AvoidDuplicateRigEntity avoidDuplicateRigEntity;
            try {
                avoidDuplicateRigEntity = em.getReference(AvoidDuplicateRigEntity.class, id);
                avoidDuplicateRigEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The avoidDuplicateRigEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(avoidDuplicateRigEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AvoidDuplicateRigEntity> findAvoidDuplicateRigEntityEntities() {
        return findAvoidDuplicateRigEntityEntities(true, -1, -1);
    }

    public List<AvoidDuplicateRigEntity> findAvoidDuplicateRigEntityEntities(int maxResults, int firstResult) {
        return findAvoidDuplicateRigEntityEntities(false, maxResults, firstResult);
    }

    private List<AvoidDuplicateRigEntity> findAvoidDuplicateRigEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AvoidDuplicateRigEntity.class));
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

    public AvoidDuplicateRigEntity findAvoidDuplicateRigEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AvoidDuplicateRigEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getAvoidDuplicateRigEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AvoidDuplicateRigEntity> rt = cq.from(AvoidDuplicateRigEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
