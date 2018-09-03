/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig;

import java.util.List;
import managerindustry.db.entities.eve.InvMarketGroups;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigMarketGroup;
import managerindustry.logic.generic.recursion.ItemRecursion;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.generic.genericRequiredItem.AGenericRequiredItem;

/**
 *
 * @author lele
 */
public class RigRecusionLogic extends AGenericRequiredItem{
    private RigMarketGroup rigMarketGroupRecursion = new RigMarketGroup();

    public RigRecusionLogic(int code) {
        requiredItem(code);
    }
    
    public RigRecusionLogic(int code, int excludeCode) {
        requiredItem(code, excludeCode);
    }
    
    @Override
    public void requiredItem(Object code) {
        List<InvMarketGroups> parentGroupIDs = 
            Manager.getInstance().db().item().invMarketGroups().getMarketGroupID( ( int ) code);
        
        RigMarketGroup rigMarketGroupRecursion = new RigMarketGroup();
        
        recusionAllBranches(parentGroupIDs, rigMarketGroupRecursion );        
        this.rigMarketGroupRecursion = rigMarketGroupRecursion; 
    }
    
    @Override
    public void requiredItem(Object code, Object excludeCode) {
        List<InvMarketGroups> parentGroupIDs = Manager.getInstance().db().item().invMarketGroups().getMarketGroupID( ( int ) code);
        RigMarketGroup rigMarketGroupRecursion = new RigMarketGroup();
        
        // Exclude some branches
        recusionExcludeTree(parentGroupIDs, rigMarketGroupRecursion,( int ) excludeCode ); 
        this.rigMarketGroupRecursion = rigMarketGroupRecursion; 
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
            
            rigRecusion_.addItemRecursions(recusion);
            
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

            rigRecusion_.addItemRecursions(recusion);
            
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
    public Object requiredItemMoreInfo(Object marketGroups01_) {
        System.err.print("RigRecusion > requiredItemMoreInfo is ENABLE!!!");
        
        InvMarketGroups marketGroups01 = (InvMarketGroups) marketGroups01_;
        
            RigMarketGroup recusion = new RigMarketGroup(
                marketGroups01.getMarketGroupID().shortValue(),
                marketGroups01.getParentGroupID().shortValue(), 
                marketGroups01.getMarketGroupName() );   
        
        return (RigMarketGroup) recusion;
    }

    @Override
    public void display() {
        displayRigMarketGroupRecursion(rigMarketGroupRecursion, "");
    }

    /**
     * Display Rig Market Group Recursion
     * @param RigMarketGroupRecursion rigMarketGroupRecursion rigMarketGroupRecursion
     * @param String tab 
     */
    private void displayRigMarketGroupRecursion(
        RigMarketGroup rigMarketGroupRecursion, String tab){
        
        if (rigMarketGroupRecursion.getMarketGroupID() != 0 )
            System.out.println(tab + 
                rigMarketGroupRecursion.getMarketGroupName() + " " + 
                rigMarketGroupRecursion.getMarketGroupID() + " " + 
                rigMarketGroupRecursion.getParentGroupID() );

        if ( rigMarketGroupRecursion.getItemRecursions().isEmpty() ){
            List<InvTypes> parentGroupID = Manager.getInstance().db().item().
                invTypes().getMarketGroupID(rigMarketGroupRecursion.getMarketGroupID(), true);            
            
            for (InvTypes invTypes : parentGroupID) {
                System.out.println(tab + " - "+ invTypes.getTypeName()+ " " + invTypes.getTypeID() );
            }            
        }

        tab += " " ;
        System.out.println("----------");         
        
        for (Object object : rigMarketGroupRecursion.getItemRecursions()) {
            displayRigMarketGroupRecursion((RigMarketGroup) object, tab);
        }         
    }    
    
    @Override
    public void pharseToMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        addMapElement(rigMarketGroupRecursion.getMarketGroupName(),rigMarketGroupRecursion);
    }

    @Override
    public void pharseToList() {
        if (rigMarketGroupRecursion != null){
            addListElement(rigMarketGroupRecursion);
        }
    }

    public List < RigRecusionLogic > getList(){
        pharseToList();
        return super.getList();        
    }
    
    @Override
    public void requiredItem(Object t1, Object b2, Object c3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object requiredItemMoreInfo(Object a1, Object b2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
