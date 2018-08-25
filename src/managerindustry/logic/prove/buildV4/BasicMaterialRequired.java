/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV4;

import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.recursion.ItemRecursionA;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.buildV3.RequiredMaterialRecusion;

/**
 *
 * @author lele
 */
public class BasicMaterialRequired extends GenericRequiredItem{
    private RequiredMaterialRecusion requiredMaterial = new RequiredMaterialRecusion(); 
    /**
     * 
     * @param String bpoName
     * @param int run <<---- controllare se si può mettere in byte
     * @param int job <<---- controllare se si può mettere in byte
     * @param byte bpoME
     * @param byte componentMe 
     */    
    public BasicMaterialRequired(String bpoName, RamActivitiesEnum activitiesEnum)
            throws ErrorExeption {
        
        bpoName += " blueprint";
        
        InvTypes invTypes = getInvTypesByName(bpoName);
        if ( invTypes == null )
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.ITEM_NOT_EXITS);

        // list material to build an item
        List< IndustryActivityMaterials> materials = 
            Manager.getInstance().db().item().industryActivityMaterials().getMaterialsID(invTypes.getTypeID(), activitiesEnum);

        requiredItem(materials, requiredMaterial, activitiesEnum);        
    }

    /**
     * Calculate Required Item
     * @param List< IndustryActivityMaterials> materials_
     * @param RequiredMaterialRecusion requiredA_
     * @param RamActivitiesEnum activitiesEnum_ 
     */
    @Override
    public void requiredItem(Object materials_, Object requiredA, Object activitiesEnum_) {
        
        List< IndustryActivityMaterials> materials = (List< IndustryActivityMaterials>) materials_;
                        
        RamActivitiesEnum activitiesEnum = ( RamActivitiesEnum ) activitiesEnum_;
        
        for (IndustryActivityMaterials material : materials) {
            InvTypes invTypes = getInvTypesById(material.getMaterialTypeID());
            
//            RequiredMaterialRecusion requiredItemsRecursionA = 
//                new RequiredMaterialRecusion(
//                    invTypes.getTypeID(), material.getQuantity());    

            // only for dbg, use this for more info on object
             RequiredMaterialRecusion requiredItemsRecursionA = 
                (RequiredMaterialRecusion) requiredItemMoreInfo(invTypes, material);
             
            ((RequiredMaterialRecusion) requiredA).addItemRecursionAs(new ItemRecursionA(requiredItemsRecursionA));
            
            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().
                getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);
                        
            if (neededComponents != null)
                requiredItem(neededComponents, requiredItemsRecursionA, activitiesEnum);            
        }
    }

    public BasicMaterialRequired() {
    }

    @Override
    public void display() {
        displayBasicMaterialRecursion(requiredMaterial, "");
    }

    /**
     * Only for dbg, use this for more info on object
     * @param InvTypes invTypes_
     * @param IndustryActivityMaterials material_
     * @return RequiredMaterialRecusion
     */
    @Override
    public Object requiredItemMoreInfo(Object invTypes_, Object material_) {
        System.err.print("BasicMaterialRequired > requiredItemMoreInfo is ENABLE!!!");
        
        InvTypes invTypes = (InvTypes) invTypes_;
        IndustryActivityMaterials material = (IndustryActivityMaterials) material_;
        
        RequiredMaterialRecusion requiredItemsRecursionA = 
            new RequiredMaterialRecusion(
                invTypes.getTypeID(), invTypes.getTypeName(), 
                material.getQuantity());
        return (RequiredMaterialRecusion) requiredItemsRecursionA;
    }    
    
    
    /**
     * Display Material recursion
     * @param RequiredMaterialRecusion requiredItemA
     * @param String tab 
     */
    private void displayBasicMaterialRecursion(RequiredMaterialRecusion requiredItemA, String tab){
        if ( requiredItemA.getTypeID() != 0 ){
            System.out.println(tab + requiredItemA.getTypeID() + " " + 
            requiredItemA.getTypeName()+ " " + requiredItemA.getQuantity());              
        }

        tab += " ";        
        
        for (ItemRecursionA requiredItem : requiredItemA.getItemRecursionAs()) {
            displayBasicMaterialRecursion(
                (RequiredMaterialRecusion) requiredItem.getRecursionA02(), tab);
        }         
    }        
    
    /**
     * Get InvTypes By Name
     * @param String bpoName
     * @return InvTypes
     */
    protected InvTypes getInvTypesByName(String bpoName) {
        return Manager.getInstance().db().item().invTypes().getInvTypesByName(bpoName);
    }
    
    /**
     * Get InvTypes By Id
     * @param int typeId
     * @return InvTypes
     */
    protected InvTypes getInvTypesById(int typeId) {    
        return Manager.getInstance().db().item().invTypes().getInvTypesById(typeId);
    }     

    @Override
    protected void pharseBasicMaterialToMap(Object a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void pharseBasicMaterialToList(Object a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
