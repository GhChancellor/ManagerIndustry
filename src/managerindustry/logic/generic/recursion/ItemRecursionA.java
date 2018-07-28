/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class ItemRecursionA {
    private List < ItemRecursionB > recursionB02s = new ArrayList<>();

    public ItemRecursionA() {
    }
    
    public List<ItemRecursionB> getRecursionB02s() {
        return recursionB02s;
    }

    public void setRecursionB02s(List<ItemRecursionB> recursionB02s) {
        this.recursionB02s = recursionB02s;
    }

    public void addRecursionB02(ItemRecursionB recursionB02) {
        this.recursionB02s.add(recursionB02);
    }
    
}
