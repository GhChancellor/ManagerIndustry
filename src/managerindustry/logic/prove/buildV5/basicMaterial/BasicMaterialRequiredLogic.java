/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV5.basicMaterial;

import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.genericRequiredItem.AGenericRequiredItem;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class BasicMaterialRequiredLogic extends AGenericRequiredItem{
    private RequiredMaterialRecusion requiredMaterial = new RequiredMaterialRecusion(); 
    
    /**
     * Basic Material Required Logic
     * @param String bpoName
     * @param RamActivitiesEnum activitiesEnum
     */    
    public BasicMaterialRequiredLogic(String bpoName, RamActivitiesEnum activitiesEnum)
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
    public void requiredItem(Object materials, Object requiredA, Object activitiesEnum) {
        
        for (IndustryActivityMaterials material : (List< IndustryActivityMaterials>) materials) {
            InvTypes invTypes = getInvTypesById(material.getMaterialTypeID());
        
//            RequiredMaterialRecusion requiredItemsRecursionA = 
//                new RequiredMaterialRecusion(
//                    invTypes.getTypeID(), material.getQuantity()); 

            // only for dbg, use this for more info on object
            RequiredMaterialRecusion requiredItemsRecursionA = 
                (RequiredMaterialRecusion) requiredItemMoreInfo(invTypes, material);

            ((RequiredMaterialRecusion) requiredA).addItemRecursionAs(requiredItemsRecursionA);
            
            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().
                getMaterialNeedByName(invTypes.getTypeName() + " blueprint", ( RamActivitiesEnum ) activitiesEnum);
                        
            if (neededComponents != null)
                requiredItem(neededComponents, requiredItemsRecursionA, ( RamActivitiesEnum ) activitiesEnum);   
        }    
    }
    
    public BasicMaterialRequiredLogic() {
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
        
        for (Object materialRecusion : requiredItemA.getItemRecursionAs()) {
            displayBasicMaterialRecursion((RequiredMaterialRecusion) materialRecusion, tab);
        } 
    }
    
    public Map < String, RequiredMaterialRecusion > getMap(){
        pharseToMap();
        return super.getMap();
    }
    
    public List < RequiredMaterialRecusion > getList(){
        pharseToList();
        return super.getList();
    }
    
    @Override
    public Object getObject() {
        return requiredMaterial;
    }  

    @Override
    public void pharseToMap() {
        addMapElement( requiredMaterial.getTypeName(),requiredMaterial);
    }

    @Override
    public void pharseToList() {
        addListElement( requiredMaterial );
    }
}
