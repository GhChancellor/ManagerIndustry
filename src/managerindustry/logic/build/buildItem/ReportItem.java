/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.buildItem;

import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.generic.nameBase.NameBase;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterial;

/**
 *
 * @author lele
 */
public class ReportItem extends RequiredMaterial{
    private NameBase materialRecusion;    

    public ReportItem() {
    }
        
    /**
     * Add Item
     * @param Item singleItem 
     */
    public void addItem(NameBase materialRecusion){
        this.materialRecusion = materialRecusion;
        totalCalculatedItem();        
    }    
    
    /**
     * Sum all value into map
     */
    private void totalCalculatedItem(){
        Map<String, NameBase> map = getMap();
        
        if( map.containsKey(materialRecusion.getTypeName())){
            Double quanityDbl = map.get(materialRecusion.getTypeName() ).getQuanityD() + 
                materialRecusion.getQuanityD();
            materialRecusion.setQuanityD(quanityDbl);
        }
        
        addMapElement(materialRecusion.getTypeName(), materialRecusion);
    }
    
    /**
     * Get Total Calculated Item
     * @return Map<String, NameBase>
     */
    public Map<String, NameBase> getTotalCalculatedItem(){
        return getMap();
    }

}
