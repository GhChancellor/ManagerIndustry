/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.itemsRecursion;

import java.util.List;
import managerindustry.db.entities.InvMarketGroups;
import managerindustry.db.entities.InvTypes;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class ItemRecusion {
    private ItemRecursionA ira = new ItemRecursionA();
    
    /**
     * Init ItemRecusion with all tree 
     * @param code 
     */
    public ItemRecusion(int code) {
        List<InvMarketGroups> parentGroupIDs = ManagerDB.getInstance().invMarketGroupsX().getMarketGroupID(code);
        ItemRecursionA recursionA02 = new ItemRecursionA();
        recusionAllBranches(parentGroupIDs, recursionA02 );
        
        ira = recursionA02;
        
        display(recursionA02, "");
        
        System.out.println("");
    }

    /**
     * Init ItemRecusion without some branches
     * @param code
     * @param excludeCode 
     */
    public ItemRecusion(int code, int excludeCode) {
        List<InvMarketGroups> parentGroupIDs = ManagerDB.getInstance().invMarketGroupsX().getMarketGroupID(code);
        ItemRecursionA recursionA02 = new ItemRecursionA();
        
        //Exclude some branches
        recusionExcludeTree(parentGroupIDs, recursionA02, excludeCode );
        
        display(recursionA02, "");
        
        System.out.println("");
    }
    
    /**
     * Exclude some branches
     * @param invMarketGroups
     * @param recursionA02
     * @param excludeCode 
     */
    private void recusionExcludeTree(List<InvMarketGroups> invMarketGroups, ItemRecursionA recursionA02, int excludeCode ){
        for (InvMarketGroups marketGroups01 : invMarketGroups) {
            ItemRecursionA recursionA = new ItemRecursionA
                ( marketGroups01.getMarketGroupID(), marketGroups01.getParentGroupID(), marketGroups01.getMarketGroupName() );
            
            // Exclude some branches ( items )
            if (marketGroups01.getMarketGroupID() == excludeCode)
                continue;
            
            recursionA02.addRecursionB02(new ItemRecursionB(recursionA));
            List<InvMarketGroups> marketGroups02 = ManagerDB.getInstance().invMarketGroupsX().getParentGroupID( marketGroups01.getMarketGroupID() );
            
            if ( marketGroups02 != null){
                if (!marketGroups02.isEmpty()){
                    recusionExcludeTree(marketGroups02, recursionA, excludeCode);
                }                
            }
        }
    }
    
    /**
     * All branches
     * @param invMarketGroups
     * @param recursionA02 
     */
    private void recusionAllBranches(List<InvMarketGroups> invMarketGroups, ItemRecursionA recursionA02 ){
        for (InvMarketGroups marketGroups01 : invMarketGroups) {
            ItemRecursionA recursionA = new ItemRecursionA
                ( marketGroups01.getMarketGroupID(), marketGroups01.getParentGroupID(), marketGroups01.getMarketGroupName() );

            recursionA02.addRecursionB02(new ItemRecursionB(recursionA));
            List<InvMarketGroups> marketGroups02 = ManagerDB.getInstance().invMarketGroupsX().getParentGroupID( marketGroups01.getMarketGroupID() );
            
            if ( marketGroups02 != null){
                if (!marketGroups02.isEmpty()){
                    recusionAllBranches(marketGroups02, recursionA);
                }                
            }
        }
    }
    
    
    
    private void display(ItemRecursionA recursionA02, String tab){
        System.out.println(tab + recursionA02.getMarketGroupName() + " " + recursionA02.getMarketGroupID() + " " + recursionA02.getParentGroupID());
        tab +="  ";

        if ( recursionA02.getRecursionB02s().isEmpty() ){
            List<InvTypes> parentGroupID = ManagerDB.getInstance().invTypes().getMarketGroupID(recursionA02.getMarketGroupID(), true);
            
            
            for (InvTypes invTypes : parentGroupID) {
                System.out.println(tab + invTypes.getTypeName()+ " " + invTypes.getTypeID() );
            }            
        }
        
        for (ItemRecursionB object : recursionA02.getRecursionB02s()) {
            display(object.getRecursionA02(), tab);
        }        
    }

    public ItemRecursionA getIra() {
        return ira;
    }
    
}
/*
   SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=4; -- ships
    SELECT * from invMarketGroups WHERE invMarketGroups.parentGroupID=4; -- type ships
     SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=391; -- class ships
      SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=391; -- t1, t2, t3
       SELECT * FROM invMarketGroups where invMarketGroups.marketGroupID=393; -- Advanced Frigates
        SELECT * FROM invMarketGroups where invMarketGroups.parentGroupID=393;	-- vuoto
            
    SELECT * FROM invTypes, invMarketGroups where invMarketGroups.marketGroupID=invTypes.marketGroupID and
    invMarketGroups.marketGroupID=393; 
*/