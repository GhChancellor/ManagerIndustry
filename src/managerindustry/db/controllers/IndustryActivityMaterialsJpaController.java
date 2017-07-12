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
import managerindustry.db.entities.IndustryActivityMaterials;

/**
 *
 * @author lele
 */
public class IndustryActivityMaterialsJpaController implements Serializable {

    public IndustryActivityMaterialsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IndustryActivityMaterials industryActivityMaterials) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(industryActivityMaterials);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IndustryActivityMaterials industryActivityMaterials) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            industryActivityMaterials = em.merge(industryActivityMaterials);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = industryActivityMaterials.getIdd();
                if (findIndustryActivityMaterials(id) == null) {
                    throw new NonexistentEntityException("The industryActivityMaterials with id " + id + " no longer exists.");
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
            IndustryActivityMaterials industryActivityMaterials;
            try {
                industryActivityMaterials = em.getReference(IndustryActivityMaterials.class, id);
                industryActivityMaterials.getIdd();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The industryActivityMaterials with id " + id + " no longer exists.", enfe);
            }
            em.remove(industryActivityMaterials);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IndustryActivityMaterials> findIndustryActivityMaterialsEntities() {
        return findIndustryActivityMaterialsEntities(true, -1, -1);
    }

    public List<IndustryActivityMaterials> findIndustryActivityMaterialsEntities(int maxResults, int firstResult) {
        return findIndustryActivityMaterialsEntities(false, maxResults, firstResult);
    }

    private List<IndustryActivityMaterials> findIndustryActivityMaterialsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IndustryActivityMaterials.class));
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

    public IndustryActivityMaterials findIndustryActivityMaterials(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IndustryActivityMaterials.class, id);
        } finally {
            em.close();
        }
    }

    public int getIndustryActivityMaterialsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IndustryActivityMaterials> rt = cq.from(IndustryActivityMaterials.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
