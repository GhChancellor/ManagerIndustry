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
@Table(name = "industryActivitySkills")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "IndustryActivitySkills.findAll", query = "SELECT i FROM IndustryActivitySkills i")
    , @NamedQuery(name = "IndustryActivitySkills.findByActivityID", query = "SELECT i FROM IndustryActivitySkills i WHERE i.activityID = :activityID")
    , @NamedQuery(name = "IndustryActivitySkills.findBySkillID", query = "SELECT i FROM IndustryActivitySkills i WHERE i.skillID = :skillID")
    , @NamedQuery(name = "IndustryActivitySkills.findByLevel", query = "SELECT i FROM IndustryActivitySkills i WHERE i.level = :level")
    , @NamedQuery(name = "IndustryActivitySkills.findByFakeID", query = "SELECT i FROM IndustryActivitySkills i WHERE i.fakeID = :fakeID")
    , @NamedQuery(name = "IndustryActivitySkills.findByTypeID", query = "SELECT i FROM IndustryActivitySkills i WHERE i.typeID = :typeID and i.activityID = :activityID")})
public class IndustryActivitySkills implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "typeID")
    private Integer typeID;
    @Column(name = "activityID")
    private Integer activityID;
    @Column(name = "skillID")
    private Integer skillID;
    @Column(name = "level")
    private Integer level;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fakeID")
    private Integer fakeID;

    public IndustryActivitySkills() {
    }

    public IndustryActivitySkills(Integer fakeID) {
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

    public Integer getSkillID() {
        return skillID;
    }

    public void setSkillID(Integer skillID) {
        this.skillID = skillID;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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
        if (!(object instanceof IndustryActivitySkills)) {
            return false;
        }
        IndustryActivitySkills other = (IndustryActivitySkills) object;
        if ((this.fakeID == null && other.fakeID != null) || (this.fakeID != null && !this.fakeID.equals(other.fakeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.IndustryActivitySkills[ fakeID=" + fakeID + " ]";
    }
    
}
