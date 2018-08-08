/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3;

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

    public int getTypeID() {
        return typeID;
    }

    public String getTypeName() {
        return typeName;
    }

    /**
     * Get Quantity
     * @return int
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Get Quanity Dbl
     * @return double
     */
    public double getQuanityDbl() {
        return quanityDbl;
    }
    
    
}
