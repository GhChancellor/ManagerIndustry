/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.fatherClass;

import managerindustry.logic.generic.fatherClass.recursion.ItemRecursion;

/**
 *
 * @author lele
 */
public class NameBase extends ItemRecursion < NameBase > {
    private int typeID;
    private String typeName;
    protected int baseQuantity;
    protected int singleItemQuantity;
    protected long totalItemsQuantity;

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
     * @param int baseQuantity 
     */
    public NameBase(int typeID, int baseQuantity) {
        this.typeID = typeID;
        this.baseQuantity = baseQuantity;
    }

    /**
     * Name Base
     * @param int typeID
     * @param String typeName
     * @param int baseQuantity 
     */
    public NameBase(int typeID, String name, int baseQuantity) {
        this.typeID = typeID;
        this.typeName = name;
        this.baseQuantity = baseQuantity;
    }

    /**
     * Name Base
     * @param int typeID
     * @param int baseQuantity
     * @param int singleItemQuantity 
     */
    public NameBase(int typeID, int quanityI, int singleItemQuantity) {
        this.typeID = typeID;
        this.baseQuantity = quanityI;
        this.singleItemQuantity = singleItemQuantity;
    }
    
    /**
     * Name Base
     * @param int typeID
     * @param String typeName
     * @param int baseQuantity
     * @param int singleItemQuantity 
     */
    public NameBase(int typeID, String name, int quanityInt, int singleItemQuantity) {
        this.typeID = typeID;
        this.typeName = name;
        this.baseQuantity = quanityInt;
        this.singleItemQuantity = singleItemQuantity;
    }

        /**
     * Name Base
     * @param int typeID
     * @param String typeName
     * @param int baseQuantity
     * @param int singleItemQuantity 
     * @param long totalItemsQuantity
     */
    public NameBase(int typeID, String typeName, int baseQuantity, int singleItemQuantity, long totalItemsQuantity) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.baseQuantity = baseQuantity;
        this.singleItemQuantity = singleItemQuantity;
        this.totalItemsQuantity = totalItemsQuantity;
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
     * @return int baseQuantity
     */
    public int getBaseQuantity() {
        return baseQuantity;
    }

    /**
     * Set Quanity
     * @param baseQuantity 
     */
    public void setBaseQuantity(int baseQuantity) {
        this.baseQuantity = baseQuantity;
    }

    /**
     * Get Quanity 
     * @return int
     */
    public int getSingleItemQuantity() {
        return singleItemQuantity;
    }

    /**
     * Set Quanity 
     * @param Float singleItemQuantity 
     */
    public void setSingleItemQuantity(int singleItemQuantity) {
        this.singleItemQuantity = singleItemQuantity;
    }    

    /**
     * Get Total Items Quantity
     * @return long
     */
    public long getTotalItemsQuantity() {
        return totalItemsQuantity;
    }

    /**
     * Set Total Items Quantity
     * @param long totalItemsQuantity 
     */
    public void setTotalItemsQuantity(long totalItemsQuantity) {
        this.totalItemsQuantity = totalItemsQuantity;
    }
    
}
