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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Crea una relazione padre figlio per sapere a quale categoria un oggetto appartiene 
 * @author lele
 */
@Entity
@Table(name = "invMarketGroups")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvMarketGroups.findAll", query = "SELECT i FROM InvMarketGroups i")
    , @NamedQuery(name = "InvMarketGroups.findByMarketGroupID", query = "SELECT i FROM InvMarketGroups i WHERE i.marketGroupID = :marketGroupID")
    , @NamedQuery(name = "InvMarketGroups.findByParentGroupID", query = "SELECT i FROM InvMarketGroups i WHERE i.parentGroupID = :parentGroupID")
    , @NamedQuery(name = "InvMarketGroups.findByMarketGroupName", query = "SELECT i FROM InvMarketGroups i WHERE i.marketGroupName = :marketGroupName")
    , @NamedQuery(name = "InvMarketGroups.findByDescription", query = "SELECT i FROM InvMarketGroups i WHERE i.description = :description")
    , @NamedQuery(name = "InvMarketGroups.findByIconID", query = "SELECT i FROM InvMarketGroups i WHERE i.iconID = :iconID")
    , @NamedQuery(name = "InvMarketGroups.findByHasTypes", query = "SELECT i FROM InvMarketGroups i WHERE i.hasTypes = :hasTypes")
      
      // recupera tutti i tipi di droni
    , @NamedQuery(name = "InvMarketGroups.findByMarketGroup_InvTypes", query = "SELECT a FROM InvMarketGroups i, InvTypes a WHERE a.marketGroupID = i.marketGroupID and i.parentGroupID = :parentGroupID ")        
})
public class InvMarketGroups implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "marketGroupID")
    private Integer marketGroupID;
    @Column(name = "parentGroupID")
    private Integer parentGroupID;
    @Column(name = "marketGroupName")
    private String marketGroupName;
    @Column(name = "description")
    private String description;
    @Column(name = "iconID")
    private Integer iconID;
    @Column(name = "hasTypes")
    private Boolean hasTypes;

    public InvMarketGroups() {
    }

    public InvMarketGroups(Integer marketGroupID) {
        this.marketGroupID = marketGroupID;
    }

    public Integer getMarketGroupID() {
        return marketGroupID;
    }

    public void setMarketGroupID(Integer marketGroupID) {
        this.marketGroupID = marketGroupID;
    }

    public Integer getParentGroupID() {
        return parentGroupID;
    }

    public void setParentGroupID(Integer parentGroupID) {
        this.parentGroupID = parentGroupID;
    }

    public String getMarketGroupName() {
        return marketGroupName;
    }

    public void setMarketGroupName(String marketGroupName) {
        this.marketGroupName = marketGroupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getIconID() {
        return iconID;
    }

    public void setIconID(Integer iconID) {
        this.iconID = iconID;
    }

    public Boolean getHasTypes() {
        return hasTypes;
    }

    public void setHasTypes(Boolean hasTypes) {
        this.hasTypes = hasTypes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (marketGroupID != null ? marketGroupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvMarketGroups)) {
            return false;
        }
        InvMarketGroups other = (InvMarketGroups) object;
        if ((this.marketGroupID == null && other.marketGroupID != null) || (this.marketGroupID != null && !this.marketGroupID.equals(other.marketGroupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.InvMarketGroups[ marketGroupID=" + marketGroupID + " ]";
    }
    
}
