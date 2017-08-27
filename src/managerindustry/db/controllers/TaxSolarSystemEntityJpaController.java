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
import managerindustry.db.entities.cache.TaxSolarSystemEntity;

/**
 *
 * @author lele
 */
public class TaxSolarSystemEntityJpaController implements Serializable {

    public TaxSolarSystemEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TaxSolarSystemEntity taxSolarSystemEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(taxSolarSystemEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TaxSolarSystemEntity taxSolarSystemEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            taxSolarSystemEntity = em.merge(taxSolarSystemEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = taxSolarSystemEntity.getId();
                if (findTaxSolarSystemEntity(id) == null) {
                    throw new NonexistentEntityException("The taxSolarSystemEntity with id " + id + " no longer exists.");
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
            TaxSolarSystemEntity taxSolarSystemEntity;
            try {
                taxSolarSystemEntity = em.getReference(TaxSolarSystemEntity.class, id);
                taxSolarSystemEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The taxSolarSystemEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(taxSolarSystemEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TaxSolarSystemEntity> findTaxSolarSystemEntityEntities() {
        return findTaxSolarSystemEntityEntities(true, -1, -1);
    }

    public List<TaxSolarSystemEntity> findTaxSolarSystemEntityEntities(int maxResults, int firstResult) {
        return findTaxSolarSystemEntityEntities(false, maxResults, firstResult);
    }

    private List<TaxSolarSystemEntity> findTaxSolarSystemEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TaxSolarSystemEntity.class));
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

    public TaxSolarSystemEntity findTaxSolarSystemEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TaxSolarSystemEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getTaxSolarSystemEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TaxSolarSystemEntity> rt = cq.from(TaxSolarSystemEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
