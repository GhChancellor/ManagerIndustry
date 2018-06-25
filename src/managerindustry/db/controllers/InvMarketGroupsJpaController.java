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
import managerindustry.db.entities.eve.InvMarketGroups;

/**
 *
 * @author lele
 */
public class InvMarketGroupsJpaController implements Serializable {

    public InvMarketGroupsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InvMarketGroups invMarketGroups) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(invMarketGroups);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInvMarketGroups(invMarketGroups.getMarketGroupID()) != null) {
                throw new PreexistingEntityException("InvMarketGroups " + invMarketGroups + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InvMarketGroups invMarketGroups) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            invMarketGroups = em.merge(invMarketGroups);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = invMarketGroups.getMarketGroupID();
                if (findInvMarketGroups(id) == null) {
                    throw new NonexistentEntityException("The invMarketGroups with id " + id + " no longer exists.");
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
            InvMarketGroups invMarketGroups;
            try {
                invMarketGroups = em.getReference(InvMarketGroups.class, id);
                invMarketGroups.getMarketGroupID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The invMarketGroups with id " + id + " no longer exists.", enfe);
            }
            em.remove(invMarketGroups);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InvMarketGroups> findInvMarketGroupsEntities() {
        return findInvMarketGroupsEntities(true, -1, -1);
    }

    public List<InvMarketGroups> findInvMarketGroupsEntities(int maxResults, int firstResult) {
        return findInvMarketGroupsEntities(false, maxResults, firstResult);
    }

    private List<InvMarketGroups> findInvMarketGroupsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InvMarketGroups.class));
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

    public InvMarketGroups findInvMarketGroups(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InvMarketGroups.class, id);
        } finally {
            em.close();
        }
    }

    public int getInvMarketGroupsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InvMarketGroups> rt = cq.from(InvMarketGroups.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
