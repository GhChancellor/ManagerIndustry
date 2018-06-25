/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.daValutare.blueprints;

import managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * @author lele
 */
public class Blueprints_OLD {
    
    /**
     * Copy_OLD
     * @return Copy_OLD
     */
    public Copy_OLD copy(){
        Copy_OLD copy = new Copy_OLD();
        return copy;
    }
    
    /**
     * Invention_OLD
     * @return Invention_OLD
     */
    public Invention_OLD invention() {
        Invention_OLD invention = new Invention_OLD();
        return invention;
    }
    
    /**
     * ME Research
     * @return MEResearch_OLD
     */    
    public MEResearch_OLD meResearch(){
        MEResearch_OLD mEResearch = new MEResearch_OLD();
        return mEResearch;
    }
    
     /**
     * TE Research
     * @return TEResearch_OLD
     */   
    public TEResearch_OLD teResearch(){
        TEResearch_OLD tEResearch = new TEResearch_OLD();
        return tEResearch;
    }
}

/*
    SELECT * FROM invTypes where invTypes.typeName="drake blueprint"; -- 24699
    SELECT * FROM industryActivity where industryActivity.typeID=24699 and industryActivity.activityID=5; -- 5 = copy
 
    typeID=24699   activityID=5   time=12000
*/