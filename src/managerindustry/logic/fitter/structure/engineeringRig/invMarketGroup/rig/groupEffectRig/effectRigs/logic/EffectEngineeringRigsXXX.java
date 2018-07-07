/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.logic;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.ItemRecusion;

/**
 * @deprecated 
 * Trova un nome decente
 * @author lele
 */
public class EffectEngineeringRigsXXX {
    private int typeID;
    private List < ItemRecusion > itemRecusions = new ArrayList<>();    

    /**
     * Add rig and add Effect
     * @param int typeId
     * @param List < ItemRecusion > itemRecusions 
     */    
    public EffectEngineeringRigsXXX(int typeID, List < ItemRecusion > itemRecusions) {
        this.typeID = typeID;
        this.itemRecusions = itemRecusions;
    }

    public EffectEngineeringRigsXXX(int typeID) {
        this.typeID = typeID;
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
