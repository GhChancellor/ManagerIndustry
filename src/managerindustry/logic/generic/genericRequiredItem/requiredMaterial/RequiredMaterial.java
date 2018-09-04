/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem.requiredMaterial;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.genericRequiredItem.AGenericRequiredItem;
import managerindustry.logic.generic.nameBase.NameBase;

/**
 *
 * @author lele
 */
public class RequiredMaterial extends AGenericRequiredItem{
    protected NameBase requiredMaterial = new NameBase();

    public RequiredMaterial() {
    }
    
    /**
     * Display
     */
    @Override
    public void display() {
        displayRequiredMaterial(requiredMaterial, "");
    }   
    
    /**
     * Display Material recursion
     * @param RequiredMaterialRecusion requiredItemA
     * @param String tab 
     */
    private void displayRequiredMaterial(NameBase requiredItemA, String tab){
        if ( requiredItemA.getTypeId() != 0 ){
            System.out.println(tab + requiredItemA.getTypeId() + " " + 
            requiredItemA.getTypeName() + " - " + 
            requiredItemA.getQuanityI() + " > " + 
            requiredItemA.getQuanityD());              
        }

        tab += " ";                        
        
        for (Object materialRecusion : requiredItemA.getItemRecursions()) {
            displayRequiredMaterial((NameBase) materialRecusion, tab);
        } 
    }
    
    /**
     * Get Map
     * @return Map < String, NameBase >
     */
    public Map < String, NameBase > getMap(){
        addListElement(requiredMaterial);
        return super.getMap();
    }
    
    /**
     * Get List
     * @return List < NameBase >
     */
    public List < NameBase > getList(){
        convertToList(requiredMaterial.getItemRecursions());
        return super.getList();
    }
    
    /**
     * Get Object
     * @return Object
     */
    @Override
    public Object getObject() {
        return requiredMaterial;
    }  

    @Override
    public void convertToList(List requiredMaterials) {        
        for (NameBase requiredMaterial_ : (List <NameBase>) requiredMaterials ) {
            if ( requiredMaterial_.getTypeId() != 0){
                addListElement(requiredMaterial_);
            }
            
            if ( !requiredMaterial_.getItemRecursions().isEmpty() ){
                convertToList(requiredMaterial_.getItemRecursions());
            }
        }        
    }
}
