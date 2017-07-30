/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.price.marketParameter.createQuery.parameters;

import managerindustry.logic.price.marketParameter.createQuery.CreateQuery;

/**
 *
 * @author lele
 */
public class TypeID extends CreateQuery<TypeID>{
    private int typeID;

    public TypeID(TypeID query) {
        super(query);
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
