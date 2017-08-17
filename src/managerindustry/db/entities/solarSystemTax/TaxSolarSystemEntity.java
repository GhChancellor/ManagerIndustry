/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities.solarSystemTax;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import managerindustry.logic.manager.ManagerDB;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.CostIndex;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;

/**
 *
 * @author lele
 */
@Entity
@NamedQueries({
@NamedQuery(name = "TaxSolarSystemEntity.IsExists", query = "SELECT a FROM TaxSolarSystemEntity a WHERE a.solarSystemID = :solarSystemID"),
@NamedQuery(name = "TaxSolarSystemEntity.getAll", query = "SELECT a FROM TaxSolarSystemEntity a"),
})
public class TaxSolarSystemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String solarSystemID;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastUsed = null;

    @OneToMany(cascade = CascadeType.ALL)
    private List < TaxCostIndexEntity > taxCostIndexEntities = new ArrayList<>(); 

    public List<TaxCostIndexEntity> getTaxCostIndexEntities() {
        return taxCostIndexEntities;
    }

    public void setTaxCostIndexEntities(List<TaxCostIndexEntity> taxCostIndexEntities) {
        this.taxCostIndexEntities = taxCostIndexEntities;
    }

    public void addTaxCostIndexEntity( TaxCostIndexEntity costIndex) {
        this.taxCostIndexEntities.add(costIndex);
    }

    public void deleteTaxCostIndexEntityies(){
        taxCostIndexEntities.clear();
    }
    
    public Date getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
    
    public String getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(String solarSystemID) {
        this.solarSystemID = solarSystemID;
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
        if (!(object instanceof TaxSolarSystemEntity)) {
            return false;
        }
        TaxSolarSystemEntity other = (TaxSolarSystemEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.XXSolarSystemEntity[ id=" + id + " ]";
    }
    
}
