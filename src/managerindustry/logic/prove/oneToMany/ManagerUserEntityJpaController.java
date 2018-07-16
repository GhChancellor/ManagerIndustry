/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.oneToMany;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import managerindustry.logic.prove.oneToMany.exceptions.NonexistentEntityException;

/**
 *
 * @author lele
 */
public class ManagerUserEntityJpaController implements Serializable {

    public ManagerUserEntityJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(ManagerUserEntity managerUserEntity) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(managerUserEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ManagerUserEntity managerUserEntity) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            managerUserEntity = em.merge(managerUserEntity);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = managerUserEntity.getId();
                if (findManagerUserEntity(id) == null) {
                    throw new NonexistentEntityException("The managerUserEntity with id " + id + " no longer exists.");
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
            ManagerUserEntity managerUserEntity;
            try {
                managerUserEntity = em.getReference(ManagerUserEntity.class, id);
                managerUserEntity.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The managerUserEntity with id " + id + " no longer exists.", enfe);
            }
            em.remove(managerUserEntity);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ManagerUserEntity> findManagerUserEntityEntities() {
        return findManagerUserEntityEntities(true, -1, -1);
    }

    public List<ManagerUserEntity> findManagerUserEntityEntities(int maxResults, int firstResult) {
        return findManagerUserEntityEntities(false, maxResults, firstResult);
    }

    private List<ManagerUserEntity> findManagerUserEntityEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ManagerUserEntity.class));
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

    public ManagerUserEntity findManagerUserEntity(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ManagerUserEntity.class, id);
        } finally {
            em.close();
        }
    }

    public int getManagerUserEntityCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ManagerUserEntity> rt = cq.from(ManagerUserEntity.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
