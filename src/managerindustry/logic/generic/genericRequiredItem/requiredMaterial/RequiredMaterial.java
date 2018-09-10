/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem.requiredMaterial;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.genericRequiredItem.AGenericRequiredItem;
import managerindustry.logic.generic.fatherClass.NameBase;

/**
 *
 * @author lele
 */
public class RequiredMaterial < A, B > extends AGenericRequiredItem{
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
        if ( requiredItemA.getTypeID() != 0 ){
            System.out.println(tab + requiredItemA.getTypeID() + " " + 
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
     * @return Map < A, B >
     */
    public Map < A, B > getMap(){
        addListElement(requiredMaterial);
        return super.getMap();
    }
    
    /**
     * @deprecated 
     * Get List
     * @return List < A >
     */
    public List < A > getList(){
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

    /**
     * Convert to list
     * @param List requiredMaterials 
     */
    @Override
    public void convertToList(List requiredMaterials) {        
        for (NameBase requiredMaterial : (List <NameBase>) requiredMaterials ) {
            if ( requiredMaterial.getTypeID() != 0){
                addListElement(requiredMaterial);
            }
            
            if ( !requiredMaterial.getItemRecursions().isEmpty() ){
                convertToList(requiredMaterial.getItemRecursions());
            }
        }        
    }
}
