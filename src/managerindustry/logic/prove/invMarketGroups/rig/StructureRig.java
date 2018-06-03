/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=404; id example
 * SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=404; id example
 * @author lele
 */
public class StructureRig {
    private List<Rig> rigGroups = new ArrayList<>();
    private List<ItemRecusion> itemRecusions = new ArrayList<>();

    /**
     * New Rig
     * @param InvTypes invTypes 
     */
    public void newRig(InvTypes invTypes){
        Rig rig = new Rig(invTypes);
        rigGroups.add(rig);
    }
    
    /**
     * New Rig groups
     * @param List < InvTypes > invTypeses 
     */
    public void newRigs(List < InvTypes > invTypeses){
        for (InvTypes invTypes : invTypeses) {
            Rig rig = new Rig(invTypes);
            rigGroups.add(rig); 
        }
    }
    
    /**
     * New Effect
     * @param int code
     * @param int excludeCode 
     */
    public void newEffect(ItemRecusion itemRecusion){
        itemRecusions.add(itemRecusion);
    }

    /**
     * Get Item Recusions
     * @return List<ItemRecusion>
     */
    public List<ItemRecusion> getItemRecusions() {
        List< ItemRecusion > groupItems = new ArrayList<>();
        groupItems.addAll(itemRecusions);
        return groupItems;
    }   

    /**
     * Get Rig Groups
     * @return List<Rig> 
     */
    public List<Rig> getRigGroups() {
        return rigGroups;
    }
    
}


/*

SELECT * FROM invTypes where invTypes.typeName="Standup M-Set Equipment Manufacturing Material Efficiency I";
-- 43920


   SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=2347;
   SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=2340;
            
    SELECT * FROM invTypes, invMarketGroups where invMarketGroups.marketGroupID=invTypes.marketGroupID and
    invMarketGroups.marketGroupID=2347; 
*/