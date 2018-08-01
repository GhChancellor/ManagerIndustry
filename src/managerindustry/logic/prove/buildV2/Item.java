/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import managerindustry.logic.build.fatherclass.NameBase;

/**
 * Single item scimitar x 1
 * @author lele
 */
public class Item extends NameBase{
    public Item( int typeId, String typeName, int singleMaterialQuantity, 
            double totalMaterialQuantity){
        super.setTypeId(typeId);
        super.setName(typeName);
        super.setQuanityInt(singleMaterialQuantity);
        super.setQuanityDbl(totalMaterialQuantity);        
    }    
}
