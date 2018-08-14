/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lele
 */
public class ReportItem {
    private Map < String, Item > singleCalculatedItemM = new HashMap<>();
    private Map < String, Item > totalCalculatedItemM = new HashMap<>();
    private Item singleItem;

    public ReportItem() {
    }
    
    /**
     * Add Item
     * @param Item singleItem 
     */
    public void addItem(Item singleItem){
        this.singleItem = singleItem;
        
        addSingleItem();
        totalCalculatedItem();        
    }
    
    /**
     * Add Calculated material/item scimitar x 1
     * @param singleItem 
     */
    private void addSingleItem(){
        singleCalculatedItemM.put(singleItem.getName(), singleItem);
    }

    /**
     * get Calculated material/item scimitar x 1
     * @return List<Item>
     */
    public Map < String, Item > getSingleCalculatedItemM() {
        return singleCalculatedItemM;
    }
    
    /**
     * Sum all value into map
     */
    private void totalCalculatedItem(){
        if ( totalCalculatedItemM.containsKey( singleItem.getName() )){
            Double quanityDbl = 
                totalCalculatedItemM.get( singleItem.getName() ).getQuanityDbl() + 
                singleItem.getQuanityDbl();
            
            singleItem.setQuanityDbl(quanityDbl);
        }
        
        totalCalculatedItemM.put( singleItem.getName(), singleItem);
    }
    
    /**
     * Get Total Calculated Item
     * @return Map < String, Item >
     */
    public Map < String, Item > getTotalCalculatedItem(){
        return totalCalculatedItemM;
    }
}
