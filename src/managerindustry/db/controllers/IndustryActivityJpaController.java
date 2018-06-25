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
import managerindustry.db.entities.eve.IndustryActivity;
import managerindustry.db.entities.eve.IndustryActivityPK;

/**
 *
 * @author lele
 */
public class IndustryActivityJpaController implements Serializable {

    public IndustryActivityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IndustryActivity industryActivity) throws PreexistingEntityException, Exception {
        if (industryActivity.getIndustryActivityPK() == null) {
            industryActivity.setIndustryActivityPK(new IndustryActivityPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(industryActivity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findIndustryActivity(industryActivity.getIndustryActivityPK()) != null) {
                throw new PreexistingEntityException("IndustryActivity " + industryActivity + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IndustryActivity industryActivity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            industryActivity = em.merge(industryActivity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                IndustryActivityPK id = industryActivity.getIndustryActivityPK();
                if (findIndustryActivity(id) == null) {
                    throw new NonexistentEntityException("The industryActivity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(IndustryActivityPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            IndustryActivity industryActivity;
            try {
                industryActivity = em.getReference(IndustryActivity.class, id);
                industryActivity.getIndustryActivityPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The industryActivity with id " + id + " no longer exists.", enfe);
            }
            em.remove(industryActivity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IndustryActivity> findIndustryActivityEntities() {
        return findIndustryActivityEntities(true, -1, -1);
    }

    public List<IndustryActivity> findIndustryActivityEntities(int maxResults, int firstResult) {
        return findIndustryActivityEntities(false, maxResults, firstResult);
    }

    private List<IndustryActivity> findIndustryActivityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IndustryActivity.class));
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

    public IndustryActivity findIndustryActivity(IndustryActivityPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IndustryActivity.class, id);
        } finally {
            em.close();
        }
    }

    public int getIndustryActivityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IndustryActivity> rt = cq.from(IndustryActivity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
