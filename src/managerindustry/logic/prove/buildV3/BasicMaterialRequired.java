/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3;

import java.util.List;
import managerindustry.db.entities.eve.IndustryActivityMaterials;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.recursion.ItemRecursionB;
import managerindustry.logic.manager.Manager;

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

    public void displatBasicMaterial(){
        display(requiredMaterial, "");
    }
    
    /**
     * Calculate Required Item
     * @param List< IndustryActivityMaterials> materials_
     * @param RequiredMaterialRecusion requiredA_
     * @param RamActivitiesEnum activitiesEnum_ 
     */
    @Override
    protected void requiredItem(Object materials_, Object requiredA_, Object activitiesEnum_) {
        List< IndustryActivityMaterials> materials = (List< IndustryActivityMaterials>) materials_;
        RequiredMaterialRecusion requiredA = (RequiredMaterialRecusion) requiredA_; 
        RamActivitiesEnum activitiesEnum = ( RamActivitiesEnum ) activitiesEnum_;
        
        for (IndustryActivityMaterials material : materials) {
            InvTypes invTypes = getInvTypesById(material.getMaterialTypeID());
            
//            RequiredMaterialRecusion requiredItemsRecursionA = 
//                new RequiredMaterialRecusion(
//                    invTypes.getTypeID(), material.getQuantity());    

            // only for dbg, use this for more info on object
             RequiredMaterialRecusion requiredItemsRecursionA = 
                (RequiredMaterialRecusion) requiredItemMoreInfo(invTypes, material);
            
            requiredA.addRecursionB02(new ItemRecursionB(requiredItemsRecursionA));
            
            // get value blueprint component if necessary
            List< IndustryActivityMaterials> neededComponents = 
              Manager.getInstance().db().item().industryActivityMaterials().
                getMaterialNeedByName(invTypes.getTypeName() + " blueprint", activitiesEnum);
            
            
            if (neededComponents != null)
                requiredItem(neededComponents, requiredItemsRecursionA, activitiesEnum);            
        }
    }
    
    @Override
    protected void display(Object requiredItemA_, Object tab_) {
        RequiredMaterialRecusion requiredItemA = (RequiredMaterialRecusion) requiredItemA_;
        String tab = (String) tab_;
        
        if ( requiredItemA.getTypeID() != 0 )
            System.out.println(tab + requiredItemA.getTypeID() + " " + 
                requiredItemA.getTypeName()+ " " + 
                requiredItemA.getQuantity());
        
        tab +="   ";
   
        for (ItemRecursionB requiredItem : requiredItemA.getRecursionB02s()) {
            display((RequiredMaterialRecusion) requiredItem.getRecursionA02(), tab);
        }  
    }

    /**
     * Get Required Items
     * @return List<RequiredMaterialRecusion>
     */
    public List<RequiredMaterialRecusion> getRequiredItems(){
        List<RequiredMaterialRecusion> requiredMaterials = 
            (List<RequiredMaterialRecusion>) getObject();
        return requiredMaterials;
    }

    /**
     * Only for dbg, use this for more info on object
     * @param InvTypes invTypes_
     * @param IndustryActivityMaterials material_
     * @return RequiredMaterialRecusion
     */
    @Override
    protected Object requiredItemMoreInfo(Object invTypes_, Object material_) {
        InvTypes invTypes = (InvTypes) invTypes_;
        IndustryActivityMaterials material = (IndustryActivityMaterials) material_;
        
        RequiredMaterialRecusion requiredItemsRecursionA = 
            new RequiredMaterialRecusion(
                invTypes.getTypeID(), invTypes.getTypeName(), 
                material.getQuantity());
        return (RequiredMaterialRecusion) requiredItemsRecursionA;
    }

    @Override
    protected Object requiredItemMoreInfo(Object t1) {
        throw new UnsupportedOperationException("Not used"); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected void requiredItem(Object t) {
        
        throw new UnsupportedOperationException("Not used"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void requiredItem(Object t1, Object t2) {
        throw new UnsupportedOperationException("Not used"); //To change body of generated methods, choose Tools | Templates.
    }     

    /**
     * Get Object
     * @return List<RequiredMaterialRecusion>
     */
    @Override
    protected Object getObject() {
        List<RequiredMaterialRecusion> requiredMaterials = 
            getConversionToList(requiredMaterial);
        return requiredMaterials;
    }
}
