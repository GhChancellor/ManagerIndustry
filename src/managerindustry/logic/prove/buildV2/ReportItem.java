/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author lele
 */
public class ReportItem {
    private List < Item > singleItems;
    private Map < String, Item > singleItemsM = new HashMap<>();
    private Item singleItem;
    
    public ReportItem(Item singleItem) {
        this.singleItem = singleItem;
        
        addSingleItem();
        totalCalculatedItem();
    }

    public ReportItem() {
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
    
    private void totalCalculatedItem(){
        if ( singleItemsM.containsKey( singleItem.getName() )){
            Double quanityDbl = 
                singleItemsM.get( singleItem.getName() ).getQuanityDbl() + 
                singleItem.getQuanityDbl();
            
            singleItem.setQuanityDbl(quanityDbl);
        }
        
        singleItemsM.put( singleItem.getName(), singleItem);
    }
}
