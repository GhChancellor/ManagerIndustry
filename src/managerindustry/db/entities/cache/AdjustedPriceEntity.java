/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities.cache;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author lele
 */
@Entity
@NamedQueries({
// Get a specific type ID ( price )
@NamedQuery(name = "AdjustedPriceEntity.getTypeId", query = "SELECT a FROM AdjustedPriceEntity a WHERE a.type_id = :type_id"),  
// Get all typeID
@NamedQuery(name = "AdjustedPriceEntity.getAll", query = "SELECT a FROM AdjustedPriceEntity a"),
// Get All Except Specific typeID
@NamedQuery(name = "AdjustedPriceEntity.getAllExceptSpecificTypeID", query = "SELECT a FROM AdjustedPriceEntity a WHERE a.type_id <> :type_id"),
    
})
public class AdjustedPriceEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String adjusted_price;
    private String average_price;
    private String type_id;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastUsed = null;

    public AdjustedPriceEntity() {
    }
    /**
     * Get LastUsed
     * @return Date
     */   
    public Date getLastUsed() {
        return lastUsed;
    }

    /**
     * Set LastUsed
     * @param Date lastUsed 
     */
    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
    
    /**
     * Get Adjusted Price
     * @return String
     */
    public String getAdjusted_price() {
        return adjusted_price;
    }

    /**
     * Set Adjusted Price
     * @param String adjusted_price 
     */
    public void setAdjusted_price(String adjusted_price) {
        this.adjusted_price = adjusted_price;
    }

    /**
     * Get Average Price
     * @return String
     */
    public String getAverage_price() {
        return average_price;
    }

    /**
     * Set Average Price
     * @param String average_price 
     */
    public void setAverage_price(String average_price) {
        this.average_price = average_price;
    }

    /**
     * Get Type Id
     * @return String
     */
    public String getType_id() {
        return type_id;
    }

    /**
     * Set Type Id
     * @param String type_id 
     */
    public void setType_id(String type_id) {
        this.type_id = type_id;
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
        if (!(object instanceof AdjustedPriceEntity)) {
            return false;
        }
        AdjustedPriceEntity other = (AdjustedPriceEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.Cache.AdjustedPriceEntity[ id=" + id + " ]";
    }
    
}
