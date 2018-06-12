/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.riggroups;

import managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize.old.RigLarge_OLD;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize.old.RigMedium_OLD;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize.old.RigXLarge_OLD;

/**
 *
 * @author lele
 */
public class RigGroups {
    private static RigGroups instance = null;
    
    public static RigGroups getInstance(){
        if (instance == null){
            instance = new RigGroups();
        }
        return instance;
    }
 
    /**
     * Rig Medium
     * @return RigMedium_OLD
     */
    public RigMedium_OLD rigMedium(){
        RigMedium_OLD rigGroupsMedium = new RigMedium_OLD();
        return rigGroupsMedium;
    }
    
    /**
     * Rig Large
     * @return RigLarge_OLD
     */
    public RigLarge_OLD rigLarge(){
        RigLarge_OLD rigLarge = new RigLarge_OLD();
        return rigLarge;
    }

    /**
     * Rig XLarge
     * @return RigXLarge_OLD
     */    
    public RigXLarge_OLD rigXLarge(){
        RigXLarge_OLD rigXLarge = new RigXLarge_OLD();
        return rigXLarge;
    }
}

/*
SELECT * FROM invTypes where invTypes.typeName="Standup M-Set Equipment Manufacturing Material Efficiency I";
-- 43920

   SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=2347; -- Advanced Frigates
   SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=2340;	-- vuoto
            
    SELECT * FROM invTypes, invMarketGroups where invMarketGroups.marketGroupID=invTypes.marketGroupID and
    invMarketGroups.marketGroupID=2347;  
*/