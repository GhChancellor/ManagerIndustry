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
 * Get all solar system
 * @author lele
 */
@Entity
@Table(name = "mapSolarSystems")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MapSolarSystems.findAll", query = "SELECT m FROM MapSolarSystems m")
    , @NamedQuery(name = "MapSolarSystems.findByRegionID", query = "SELECT m FROM MapSolarSystems m WHERE m.regionID = :regionID")
    , @NamedQuery(name = "MapSolarSystems.findByConstellationID", query = "SELECT m FROM MapSolarSystems m WHERE m.constellationID = :constellationID")
    , @NamedQuery(name = "MapSolarSystems.findBySolarSystemID", query = "SELECT m FROM MapSolarSystems m WHERE m.solarSystemID = :solarSystemID")
    , @NamedQuery(name = "MapSolarSystems.findBySolarSystemName", query = "SELECT m FROM MapSolarSystems m WHERE m.solarSystemName = :solarSystemName")
    , @NamedQuery(name = "MapSolarSystems.findByX", query = "SELECT m FROM MapSolarSystems m WHERE m.x = :x")
    , @NamedQuery(name = "MapSolarSystems.findByY", query = "SELECT m FROM MapSolarSystems m WHERE m.y = :y")
    , @NamedQuery(name = "MapSolarSystems.findByZ", query = "SELECT m FROM MapSolarSystems m WHERE m.z = :z")
    , @NamedQuery(name = "MapSolarSystems.findByXMin", query = "SELECT m FROM MapSolarSystems m WHERE m.xMin = :xMin")
    , @NamedQuery(name = "MapSolarSystems.findByXMax", query = "SELECT m FROM MapSolarSystems m WHERE m.xMax = :xMax")
    , @NamedQuery(name = "MapSolarSystems.findByYMin", query = "SELECT m FROM MapSolarSystems m WHERE m.yMin = :yMin")
    , @NamedQuery(name = "MapSolarSystems.findByYMax", query = "SELECT m FROM MapSolarSystems m WHERE m.yMax = :yMax")
    , @NamedQuery(name = "MapSolarSystems.findByZMin", query = "SELECT m FROM MapSolarSystems m WHERE m.zMin = :zMin")
    , @NamedQuery(name = "MapSolarSystems.findByZMax", query = "SELECT m FROM MapSolarSystems m WHERE m.zMax = :zMax")
    , @NamedQuery(name = "MapSolarSystems.findByLuminosity", query = "SELECT m FROM MapSolarSystems m WHERE m.luminosity = :luminosity")
    , @NamedQuery(name = "MapSolarSystems.findByBorder", query = "SELECT m FROM MapSolarSystems m WHERE m.border = :border")
    , @NamedQuery(name = "MapSolarSystems.findByFringe", query = "SELECT m FROM MapSolarSystems m WHERE m.fringe = :fringe")
    , @NamedQuery(name = "MapSolarSystems.findByCorridor", query = "SELECT m FROM MapSolarSystems m WHERE m.corridor = :corridor")
    , @NamedQuery(name = "MapSolarSystems.findByHub", query = "SELECT m FROM MapSolarSystems m WHERE m.hub = :hub")
    , @NamedQuery(name = "MapSolarSystems.findByInternational", query = "SELECT m FROM MapSolarSystems m WHERE m.international = :international")
    , @NamedQuery(name = "MapSolarSystems.findByRegional", query = "SELECT m FROM MapSolarSystems m WHERE m.regional = :regional")
    , @NamedQuery(name = "MapSolarSystems.findByConstellation", query = "SELECT m FROM MapSolarSystems m WHERE m.constellation = :constellation")
    , @NamedQuery(name = "MapSolarSystems.findBySecurity", query = "SELECT m FROM MapSolarSystems m WHERE m.security = :security")
    , @NamedQuery(name = "MapSolarSystems.findByFactionID", query = "SELECT m FROM MapSolarSystems m WHERE m.factionID = :factionID")
    , @NamedQuery(name = "MapSolarSystems.findByRadius", query = "SELECT m FROM MapSolarSystems m WHERE m.radius = :radius")
    , @NamedQuery(name = "MapSolarSystems.findBySunTypeID", query = "SELECT m FROM MapSolarSystems m WHERE m.sunTypeID = :sunTypeID")
    , @NamedQuery(name = "MapSolarSystems.findBySecurityClass", query = "SELECT m FROM MapSolarSystems m WHERE m.securityClass = :securityClass")})
public class MapSolarSystems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Column(name = "regionID")
    private Integer regionID;
    @Column(name = "constellationID")
    private Integer constellationID;
    @Id
    @Basic(optional = false)
    @Column(name = "solarSystemID")
    private Integer solarSystemID;
    @Column(name = "solarSystemName")
    private String solarSystemName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "x")
    private Double x;
    @Column(name = "y")
    private Double y;
    @Column(name = "z")
    private Double z;
    @Column(name = "xMin")
    private Double xMin;
    @Column(name = "xMax")
    private Double xMax;
    @Column(name = "yMin")
    private Double yMin;
    @Column(name = "yMax")
    private Double yMax;
    @Column(name = "zMin")
    private Double zMin;
    @Column(name = "zMax")
    private Double zMax;
    @Column(name = "luminosity")
    private Double luminosity;
    @Column(name = "border")
    private Boolean border;
    @Column(name = "fringe")
    private Boolean fringe;
    @Column(name = "corridor")
    private Boolean corridor;
    @Column(name = "hub")
    private Boolean hub;
    @Column(name = "international")
    private Boolean international;
    @Column(name = "regional")
    private Boolean regional;
    @Column(name = "constellation")
    private Boolean constellation;
    @Column(name = "security")
    private Double security;
    @Column(name = "factionID")
    private Integer factionID;
    @Column(name = "radius")
    private Double radius;
    @Column(name = "sunTypeID")
    private Integer sunTypeID;
    @Column(name = "securityClass")
    private String securityClass;

    public MapSolarSystems() {
    }

    public MapSolarSystems(Integer solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public Integer getConstellationID() {
        return constellationID;
    }

    public void setConstellationID(Integer constellationID) {
        this.constellationID = constellationID;
    }

    public Integer getSolarSystemID() {
        return solarSystemID;
    }

    public void setSolarSystemID(Integer solarSystemID) {
        this.solarSystemID = solarSystemID;
    }

    public String getSolarSystemName() {
        return solarSystemName;
    }

    public void setSolarSystemName(String solarSystemName) {
        this.solarSystemName = solarSystemName;
    }

    public Double getX() {
        return x;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public Double getY() {
        return y;
    }

    public void setY(Double y) {
        this.y = y;
    }

    public Double getZ() {
        return z;
    }

    public void setZ(Double z) {
        this.z = z;
    }

    public Double getXMin() {
        return xMin;
    }

    public void setXMin(Double xMin) {
        this.xMin = xMin;
    }

    public Double getXMax() {
        return xMax;
    }

    public void setXMax(Double xMax) {
        this.xMax = xMax;
    }

    public Double getYMin() {
        return yMin;
    }

    public void setYMin(Double yMin) {
        this.yMin = yMin;
    }

    public Double getYMax() {
        return yMax;
    }

    public void setYMax(Double yMax) {
        this.yMax = yMax;
    }

    public Double getZMin() {
        return zMin;
    }

    public void setZMin(Double zMin) {
        this.zMin = zMin;
    }

    public Double getZMax() {
        return zMax;
    }

    public void setZMax(Double zMax) {
        this.zMax = zMax;
    }

    public Double getLuminosity() {
        return luminosity;
    }

    public void setLuminosity(Double luminosity) {
        this.luminosity = luminosity;
    }

    public Boolean getBorder() {
        return border;
    }

    public void setBorder(Boolean border) {
        this.border = border;
    }

    public Boolean getFringe() {
        return fringe;
    }

    public void setFringe(Boolean fringe) {
        this.fringe = fringe;
    }

    public Boolean getCorridor() {
        return corridor;
    }

    public void setCorridor(Boolean corridor) {
        this.corridor = corridor;
    }

    public Boolean getHub() {
        return hub;
    }

    public void setHub(Boolean hub) {
        this.hub = hub;
    }

    public Boolean getInternational() {
        return international;
    }

    public void setInternational(Boolean international) {
        this.international = international;
    }

    public Boolean getRegional() {
        return regional;
    }

    public void setRegional(Boolean regional) {
        this.regional = regional;
    }

    public Boolean getConstellation() {
        return constellation;
    }

    public void setConstellation(Boolean constellation) {
        this.constellation = constellation;
    }

    public Double getSecurity() {
        return security;
    }

    public void setSecurity(Double security) {
        this.security = security;
    }

    public Integer getFactionID() {
        return factionID;
    }

    public void setFactionID(Integer factionID) {
        this.factionID = factionID;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Integer getSunTypeID() {
        return sunTypeID;
    }

    public void setSunTypeID(Integer sunTypeID) {
        this.sunTypeID = sunTypeID;
    }

    public String getSecurityClass() {
        return securityClass;
    }

    public void setSecurityClass(String securityClass) {
        this.securityClass = securityClass;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solarSystemID != null ? solarSystemID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MapSolarSystems)) {
            return false;
        }
        MapSolarSystems other = (MapSolarSystems) object;
        if ((this.solarSystemID == null && other.solarSystemID != null) || (this.solarSystemID != null && !this.solarSystemID.equals(other.solarSystemID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.MapSolarSystems[ solarSystemID=" + solarSystemID + " ]";
    }
    
}
