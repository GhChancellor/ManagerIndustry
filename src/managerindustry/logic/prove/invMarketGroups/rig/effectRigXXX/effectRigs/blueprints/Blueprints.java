/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRigXXX.effectRigs.blueprints;

import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * @author lele
 */
public class Blueprints {
    
    /**
     * Copy
     * @return Copy
     */
    public Copy copy(){
        Copy copy = new Copy();
        return copy;
    }
    
    /**
     * Invention
     * @return Invention
     */
    public Invention invention() {
        Invention invention = new Invention();
        return invention;
    }
    
    /**
     * ME Research
     * @return MEResearch
     */    
    public MEResearch meResearch(){
        MEResearch mEResearch = new MEResearch();
        return mEResearch;
    }
    
     /**
     * TE Research
     * @return TEResearch
     */   
    public TEResearch teResearch(){
        TEResearch tEResearch = new TEResearch();
        return tEResearch;
    }
}

/*
    SELECT * FROM invTypes where invTypes.typeName="drake blueprint"; -- 24699
    SELECT * FROM industryActivity where industryActivity.typeID=24699 and industryActivity.activityID=5; -- 5 = copy
 
    typeID=24699   activityID=5   time=12000
*/