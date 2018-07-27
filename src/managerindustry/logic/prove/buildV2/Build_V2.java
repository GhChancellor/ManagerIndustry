/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV2;

import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.IndustryActivitySkills;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.enumName.RamActivitiesEnum;
import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.exception.ErrorExeption.ErrorExeptionEnum;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class Build_V2 {
    private RequiredItemsRecursionA requiredItems;
    private RequiredItemsRecursionA requiredSkill;
    private String DBG_bpoName;
    /**
     * 
     * @param bpoName
     * @param run <<---- controllare se si può mettere in byte
     * @param job <<---- controllare se si può mettere in byte
     * @param bpoME
     * @param componentMe 
     */
    public Build_V2(String bpoName, int run, int job, byte bpoME, 
        byte componentMe, RamActivitiesEnum activitiesEnum) throws ErrorExeption {
        
        bpoName += " blueprint";
        DBG_bpoName = bpoName;
        
        Integer typeID = 
            Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName).getTypeID();
        
        if ( typeID == null )
            throw new ErrorExeption(ErrorExeptionEnum.ITEM_NOT_EXITS);
        
        // list material to build an item
        List< IndustryActivityMaterials> materialLists = 
            Manager.getInstance().db().item().industryActivityMaterials().getMaterialsID(typeID, activitiesEnum);
        
        // list skill required to build an item
        List<IndustryActivitySkills> industryActivitySkills = 
            Manager.getInstance().db().item().industryActivitySkills().getRequiredSkill(typeID, activitiesEnum);
        

        RequiredItemsRecursionA requiredItems = new RequiredItemsRecursionA();
        baseMaterialRequired(materialLists, requiredItems, activitiesEnum);

        RequiredItemsRecursionA requiredSkill = new RequiredItemsRecursionA();
        skillRequired(industryActivitySkills, requiredSkill, activitiesEnum);

        this.requiredItems = requiredItems;
        this.requiredSkill = requiredSkill;
        System.out.println("");
    }
    
    /**
     * required skill to build object
     */
    private void skillRequired(List<IndustryActivitySkills> industryActivitySkills, 
        RequiredItemsRecursionA requiredA, RamActivitiesEnum activitiesEnum){
        
        for (IndustryActivitySkills industryActivitySkill : industryActivitySkills) {
            RequiredItemsRecursionA requiredItemsRecursionA = 
                new RequiredItemsRecursionA(industryActivitySkill.getTypeID(), 
                industryActivitySkill.getSkillID(), industryActivitySkill.getLevel().byteValue() );
            
            requiredA.addMaterialRequiredRecursionB(new RequiredItemsRecursionB(requiredItemsRecursionA) );
        }
        
        
    }
        
    
    /**
     * new RequiredItemsRecursionA(invTypes.getTypeName(), materialList.getQuantity()); deve essere quella finale
     * 
     * Material required to build object
     */
    private void baseMaterialRequired(List< IndustryActivityMaterials> materialLists, 
        RequiredItemsRecursionA requiredA, RamActivitiesEnum activitiesEnum ) {
        
        for (IndustryActivityMaterials materialList : materialLists) {
            
            // get name and id            
            InvTypes invTypes =
              Manager.getInstance().db().item().invTypes().getInvTypesById(materialList.getMaterialTypeID());
            
            RequiredItemsRecursionA requiredItemsRecursionA = 
                new RequiredItemsRecursionA(invTypes.getTypeID(), invTypes.getTypeName(), materialList.getQuantity());
//                new RequiredItemsRecursionA(invTypes.getTypeName(), materialList.getQuantity());

            requiredA.addMaterialRequiredRecursionB(new RequiredItemsRecursionB(requiredItemsRecursionA));

            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);

            if (neededComponents != null)
                baseMaterialRequired(neededComponents, requiredItemsRecursionA, activitiesEnum);
            
        }
    }
    
    public void displayBaseMaterialRequired(){
        display();
        displayMap(requiredItems, "");
    }
    
    private void displayMap(RequiredItemsRecursionA requiredItems, String tab){
        System.out.println(""+ requiredItems.getTypeId() + " " + 
            requiredItems.getName() + " " + 
            requiredItems.getQuanityInt() + " - " +
            requiredItems.getQuanityDbl());
        
        tab +="\t";
        
        for (RequiredItemsRecursionB requiredItemsB : requiredItems.getMaterialRequiredRecursionBs()) {
            displayMap(requiredItemsB.getMaterialRequiredRecursionA(), tab);
        }
    }
    
    public void display(){
        InvTypes invTypes = Manager.getInstance().db().item().invTypes().getInvTypesByName(DBG_bpoName);
        System.out.println(""+ invTypes.getTypeID() + " " +invTypes.getTypeName() );
    }
    
}
