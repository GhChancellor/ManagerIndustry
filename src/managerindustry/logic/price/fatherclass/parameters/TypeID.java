/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.fatherclass.parameters;

import managerindustry.logic.price.fatherclass.UrlPrice;

/**
 *
 * @author lele
 */
public class TypeID implements UrlPrice{
    private int typeID;

    public TypeID(int typeID) {
        this.typeID = typeID;
    }
    
    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    @Override
    public String getUrl() {
        return "typeid";
    }

    @Override
    public String getUrlValue() {
        return ""+this.typeID;
    }
    
}
