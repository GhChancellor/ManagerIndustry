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
    public enum Converter{List,Map};
    
    private List < T > templates = new ArrayList<>();
    private Map < T, T > templatem = new HashMap<>();
    
    protected abstract void requiredItem(T t);
    protected abstract void requiredItem(T t1, T t2);
    protected abstract void requiredItem(T t1, T t2, T t3);
    protected abstract void display(T t1, T t2);
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
    public List<T> getConversionToList(T t) {
        converter(t, Converter.List);
        return templates;
    }

    /**
     * Get Conversion To Map
     * @param T t
     * @return Map<T, T>
     */
    public Map<T, T> getConversionToMap (T t) {
        converter(t, Converter.Map);
        return templatem;
    }
    
    private void converter(T t, Converter converter){
        if ( t instanceof RigMarketGroupRecursion){
            rigMarketGroupRecursion( (RigMarketGroupRecursion) t, converter);
            return;
        }
        
        if ( t instanceof RequiredMaterialRecusion){
            basicMaterialRecursion( (RequiredMaterialRecusion) t, converter);
            return;            
        }
    }    
    
    /**
     * @deprecated unificare rigMarketGroupRecursion con basicMaterialRecursion
     * @param materialRecusion_
     * @param converter 
     */
    private void basicMaterialRecursion
        (RequiredMaterialRecusion materialRecusion_, Converter converter ){
        
        if ( !materialRecusion_.getRecursionB02s().isEmpty()){
            List<ItemRecursionB> recursionB02s = materialRecusion_.getRecursionB02s();
            
            for (ItemRecursionB recursionB02 : recursionB02s) {
                RequiredMaterialRecusion materialRecusion = 
                    (RequiredMaterialRecusion) recursionB02.getRecursionA02();
                
                if ( materialRecusion != null ){
                    if (converter == Converter.List){
                        List<RequiredMaterialRecusion> list = 
                            ( List < RequiredMaterialRecusion > ) templates;     
                        
                        list.add( (RequiredMaterialRecusion) materialRecusion );                         
                    }else{
                        Map< Integer, RequiredMaterialRecusion> map = 
                            (Map < Integer, RequiredMaterialRecusion >) templatem;
                        
                        map.put(materialRecusion.getTypeID(), 
                            (RequiredMaterialRecusion) materialRecusion);
                    }    
                }
                
                if (!materialRecusion.getRecursionB02s().isEmpty()){
                    basicMaterialRecursion( 
                        (RequiredMaterialRecusion) recursionB02.getRecursionA02(), 
                        converter);
                }
            }            
        }        
    }
    
    /**
     * @deprecated unificare rigMarketGroupRecursion con basicMaterialRecursion
     * Add to map or to list
     * @param rigMarketGroupRecursion_ rigMarketGroupRecursion
     * @param Converter converter 
     */
    private void rigMarketGroupRecursion(
        RigMarketGroupRecursion rigMarketGroupRecursion_, Converter converter){

        if ( !rigMarketGroupRecursion_.getRecursionB02s().isEmpty()){

            List<ItemRecursionB> recursionB02s = rigMarketGroupRecursion_.getRecursionB02s(); 
            for (ItemRecursionB recursionB02 : recursionB02s) {
                RigMarketGroupRecursion rigMarketGroupRecursion = 
                    (RigMarketGroupRecursion) recursionB02.getRecursionA02();
                
                if (rigMarketGroupRecursion != null){
                    if (converter == Converter.List){
                        List<Short> list = ( List < Short > ) templates;                    
                        list.add( (short) rigMarketGroupRecursion.getMarketGroupID() ); 
                        
                    }else{
                        Map< Short, Short> map = (Map < Short, Short >) templatem;
                        map.put( (short) rigMarketGroupRecursion.getMarketGroupID(), 
                            (short) rigMarketGroupRecursion.getMarketGroupID() );
                    }    
                }
                
                if ( !rigMarketGroupRecursion.getRecursionB02s().isEmpty() ){
                    rigMarketGroupRecursion(
                        (RigMarketGroupRecursion) rigMarketGroupRecursion, 
                        converter);
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
