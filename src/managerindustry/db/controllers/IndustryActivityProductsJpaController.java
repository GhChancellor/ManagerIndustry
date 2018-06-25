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
import managerindustry.db.entities.eve.IndustryActivityProducts;

/**
 *
 * @author lele
 */
public class IndustryActivityProductsJpaController implements Serializable {

    public IndustryActivityProductsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IndustryActivityProducts industryActivityProducts) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(industryActivityProducts);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IndustryActivityProducts industryActivityProducts) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            industryActivityProducts = em.merge(industryActivityProducts);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = industryActivityProducts.getFakeID();
                if (findIndustryActivityProducts(id) == null) {
                    throw new NonexistentEntityException("The industryActivityProducts with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IndustryActivityProducts industryActivityProducts;
            try {
                industryActivityProducts = em.getReference(IndustryActivityProducts.class, id);
                industryActivityProducts.getFakeID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The industryActivityProducts with id " + id + " no longer exists.", enfe);
            }
            em.remove(industryActivityProducts);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IndustryActivityProducts> findIndustryActivityProductsEntities() {
        return findIndustryActivityProductsEntities(true, -1, -1);
    }

    public List<IndustryActivityProducts> findIndustryActivityProductsEntities(int maxResults, int firstResult) {
        return findIndustryActivityProductsEntities(false, maxResults, firstResult);
    }

    private List<IndustryActivityProducts> findIndustryActivityProductsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IndustryActivityProducts.class));
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

    public IndustryActivityProducts findIndustryActivityProducts(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IndustryActivityProducts.class, id);
        } finally {
            em.close();
        }
    }

    public int getIndustryActivityProductsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IndustryActivityProducts> rt = cq.from(IndustryActivityProducts.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
