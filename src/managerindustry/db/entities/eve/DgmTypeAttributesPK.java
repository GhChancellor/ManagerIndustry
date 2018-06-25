/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities.eve;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author lele
 */
@Embeddable
public class DgmTypeAttributesPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "typeID")
    private int typeID;
    @Basic(optional = false)
    @Column(name = "attributeID")
    private int attributeID;

    public DgmTypeAttributesPK() {
    }

    public DgmTypeAttributesPK(int typeID, int attributeID) {
        this.typeID = typeID;
        this.attributeID = attributeID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(int attributeID) {
        this.attributeID = attributeID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) typeID;
        hash += (int) attributeID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DgmTypeAttributesPK)) {
            return false;
        }
        DgmTypeAttributesPK other = (DgmTypeAttributesPK) object;
        if (this.typeID != other.typeID) {
            return false;
        }
        if (this.attributeID != other.attributeID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.DgmTypeAttributesPK[ typeID=" + typeID + ", attributeID=" + attributeID + " ]";
    }
    
}
