/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.InvMarketGroups;
import managerindustry.logic.generic.recursion.ItemRecursionA;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.buildV3.genericRequireRecursion.GenericRequiredItem;

/**
 * Recursion rig
 * @deprecated da ottimizzare
 * @author lele
 */
public class RigRecusion extends GenericRequiredItem{
    private RigMarketGroup rigMarketGroupRecursion = new RigMarketGroup();

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
        RigMarketGroup rigMarketGroupRecursion_ = new RigMarketGroup();
        
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
        RigMarketGroup rigMarketGroupRecursion_ = new RigMarketGroup();
        
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
    private void recusionExcludeTree(List<InvMarketGroups> invMarketGroups, RigMarketGroup rigRecusion_, int excludeCode ){
        for (InvMarketGroups marketGroups01 : invMarketGroups) {        
            if (marketGroups01.getParentGroupID() == null)
                marketGroups01.setParentGroupID(-1);
            
            RigMarketGroup recusion = new RigMarketGroup(
                marketGroups01.getMarketGroupID().shortValue(),
                marketGroups01.getParentGroupID().shortValue());

//            Only for dbg, use this for more info on object
//            RigMarketGroup recusion = 
//                (RigMarketGroup) requiredItemMoreInfo(marketGroups01);
            
            rigRecusion_.addItemRecursionAs(new ItemRecursionA(recusion));
            
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
    private void recusionAllBranches(List<InvMarketGroups> invMarketGroups, RigMarketGroup rigRecusion_ ){
        for (InvMarketGroups marketGroups01 : invMarketGroups) {        
            if (marketGroups01.getParentGroupID() == null)
                marketGroups01.setParentGroupID(-1);
            
//            RigMarketGroup recusion = new RigMarketGroup(
//                marketGroups01.getMarketGroupID().shortValue(),
//                marketGroups01.getParentGroupID().shortValue());
            
//            Only for dbg, use this for more info on object
            RigMarketGroup recusion = 
                (RigMarketGroup) requiredItemMoreInfo(marketGroups01);  

            rigRecusion_.addItemRecursionAs(new ItemRecursionA(recusion));
            
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

    @Override
    protected Object requiredItemMoreInfo(Object marketGroups01_) {
        System.err.print("RigRecusion > requiredItemMoreInfo is ENABLE!!!");
        
        InvMarketGroups marketGroups01 = (InvMarketGroups) marketGroups01_;
        
            RigMarketGroup recusion = new RigMarketGroup(
                marketGroups01.getMarketGroupID().shortValue(),
                marketGroups01.getParentGroupID().shortValue(), 
                marketGroups01.getMarketGroupName() );   
        
        return (RigMarketGroup) recusion;
    }
    
    /**
     * Display rig recursion
     */
    public void displayRecursion(){
        display(rigMarketGroupRecursion);
    }
    
    /**
     * @deprecated 
     * Get RigMarket Groups
     * @return List < Integer >
     */
    public List < Integer > getRigMarketGroups(){
//        List<Integer> rigMarketGroups = 
//            (List < Integer >) getObject();
//        return rigMarketGroups;
        return new ArrayList<>();
    }
    
    public List < RigMarketGroup > getRigMarketGroupsList(){
        return ( List < RigMarketGroup > ) 
                    getConversionToList(rigMarketGroupRecursion);
    }
    
    /**
     * Get Rig Recursion
     * @return RigMarketGroup
     */
    public RigMarketGroup getRigRecursion(){
        return (RigMarketGroup) getObject();
    }
    
    /**
     * Get RigMarket Group Map
     * @return Map< Integer, Integer >
     */
    public Map< Integer, Integer > getRigMarketGroupM(){
        Map rigMarketGroupM = getConversionToMap(rigMarketGroupRecursion);
        return rigMarketGroupM;
    }
    
    /**
     * Get Object
     * @return 
     */
    @Override
    protected Object getObject() {
        return rigMarketGroupRecursion;
    }    
    
    @Override
    protected void requiredItem(Object t1, Object t2, Object t3) {
        throw new UnsupportedOperationException("Unused"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object requiredItemMoreInfo(Object t1, Object t2) {
        throw new UnsupportedOperationException("Not used"); //To change body of generated methods, choose Tools | Templates.
    }
        
}
