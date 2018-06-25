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
 *
 * @author lele
 */
@Entity
@Table(name = "dgmAttributeTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DgmAttributeTypes.findAll", query = "SELECT d FROM DgmAttributeTypes d")
    , @NamedQuery(name = "DgmAttributeTypes.findByAttributeID", query = "SELECT d FROM DgmAttributeTypes d WHERE d.attributeID = :attributeID")
    , @NamedQuery(name = "DgmAttributeTypes.findByAttributeName", query = "SELECT d FROM DgmAttributeTypes d WHERE d.attributeName = :attributeName")
    , @NamedQuery(name = "DgmAttributeTypes.findByDescription", query = "SELECT d FROM DgmAttributeTypes d WHERE d.description = :description")
    , @NamedQuery(name = "DgmAttributeTypes.findByIconID", query = "SELECT d FROM DgmAttributeTypes d WHERE d.iconID = :iconID")
    , @NamedQuery(name = "DgmAttributeTypes.findByDefaultValue", query = "SELECT d FROM DgmAttributeTypes d WHERE d.defaultValue = :defaultValue")
    , @NamedQuery(name = "DgmAttributeTypes.findByPublished", query = "SELECT d FROM DgmAttributeTypes d WHERE d.published = :published")
    , @NamedQuery(name = "DgmAttributeTypes.findByDisplayName", query = "SELECT d FROM DgmAttributeTypes d WHERE d.displayName = :displayName")
    , @NamedQuery(name = "DgmAttributeTypes.findByUnitID", query = "SELECT d FROM DgmAttributeTypes d WHERE d.unitID = :unitID")
    , @NamedQuery(name = "DgmAttributeTypes.findByStackable", query = "SELECT d FROM DgmAttributeTypes d WHERE d.stackable = :stackable")
    , @NamedQuery(name = "DgmAttributeTypes.findByHighIsGood", query = "SELECT d FROM DgmAttributeTypes d WHERE d.highIsGood = :highIsGood")
    , @NamedQuery(name = "DgmAttributeTypes.findByCategoryID", query = "SELECT d FROM DgmAttributeTypes d WHERE d.categoryID = :categoryID")})
public class DgmAttributeTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "attributeID")
    private Integer attributeID;
    @Column(name = "attributeName")
    private String attributeName;
    @Column(name = "description")
    private String description;
    @Column(name = "iconID")
    private Integer iconID;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "defaultValue")
    private Float defaultValue;
    @Column(name = "published")
    private Boolean published;
    @Column(name = "displayName")
    private String displayName;
    @Column(name = "unitID")
    private Integer unitID;
    @Column(name = "stackable")
    private Boolean stackable;
    @Column(name = "highIsGood")
    private Boolean highIsGood;
    @Column(name = "categoryID")
    private Integer categoryID;

    public DgmAttributeTypes() {
    }

    public DgmAttributeTypes(Integer attributeID) {
        this.attributeID = attributeID;
    }

    public Integer getAttributeID() {
        return attributeID;
    }

    public void setAttributeID(Integer attributeID) {
        this.attributeID = attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
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

    public Float getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(Float defaultValue) {
        this.defaultValue = defaultValue;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public Integer getUnitID() {
        return unitID;
    }

    public void setUnitID(Integer unitID) {
        this.unitID = unitID;
    }

    public Boolean getStackable() {
        return stackable;
    }

    public void setStackable(Boolean stackable) {
        this.stackable = stackable;
    }

    public Boolean getHighIsGood() {
        return highIsGood;
    }

    public void setHighIsGood(Boolean highIsGood) {
        this.highIsGood = highIsGood;
    }

    public Integer getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(Integer categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attributeID != null ? attributeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DgmAttributeTypes)) {
            return false;
        }
        DgmAttributeTypes other = (DgmAttributeTypes) object;
        if ((this.attributeID == null && other.attributeID != null) || (this.attributeID != null && !this.attributeID.equals(other.attributeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.DgmAttributeTypes[ attributeID=" + attributeID + " ]";
    }
    
}
