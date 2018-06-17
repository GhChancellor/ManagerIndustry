/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.QUALCOSA;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 *
 * @author lele
 */
public class StructureRig {
    private int typeID;
    private List < ItemRecusion > itemRecusions = new ArrayList<>();    

    /**
     * Add rig and add Effect
     * @param int typeId
     * @param List < ItemRecusion > itemRecusions 
     */    
    public StructureRig(int typeID, List < ItemRecusion > itemRecusions) {
        this.typeID = typeID;
        this.itemRecusions = itemRecusions;
    }

    /**
     * Get TypeID
     * @return int
     */
    public int getTypeID() {
        return typeID;
    }

    /**
     * Get ItemRecusions
     * @return List<ItemRecusion>
     */
    public List<ItemRecusion> getItemRecusions() {
        return itemRecusions;
    }    
}
