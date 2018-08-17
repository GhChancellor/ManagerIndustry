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
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.buildV3.RequiredMaterialRecusion;

/**
 * @deprecated da dividere in singole classi rigMarketGroupRecursion e RequiredMaterialRecusion
 * @author lele
 */
public abstract class GenericRequiredItem  < T >{
    protected enum ChooseEnum{List, Map, Display};
    
    private BasicMaterialRecursion basicMaterialRecursion;
    private RigMarketGroupRecursion rigMarketGroupRecursion;
    
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
        
        if (t instanceof RequiredMaterialRecusion){
            return basicMaterialRecursion.getTemplates();
        }
        
        if (t instanceof RigMarketGroup){
            return rigMarketGroupRecursion.getTemplates();
        }
        return null;
    }

    /**
     * Get Conversion To Map
     * @param T t
     * @return Map<T, T>
     */
    protected Map<T, T> getConversionToMap(T t) {
        choose(t, ChooseEnum.Map);
        
        if (t instanceof RequiredMaterialRecusion){
            return basicMaterialRecursion.getTemplatem();
        }
        
        if (t instanceof RigMarketGroup){
            return rigMarketGroupRecursion.getTemplatem();
        }
        
        return null;
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
            basicMaterialRecursion = 
                new BasicMaterialRecursion((RequiredMaterialRecusion) t , choose);
            return;            
        }        
        
        if ( t instanceof RigMarketGroup){
            rigMarketGroupRecursion = new RigMarketGroupRecursion((RigMarketGroup) t, choose);
            return;
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
