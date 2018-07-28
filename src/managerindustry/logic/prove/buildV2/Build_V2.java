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
import managerindustry.logic.build.ComponentX;
import managerindustry.logic.build.MaterialForComponents;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.ErrorExeption.ErrorExeptionEnum;
import managerindustry.logic.generic.recursion.ItemRecursionB;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class Build_V2 {
    private RequiredMaterialRecusion requiredItems;
    private RequiredSkillRecusion requiredSkill;
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
        

        RequiredMaterialRecusion requiredItems = new RequiredMaterialRecusion();
        baseMaterialRequired(materialLists, requiredItems, activitiesEnum);

        RequiredSkillRecusion requiredSkill = new RequiredSkillRecusion();
        skillRequired(industryActivitySkills, requiredSkill, activitiesEnum);

        this.requiredItems = requiredItems;
        this.requiredSkill = requiredSkill;
        System.out.println("");
    }
    
    /**
     * required skill to build object
     * @param List<IndustryActivitySkills> industryActivitySkills industryActivitySkills
     * @param RequiredSkillRecusion requiredA requiredA
     * @param RamActivitiesEnum activitiesEnum 
     */
    private void skillRequired(List<IndustryActivitySkills> industryActivitySkills,
        RequiredSkillRecusion requiredA, RamActivitiesEnum activitiesEnum){
        
        for (IndustryActivitySkills industryActivitySkill : industryActivitySkills) {

            
            RequiredSkillRecusion requiredSkillRecusion = 
                new RequiredSkillRecusion(
                industryActivitySkill.getTypeID(), getName(industryActivitySkill.getTypeID()),
                        
                industryActivitySkill.getSkillID(), getName(industryActivitySkill.getSkillID()),
                industryActivitySkill.getLevel().byteValue() );            
            
            requiredA.addRecursionB02(new ItemRecursionB(requiredSkillRecusion));
            
            List<IndustryActivitySkills> recursion = 
                Manager.getInstance().db().item().industryActivitySkills().getRequiredSkill(
                industryActivitySkill.getSkillID(), activitiesEnum);
            
            if (!recursion.isEmpty())
                skillRequired(recursion, requiredA, activitiesEnum);            
        }
    }
        
    private String getName(int typeId){
        return Manager.getInstance().db().item().invTypes().getInvTypesById(
            typeId).getTypeName();
    }
    /**
     * new RequiredItemsRecursionA_OLD(invTypes.getTypeName(), materialList.getQuantity()); deve essere quella finale
     * Material required to build object
     */
    private void baseMaterialRequired(List< IndustryActivityMaterials> materialLists, 
        RequiredMaterialRecusion requiredA, RamActivitiesEnum activitiesEnum ) {
        
        for (IndustryActivityMaterials materialList : materialLists) {
            
            // get name and id            
            InvTypes invTypes =
              Manager.getInstance().db().item().invTypes().getInvTypesById(materialList.getMaterialTypeID());
            
            RequiredMaterialRecusion requiredItemsRecursionA = 
                new RequiredMaterialRecusion(invTypes.getTypeID(), invTypes.getTypeName(), materialList.getQuantity());
//                new RequiredMaterialRecusion(invTypes.getTypeName(), materialList.getQuantity());

            requiredA.addRecursionB02(new ItemRecursionB(requiredItemsRecursionA));
            
            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);

            if (neededComponents != null)
                baseMaterialRequired(neededComponents, requiredItemsRecursionA, activitiesEnum);
            
        }
    }
    
    public void displayBaseMaterialRequired(){
        displayBaseMaterialRequired_(requiredItems, "");        
    }
    
    private void displayRequiredSkill( ){
        displayRequiredSkill_(requiredSkill, "");
    }
    
    private void displayRequiredSkill_( RequiredSkillRecusion requiredSkillA, String tab){
        
        System.out.println("" + 
            requiredSkillA.getTypeIdSkill() + " " +
            requiredSkillA.getNameSkill() + " - " +
            requiredSkillA.getRequiredSKillId() + " " +
            requiredSkillA.getRequiredSKillName() + " " +
            requiredSkillA.getLevel() );
        
        tab += tab;
        
        for (ItemRecursionB recursionB02 : requiredSkillA.getRecursionB02s()) {
            displayRequiredSkill_( (RequiredSkillRecusion) recursionB02.getRecursionA02(), tab);
        }
    }
    
    private void displayBaseMaterialRequired_(RequiredMaterialRecusion requiredItemA, String tab){
        System.out.println(""+ requiredItemA.getTypeID() + " " + 
            requiredItemA.getTypeName()+ " " + 
            requiredItemA.getQuantity()+ " - " +
            requiredItemA.getQuanityDbl());
        
        tab +="\t";
        
        for (ItemRecursionB requiredItem : requiredItemA.getRecursionB02s()) {
            displayBaseMaterialRequired_((RequiredMaterialRecusion) requiredItem.getRecursionA02(), tab);
        }
                
        
    }
    
    public void display(){
        InvTypes invTypes = Manager.getInstance().db().item().invTypes().getInvTypesByName(DBG_bpoName);
        System.out.println(""+ invTypes.getTypeID() + " " +invTypes.getTypeName() );
        
//        displayBaseMaterialRequired();
        displayRequiredSkill();
    }
    
}
