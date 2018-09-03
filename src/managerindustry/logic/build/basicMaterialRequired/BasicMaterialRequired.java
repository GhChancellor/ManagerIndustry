/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.basicMaterialRequired;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.nameBase.NameBase;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterialGeneric;

/**
 *
 * @author lele
 */
public class BasicMaterialRequired extends RequiredMaterialGeneric{
    private BasicMaterialRequiredLogic basicMaterialRequired;
    
    /**
     * Basic Material Required
     * @param String bpoName
     * @param RamActivitiesEnum activitiesEnum
     * @throws ErrorExeption 
     */
    public BasicMaterialRequired(String bpoName, RamActivitiesEnum activitiesEnum) throws ErrorExeption{
        this.basicMaterialRequired = new BasicMaterialRequiredLogic(bpoName, activitiesEnum);
    }    

    public BasicMaterialRequired() {
    }
    
    /**
     * Display
     */ 
    @Override
    public void display() {
        basicMaterialRequired.display();
    }

    /**
     * Get Map
     * @return Map < String, NameBase >
     */  
    @Override
    public Map<String, NameBase> getMap() {
        return basicMaterialRequired.getMap();
    }

    /**
     * Get List
     * @return List < NameBase >
     */
    @Override
    public List<NameBase> getList() {
        return basicMaterialRequired.getList();
    }

    /**
     * Get Required Material Object
     * @return NameBase
     */    
    @Override
    public NameBase getRequiredMaterialObject() {
        return (NameBase) basicMaterialRequired.getObject();
    }

  
    
}
