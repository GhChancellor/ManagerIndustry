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
import managerindustry.db.entities.DgmAttributeTypes;

/**
 *
 * @author lele
 */
public class DgmAttributeTypesJpaController implements Serializable {

    public DgmAttributeTypesJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(DgmAttributeTypes dgmAttributeTypes) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(dgmAttributeTypes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findDgmAttributeTypes(dgmAttributeTypes.getAttributeID()) != null) {
                throw new PreexistingEntityException("DgmAttributeTypes " + dgmAttributeTypes + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(DgmAttributeTypes dgmAttributeTypes) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            dgmAttributeTypes = em.merge(dgmAttributeTypes);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = dgmAttributeTypes.getAttributeID();
                if (findDgmAttributeTypes(id) == null) {
                    throw new NonexistentEntityException("The dgmAttributeTypes with id " + id + " no longer exists.");
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
            DgmAttributeTypes dgmAttributeTypes;
            try {
                dgmAttributeTypes = em.getReference(DgmAttributeTypes.class, id);
                dgmAttributeTypes.getAttributeID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The dgmAttributeTypes with id " + id + " no longer exists.", enfe);
            }
            em.remove(dgmAttributeTypes);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<DgmAttributeTypes> findDgmAttributeTypesEntities() {
        return findDgmAttributeTypesEntities(true, -1, -1);
    }

    public List<DgmAttributeTypes> findDgmAttributeTypesEntities(int maxResults, int firstResult) {
        return findDgmAttributeTypesEntities(false, maxResults, firstResult);
    }

    private List<DgmAttributeTypes> findDgmAttributeTypesEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(DgmAttributeTypes.class));
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

    public DgmAttributeTypes findDgmAttributeTypes(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(DgmAttributeTypes.class, id);
        } finally {
            em.close();
        }
    }

    public int getDgmAttributeTypesCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<DgmAttributeTypes> rt = cq.from(DgmAttributeTypes.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
