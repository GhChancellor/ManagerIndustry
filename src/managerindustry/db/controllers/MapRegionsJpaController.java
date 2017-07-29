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
import managerindustry.db.entities.MapRegions;

/**
 *
 * @author lele
 */
public class MapRegionsJpaController implements Serializable {

    public MapRegionsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MapRegions mapRegions) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mapRegions);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMapRegions(mapRegions.getRegionID()) != null) {
                throw new PreexistingEntityException("MapRegions " + mapRegions + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MapRegions mapRegions) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mapRegions = em.merge(mapRegions);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mapRegions.getRegionID();
                if (findMapRegions(id) == null) {
                    throw new NonexistentEntityException("The mapRegions with id " + id + " no longer exists.");
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
            MapRegions mapRegions;
            try {
                mapRegions = em.getReference(MapRegions.class, id);
                mapRegions.getRegionID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mapRegions with id " + id + " no longer exists.", enfe);
            }
            em.remove(mapRegions);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MapRegions> findMapRegionsEntities() {
        return findMapRegionsEntities(true, -1, -1);
    }

    public List<MapRegions> findMapRegionsEntities(int maxResults, int firstResult) {
        return findMapRegionsEntities(false, maxResults, firstResult);
    }

    private List<MapRegions> findMapRegionsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MapRegions.class));
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

    public MapRegions findMapRegions(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MapRegions.class, id);
        } finally {
            em.close();
        }
    }

    public int getMapRegionsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MapRegions> rt = cq.from(MapRegions.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
