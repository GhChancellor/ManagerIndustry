/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.nameBase;

import managerindustry.logic.generic.recursion.ItemRecursionA;

/**
 *
 * @author lele
 */
public class NameBase extends ItemRecursionA {
    private int typeId;
    private String typeName;
    private int quanityI;
    private double quanityD;

    /**
     * Name Base
     * @param int typeId
     * @param String typeName 
     */
    public NameBase(int typeId, String typeName) {
        this.typeId = typeId;
        this.typeName = typeName;
    }

    /**
     * Name Base
     * @param int typeId
     * @param int quanityI 
     */
    public NameBase(int typeId, int quanityInt) {
        this.typeId = typeId;
        this.quanityI = quanityInt;
    }

    /**
     * Name Base
     * @param int typeId
     * @param String typeName
     * @param int quanityI 
     */
    public NameBase(int typeId, String name, int quanityInt) {
        this.typeId = typeId;
        this.typeName = name;
        this.quanityI = quanityInt;
    }

    /**
     * Name Base
     * @param int typeId
     * @param String typeName
     * @param int quanityI
     * @param double quanityD 
     */
    public NameBase(int typeId, String name, int quanityInt, double quanityDbl) {
        this.typeId = typeId;
        this.typeName = name;
        this.quanityI = quanityInt;
        this.quanityD = quanityDbl;
    }
    
    public NameBase() {
    }
 
    /**
     * Get Id
     * @return int
     */
    public int getTypeId() {
        return typeId;
    }

    /**
     * Set Id
     * @param typeId 
     */
    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }
    
    /**
     * Get Name
     * @return String typeName
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Set Name
     * @param String typeName 
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    /**
     * Get Quanity
     * @return int quanityI
     */
    public int getQuanityI() {
        return quanityI;
    }

    /**
     * Set Quanity
     * @param quanityI 
     */
    public void setQuanityI(int quanityI) {
        this.quanityI = quanityI;
    }

    /**
     * Get Quanity Float
     * @return double
     */
    public double getQuanityD() {
        return quanityD;
    }

    /**
     * Set Quanity Float
     * @param Float quanityD 
     */
    public void setQuanityD(double quanityD) {
        this.quanityD = quanityD;
    }    
}
