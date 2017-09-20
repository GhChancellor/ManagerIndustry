/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.buiild;

import managerindustry.logic.buiild.fatherclass.NameBase;

/**
 *
 * @author lele
 */
public class TotalCalculatedComponentX extends NameBase{

    /** 
     * Put Total Calculated Components
     * @param String name
     * @param float quantity 
     */
    public TotalCalculatedComponentX(String name, double quantity) {
        super.setName(name);
        super.setQuanityDbl(quantity);
    }
    
}
