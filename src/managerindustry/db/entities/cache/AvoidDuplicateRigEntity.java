/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities.cache;

import java.io.Serializable;
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
    @NamedQuery(name = "AvoidDuplicateRigEntity.NotMountableById_T1", query="SELECT a FROM AvoidDuplicateRigEntity a where a.typeId_T1 = :typeId_T1" ),
    @NamedQuery(name = "AvoidDuplicateRigEntity.NotMountableById_T2", query="SELECT a FROM AvoidDuplicateRigEntity a where a.typeId_T2 = :typeId_T2" ),    
})

public class AvoidDuplicateRigEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int typeId_T1;
    private int typeId_T2;

    public AvoidDuplicateRigEntity() {
    }

    /**
     * Avoid Duplicate Rig Entity
     * @param typeId_T1
     * @param typeId_T2 
     */
    public AvoidDuplicateRigEntity(int typeId_T1, int typeId_T2) {
        this.typeId_T1 = typeId_T1;
        this.typeId_T2 = typeId_T2;
    }

    /**
     * Get TypeId T1
     * @return int
     */
    public int getTypeId_T1() {
        return typeId_T1;
    }
    
    /**
     * Get TypeId T2
     * @return int
     */
    public int getTypeId_T2() {
        return typeId_T2;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
        if (!(object instanceof AvoidDuplicateRigEntity)) {
            return false;
        }
        AvoidDuplicateRigEntity other = (AvoidDuplicateRigEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.cache.AvoidDuplicateRigEntity[ id=" + id + " ]";
    }
    
}
