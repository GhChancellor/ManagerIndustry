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
@Table(name = "invNames")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvNames.findAll", query = "SELECT i FROM InvNames i")
    , @NamedQuery(name = "InvNames.findByItemID", query = "SELECT i FROM InvNames i WHERE i.itemID = :itemID")
    , @NamedQuery(name = "InvNames.findByItemName", query = "SELECT i FROM InvNames i WHERE i.itemName = :itemName")})
public class InvNames implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "itemID")
    private Integer itemID;
    @Basic(optional = false)
    @Column(name = "itemName")
    private String itemName;

    public InvNames() {
    }

    public InvNames(Integer itemID) {
        this.itemID = itemID;
    }

    public InvNames(Integer itemID, String itemName) {
        this.itemID = itemID;
        this.itemName = itemName;
    }

    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemID != null ? itemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvNames)) {
            return false;
        }
        InvNames other = (InvNames) object;
        if ((this.itemID == null && other.itemID != null) || (this.itemID != null && !this.itemID.equals(other.itemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.InvNames[ itemID=" + itemID + " ]";
    }
    
}
