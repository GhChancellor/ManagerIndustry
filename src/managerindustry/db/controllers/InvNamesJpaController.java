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
import managerindustry.db.entities.eve.InvNames;

/**
 *
 * @author lele
 */
public class InvNamesJpaController implements Serializable {

    public InvNamesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InvNames invNames) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(invNames);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInvNames(invNames.getItemID()) != null) {
                throw new PreexistingEntityException("InvNames " + invNames + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InvNames invNames) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            invNames = em.merge(invNames);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = invNames.getItemID();
                if (findInvNames(id) == null) {
                    throw new NonexistentEntityException("The invNames with id " + id + " no longer exists.");
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
            InvNames invNames;
            try {
                invNames = em.getReference(InvNames.class, id);
                invNames.getItemID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The invNames with id " + id + " no longer exists.", enfe);
            }
            em.remove(invNames);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InvNames> findInvNamesEntities() {
        return findInvNamesEntities(true, -1, -1);
    }

    public List<InvNames> findInvNamesEntities(int maxResults, int firstResult) {
        return findInvNamesEntities(false, maxResults, firstResult);
    }

    private List<InvNames> findInvNamesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InvNames.class));
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

    public InvNames findInvNames(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InvNames.class, id);
        } finally {
            em.close();
        }
    }

    public int getInvNamesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InvNames> rt = cq.from(InvNames.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
