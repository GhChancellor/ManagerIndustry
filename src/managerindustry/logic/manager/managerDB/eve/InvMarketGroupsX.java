/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.managerDB.eve;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.db.entities.InvTypes;

/**
 *
 * @author lele
 */
public class InvMarketGroupsX {
    private EntityManager entityManager;

    public InvMarketGroupsX(EntityManager entityManager) {
        this.entityManager = entityManager;
    }    
    
}
