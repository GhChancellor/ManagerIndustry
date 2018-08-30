/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV5;

import java.util.HashMap;
import java.util.Map;
import managerindustry.logic.generic.nameBase.NameBase;

/**
 *
 * @author lele
 */
public class ReportItem {
    private Map < String, NameBase > singleCalculatedItemM = new HashMap<>();
    private Map < String, NameBase > totalCalculatedItemM = new HashMap<>();
    private NameBase materialRecusion;

    public ReportItem() {
    }
    
    /**
     * Add Item
     * @param Item singleItem 
     */
    public void addItem(NameBase materialRecusion){
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
                totalCalculatedItemM.get( materialRecusion.getTypeName() ).getQuanityD() + 
                materialRecusion.getQuanityD();
            
            materialRecusion.setQuanityD(quanityDbl);
        }
        
        totalCalculatedItemM.put( materialRecusion.getTypeName(), materialRecusion);
    }

    public Map<String, NameBase> getSingleCalculatedItemM() {
        return singleCalculatedItemM;
    }

    public Map<String, NameBase> getTotalCalculatedItemM() {
        return totalCalculatedItemM;
    }
    
    
}
