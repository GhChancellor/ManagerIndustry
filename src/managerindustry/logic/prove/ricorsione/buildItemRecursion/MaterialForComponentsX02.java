/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.buildItemRecursion;

import managerindustry.logic.build.fatherclass.NameBase;

/**
 * Attribute Material For Components
 * @author lele
 */
public class MaterialForComponentsX02 extends NameBase {
    public MaterialForComponentsX02(int typeID, String typeName, int amount) {
        super.setId(typeID);
        super.setName(typeName);
        super.setQuanityInt(amount);
    }    
}
