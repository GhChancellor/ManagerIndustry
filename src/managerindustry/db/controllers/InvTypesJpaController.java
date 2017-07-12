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
import managerindustry.db.entities.InvTypes;

/**
 *
 * @author lele
 */
public class InvTypesJpaController implements Serializable {

    public InvTypesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(InvTypes invTypes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(invTypes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findInvTypes(invTypes.getTypeID()) != null) {
                throw new PreexistingEntityException("InvTypes " + invTypes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(InvTypes invTypes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            invTypes = em.merge(invTypes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = invTypes.getTypeID();
                if (findInvTypes(id) == null) {
                    throw new NonexistentEntityException("The invTypes with id " + id + " no longer exists.");
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
            InvTypes invTypes;
            try {
                invTypes = em.getReference(InvTypes.class, id);
                invTypes.getTypeID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The invTypes with id " + id + " no longer exists.", enfe);
            }
            em.remove(invTypes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InvTypes> findInvTypesEntities() {
        return findInvTypesEntities(true, -1, -1);
    }

    public List<InvTypes> findInvTypesEntities(int maxResults, int firstResult) {
        return findInvTypesEntities(false, maxResults, firstResult);
    }

    private List<InvTypes> findInvTypesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(InvTypes.class));
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

    public InvTypes findInvTypes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(InvTypes.class, id);
        } finally {
            em.close();
        }
    }

    public int getInvTypesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<InvTypes> rt = cq.from(InvTypes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
