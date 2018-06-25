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
import managerindustry.db.entities.eve.IndustryActivitySkills;

/**
 *
 * @author lele
 */
public class IndustryActivitySkillsJpaController implements Serializable {

    public IndustryActivitySkillsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(IndustryActivitySkills industryActivitySkills) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(industryActivitySkills);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(IndustryActivitySkills industryActivitySkills) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            industryActivitySkills = em.merge(industryActivitySkills);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = industryActivitySkills.getFakeID();
                if (findIndustryActivitySkills(id) == null) {
                    throw new NonexistentEntityException("The industryActivitySkills with id " + id + " no longer exists.");
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
            IndustryActivitySkills industryActivitySkills;
            try {
                industryActivitySkills = em.getReference(IndustryActivitySkills.class, id);
                industryActivitySkills.getFakeID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The industryActivitySkills with id " + id + " no longer exists.", enfe);
            }
            em.remove(industryActivitySkills);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<IndustryActivitySkills> findIndustryActivitySkillsEntities() {
        return findIndustryActivitySkillsEntities(true, -1, -1);
    }

    public List<IndustryActivitySkills> findIndustryActivitySkillsEntities(int maxResults, int firstResult) {
        return findIndustryActivitySkillsEntities(false, maxResults, firstResult);
    }

    private List<IndustryActivitySkills> findIndustryActivitySkillsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(IndustryActivitySkills.class));
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

    public IndustryActivitySkills findIndustryActivitySkills(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(IndustryActivitySkills.class, id);
        } finally {
            em.close();
        }
    }

    public int getIndustryActivitySkillsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<IndustryActivitySkills> rt = cq.from(IndustryActivitySkills.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
