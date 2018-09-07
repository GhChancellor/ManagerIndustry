/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.old;

import managerindustry.logic.generic.fatherClass.NameBase;

/**
 *
 * @author lele
 */
public class ReportCalculatedComponentX extends NameBase{

    /** 
     * Put report Calculated ComponentX
     * @param String name
     * @param float quantity 
     */
    public ReportCalculatedComponentX(String name, int singleMaterial, double quantity) {
        super.setTypeName(name);
        super.setQuanityD(quantity);
        super.setQuanityI(singleMaterial);

    }
    
}
