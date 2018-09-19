/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.db.item.eve;

import javax.persistence.EntityManager;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class MapSolarSystemsX {
    private EntityManager entityManager;

    public MapSolarSystemsX() {
        entityManager = Manager.getInstance().db().getEntityManager();
    }
    
//    public MapSolarSystems getMapSolarSystems_SolarSystem(String name){
//        try {
//            EntityManager solarSystemEM = entityManager;
//            TypedQuery < MapSolarSystems > solarSystemTQ = solarSystemEM.createNamedQuery(XXXX, MapSolarSystems.class);
//            
//            solarSystemTQ.setParameter(XXX, XXX);
//            
//            return solarSystemTQ.getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;            
//        }
//    }
    
//    public MapRegions getMapRegions_Region(int region){
//        try {
//            EntityManager regionEM = entityManager;
//
//            TypedQuery < MapRegions > regionTQ = regionEM.createNativeQuery(XXXX, MapRegions.class);
//            regionTQ.setParameter(XXX, XXX);
//            return regionTQ.getSingleResult();
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;        
//        }        
//    }    
}
