/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.immondizia;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class New001 <T> {
    private List < Integer > value = new ArrayList<>();
    
    public New001() {
        value.add(1);
        value.add(2);
        value.add(3);
        value.add(4);
        a001((T) value);
    }

    public void a001(T t){
        List < Integer > aa = (List < Integer >) t;
        for (Integer xx : aa) {
            System.out.println(""+ xx);
        }
    }
}

