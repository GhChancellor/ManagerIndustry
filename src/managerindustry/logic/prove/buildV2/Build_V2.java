/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class Build_V2 {
    private RequiredItemsRecursionA requiredItems;
    
    /**
     * 
     * @param bpoName
     * @param run <<---- controllare se si può mettere in byte
     * @param job <<---- controllare se si può mettere in byte
     * @param bpoME
     * @param componentMe 
     */
    public Build_V2(String bpoName, int run, int job, byte bpoME, 
        byte componentMe, RamActivitiesEnum activitiesEnum) {
        
        bpoName += " blueprint";

        // list material to build an item
        List< IndustryActivityMaterials> materialLists = 
         Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(bpoName, activitiesEnum);        
        
        RequiredItemsRecursionA requiredA = new RequiredItemsRecursionA();
        baseMaterialRequired(materialLists, requiredA, activitiesEnum);
        requiredItems = requiredA;
    }
    
    /**
     * Material required to build object
     */
    private void baseMaterialRequired(List< IndustryActivityMaterials> materialLists, 
        RequiredItemsRecursionA requiredA, RamActivitiesEnum activitiesEnum ){
        
        for (IndustryActivityMaterials materialList : materialLists) {
            // get name and id
            InvTypes invTypes =
              Manager.getInstance().db().item().invTypes().getInvTypesById(materialList.getMaterialTypeID());

            RequiredItemsRecursionA requiredItemsRecursionA = 
                new RequiredItemsRecursionA(invTypes.getTypeName(), materialList.getQuantity());

            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);

            if (neededComponents != null)
                baseMaterialRequired(neededComponents, requiredItemsRecursionA, activitiesEnum);
            
        }
    }
    
    public void displayBaseMaterialRequired(){
        displayMap(requiredItems, "");
    }
    
    private void displayMap(RequiredItemsRecursionA requiredItems, String tab){
        System.out.println("" + requiredItems.getName() + " Quantity base " + requiredItems.getQuanityInt());
        tab +="\t";
        
        for (RequiredItemsRecursionB requiredItemsB : requiredItems.getMaterialRequiredRecursionBs()) {
            displayMap(requiredItemsB.getMaterialRequiredRecursionA(), tab);
        }
    }
    
    /**
     * required skill to build object
     */
    private void skillRequired(){
        
    }
    
    public void display(String bpoName){
        System.out.println(""+ bpoName );
    }
}
