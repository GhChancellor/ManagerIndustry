/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.riggroups;

import managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize.RigLarge;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize.RigMedium;
import managerindustry.logic.prove.invMarketGroups.rig.riggroups.rigSize.RigXLarge;

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
 
    public RigMedium rigMedium(){
        RigMedium rigGroupsMedium = new RigMedium();
        return rigGroupsMedium;
    }
    
    public RigLarge rigLarge(){
        RigLarge rigLarge = new RigLarge();
        return rigLarge;
    }
    
    public RigXLarge rigXLarge(){
        RigXLarge rigXLarge = new RigXLarge();
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