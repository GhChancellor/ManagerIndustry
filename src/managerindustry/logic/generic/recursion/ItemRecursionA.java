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
public class ItemRecursionA < T > {
    private List < T > recursionTs = new ArrayList<>();
    private T t;

    public ItemRecursionA() {
    }    
    
    public ItemRecursionA(T t) {
        this.t = t;
    }
   
    public T getRecursionA02() {
        return t;
    }

    public List<T> getItemRecursionAs() {
        return recursionTs;
    }

    public void setItemRecursionAs(List<T> t) {
        this.recursionTs = t;
    }
    
    public void addItemRecursionAs(T t) {
        this.recursionTs.add(t);
    }
    
}
