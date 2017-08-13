/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import managerindustry.logic.tax.jobInstallationFee.systemCostIndex.SolarSystem;

/**
 *
 * @author lele
 */
@Entity
public class XXSolarSystemEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String solarSystem;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date lastUsed;

    @OneToMany(cascade = CascadeType.ALL)
    private List < XXCostIndexEntity > costIndex; 

    
    public void qualcosa( Map<String, SolarSystem > solarSystemMap, String SolarSystemID, String activity ){
        
    }
    
    private List<XXCostIndexEntity> getCostIndex() {
        return costIndex;
    }
    
    private void setCostIndex(List<XXCostIndexEntity> costIndex) {
        this.costIndex = costIndex;
    }
    
    private void addCostIndex( XXCostIndexEntity costIndex) {
        this.costIndex.add(costIndex);
    }

    private Date getLastUsed() {
        return lastUsed;
    }

    private void setLastUsed(Date lastUsed) {
        this.lastUsed = lastUsed;
    }
    
    public String getSolarSystem() {
        return solarSystem;
    }

    private void setSolarSystem(String solarSystem) {
        this.solarSystem = solarSystem;
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
        if (!(object instanceof XXSolarSystemEntity)) {
            return false;
        }
        XXSolarSystemEntity other = (XXSolarSystemEntity) object;
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
