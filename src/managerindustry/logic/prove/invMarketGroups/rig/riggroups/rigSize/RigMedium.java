/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 *
 * @author lele
 */
public class RigMedium {
    private int typeID;
    private List < ItemRecusion > itemRecusions = new ArrayList<>();

    public RigMedium(int typeID, List < ItemRecusion > itemRecusions) {
        this.typeID = typeID;
        this.itemRecusions.addAll(itemRecusions);
    }
    
}
