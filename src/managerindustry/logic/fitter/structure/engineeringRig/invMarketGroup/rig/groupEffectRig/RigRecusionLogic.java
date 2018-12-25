/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig;

import java.util.ArrayList;
import java.util.List;
import managerindustry.db.entities.eve.InvMarketGroups;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.fatherClass.RigMarketGroup;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterial;

/**
 *
 * @author lele
 */
public class RigRecusionLogic < C, E, G > 
    extends RequiredMaterial < Integer, Integer, C, InvMarketGroups, 
        E, RigMarketGroup, RigMarketGroup > {

    private RigMarketGroup rigMarketGroupRecursion = new RigMarketGroup();
    private List < Integer > rigMarketGroupRecursions = new ArrayList<Integer>();

    public RigRecusionLogic() {
    }
            
    public RigRecusionLogic(int code) {
        requiredItem(code);
    }
    
    public RigRecusionLogic(int code, int excludeCode) {
        requiredItem(code, excludeCode);
    }
    
    @Override
    public void requiredItem(Integer code) {
        List<InvMarketGroups> parentGroupIDs = 
            Manager.getInstance().db().item().invMarketGroups().getMarketGroupID(code);
        
        RigMarketGroup rigMarketGroupRecursion = new RigMarketGroup();
        
        recusionAllBranches(parentGroupIDs, rigMarketGroupRecursion );        
        this.rigMarketGroupRecursion = rigMarketGroupRecursion; 
    }
    
    @Override
    public void requiredItem(Integer code, Integer excludeCode) {
        List<InvMarketGroups> parentGroupIDs = 
            Manager.getInstance().db().item().invMarketGroups().getMarketGroupID(code);
        
        RigMarketGroup rigMarketGroupRecursion = new RigMarketGroup();
        
        // Exclude some branches
        recusionExcludeTree(parentGroupIDs, rigMarketGroupRecursion, excludeCode ); 
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
    private void recusionAllBranches(List<InvMarketGroups> invMarketGroups, RigMarketGroup rigRecusion ){
        for (InvMarketGroups marketGroups01 : invMarketGroups) {        
            if (marketGroups01.getParentGroupID() == null)
                marketGroups01.setParentGroupID(-1);
            
//            Only for dbg, use this for more info on object
            RigMarketGroup recusion = 
                (RigMarketGroup) requiredItemMoreInfo(marketGroups01);  

            rigRecusion.addItemRecursions(recusion);
            
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
    public RigMarketGroup requiredItemMoreInfo(InvMarketGroups marketGroups01) {
        System.err.print("RigRecusion > requiredItemMoreInfo is ENABLE!!!");
        
        RigMarketGroup recusion = new RigMarketGroup(
            marketGroups01.getMarketGroupID().shortValue(),
            marketGroups01.getParentGroupID().shortValue(), 
            marketGroups01.getMarketGroupName() );   
        
        return recusion;
    }

    /**
     * @deprecated 
     * modificare entity 
     * List<InvTypes> parentGroupID = Manager.getInstance().db().item().
            invTypes().getMarketGroupID(rigMarketGroupRecursion.getMarketGroupID(), true); 
     */
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
                System.out.println(tab + " - "+ invTypes.getTypeName()+ " " + 
                    invTypes.getTypeID() );
            }            
        }

        tab += " " ;
        System.out.println("----------");         
        
        for (RigMarketGroup marketGroup : rigMarketGroupRecursion.getItemRecursions()) {
            displayRigMarketGroupRecursion( marketGroup, tab);
        }         
    }    

    @Override
    public RigMarketGroup getObject() {
        return rigMarketGroupRecursion;
    }
    
    public List < Integer > getList(){
        return rigMarketGroupRecursions;
    }
    
    private void createList(RigMarketGroup rigMarketGroupRecursion){
        
        if ( rigMarketGroupRecursion.getItemRecursions().isEmpty() ){
            List<InvTypes> parentGroupID = Manager.getInstance().db().item().
                invTypes().getMarketGroupID(rigMarketGroupRecursion.getMarketGroupID(), true);            
            
            for (InvTypes invTypes : parentGroupID) {
                rigMarketGroupRecursions.add(invTypes.getTypeID());
            }            
        }
        
        for (RigMarketGroup object : rigMarketGroupRecursion.getItemRecursions()) {
            createList(object);
        }         
    }
}
