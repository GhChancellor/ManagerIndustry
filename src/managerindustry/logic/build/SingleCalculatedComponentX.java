/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build;

import managerindustry.logic.build.fatherclass.NameBase;

/**
 * Put single Calculated Component
 * @author lele
 */
public class SingleCalculatedComponentX extends NameBase{
    /**
     * Put single Calculated Component
     * @param name
     * @param quantity 
     */
    public SingleCalculatedComponentX(String name, int quantity) {
        super.setName(name);
        super.setQuanityInt(quantity);        
    }
    
}