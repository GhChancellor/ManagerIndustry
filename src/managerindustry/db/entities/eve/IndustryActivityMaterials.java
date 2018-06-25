/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities.eve;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Get blueprint type id, activity id, material id, quantity, and if it’s consumed. 
 * @author lele
 */
@Entity
@Table(name = "industryActivityMaterials")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndustryActivityMaterials.findAll", query = "SELECT i FROM IndustryActivityMaterials i")    
    , @NamedQuery(name = "IndustryActivityMaterials.findByActivityID", query = "SELECT i FROM IndustryActivityMaterials i WHERE i.activityID = :activityID")
    , @NamedQuery(name = "IndustryActivityMaterials.findByMaterialTypeID", query = "SELECT i FROM IndustryActivityMaterials i WHERE i.materialTypeID = :materialTypeID")
    , @NamedQuery(name = "IndustryActivityMaterials.findByQuantity", query = "SELECT i FROM IndustryActivityMaterials i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "IndustryActivityMaterials.findByFakeID", query = "SELECT i FROM IndustryActivityMaterials i WHERE i.fakeID = :fakeID")
    // , @NamedQuery(name = "IndustryActivityMaterials.findByTypeID", query = "SELECT i FROM IndustryActivityMaterials i WHERE i.typeID = :typeID")    
    , @NamedQuery(name = "IndustryActivityMaterials.findByTypeID", 
      query = "SELECT i FROM IndustryActivityMaterials i WHERE i.typeID = :typeID and i.activityID= :activityID") 

})
public class IndustryActivityMaterials implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "typeID")
    private Integer typeID;
    @Column(name = "activityID")
    private Integer activityID;
    @Column(name = "materialTypeID")
    private Integer materialTypeID;
    @Column(name = "quantity")
    private Integer quantity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fakeID")
    private Integer fakeID;

    public IndustryActivityMaterials() {
    }

    public IndustryActivityMaterials(Integer fakeID) {
        this.fakeID = fakeID;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public Integer getActivityID() {
        return activityID;
    }

    public void setActivityID(Integer activityID) {
        this.activityID = activityID;
    }

    public Integer getMaterialTypeID() {
        return materialTypeID;
    }

    public void setMaterialTypeID(Integer materialTypeID) {
        this.materialTypeID = materialTypeID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getFakeID() {
        return fakeID;
    }

    public void setFakeID(Integer fakeID) {
        this.fakeID = fakeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fakeID != null ? fakeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndustryActivityMaterials)) {
            return false;
        }
        IndustryActivityMaterials other = (IndustryActivityMaterials) object;
        if ((this.fakeID == null && other.fakeID != null) || (this.fakeID != null && !this.fakeID.equals(other.fakeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.IndustryActivityMaterials[ fakeID=" + fakeID + " ]";
    }
    
}
