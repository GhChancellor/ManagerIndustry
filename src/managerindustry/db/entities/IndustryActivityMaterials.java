/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities;

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
 *
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
    , @NamedQuery(name = "IndustryActivityMaterials.findByIdd", query = "SELECT i FROM IndustryActivityMaterials i WHERE i.idd = :idd")
    , @NamedQuery(name = "IndustryActivityMaterials.findByTypeID", 
      query = "SELECT i FROM IndustryActivityMaterials i WHERE i.typeID = :typeID and i.activityID= :activityID") 
/**
    , @NamedQuery(name = "IndustryActivityMaterials.findByTypeName", 
        query = "SELECT iam FROM IndustryActivityMaterials iam, InvTypes inv WHERE "
        + "iam.activityID= :activityID and iam.typeID = inv.typeID and "
        + "iam.activityID = :activityID and"
        + "  " )    
     */   
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
    @Column(name = "IDD")
    private Integer idd;

    public IndustryActivityMaterials() {
    }

    public IndustryActivityMaterials(Integer idd) {
        this.idd = idd;
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

    public Integer getIdd() {
        return idd;
    }

    public void setIdd(Integer idd) {
        this.idd = idd;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idd != null ? idd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndustryActivityMaterials)) {
            return false;
        }
        IndustryActivityMaterials other = (IndustryActivityMaterials) object;
        if ((this.idd == null && other.idd != null) || (this.idd != null && !this.idd.equals(other.idd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.IndustryActivityMaterials[ idd=" + idd + " ]";
    }
    
}
