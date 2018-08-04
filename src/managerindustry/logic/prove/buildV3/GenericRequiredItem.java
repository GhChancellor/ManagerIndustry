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
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.buildV3.recusionRig.safe.RigMarketGroupRecursion;

/**
 *
 * @author lele
 */
public abstract class GenericRequiredItem  < T >{
    public enum Converter{List,Map};
    
    private List < T > ts = new ArrayList<>();
    private Map < T, T > tm = new HashMap<>();
    
    protected abstract void requiredItem(T t);
    protected abstract void requiredItem(T t1, T t2);
    protected abstract void requiredItem(T t1, T t2, T t3);
    protected abstract void display(T t1, T t2);

    public GenericRequiredItem() {
    }

    /**
     * Get Conversion To List
     * @param T t
     * @return List<T>
     */
    public List<T> getConversionToList(T t) {
        converter(t, Converter.List);
        return ts;
    }

    /**
     * Get Conversion To Map
     * @param T t
     * @return Map<T, T>
     */
    public Map<T, T> getConversionToMap (T t) {
        converter(t, Converter.Map);
        return tm;
    }
    
    private void converter(T t, Converter converter){
        if ( t instanceof RigMarketGroupRecursion){
            rigMarketGroupRecursion( (RigMarketGroupRecursion) t, converter);
        }
    }    
    
    /**
     * Add to map or to list
     * @param rigMarketGroupRecursion rigMarketGroupRecursion
     * @param Converter converter 
     */
    private void rigMarketGroupRecursion(
        RigMarketGroupRecursion rigMarketGroupRecursion, Converter converter){
        
        if ( rigMarketGroupRecursion.getRecursionB02s().isEmpty()){
            List<InvTypes> parentGroupID = 
                Manager.getInstance().db().item().invTypes().getMarketGroupID(
                rigMarketGroupRecursion.getMarketGroupID(), true);
            
            for (InvTypes invTypes : parentGroupID) {
                if (converter == Converter.List){
                    List<Integer> list = ( List < Integer > ) ts;                    
                    list.add( invTypes.getTypeID() ); 
                }else{
                    Map<Integer, Integer> map = (Map < Integer, Integer >) tm;
                    map.put(invTypes.getTypeID(), invTypes.getTypeID());
                }                
            }
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
