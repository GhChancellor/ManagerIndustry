/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build;

import managerindustry.logic.build.fatherclass.NameBase;

/**
 *
 * @author lele
 */
public class CalculatedComponentX extends NameBase {

    public CalculatedComponentX(String name, int partialQuantity, 
            double totalQuantity) {
        super.setName(name);
        super.setQuanityInt(partialQuantity);
        super.setQuanityDbl(totalQuantity);
    }
    
}
