/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.market.price.marketParameter.createQuery.parameters;

import java.util.List;
import managerindustry.logic.prove.market.price.marketParameter.createQuery.CreateQuery;

/**
 *
 * @author lele
 */
public class TypeID extends CreateQuery{
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
