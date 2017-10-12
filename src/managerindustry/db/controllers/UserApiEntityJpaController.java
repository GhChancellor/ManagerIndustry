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
import managerindustry.db.entities.user.UserApiEntity;

/**
 *
 * @author lele
 */
public class UserApiEntityJpaController implements Serializable {

    public UserApiEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(UserApiEntity userApiEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(userApiEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(UserApiEntity userApiEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            userApiEntity = em.merge(userApiEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = userApiEntity.getId();
                if (findUserApiEntity(id) == null) {
                    throw new NonexistentEntityException("The userApiEntity with id " + id + " no longer exists.");
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
            UserApiEntity userApiEntity;
            try {
                userApiEntity = em.getReference(UserApiEntity.class, id);
                userApiEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The userApiEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(userApiEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<UserApiEntity> findUserApiEntityEntities() {
        return findUserApiEntityEntities(true, -1, -1);
    }

    public List<UserApiEntity> findUserApiEntityEntities(int maxResults, int firstResult) {
        return findUserApiEntityEntities(false, maxResults, firstResult);
    }

    private List<UserApiEntity> findUserApiEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(UserApiEntity.class));
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

    public UserApiEntity findUserApiEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(UserApiEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getUserApiEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<UserApiEntity> rt = cq.from(UserApiEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
