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
import managerindustry.db.entities.XXCostIndexEntity;

/**
 *
 * @author lele
 */
public class XXCostIndexEntityJpaController implements Serializable {

    public XXCostIndexEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(XXCostIndexEntity XXCostIndexEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(XXCostIndexEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(XXCostIndexEntity XXCostIndexEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            XXCostIndexEntity = em.merge(XXCostIndexEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = XXCostIndexEntity.getId();
                if (findXXCostIndexEntity(id) == null) {
                    throw new NonexistentEntityException("The xXCostIndexEntity with id " + id + " no longer exists.");
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
            XXCostIndexEntity XXCostIndexEntity;
            try {
                XXCostIndexEntity = em.getReference(XXCostIndexEntity.class, id);
                XXCostIndexEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The XXCostIndexEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(XXCostIndexEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<XXCostIndexEntity> findXXCostIndexEntityEntities() {
        return findXXCostIndexEntityEntities(true, -1, -1);
    }

    public List<XXCostIndexEntity> findXXCostIndexEntityEntities(int maxResults, int firstResult) {
        return findXXCostIndexEntityEntities(false, maxResults, firstResult);
    }

    private List<XXCostIndexEntity> findXXCostIndexEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(XXCostIndexEntity.class));
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

    public XXCostIndexEntity findXXCostIndexEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(XXCostIndexEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getXXCostIndexEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<XXCostIndexEntity> rt = cq.from(XXCostIndexEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
