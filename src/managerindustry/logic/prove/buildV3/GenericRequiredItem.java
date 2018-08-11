/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigMarketGroupRecursion;
import managerindustry.logic.generic.recursion.ItemRecursionB;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public abstract class GenericRequiredItem  < T >{
    private enum ChooseEnum{List, Map, Display};
    
    private List < T > templates = new ArrayList<>();
    private Map < T, T > templatem = new HashMap<>();
    
    protected abstract void requiredItem(T t);
    protected abstract void requiredItem(T t1, T t2);
    protected abstract void requiredItem(T t1, T t2, T t3);
    protected abstract T requiredItemMoreInfo(T t1);
    protected abstract T requiredItemMoreInfo(T t1, T t2);
    protected abstract T getObject();
    
    public GenericRequiredItem() {
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
    protected Map<T, T> getConversionToMap (T t) {
        choose(t, ChooseEnum.Map);
        return templatem;
    } 
    
    /**
     * Show all value
     * @param t 
     */
    public void display(T t){
        choose(t, ChooseEnum.Display);
    }    
    
    /**
     * ChooseEnum if RequiredMaterialRecusion/rigMarketGroupRecursion/list/map
     * @param t
     * @param choose 
     */
    private void choose(T t, ChooseEnum choose){
        if ( t instanceof RequiredMaterialRecusion){
            basicMaterialRecursion((RequiredMaterialRecusion) t, choose, (T) "");
            return;            
        }        
        
        if ( t instanceof RigMarketGroupRecursion){
            rigMarketGroupRecursion( (RigMarketGroupRecursion) t, choose, (T) "");
            return;
        }
    }     

    /**
     * @deprecated 
     * ??? perché ha bisogno del cast se passo l'oggetto specifico?
     * @param RequiredMaterialRecusion materialRecusion_
     * @param Choose choose
     * @param t 
     */
    private void basicMaterialRecursion
        (RequiredMaterialRecusion materialRecusion_, ChooseEnum choose, T t ){
        RequiredMaterialRecusion requiredItemA = (RequiredMaterialRecusion) materialRecusion_;
        String tab = (String) t;
        
        switch(choose){
            case Display:                
                displayBasicMaterialRecursion(requiredItemA, tab );
                tab += " " ;
                break;
            case List:
                pharseBasicMaterialToList(materialRecusion_);
                break;
            case Map:
                break;
        }

        for (ItemRecursionB requiredItem : requiredItemA.getRecursionB02s()) {
            basicMaterialRecursion((RequiredMaterialRecusion) requiredItem.getRecursionA02(), choose, (T) tab );
        }
    }
       
    /**
     * Display Material recursion
     * @param RequiredMaterialRecusion requiredItemA
     * @param String tab 
     */
    private void displayBasicMaterialRecursion(RequiredMaterialRecusion requiredItemA, String tab){
        if ( requiredItemA.getTypeID() != 0 )
            System.out.println(tab + requiredItemA.getTypeID() + " " + 
            requiredItemA.getTypeName()+ " " + requiredItemA.getQuantity());        
    }
    
    /**
     * Check if map, list, display
     * @param rigMarketGroupRecursion
     * @param choose
     * @param t 
     */
    private void rigMarketGroupRecursion(
        RigMarketGroupRecursion rigMarketGroupRecursion, ChooseEnum choose, T t){
        
        String tab = (String) t;        
        
        switch(choose){
            case Display:                
                displayRigMarketGroupRecursion(rigMarketGroupRecursion, tab );
                tab += " " ;
                break;
            case List:
                pharseRigRecursionToList(rigMarketGroupRecursion);
                break;
            case Map:
                break;
        }        
        
        for (ItemRecursionB object : rigMarketGroupRecursion.getRecursionB02s()) {
            rigMarketGroupRecursion(
                (RigMarketGroupRecursion) object.getRecursionA02(), choose, (T) tab);
        } 
    }
    
    /**
     * Display Rig Market Group Recursion
     * @param RigMarketGroupRecursion rigMarketGroupRecursion rigMarketGroupRecursion
     * @param String tab 
     */
    private void displayRigMarketGroupRecursion(
        RigMarketGroupRecursion rigMarketGroupRecursion, String tab){
        
        if (rigMarketGroupRecursion.getMarketGroupID() != 0 )
            System.out.println(tab + 
                rigMarketGroupRecursion.getMarketGroupName() + " " + 
                rigMarketGroupRecursion.getMarketGroupID() + " " + 
                rigMarketGroupRecursion.getParentGroupID() );

        if ( rigMarketGroupRecursion.getRecursionB02s().isEmpty() ){
            List<InvTypes> parentGroupID = Manager.getInstance().db().item().
                invTypes().getMarketGroupID(rigMarketGroupRecursion.getMarketGroupID(), true);            
            
            for (InvTypes invTypes : parentGroupID) {
                System.out.println(tab + " - "+ invTypes.getTypeName()+ " " + invTypes.getTypeID() );
            }            
        }

        System.out.println("----------");        
    }
    
    /**
     * Pharse Rig Recursion To List
     * @param RigMarketGroupRecursion rigMarketGroupRecursion 
     */
    private void pharseRigRecursionToList
        (RigMarketGroupRecursion rigMarketGroupRecursion){
        if (rigMarketGroupRecursion != null){
            List<Short> list = ( List < Short > ) templates;                    
            list.add( (short) rigMarketGroupRecursion.getMarketGroupID() ); 
        }        
    }
    
    /**
     * Pharse Basic Material To List
     * @param RequiredMaterialRecusion materialRecusion 
     */
    private void pharseBasicMaterialToList(RequiredMaterialRecusion materialRecusion){
        if (materialRecusion != null){
            List<RequiredMaterialRecusion> list = 
                ( List < RequiredMaterialRecusion > ) templates;     

            list.add( (RequiredMaterialRecusion) materialRecusion );
        }
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
