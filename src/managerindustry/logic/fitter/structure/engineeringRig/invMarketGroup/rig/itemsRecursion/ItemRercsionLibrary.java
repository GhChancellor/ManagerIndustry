/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class ItemRercsionLibrary {
    
    public enum Converter{List,Map};

    private List<Integer> recursionAs = new ArrayList<>();
    private Map <Integer, Integer> recursionAMap = new HashMap<>();
    
            
    /**
     * Display itemRecursion with tree
     * @param recursionA
     * @param tab 
     */
    public void display(ItemRecursionA recursionA, String tab){
        System.out.println(tab + recursionA.getMarketGroupName() + " " + recursionA.getMarketGroupID() + " " + recursionA.getParentGroupID());
        tab +="  ";

        if ( recursionA.getRecursionB02s().isEmpty() ){
            List<InvTypes> parentGroupID = Manager.getInstance().db().item().invTypes().getMarketGroupID(recursionA.getMarketGroupID(), true);            
            
            for (InvTypes invTypes : parentGroupID) {
                System.out.println(tab + invTypes.getTypeName()+ " " + invTypes.getTypeID() );
            }            
        }
        
        for (ItemRecursionB object : recursionA.getRecursionB02s()) {
            display(object.getRecursionA02(), tab);
        }        
    }
    
    /**
     * Get Conversion To List
     * @param ItemRecursionA recursionA
     * @return List<Integer>
     */
    public List<Integer> getConversionToList(ItemRecursionA recursionA){
        converter(recursionA, Converter.List);
        return recursionAs;
    }

    /**
     * Get Conversion To Map
     * @param recursionA
     * @return Map<Integer, Integer> 
     */
    public Map<Integer, Integer> getConversionToMap(ItemRecursionA recursionA){
        converter(recursionA, Converter.Map);
        return recursionAMap;        
    }
    
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
    
}
/*
        Map< String, User > userMap = 
         users.stream().collect(Collectors.toMap(User::getName, User -> User));
        
        userMap.forEach((k, v) -> System.out.println( k + " " + v.getName() + " " + v.getSurname()));
*/   