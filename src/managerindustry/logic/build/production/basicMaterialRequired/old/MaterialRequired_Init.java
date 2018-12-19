/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.basicMaterialRequired.old;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterialGeneric;

/**
 *
 * @author lele
 */
public class MaterialRequired_Init extends RequiredMaterialGeneric{
    private BasicMaterialRequired_Logic basicMaterialRequired_Logic;
    
    /**
     * Basic Material Required
     * @param String bpoName
     * @param RamActivitiesEnum activitiesEnum
     * @throws ErrorExeption 
     */
    public MaterialRequired_Init(String bpoName, RamActivitiesEnum activitiesEnum)
            throws ErrorExeption{
        this.basicMaterialRequired_Logic = 
            new BasicMaterialRequired_Logic(bpoName, activitiesEnum);
    }    

    public MaterialRequired_Init() {
    }
    
    /**
     * Display
     */ 
    @Override
    public void display() {
        basicMaterialRequired_Logic.display();
    }

    /**
     * Get Map
     * @return Map < String, NameBase >
     */  
    @Override
    public Map<String, NameBase> getMap() {
        return basicMaterialRequired_Logic.getMap();
    }

    /**
     * Get List
     * @return List < NameBase >
     */
    @Override
    public List<NameBase> getList() {
        return basicMaterialRequired_Logic.getList();
    }

    /**
     * Get Required Material Object
     * @return NameBase
     */    
    @Override
    public NameBase getRequiredMaterialObject() {
        return (NameBase) basicMaterialRequired_Logic.getObject();
    }

  
    
}
