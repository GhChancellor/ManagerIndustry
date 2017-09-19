/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.buiild;

import managerindustry.logic.buiild.fatherclass.NameBase;
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

    public ComponentX(int typeID, String typeName, int amount ) {
        super.setName(typeName);
        super.setQuanityInt(amount);
        super.setId(typeID);
    }

    public ComponentX() {
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
