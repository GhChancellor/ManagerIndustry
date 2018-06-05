/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig.blueprints;

import managerindustry.logic.prove.invMarketGroups.itemsRecursion.ItemRecusion;

/**
 * marketGroupID  
 * parentGroupID 
 * @author lele
 */
public class Blueprints {
    public Copy copy(){
        Copy copy = new Copy();
        return copy;
    }
    
    public Invention invention() {
        Invention invention = new Invention();
        return invention;
    }
    
    public MEResearch meResearch(){
        MEResearch mEResearch = new MEResearch();
        return mEResearch;
    }
    
    public TEResearch teResearch(){
        TEResearch tEResearch = new TEResearch();
        return tEResearch;
    }
}
