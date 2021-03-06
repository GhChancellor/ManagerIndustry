/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities.cache;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author lele
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "EffectEngineeringRigEntity.getByEffectID_ByID", 
        query = "SELECT a FROM EffectEngineeringRigEntity a WHERE a.rigTypeID= :rigTypeID AND a.groupEffectID = :groupEffectID"),
    @NamedQuery(name = "EffectEngineeringRigEntity.getByID", query = "SELECT a FROM EffectEngineeringRigEntity a WHERE a.rigTypeID= :rigTypeID")
})

public class EffectEngineeringRigEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    // rigTypeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
    private int rigTypeID;
    // groupEffectID, has effect on item to build like ammunition
    @Column(unique = false)
    private int groupEffectID;

    public EffectEngineeringRigEntity() {
    }

    public EffectEngineeringRigEntity(int typeID, int effectID) {
        this.rigTypeID = typeID;
        this.groupEffectID = effectID;
    }
    
    /**
     * Get rigTypeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     * @return int
     */
    public int getRigTypeID() {
        return rigTypeID;
    }

    /**
     * Set rigTypeID is enginnering rig ( Standup M-Set Blueprint Copy Accelerator II )
     * @param int rigTypeID 
     */
    public void setRigTypeID(int rigTypeID) {
        this.rigTypeID = rigTypeID;
    }

    /**
     * Get groupEffectID has effect on item to build like ammunition
     * @return int
     */
    public int getGroupEffectID() {
        return groupEffectID;
    }

    /**
     * Set groupEffectID, has effect on item to build like ammunition
     * @param int groupEffectID 
     */
    public void setGroupEffectID(int groupEffectID) {
        this.groupEffectID = groupEffectID;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EffectEngineeringRigEntity)) {
            return false;
        }
        EffectEngineeringRigEntity other = (EffectEngineeringRigEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.cache.EffectEngineeringRigEntity[ id=" + id + " ]";
    }
    
}
