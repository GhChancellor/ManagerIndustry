/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.old.father;

import managerindustry.logic.generic.fatherClass.*;
import managerindustry.logic.generic.fatherClass.recursion.ItemRecursion;

/**
 *
 * @author lele
 */
public class NameBase extends ItemRecursion {
    private int typeID;
    private String typeName;
    private int quanityI;
    private double quanityD;

    /**
     * Name Base
     * @param int typeID
     * @param String typeName 
     */
    public NameBase(int typeID, String typeName) {
        this.typeID = typeID;
        this.typeName = typeName;
    }

    /**
     * Name Base
     * @param int typeID
     * @param int quanityI 
     */
    public NameBase(int typeID, int quanityInt) {
        this.typeID = typeID;
        this.quanityI = quanityInt;
    }

    /**
     * Name Base
     * @param int typeID
     * @param String typeName
     * @param int quanityI 
     */
    public NameBase(int typeID, String name, int quanityInt) {
        this.typeID = typeID;
        this.typeName = name;
        this.quanityI = quanityInt;
    }

    /**
     * Name Base
     * @param int typeID
     * @param int quanityI
     * @param double quanityD 
     */
    public NameBase(int typeID, int quanityI, double quanityD) {
        this.typeID = typeID;
        this.quanityI = quanityI;
        this.quanityD = quanityD;
    }
    
    /**
     * Name Base
     * @param int typeID
     * @param String typeName
     * @param int quanityI
     * @param double quanityD 
     */
    public NameBase(int typeID, String name, int quanityInt, double quanityDbl) {
        this.typeID = typeID;
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
    public int getTypeID() {
        return typeID;
    }

    /**
     * Set Id
     * @param typeID 
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
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
