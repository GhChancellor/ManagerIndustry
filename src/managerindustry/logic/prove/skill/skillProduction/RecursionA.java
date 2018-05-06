/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.skillProduction;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class RecursionA < T >{
    private List<T> lists = new ArrayList<>();
    private int value;    

    public RecursionA(int value) {
        this.value = value;
    }

    public RecursionA() {
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

    public void setValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
 
}
