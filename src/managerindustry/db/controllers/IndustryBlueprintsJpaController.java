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
import managerindustry.db.controllers.exceptions.PreexistingEntityException;
import managerindustry.db.entities.eve.IndustryBlueprints;

/**
 *
 * @author lele
 */
public class IndustryBlueprintsJpaController implements Serializable {

    public IndustryBlueprintsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IndustryBlueprints industryBlueprints) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(industryBlueprints);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIndustryBlueprints(industryBlueprints.getTypeID()) != null) {
                throw new PreexistingEntityException("IndustryBlueprints " + industryBlueprints + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IndustryBlueprints industryBlueprints) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            industryBlueprints = em.merge(industryBlueprints);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = industryBlueprints.getTypeID();
                if (findIndustryBlueprints(id) == null) {
                    throw new NonexistentEntityException("The industryBlueprints with id " + id + " no longer exists.");
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
            IndustryBlueprints industryBlueprints;
            try {
                industryBlueprints = em.getReference(IndustryBlueprints.class, id);
                industryBlueprints.getTypeID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The industryBlueprints with id " + id + " no longer exists.", enfe);
            }
            em.remove(industryBlueprints);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IndustryBlueprints> findIndustryBlueprintsEntities() {
        return findIndustryBlueprintsEntities(true, -1, -1);
    }

    public List<IndustryBlueprints> findIndustryBlueprintsEntities(int maxResults, int firstResult) {
        return findIndustryBlueprintsEntities(false, maxResults, firstResult);
    }

    private List<IndustryBlueprints> findIndustryBlueprintsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IndustryBlueprints.class));
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

    public IndustryBlueprints findIndustryBlueprints(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IndustryBlueprints.class, id);
        } finally {
            em.close();
        }
    }

    public int getIndustryBlueprintsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IndustryBlueprints> rt = cq.from(IndustryBlueprints.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
