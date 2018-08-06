/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig;

import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.InvMarketGroups;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.recursion.ItemRecursionB;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.buildV3.GenericRequiredItem;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;

/**
 * Recursion rig
 * @deprecated da ottimizzare
 * @author lele
 */
public class RigRecusion extends GenericRequiredItem{
    private RigMarketGroupRecursion rigMarketGroupRecursion = new RigMarketGroupRecursion();

    public RigRecusion(int code) {
        requiredItem(code);
    }
    
    public RigRecusion(int code, int excludeCode) {
        requiredItem(code, excludeCode);
    }
    /**
     * Init ItemRecusion with all tree 
     * @param int code_ 
     */
    @Override
    protected void requiredItem(Object code_) {
        int code = ( int ) code_;
        List<InvMarketGroups> parentGroupIDs = Manager.getInstance().db().item().invMarketGroups().getMarketGroupID(code);
        RigMarketGroupRecursion rigMarketGroupRecursion_ = new RigMarketGroupRecursion();
        
        recusionAllBranches(parentGroupIDs, rigMarketGroupRecursion_ );        
        rigMarketGroupRecursion = rigMarketGroupRecursion_;                
    }

    /**
     * Init ItemRecusion without some branches
     * @param int code_
     * @param int excludeCode_ 
     */
    @Override
    protected void requiredItem(Object code_, Object excludeCode_) {
        int code = ( int ) code_;
        int excludeCode = ( int ) excludeCode_;
        List<InvMarketGroups> parentGroupIDs = Manager.getInstance().db().item().invMarketGroups().getMarketGroupID(code);
        RigMarketGroupRecursion rigMarketGroupRecursion_ = new RigMarketGroupRecursion();
        
        // Exclude some branches
        recusionExcludeTree(parentGroupIDs, rigMarketGroupRecursion_, excludeCode ); 
        rigMarketGroupRecursion = rigMarketGroupRecursion_;        
    }    
    
    /**
     * Exclude some branches 
     * @param List<InvMarketGroups> invMarketGroups
     * @param RigMarketGroupRecursion rigRecusion_
     * @param int excludeCode 
     */
    private void recusionExcludeTree(List<InvMarketGroups> invMarketGroups, RigMarketGroupRecursion rigRecusion_, int excludeCode ){
        for (InvMarketGroups marketGroups01 : invMarketGroups) {        
            if (marketGroups01.getParentGroupID() == null)
                marketGroups01.setParentGroupID(-1);
            
            RigMarketGroupRecursion recusion = new RigMarketGroupRecursion(
                marketGroups01.getMarketGroupID().shortValue(),
                marketGroups01.getParentGroupID().shortValue(), 
                marketGroups01.getMarketGroupName() );
            rigRecusion_.addRecursionB02( new ItemRecursionB(recusion) );
            
            // Exclude some branches ( items )
            if (marketGroups01.getMarketGroupID() == excludeCode)
                continue;            
            
            List<InvMarketGroups> marketGroups02 = 
                Manager.getInstance().db().item().invMarketGroups().getParentGroupID( 
                marketGroups01.getMarketGroupID() );
            
            if ( marketGroups02 != null){
                if (!marketGroups02.isEmpty()){
                    recusionExcludeTree(marketGroups02, recusion, excludeCode);
                }                
            }            
        }        
    }
    
    /**
     * All branches
     * @param List<InvMarketGroups> invMarketGroups
     * @param RigMarketGroupRecursion rigRecusion_ 
     */
    private void recusionAllBranches(List<InvMarketGroups> invMarketGroups, RigMarketGroupRecursion rigRecusion_ ){
        for (InvMarketGroups marketGroups01 : invMarketGroups) {        
            if (marketGroups01.getParentGroupID() == null)
                marketGroups01.setParentGroupID(-1);
            
            RigMarketGroupRecursion recusion = new RigMarketGroupRecursion(
                marketGroups01.getMarketGroupID().shortValue(),
                marketGroups01.getParentGroupID().shortValue(), 
                marketGroups01.getMarketGroupName() );
            rigRecusion_.addRecursionB02( new ItemRecursionB(recusion) );
            
            List<InvMarketGroups> marketGroups02 = 
                Manager.getInstance().db().item().invMarketGroups().getParentGroupID( 
                marketGroups01.getMarketGroupID() );
            
            if ( marketGroups02 != null){
                if (!marketGroups02.isEmpty()){
                    recusionAllBranches(marketGroups02, recusion);
                }                
            }            
        }
    }
    
    /**
     * Display rig recursion
     */
    public void displayRecursion(){
        display(rigMarketGroupRecursion, "");
    }
    
    /**
     * Display rig recursion
     * @param t1
     * @param t2 
     */
    @Override
    protected void display(Object t1, Object t2) {
        RigMarketGroupRecursion rigMarketGroupRecursion = (RigMarketGroupRecursion) t1;
        String tab = (String) t2;
        
        System.out.println(tab + 
            rigMarketGroupRecursion.getMarketGroupName() + " " + 
            rigMarketGroupRecursion.getMarketGroupID() + " " + 
            rigMarketGroupRecursion.getParentGroupID() );
        
        tab +=" ";

        if ( rigMarketGroupRecursion.getRecursionB02s().isEmpty() ){
            List<InvTypes> parentGroupID = Manager.getInstance().db().item().
                invTypes().getMarketGroupID(rigMarketGroupRecursion.getMarketGroupID(), true);            
            
            for (InvTypes invTypes : parentGroupID) {
                System.out.println(tab + invTypes.getTypeName()+ " " + invTypes.getTypeID() );
            }            
        }
        
        for (ItemRecursionB object : rigMarketGroupRecursion.getRecursionB02s()) {
            display(object.getRecursionA02(), tab);
        }         
        
    }

    /**
     * Get RigMarket Groups
     * @return List < Integer >
     */
    public List < Integer > getRigMarketGroups(){
        List<Integer> rigMarketGroups = 
            (List < Integer >) getConversionToList(rigMarketGroupRecursion);
        return rigMarketGroups;
    }
    
    /**
     * Get RigMarket Group Map
     * @return Map< Integer, Integer >
     */
    public Map< Integer, Integer > getRigMarketGroupM(){
        Map rigMarketGroupM = getConversionToMap(rigMarketGroupRecursion);
        return rigMarketGroupM;
    }
    
    @Override
    protected void requiredItem(Object t1, Object t2, Object t3) {
        throw new UnsupportedOperationException("Unused"); //To change body of generated methods, choose Tools | Templates.
    }


    
}
