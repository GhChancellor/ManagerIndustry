/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lele
 */
public class ItemRecursion < T > {
    private List < T > recursionTs = new ArrayList<>();
    private T t;

    public ItemRecursion() {
    }    
    
    /**
     * Item Recursion
     * @param T t 
     */
    public ItemRecursion(T t) {
        this.t = t;
    }
   
    /**
     * Get Recursion
     * @return T
     */
    public T getRecursion() {
        return t;
    }

    /**
     * Get Item Recursions
     * @return List <T>
     */
    public List<T> getItemRecursions() {
        return recursionTs;
    }

    /**
     * Set Item Recursions
     * @param T t 
     */
    public void setItemRecursions(List<T> t) {
        this.recursionTs = t;
    }
    
    /**
     * Aadd Item Recursions
     * @param t 
     */
    public void addItemRecursions(T t) {
        this.recursionTs.add(t);
    }
    
}
