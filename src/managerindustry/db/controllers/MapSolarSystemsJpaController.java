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
import managerindustry.db.entities.eve.MapSolarSystems;

/**
 *
 * @author lele
 */
public class MapSolarSystemsJpaController implements Serializable {

    public MapSolarSystemsJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(MapSolarSystems mapSolarSystems) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(mapSolarSystems);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMapSolarSystems(mapSolarSystems.getSolarSystemID()) != null) {
                throw new PreexistingEntityException("MapSolarSystems " + mapSolarSystems + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(MapSolarSystems mapSolarSystems) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            mapSolarSystems = em.merge(mapSolarSystems);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = mapSolarSystems.getSolarSystemID();
                if (findMapSolarSystems(id) == null) {
                    throw new NonexistentEntityException("The mapSolarSystems with id " + id + " no longer exists.");
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
            MapSolarSystems mapSolarSystems;
            try {
                mapSolarSystems = em.getReference(MapSolarSystems.class, id);
                mapSolarSystems.getSolarSystemID();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The mapSolarSystems with id " + id + " no longer exists.", enfe);
            }
            em.remove(mapSolarSystems);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MapSolarSystems> findMapSolarSystemsEntities() {
        return findMapSolarSystemsEntities(true, -1, -1);
    }

    public List<MapSolarSystems> findMapSolarSystemsEntities(int maxResults, int firstResult) {
        return findMapSolarSystemsEntities(false, maxResults, firstResult);
    }

    private List<MapSolarSystems> findMapSolarSystemsEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MapSolarSystems.class));
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

    public MapSolarSystems findMapSolarSystems(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MapSolarSystems.class, id);
        } finally {
            em.close();
        }
    }

    public int getMapSolarSystemsCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MapSolarSystems> rt = cq.from(MapSolarSystems.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
