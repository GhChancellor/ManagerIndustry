/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.buildItemRecursion;

import managerindustry.logic.buiild.*;
import managerindustry.logic.buiild.fatherclass.NameBase;
import java.util.ArrayList;
import java.util.List;

/**
 * Attribute of ComponentX and Advanced Moon Material
 * @author lele
 */
public class ComponentX02 extends NameBase{
    /**
     * @param int typeID
     * @param String typeName
     * @param int amount 
     */
    public ComponentX02(int typeID, String typeName, int amount ) {
        super.setName(typeName);
        super.setQuanityInt(amount);
        super.setId(typeID);
    }

    public ComponentX02() {
    }
    
    public void setName(String typeName){
        super.setName(typeName);
    }
    
    public void setQuanityInt(int amount){
        super.setQuanityInt(amount);
    }

    public void setId(int typeID){
        super.setId(typeID);
    }
    
    
}
