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
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecursionA;
import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=404; id example
 * SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=404; id example
 * @author lele
 */
public class StructureRig {
    private List<RigDescription> rigGroups = new ArrayList<>();
    private List<ItemRecursionA> effects = new ArrayList<>();

    /**
     * New RigDescription
     * @param InvTypes invTypes 
     */
    public void newRig(InvTypes invTypes){
        RigDescription rig = new RigDescription(invTypes);
        rigGroups.add(rig);
    }

    /**
     * Get RigDescription Groups
     * @return List<Rig> 
     */
    public List<RigDescription> getRigGroups() {
        return rigGroups;
    }
    
    /**
     * New RigDescription groups
     * @param List < InvTypes > invTypeses 
     */
    public void newRigGroups(List < InvTypes > invTypeses){
        for (InvTypes invTypes : invTypeses) {
            RigDescription rig = new RigDescription(invTypes);
            rigGroups.add(rig); 
        }
    }
    
    /**
     * New Effect
     * @param int code
     * @param int excludeCode 
     */
    public void newEffect(ItemRecusion itemRecusion){       
        effects.add(itemRecusion.getIra());
        System.out.println("");
    }

    /**
     * Get Item Recusions
     * @return List<ItemRecusion>
     */
    public List<ItemRecursionA> getEffects() {
        return effects;
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