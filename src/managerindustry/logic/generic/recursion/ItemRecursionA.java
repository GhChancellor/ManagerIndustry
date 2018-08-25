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
public class ItemRecursionA {
    private List < ItemRecursionA > itemRecursionAs = new ArrayList<>();
    private ItemRecursionA recursionA02;

    public ItemRecursionA(ItemRecursionA recursionA02) {
        this.recursionA02 = recursionA02;
    }

    public ItemRecursionA() {
    }

    public List<ItemRecursionA> getItemRecursionAs() {
        return itemRecursionAs;
    }

    public void setItemRecursionAs(List<ItemRecursionA> itemRecursionAs) {
        this.itemRecursionAs = itemRecursionAs;
    }

    
    public void addItemRecursionAs(ItemRecursionA itemRecursionA) {
        this.itemRecursionAs.add(itemRecursionA);
    }
    
    public ItemRecursionA getRecursionA02() {
        return recursionA02;
    }
    
}
