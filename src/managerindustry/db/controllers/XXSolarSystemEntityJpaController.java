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
import managerindustry.db.entities.XXSolarSystemEntity;

/**
 *
 * @author lele
 */
public class XXSolarSystemEntityJpaController implements Serializable {

    public XXSolarSystemEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(XXSolarSystemEntity XXSolarSystemEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(XXSolarSystemEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(XXSolarSystemEntity XXSolarSystemEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            XXSolarSystemEntity = em.merge(XXSolarSystemEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = XXSolarSystemEntity.getId();
                if (findXXSolarSystemEntity(id) == null) {
                    throw new NonexistentEntityException("The xXSolarSystemEntity with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            XXSolarSystemEntity XXSolarSystemEntity;
            try {
                XXSolarSystemEntity = em.getReference(XXSolarSystemEntity.class, id);
                XXSolarSystemEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The XXSolarSystemEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(XXSolarSystemEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<XXSolarSystemEntity> findXXSolarSystemEntityEntities() {
        return findXXSolarSystemEntityEntities(true, -1, -1);
    }

    public List<XXSolarSystemEntity> findXXSolarSystemEntityEntities(int maxResults, int firstResult) {
        return findXXSolarSystemEntityEntities(false, maxResults, firstResult);
    }

    private List<XXSolarSystemEntity> findXXSolarSystemEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(XXSolarSystemEntity.class));
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

    public XXSolarSystemEntity findXXSolarSystemEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(XXSolarSystemEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getXXSolarSystemEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<XXSolarSystemEntity> rt = cq.from(XXSolarSystemEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
