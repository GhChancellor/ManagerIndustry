/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author lele
 */
@Embeddable
public class IndustryActivityPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "typeID")
    private int typeID;
    @Basic(optional = false)
    @Column(name = "activityID")
    private int activityID;

    public IndustryActivityPK() {
    }

    public IndustryActivityPK(int typeID, int activityID) {
        this.typeID = typeID;
        this.activityID = activityID;
    }

    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) typeID;
        hash += (int) activityID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IndustryActivityPK)) {
            return false;
        }
        IndustryActivityPK other = (IndustryActivityPK) object;
        if (this.typeID != other.typeID) {
            return false;
        }
        if (this.activityID != other.activityID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.IndustryActivityPK[ typeID=" + typeID + ", activityID=" + activityID + " ]";
    }
    
}
