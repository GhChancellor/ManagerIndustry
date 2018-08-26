/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV4;

import managerindustry.logic.prove.buildV3.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lele
 */
public class ReportItem {
    private Map < String, RequiredMaterialRecusion > singleCalculatedItemM = new HashMap<>();
    private Map < String, RequiredMaterialRecusion > totalCalculatedItemM = new HashMap<>();
    private RequiredMaterialRecusion materialRecusion;

    public ReportItem() {
    }
    
    /**
     * Add Item
     * @param Item singleItem 
     */
    public void addItem(RequiredMaterialRecusion materialRecusion){
        this.materialRecusion = materialRecusion;
        
        addSingleItem();
        totalCalculatedItem();        
    }
    
    /**
     * Add Calculated material/item scimitar x 1
     * @param singleItem 
     */
    private void addSingleItem(){
        singleCalculatedItemM.put(materialRecusion.getTypeName(), materialRecusion);
    }

    /**
     * Sum all value into map
     */
    private void totalCalculatedItem(){
        if ( totalCalculatedItemM.containsKey( materialRecusion.getTypeName())){
            Double quanityDbl = 
                totalCalculatedItemM.get( materialRecusion.getTypeName() ).getQuanityDbl() + 
                materialRecusion.getQuanityDbl();
            
            materialRecusion.setQuanityDbl(quanityDbl);
        }
        
        totalCalculatedItemM.put( materialRecusion.getTypeName(), materialRecusion);
    }

    public Map<String, RequiredMaterialRecusion> getSingleCalculatedItemM() {
        return singleCalculatedItemM;
    }

    public Map<String, RequiredMaterialRecusion> getTotalCalculatedItemM() {
        return totalCalculatedItemM;
    }
    
    
}
