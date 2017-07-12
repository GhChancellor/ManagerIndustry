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
import managerindustry.db.entities.DgmTypeAttributes;
import managerindustry.db.entities.DgmTypeAttributesPK;

/**
 *
 * @author lele
 */
public class DgmTypeAttributesJpaController implements Serializable {

    public DgmTypeAttributesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DgmTypeAttributes dgmTypeAttributes) throws PreexistingEntityException, Exception {
        if (dgmTypeAttributes.getDgmTypeAttributesPK() == null) {
            dgmTypeAttributes.setDgmTypeAttributesPK(new DgmTypeAttributesPK());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dgmTypeAttributes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDgmTypeAttributes(dgmTypeAttributes.getDgmTypeAttributesPK()) != null) {
                throw new PreexistingEntityException("DgmTypeAttributes " + dgmTypeAttributes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DgmTypeAttributes dgmTypeAttributes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dgmTypeAttributes = em.merge(dgmTypeAttributes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                DgmTypeAttributesPK id = dgmTypeAttributes.getDgmTypeAttributesPK();
                if (findDgmTypeAttributes(id) == null) {
                    throw new NonexistentEntityException("The dgmTypeAttributes with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(DgmTypeAttributesPK id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            DgmTypeAttributes dgmTypeAttributes;
            try {
                dgmTypeAttributes = em.getReference(DgmTypeAttributes.class, id);
                dgmTypeAttributes.getDgmTypeAttributesPK();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dgmTypeAttributes with id " + id + " no longer exists.", enfe);
            }
            em.remove(dgmTypeAttributes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DgmTypeAttributes> findDgmTypeAttributesEntities() {
        return findDgmTypeAttributesEntities(true, -1, -1);
    }

    public List<DgmTypeAttributes> findDgmTypeAttributesEntities(int maxResults, int firstResult) {
        return findDgmTypeAttributesEntities(false, maxResults, firstResult);
    }

    private List<DgmTypeAttributes> findDgmTypeAttributesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DgmTypeAttributes.class));
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

    public DgmTypeAttributes findDgmTypeAttributes(DgmTypeAttributesPK id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DgmTypeAttributes.class, id);
        } finally {
            em.close();
        }
    }

    public int getDgmTypeAttributesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DgmTypeAttributes> rt = cq.from(DgmTypeAttributes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
