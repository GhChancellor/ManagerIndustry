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
import managerindustry.logic.generic.recursion.ItemRecursionA;
import managerindustry.logic.generic.recursion.ItemRecursionB;
import managerindustry.logic.manager.Manager;

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
     * @param rigMarketGroupRecursion_ rigMarketGroupRecursion
     * @param Converter converter 
     */
    private void rigMarketGroupRecursion(
        RigMarketGroupRecursion rigMarketGroupRecursion_, Converter converter){

        if ( !rigMarketGroupRecursion_.getRecursionB02s().isEmpty()){

            List<ItemRecursionB> recursionB02s = rigMarketGroupRecursion_.getRecursionB02s(); 
            for (ItemRecursionB recursionB02 : recursionB02s) {
                ItemRecursionA recursionA02 = recursionB02.getRecursionA02();
                RigMarketGroupRecursion name = (RigMarketGroupRecursion) recursionA02;
                
                List<InvTypes> parentGroupIDs = 
                    Manager.getInstance().db().item().invTypes().getMarketGroupID(name.getMarketGroupID(), true);
                
                System.out.println("");
            }
            
        }
        
//        if ( !rigMarketGroupRecursion_.getRecursionB02s().isEmpty()){
//            RigMarketGroupRecursion rigMarketGroupRecursion = 
//               (RigMarketGroupRecursion) rigMarketGroupRecursion_.getRecursionB02s();
//            
//            List<InvTypes> parentGroupIDs = 
//                Manager.getInstance().db().item().invTypes().getMarketGroupID(rigMarketGroupRecursion.getMarketGroupID(), true);
//
//            for (InvTypes invTypes : parentGroupIDs) {
//                if (converter == Converter.List){
//                    List<Integer> list = ( List < Integer > ) ts;                    
//                    list.add( invTypes.getTypeID() ); 
//                }else{
//                    Map<Integer, Integer> map = (Map < Integer, Integer >) tm;
//                    map.put(invTypes.getTypeID(), invTypes.getTypeID());
//                }                
//            }                
//        }
//        
//        for (ItemRecursionB recursionB02 : rigMarketGroupRecursion_.getRecursionB02s()) {
//            rigMarketGroupRecursion((RigMarketGroupRecursion) recursionB02.getRecursionA02(), converter);
//        }


// -------

//        if ( !rigMarketGroupRecursion.getRecursionB02s().isEmpty()){
//            List<InvTypes> parentGroupID = 
//                Manager.getInstance().db().item().invTypes().getMarketGroupID(
//                rigMarketGroupRecursion.getMarketGroupID(), true);
//            
//            for (InvTypes invTypes : parentGroupID) {
//                if (converter == Converter.List){
//                    List<Integer> list = ( List < Integer > ) ts;                    
//                    list.add( invTypes.getTypeID() ); 
//                }else{
//                    Map<Integer, Integer> map = (Map < Integer, Integer >) tm;
//                    map.put(invTypes.getTypeID(), invTypes.getTypeID());
//                }                
//            }
//        }
//        System.out.println("");
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
/*
    private void converter(ItemRecursionA recursionA, Converter converter){
        if ( recursionA.getRecursionB02s().isEmpty() ){
            List<InvTypes> parentGroupID = Manager.getInstance().db().item().invTypes().getMarketGroupID(recursionA.getMarketGroupID(), true);
            
            for (InvTypes invTypes : parentGroupID) {
                if (converter == Converter.List){
                    recursionAs.add(invTypes.getTypeID());
                }else{
                    recursionAMap.put(invTypes.getTypeID(), invTypes.getTypeID());
                }
            }            
        }
        
        for (ItemRecursionB object : recursionA.getRecursionB02s()) {
            converter(object.getRecursionA02(), converter);
        }  
    } 
*/