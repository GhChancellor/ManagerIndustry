/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem;

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
public abstract class AGenericRequiredItem < A, B > implements IGenericRequiredItem {    
    private List < A > list = new ArrayList<>();
    private Map < A, B > map = new HashMap<>();
    
    /**
     * Get InvTypes By Name
     * @param String bpoName
     * @return InvTypes
     */
    public InvTypes getInvTypesByName(String bpoName) {
        return Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName);
    }
    
    /**
     * Get InvTypes By Id
     * @param int typeId
     * @return InvTypes
     */
    public InvTypes getInvTypesById(int typeId) {    
        return Manager.getInstance().db().item().invTypes().getInvTypesById(typeId);
    }    
  
    /**
     * Get List
     * @return List<A>
     */
    public List<A> getList() {
        return list;
    }

    /**
     * Set List
     * @param List<A> list 
     */
    public void setList(List<A> list) {
        this.list = list;
    }

    /**
     * Add List Element
     * @param A 
     */
    public void addListElement(A a){
        list.add(a);
    }
    
    /**
     * Get Map
     * @return Map<A, B>
     */
    public Map<A, B> getMap() {
        return map;
    }

    /**
     * Set Map
     * @param Map<A, B> map 
     */
    public void setMap(Map<A, B> map) {
        this.map = map;
    }

    /**
     * Add Map Element
     * @param A a
     * @param B b 
     */
    public void addMapElement(A a, B b){
        map.put(a, b);
    }
    
  @Override
    public void requiredItem(Object a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requiredItem(Object a1, Object b2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object requiredItemMoreInfo(Object a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }        
}
