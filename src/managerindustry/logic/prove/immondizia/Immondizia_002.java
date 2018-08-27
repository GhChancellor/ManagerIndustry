/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.immondizia;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.prove.buildV3.BasicMaterialRequired;
import managerindustry.logic.prove.buildV3.genericRequireRecursion.GenericRequiredItem;
import managerindustry.logic.prove.buildV3.RequiredMaterialRecusion;

/**
 *
 * @author lele
 */
public class Immondizia_002 {
    
    public Immondizia_002() {
        byte count01 =0;
        for (int i = 0; i < 10; i++) {
            count01 = (byte) ( count01 + 1);
        }
        System.out.println(""+ count01);
    
    }
    
    
}
