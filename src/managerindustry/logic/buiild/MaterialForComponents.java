/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.buiild;

import managerindustry.logic.buiild.fatherclass.NameBase;

/**
 * Attribute Material For Components
 * @author lele
 */
public class MaterialForComponents extends NameBase {
    private ComponentX componentX; 

    public MaterialForComponents(ComponentX componentX) {
        this.componentX = componentX;
    }
    
    public ComponentX getComponentX() {
        return componentX;
    }

    public void setComponentX(ComponentX componentX) {
        this.componentX = componentX;
    }
    
    
    //-----------------------------------------------------------------------
    
    
    public MaterialForComponents(int typeID, String typeName, int amount) {
        super.setId(typeID);
        super.setName(typeName);
        super.setQuanity(amount);
    }    
    
}
