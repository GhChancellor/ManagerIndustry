/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.buildItemRecursion.build02;

import managerindustry.logic.prove.ricorsione.skill.skillProduction.qualcosa.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class TemplateRecursionA02 < T >{
    private List<T> lists = new ArrayList<>();
    private T t;

    public TemplateRecursionA02() {
    }
    
    public TemplateRecursionA02(T t) {
        this.t = t;
    }
    
    public List<T> getLists() {
        return lists;
    }

    public void setLists(List<T> lists) {
        this.lists = lists;
    }

    public void addLists(T t) {
        this.lists.add(t);
    }

    public T getT() {
        return t;
    }
 
    
}