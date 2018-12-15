/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.old;

import managerindustry.logic.build.production.old.father.NameBase;
import java.util.ArrayList;
import java.util.List;

/**
 * Attribute of ComponentX and Advanced Moon Material
 * @author lele
 */
public class ComponentX extends NameBase{
    private List < MaterialForComponents > materialForComponents = new ArrayList<>();

    /**
     * Get material For Component
     * @return List<AdvancedMoonMaterial>
     */
    public List<MaterialForComponents> getMaterialForComponents() {
        return materialForComponents;
    }

    /**
     * Set material For Component
     * @param List<AdvancedMoonMaterial> materialForComponents 
     */
    public void setMaterialForComponents(List<MaterialForComponents> materialForComponents) {
        this.materialForComponents = materialForComponents;
    }
    
    /**
     * Add Material For Components
     * @param MaterialForComponents materialForComponent 
     */
    public void addMaterialForComponents( MaterialForComponents materialForComponent) {
        this.materialForComponents.add(materialForComponent);
    }   

    /**
     * @param int typeID
     * @param String typeName
     * @param int amount 
     */
    public ComponentX(int typeID, String typeName, int amount ) {
        super.setTypeName(typeName);
        super.setQuanityI(amount);
        super.setTypeID(typeID);
    }

    public ComponentX() {
    }
    
    public void setTypeName(String typeName){
        super.setTypeName(typeName);
    }
    
    public void setQuanityI(int amount){
        super.setQuanityI(amount);
    }

    public void setTypeID(int typeID){
        super.setTypeID(typeID);
    }
}
