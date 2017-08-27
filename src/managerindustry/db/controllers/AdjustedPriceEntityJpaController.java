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
import managerindustry.db.entities.cache.AdjustedPriceEntity;

/**
 *
 * @author lele
 */
public class AdjustedPriceEntityJpaController implements Serializable {

    public AdjustedPriceEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(AdjustedPriceEntity adjustedPriceEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(adjustedPriceEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(AdjustedPriceEntity adjustedPriceEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            adjustedPriceEntity = em.merge(adjustedPriceEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = adjustedPriceEntity.getId();
                if (findAdjustedPriceEntity(id) == null) {
                    throw new NonexistentEntityException("The adjustedPriceEntity with id " + id + " no longer exists.");
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
            AdjustedPriceEntity adjustedPriceEntity;
            try {
                adjustedPriceEntity = em.getReference(AdjustedPriceEntity.class, id);
                adjustedPriceEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The adjustedPriceEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(adjustedPriceEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<AdjustedPriceEntity> findAdjustedPriceEntityEntities() {
        return findAdjustedPriceEntityEntities(true, -1, -1);
    }

    public List<AdjustedPriceEntity> findAdjustedPriceEntityEntities(int maxResults, int firstResult) {
        return findAdjustedPriceEntityEntities(false, maxResults, firstResult);
    }

    private List<AdjustedPriceEntity> findAdjustedPriceEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(AdjustedPriceEntity.class));
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

    public AdjustedPriceEntity findAdjustedPriceEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(AdjustedPriceEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getAdjustedPriceEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<AdjustedPriceEntity> rt = cq.from(AdjustedPriceEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
