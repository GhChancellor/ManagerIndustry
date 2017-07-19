/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lele
 */
@Entity
@Table(name = "invTypes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InvTypes.findAll", query = "SELECT i FROM InvTypes i")
    , @NamedQuery(name = "InvTypes.findByTypeID", query = "SELECT i FROM InvTypes i WHERE i.typeID = :typeID")
    , @NamedQuery(name = "InvTypes.findByGroupID", query = "SELECT i FROM InvTypes i WHERE i.groupID = :groupID")
    , @NamedQuery(name = "InvTypes.findByTypeName", query = "SELECT i FROM InvTypes i WHERE i.typeName = :typeName")
    , @NamedQuery(name = "InvTypes.findByMass", query = "SELECT i FROM InvTypes i WHERE i.mass = :mass")
    , @NamedQuery(name = "InvTypes.findByVolume", query = "SELECT i FROM InvTypes i WHERE i.volume = :volume")
    , @NamedQuery(name = "InvTypes.findByCapacity", query = "SELECT i FROM InvTypes i WHERE i.capacity = :capacity")
    , @NamedQuery(name = "InvTypes.findByPortionSize", query = "SELECT i FROM InvTypes i WHERE i.portionSize = :portionSize")
    , @NamedQuery(name = "InvTypes.findByRaceID", query = "SELECT i FROM InvTypes i WHERE i.raceID = :raceID")
    , @NamedQuery(name = "InvTypes.findByBasePrice", query = "SELECT i FROM InvTypes i WHERE i.basePrice = :basePrice")
    , @NamedQuery(name = "InvTypes.findByPublished", query = "SELECT i FROM InvTypes i WHERE i.published = :published")
    , @NamedQuery(name = "InvTypes.findByMarketGroupID", query = "SELECT i FROM InvTypes i WHERE i.marketGroupID = :marketGroupID")
    , @NamedQuery(name = "InvTypes.findByIconID", query = "SELECT i FROM InvTypes i WHERE i.iconID = :iconID")
    , @NamedQuery(name = "InvTypes.findBySoundID", query = "SELECT i FROM InvTypes i WHERE i.soundID = :soundID")
    , @NamedQuery(name = "InvTypes.findByGraphicID", query = "SELECT i FROM InvTypes i WHERE i.graphicID = :graphicID")
    , @NamedQuery(name = "InvTypes.findByTypeId-Published-AttributeID",  query = 
     "SELECT NEW managerindustry.logic.skill ( a.typeName, a.description, b.valueFloat, b.valueInt ) FROM InvTypes A, DgmTypeAttributes B, DgmAttributeTypes C where A.typeID = b.dgmTypeAttributesPK.typeID and B.dgmTypeAttributesPK.attributeID = C.attributeID AND A.typeID = :typeID AND A.published = :published AND c.attributeID = :attributeID ")

})
public class InvTypes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "typeID")
    private Integer typeID;
    @Column(name = "groupID")
    private Integer groupID;
    @Column(name = "typeName")
    private String typeName;
    @Lob
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "mass")
    private Double mass;
    @Column(name = "volume")
    private Double volume;
    @Column(name = "capacity")
    private Double capacity;
    @Column(name = "portionSize")
    private Integer portionSize;
    @Column(name = "raceID")
    private Integer raceID;
    @Column(name = "basePrice")
    private BigDecimal basePrice;
    @Column(name = "published")
    private Boolean published;
    @Column(name = "marketGroupID")
    private Integer marketGroupID;
    @Column(name = "iconID")
    private Integer iconID;
    @Column(name = "soundID")
    private Integer soundID;
    @Column(name = "graphicID")
    private Integer graphicID;

    public InvTypes() {
    }

    public InvTypes(Integer typeID) {
        this.typeID = typeID;
    }

    public Integer getTypeID() {
        return typeID;
    }

    public void setTypeID(Integer typeID) {
        this.typeID = typeID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMass() {
        return mass;
    }

    public void setMass(Double mass) {
        this.mass = mass;
    }

    public Double getVolume() {
        return volume;
    }

    public void setVolume(Double volume) {
        this.volume = volume;
    }

    public Double getCapacity() {
        return capacity;
    }

    public void setCapacity(Double capacity) {
        this.capacity = capacity;
    }

    public Integer getPortionSize() {
        return portionSize;
    }

    public void setPortionSize(Integer portionSize) {
        this.portionSize = portionSize;
    }

    public Integer getRaceID() {
        return raceID;
    }

    public void setRaceID(Integer raceID) {
        this.raceID = raceID;
    }

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Boolean getPublished() {
        return published;
    }

    public void setPublished(Boolean published) {
        this.published = published;
    }

    public Integer getMarketGroupID() {
        return marketGroupID;
    }

    public void setMarketGroupID(Integer marketGroupID) {
        this.marketGroupID = marketGroupID;
    }

    public Integer getIconID() {
        return iconID;
    }

    public void setIconID(Integer iconID) {
        this.iconID = iconID;
    }

    public Integer getSoundID() {
        return soundID;
    }

    public void setSoundID(Integer soundID) {
        this.soundID = soundID;
    }

    public Integer getGraphicID() {
        return graphicID;
    }

    public void setGraphicID(Integer graphicID) {
        this.graphicID = graphicID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (typeID != null ? typeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InvTypes)) {
            return false;
        }
        InvTypes other = (InvTypes) object;
        if ((this.typeID == null && other.typeID != null) || (this.typeID != null && !this.typeID.equals(other.typeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.InvTypes[ typeID=" + typeID + " ]";
    }
    
}
