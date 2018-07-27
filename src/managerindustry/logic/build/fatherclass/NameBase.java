/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.fatherclass;

/**
 *
 * @author lele
 */
public class NameBase {
    private int typeId;
    private String name;
    private int quanityInt;
    private double quanityDbl;

    /**
     * Name Base
     * @param int typeId
     * @param String name 
     */
    public NameBase(int typeId, String name) {
        this.typeId = typeId;
        this.name = name;
    }

    /**
     * Name Base
     * @param int typeId
     * @param int quanityInt 
     */
    public NameBase(int typeId, int quanityInt) {
        this.typeId = typeId;
        this.quanityInt = quanityInt;
    }

    /**
     * Name Base
     * @param int typeId
     * @param String name
     * @param int quanityInt 
     */
    public NameBase(int typeId, String name, int quanityInt) {
        this.typeId = typeId;
        this.name = name;
        this.quanityInt = quanityInt;
    }

    /**
     * Name Base
     * @param int typeId
     * @param String name
     * @param int quanityInt
     * @param double quanityDbl 
     */
    public NameBase(int typeId, String name, int quanityInt, double quanityDbl) {
        this.typeId = typeId;
        this.name = name;
        this.quanityInt = quanityInt;
        this.quanityDbl = quanityDbl;
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
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name
     * @param String name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Quanity
     * @return int quanityInt
     */
    public int getQuanityInt() {
        return quanityInt;
    }

    /**
     * Set Quanity
     * @param quanityInt 
     */
    public void setQuanityInt(int quanityInt) {
        this.quanityInt = quanityInt;
    }

    /**
     * Get Quanity Float
     * @return double
     */
    public double getQuanityDbl() {
        return quanityDbl;
    }

    /**
     * Set Quanity Float
     * @param Float quanityDbl 
     */
    public void setQuanityDbl(double quanityDbl) {
        this.quanityDbl = quanityDbl;
    }    
}
