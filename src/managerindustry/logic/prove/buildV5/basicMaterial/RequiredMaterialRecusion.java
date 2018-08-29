/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV5.basicMaterial;

import managerindustry.logic.generic.recursion.ItemRecursionA;


/**
 * @deprecated 
 * estendila a BaseName
 * @author lele
 */
public class RequiredMaterialRecusion extends ItemRecursionA {
    private int typeID;  
    private String typeName;
    private int quantity;
    private double quanityDbl;

    /** Init value
     * @param int typeID
     * @param String typeName
     * @param int quantity 
     * @param int quanityDbl 
     */      
    public RequiredMaterialRecusion(int typeID, String typeName, int quantity, double quanityDbl) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.quantity = quantity;
        this.quanityDbl = quanityDbl;
    }

    /** Init value
     * @param int typeID
     * @param String typeName
     * @param int quantity 
     * @param int quanityDbl 
     */      
    public RequiredMaterialRecusion(int typeID, String typeName, int quantity) {
        this.typeID = typeID;
        this.typeName = typeName;
        this.quantity = quantity;
    }

    /**
     * Init value
     * @param int typeID
     * @param int quantity 
     */
    public RequiredMaterialRecusion(int typeID, int quantity) {
        this.typeID = typeID;
        this.quantity = quantity;
    }
   
    public RequiredMaterialRecusion() {
    }

    /**
     * Get Type ID
     * @return int
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Set Type ID
     * @param int typeID 
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
    
    /**
     * Get Quanity Dbl
     * @return double
     */
    public double getQuanityDbl() {
        return quanityDbl;
    }

    /**
     * Get Type Name
     * @return String
     */
    public String getTypeName() {
        return typeName;
    }    
    
    /**
     * Set Type Name
     * @param String typeName 
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
   
    /**
     * Get Quantity
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }    
    
    /**
     * Set Quantity
     * @param int quantity 
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Set Quanity Dbl
     * @param double quanityDbl 
     */
    public void setQuanityDbl(double quanityDbl) {
        this.quanityDbl = quanityDbl;
    }

}
