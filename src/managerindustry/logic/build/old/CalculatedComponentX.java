/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.old;

import managerindustry.logic.generic.nameBase.NameBase;

/**
 *
 * @author lele
 */
public class CalculatedComponentX extends NameBase {

    public CalculatedComponentX(String name, int partialQuantity, 
            double totalQuantity) {
        super.setTypeName(name);
        super.setQuanityI(partialQuantity);
        super.setQuanityD(totalQuantity);
    }
    
}
