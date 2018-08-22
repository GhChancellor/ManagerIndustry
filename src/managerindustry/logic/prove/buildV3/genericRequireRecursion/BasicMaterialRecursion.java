/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3.genericRequireRecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.recursion.ItemRecursionA;
import managerindustry.logic.prove.buildV3.RequiredMaterialRecusion;

/**
 *
 * @author lele
 */
public class BasicMaterialRecursion < T >{  
    private List < T > templates = new ArrayList<>();
    private Map < T, T > templatem = new HashMap<>();

    public BasicMaterialRecursion() {
    }

    /**
     * Basic Material Recursion
     * @param RequiredMaterialRecusion materialRecusion
     * @param Choose choose
     */    
    public BasicMaterialRecursion(
        RequiredMaterialRecusion materialRecusion, GenericRequiredItem.ChooseEnum choose) {

        switch(choose){
            case Display:                
                displayBasicMaterialRecursion(materialRecusion, "" );
                break;
            case List:
                if ( !materialRecusion.getItemRecursionAs().isEmpty() ) 
                    pharseBasicMaterialToList(materialRecusion);
                break;
            case Map:
                if ( !materialRecusion.getItemRecursionAs().isEmpty() )                
                    pharseBasicMaterialToMap(materialRecusion);
                break;
        }           
    }
    
    /**
     * Display Material recursion
     * @param RequiredMaterialRecusion requiredItemA
     * @param String tab 
     */
    private void displayBasicMaterialRecursion(RequiredMaterialRecusion requiredItemA, String tab){
        if ( requiredItemA.getTypeID() != 0 ){
            System.out.println(tab + requiredItemA.getTypeID() + " " + 
            requiredItemA.getTypeName()+ " " + requiredItemA.getQuantity());              
        }

        tab += " ";        
        
        for (ItemRecursionA object : requiredItemA.getItemRecursionAs()) {
            displayBasicMaterialRecursion(
                (RequiredMaterialRecusion) object.getRecursionA02(), tab);
        }         
    }        
    
//    /**
//     * Pharse Basic Material To List
//     * @param RequiredMaterialRecusion materialRecusion 
//     */
//    private void pharseBasicMaterialToList(T materialRecusion){
//        if (materialRecusion != null){
//            templates.add( materialRecusion );
//        }
//    }
    
    /**
     * Pharse Basic Material To List
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void pharseBasicMaterialToList(RequiredMaterialRecusion materialRecusion){
        if (materialRecusion != null){
            templates.add((T) (RequiredMaterialRecusion) materialRecusion);
        }
    }
    
    /**
     * Pharse Basic Material To Map
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void pharseBasicMaterialToMap(RequiredMaterialRecusion materialRecusion){
        templatem.put((T) materialRecusion.getTypeName(), (T) materialRecusion);
    }

    /**
     * Get Templates
     * @return List<T>
     */    
    protected List<T> getTemplates() {
        return templates;
    }

    /**
     * Get Templatem()
     * @return Map<T, T>
     */    
    protected Map<T, T> getTemplatem() {
        return templatem;
    }
    
    
}
