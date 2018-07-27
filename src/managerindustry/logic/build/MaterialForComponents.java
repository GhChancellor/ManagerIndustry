/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build;

import managerindustry.logic.build.fatherclass.NameBase;

/**
 * Attribute Material For Components
 * @author lele
 */
public class MaterialForComponents extends NameBase {
    private ComponentX componentX; 

    public MaterialForComponents() {
    }

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
        super.setTypeId(typeID);
        super.setName(typeName);
        super.setQuanityInt(amount);
    }    
    
}
