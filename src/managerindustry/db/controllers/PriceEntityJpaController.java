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
import managerindustry.db.entities.cache.PriceEntity;

/**
 *
 * @author lele
 */
public class PriceEntityJpaController implements Serializable {

    public PriceEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PriceEntity priceEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(priceEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(PriceEntity priceEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            priceEntity = em.merge(priceEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = priceEntity.getId();
                if (findPriceEntity(id) == null) {
                    throw new NonexistentEntityException("The priceEntity with id " + id + " no longer exists.");
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
            PriceEntity priceEntity;
            try {
                priceEntity = em.getReference(PriceEntity.class, id);
                priceEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The priceEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(priceEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PriceEntity> findPriceEntityEntities() {
        return findPriceEntityEntities(true, -1, -1);
    }

    public List<PriceEntity> findPriceEntityEntities(int maxResults, int firstResult) {
        return findPriceEntityEntities(false, maxResults, firstResult);
    }

    private List<PriceEntity> findPriceEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PriceEntity.class));
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

    public PriceEntity findPriceEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PriceEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getPriceEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PriceEntity> rt = cq.from(PriceEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
