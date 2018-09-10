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
 *
 * @author lele
 */
@Entity
@Table(name = "industryActivityProducts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndustryActivityProducts.findAll", query = "SELECT i FROM IndustryActivityProducts i")
    , @NamedQuery(name = "IndustryActivityProducts.findByTypeID", query = "SELECT i FROM IndustryActivityProducts i WHERE i.typeID = :typeID")
    , @NamedQuery(name = "IndustryActivityProducts.findByActivityID", query = "SELECT i FROM IndustryActivityProducts i WHERE i.activityID = :activityID")
    , @NamedQuery(name = "IndustryActivityProducts.findByProductTypeID", query = "SELECT i FROM IndustryActivityProducts i WHERE i.productTypeID = :productTypeID")
    , @NamedQuery(name = "IndustryActivityProducts.findByQuantity", query = "SELECT i FROM IndustryActivityProducts i WHERE i.quantity = :quantity")
    , @NamedQuery(name = "IndustryActivityProducts.findByFakeID", query = "SELECT i FROM IndustryActivityProducts i WHERE i.fakeID = :fakeID")
      // Get ProductTypeID and quantity By ID and activityID
      // From scimitar ( ship ) to scimitar blueprint  
    , @NamedQuery(name = "IndustryActivityProducts.findProductTypeID_ByTypeID_ActivityID", 
        query = "SELECT i FROM IndustryActivityProducts i WHERE i.typeID = :typeID and i.activityID = :activityID")
      
    // Get typeID and quantity By productTypeID and activityID  
    // From scimitar blueprint to scimitar ( ship )    
    , @NamedQuery(name = "IndustryActivityProducts.findTypeID_ByProductTypeID_ByActivityID", 
        query = "SELECT i FROM IndustryActivityProducts i WHERE i.productTypeID = :productTypeID and i.activityID = :activityID")
})


public class IndustryActivityProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "typeID")
    private Integer typeID;
    @Column(name = "activityID")
    private Integer activityID;
    @Column(name = "productTypeID")
    private Integer productTypeID;
    @Column(name = "quantity")
    private Integer quantity;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "FakeID")
    private Integer fakeID;

    public IndustryActivityProducts() {
    }

    public IndustryActivityProducts(Integer fakeID) {
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

    public Integer getProductTypeID() {
        return productTypeID;
    }

    public void setProductTypeID(Integer productTypeID) {
        this.productTypeID = productTypeID;
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
        if (!(object instanceof IndustryActivityProducts)) {
            return false;
        }
        IndustryActivityProducts other = (IndustryActivityProducts) object;
        if ((this.fakeID == null && other.fakeID != null) || (this.fakeID != null && !this.fakeID.equals(other.fakeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.eve.IndustryActivityProducts[ fakeID=" + fakeID + " ]";
    }
    
}
