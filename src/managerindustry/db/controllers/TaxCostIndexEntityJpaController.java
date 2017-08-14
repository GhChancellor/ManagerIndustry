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
import managerindustry.db.entities.solarSystemTax.TaxCostIndexEntity;

/**
 *
 * @author lele
 */
public class TaxCostIndexEntityJpaController implements Serializable {

    public TaxCostIndexEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TaxCostIndexEntity taxCostIndexEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(taxCostIndexEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TaxCostIndexEntity taxCostIndexEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            taxCostIndexEntity = em.merge(taxCostIndexEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = taxCostIndexEntity.getId();
                if (findTaxCostIndexEntity(id) == null) {
                    throw new NonexistentEntityException("The taxCostIndexEntity with id " + id + " no longer exists.");
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
            TaxCostIndexEntity taxCostIndexEntity;
            try {
                taxCostIndexEntity = em.getReference(TaxCostIndexEntity.class, id);
                taxCostIndexEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The taxCostIndexEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(taxCostIndexEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TaxCostIndexEntity> findTaxCostIndexEntityEntities() {
        return findTaxCostIndexEntityEntities(true, -1, -1);
    }

    public List<TaxCostIndexEntity> findTaxCostIndexEntityEntities(int maxResults, int firstResult) {
        return findTaxCostIndexEntityEntities(false, maxResults, firstResult);
    }

    private List<TaxCostIndexEntity> findTaxCostIndexEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TaxCostIndexEntity.class));
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

    public TaxCostIndexEntity findTaxCostIndexEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TaxCostIndexEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getTaxCostIndexEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TaxCostIndexEntity> rt = cq.from(TaxCostIndexEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
