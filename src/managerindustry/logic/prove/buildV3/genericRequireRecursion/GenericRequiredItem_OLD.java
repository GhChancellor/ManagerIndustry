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
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigMarketGroup;
import managerindustry.logic.generic.recursion.ItemRecursionA;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.buildV3.RequiredMaterialRecusion;

/**
 * @deprecated da dividere in singole classi rigMarketGroupRecursion e RequiredMaterialRecusion
 * @author lele
 */
public abstract class GenericRequiredItem_OLD  < T >{
    private enum ChooseEnum{List, Map, Display};
    
    private List < T > templates = new ArrayList<>();
    private Map < T, T > templatem = new HashMap<>();
    
    protected abstract void requiredItem(T t);
    protected abstract void requiredItem(T t1, T t2);
    protected abstract void requiredItem(T t1, T t2, T t3);
    protected abstract T requiredItemMoreInfo(T t1);
    protected abstract T requiredItemMoreInfo(T t1, T t2);
    protected abstract T getObject();
    
    public GenericRequiredItem_OLD() {
    }
    
    /**
     * Get Conversion To List
     * @param T t
     * @return List<T>
     */
    protected List<T> getConversionToList(T t) {
        choose(t, ChooseEnum.List);
        return templates;
    }

    /**
     * Get Conversion To Map
     * @param T t
     * @return Map<T, T>
     */
    protected Map<T, T> getConversionToMap(T t) {
        choose(t, ChooseEnum.Map);
        return templatem;
    } 
    
    /**
     * Show all value T is a recursion
     * @param t 
     */
    protected void display(T t){
        choose(t, ChooseEnum.Display);
    }     
    
    /**
     * ChooseEnum if RequiredMaterialRecusion/rigMarketGroupRecursion/list/map
     * @param t
     * @param choose 
     */
    private void choose(T t, ChooseEnum choose){
        if ( t instanceof RequiredMaterialRecusion){
            basicMaterialRecursion((RequiredMaterialRecusion) t, choose);
            return;            
        }        
        
        if ( t instanceof RigMarketGroup){
            rigMarketGroupRecursion((RigMarketGroup) t, choose);
            return;
        }
    } 

    /**
     * Basic Material Recursion
     * @param RequiredMaterialRecusion materialRecusion
     * @param Choose choose
     */
    private void basicMaterialRecursion
        (RequiredMaterialRecusion materialRecusion, ChooseEnum choose ){

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
    
    //----------------------------------------------
    
    /**
     * Check if map, list, display
     * @param rigMarketGroupRecursion
     * @param choose
     */
    private void rigMarketGroupRecursion(
        RigMarketGroup rigMarketGroupRecursion, ChooseEnum choose){  
        
        switch(choose){
            case Display:                
                displayRigMarketGroupRecursion(rigMarketGroupRecursion, "" );
                break;
            case List:
                if ( !rigMarketGroupRecursion.getItemRecursionAs().isEmpty() )
                    pharseRigRecursionToList(rigMarketGroupRecursion);
                break;
            case Map:
                if ( !rigMarketGroupRecursion.getItemRecursionAs().isEmpty() )
                    pharseRigRecursionToMap(rigMarketGroupRecursion);
                break;
        }
    }    
    
    /**
     * Display Rig Market Group Recursion
     * @param RigMarketGroupRecursion rigMarketGroupRecursion rigMarketGroupRecursion
     * @param String tab 
     */
    private void displayRigMarketGroupRecursion(
        RigMarketGroup rigMarketGroupRecursion, String tab){
        
        if (rigMarketGroupRecursion.getMarketGroupID() != 0 )
            System.out.println(tab + 
                rigMarketGroupRecursion.getMarketGroupName() + " " + 
                rigMarketGroupRecursion.getMarketGroupID() + " " + 
                rigMarketGroupRecursion.getParentGroupID() );

        if ( rigMarketGroupRecursion.getItemRecursionAs().isEmpty() ){
            List<InvTypes> parentGroupID = Manager.getInstance().db().item().
                invTypes().getMarketGroupID(rigMarketGroupRecursion.getMarketGroupID(), true);            
            
            for (InvTypes invTypes : parentGroupID) {
                System.out.println(tab + " - "+ invTypes.getTypeName()+ " " + invTypes.getTypeID() );
            }            
        }

        tab += " " ;
        System.out.println("----------");         
        
        for (ItemRecursionA object : rigMarketGroupRecursion.getItemRecursionAs()) {
            displayRigMarketGroupRecursion((RigMarketGroup) object.getRecursionA02(), tab);
        }         
    }
    
    /**
     * Pharse Rig Recursion To List
     * @param RigMarketGroupRecursion rigMarketGroupRecursion 
     */
    private void pharseRigRecursionToList
        (RigMarketGroup rigMarketGroupRecursion){
        if (rigMarketGroupRecursion != null){
            templates.add((T) (RigMarketGroup) rigMarketGroupRecursion);
        }        
    }

    private void pharseRigRecursionToMap(RigMarketGroup rigMarketGroupRecursion){
        throw new UnsupportedOperationException("Not implemented"); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Get InvTypes By Name
     * @param String bpoName
     * @return InvTypes
     */
    protected InvTypes getInvTypesByName(String bpoName) {
        return Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName);
    }
    
    /**
     * Get InvTypes By Id
     * @param int typeId
     * @return InvTypes
     */
    protected InvTypes getInvTypesById(int typeId) {    
        return Manager.getInstance().db().item().invTypes().getInvTypesById(typeId);
    }    
}
