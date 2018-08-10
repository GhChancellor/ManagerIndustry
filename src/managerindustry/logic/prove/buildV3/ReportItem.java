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
    private List < Item > singleItems = new ArrayList<>();
    private Map < String, Item > singleItemM = new HashMap<>();
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
        singleItems.add(singleItem);
    }

    /**
     * get Calculated material/item scimitar x 1
     * @return List<Item>
     */
    public List<Item> getSingleItems() {
        return singleItems;
    }
    
    /**
     * Sum all value into map
     */
    private void totalCalculatedItem(){
        if ( singleItemM.containsKey( singleItem.getName() )){
            Double quanityDbl = 
                singleItemM.get( singleItem.getName() ).getQuanityDbl() + 
                singleItem.getQuanityDbl();
            
            singleItem.setQuanityDbl(quanityDbl);
        }
        
        singleItemM.put( singleItem.getName(), singleItem);
    }
    
    /**
     * Get Total Calculated Item
     * @return Map < String, Item >
     */
    public Map < String, Item > getTotalCalculatedItem(){
        return singleItemM;
    }
}
