/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.db.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lele
 */
@Entity
@Table(name = "dgmTypeAttributes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DgmTypeAttributes.findAll", query = "SELECT d FROM DgmTypeAttributes d")
    , @NamedQuery(name = "DgmTypeAttributes.findByTypeID", query = "SELECT d FROM DgmTypeAttributes d WHERE d.dgmTypeAttributesPK.typeID = :typeID")
    , @NamedQuery(name = "DgmTypeAttributes.findByAttributeID", query = "SELECT d FROM DgmTypeAttributes d WHERE d.dgmTypeAttributesPK.attributeID = :attributeID")
    , @NamedQuery(name = "DgmTypeAttributes.findByValueInt", query = "SELECT d FROM DgmTypeAttributes d WHERE d.valueInt = :valueInt")
    , @NamedQuery(name = "DgmTypeAttributes.findByValueFloat", query = "SELECT d FROM DgmTypeAttributes d WHERE d.valueFloat = :valueFloat")
       // /get value station like reductionManufacturingMaterial, calibration....
    , @NamedQuery(name = "DgmTypeAttributes.findByValueStation", 
       query = "SELECT a FROM DgmTypeAttributes a, DgmAttributeTypes b, InvTypes c WHERE "
       + "a.dgmTypeAttributesPK.typeID = C.typeID AND "
       + "B.attributeID = A.dgmTypeAttributesPK.attributeID AND "
       + "A.dgmTypeAttributesPK.attributeID = :attributeID AND "
       + "C.typeID = :typeID"), 
    
})
public class DgmTypeAttributes implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DgmTypeAttributesPK dgmTypeAttributesPK;
    @Column(name = "valueInt")
    private Integer valueInt;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valueFloat")
    private Float valueFloat;

    public DgmTypeAttributes() {
    }

    public DgmTypeAttributes(DgmTypeAttributesPK dgmTypeAttributesPK) {
        this.dgmTypeAttributesPK = dgmTypeAttributesPK;
    }

    public DgmTypeAttributes(int typeID, int attributeID) {
        this.dgmTypeAttributesPK = new DgmTypeAttributesPK(typeID, attributeID);
    }

    public DgmTypeAttributesPK getDgmTypeAttributesPK() {
        return dgmTypeAttributesPK;
    }

    public void setDgmTypeAttributesPK(DgmTypeAttributesPK dgmTypeAttributesPK) {
        this.dgmTypeAttributesPK = dgmTypeAttributesPK;
    }

    public Integer getValueInt() {
        return valueInt;
    }

    public void setValueInt(Integer valueInt) {
        this.valueInt = valueInt;
    }

    public Float getValueFloat() {
        return valueFloat;
    }

    public void setValueFloat(Float valueFloat) {
        this.valueFloat = valueFloat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dgmTypeAttributesPK != null ? dgmTypeAttributesPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DgmTypeAttributes)) {
            return false;
        }
        DgmTypeAttributes other = (DgmTypeAttributes) object;
        if ((this.dgmTypeAttributesPK == null && other.dgmTypeAttributesPK != null) || (this.dgmTypeAttributesPK != null && !this.dgmTypeAttributesPK.equals(other.dgmTypeAttributesPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "managerindustry.db.entities.DgmTypeAttributes[ dgmTypeAttributesPK=" + dgmTypeAttributesPK + " ]";
    }
    
}
