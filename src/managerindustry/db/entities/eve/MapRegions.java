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
 * Get all region 
 * @author lele
 */
@Entity
@Table(name = "mapRegions")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MapRegions.findAll", query = "SELECT m FROM MapRegions m")
    , @NamedQuery(name = "MapRegions.findByRegionID", query = "SELECT m FROM MapRegions m WHERE m.regionID = :regionID")
    , @NamedQuery(name = "MapRegions.findByRegionName", query = "SELECT m FROM MapRegions m WHERE m.regionName = :regionName")
    , @NamedQuery(name = "MapRegions.findByX", query = "SELECT m FROM MapRegions m WHERE m.x = :x")
    , @NamedQuery(name = "MapRegions.findByY", query = "SELECT m FROM MapRegions m WHERE m.y = :y")
    , @NamedQuery(name = "MapRegions.findByZ", query = "SELECT m FROM MapRegions m WHERE m.z = :z")
    , @NamedQuery(name = "MapRegions.findByXMin", query = "SELECT m FROM MapRegions m WHERE m.xMin = :xMin")
    , @NamedQuery(name = "MapRegions.findByXMax", query = "SELECT m FROM MapRegions m WHERE m.xMax = :xMax")
    , @NamedQuery(name = "MapRegions.findByYMin", query = "SELECT m FROM MapRegions m WHERE m.yMin = :yMin")
    , @NamedQuery(name = "MapRegions.findByYMax", query = "SELECT m FROM MapRegions m WHERE m.yMax = :yMax")
    , @NamedQuery(name = "MapRegions.findByZMin", query = "SELECT m FROM MapRegions m WHERE m.zMin = :zMin")
    , @NamedQuery(name = "MapRegions.findByZMax", query = "SELECT m FROM MapRegions m WHERE m.zMax = :zMax")
    , @NamedQuery(name = "MapRegions.findByFactionID", query = "SELECT m FROM MapRegions m WHERE m.factionID = :factionID")
    , @NamedQuery(name = "MapRegions.findByRadius", query = "SELECT m FROM MapRegions m WHERE m.radius = :radius")})
public class MapRegions implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "regionID")
    private Integer regionID;
    @Column(name = "regionName")
    private String regionName;
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
    @Column(name = "factionID")
    private Integer factionID;
    @Column(name = "radius")
    private Float radius;

    public MapRegions() {
    }

    public MapRegions(Integer regionID) {
        this.regionID = regionID;
    }

    public Integer getRegionID() {
        return regionID;
    }

    public void setRegionID(Integer regionID) {
        this.regionID = regionID;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
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

    public Integer getFactionID() {
        return factionID;
    }

    public void setFactionID(Integer factionID) {
        this.factionID = factionID;
    }

    public Float getRadius() {
        return radius;
    }

    public void setRadius(Float radius) {
        this.radius = radius;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regionID != null ? regionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MapRegions)) {
            return false;
        }
        MapRegions other = (MapRegions) object;
        if ((this.regionID == null && other.regionID != null) || (this.regionID != null && !this.regionID.equals(other.regionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.MapRegions[ regionID=" + regionID + " ]";
    }
    
}
