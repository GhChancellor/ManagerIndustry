/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.buildItem;

import managerindustry.logic.generic.fatherClass.BuildItem;
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
public class BuildItemRequired_Init extends RequiredMaterialGeneric{
    private BuildItem_Logic buildItemLogic;
    
    public BuildItemRequired_Init( BuildItem buildItem, RamActivitiesEnum activitiesEnum) throws ErrorExeption {
        buildItemLogic = new BuildItem_Logic(buildItem, activitiesEnum);
    }

    public BuildItemRequired_Init() {
    }
    
    /**
     * Display
     */
    @Override
    public void display(){
        buildItemLogic.display();
    }
    
    /**
     * Get Map
     * @return Map < String, NameBase >
     */    
    @Override
    public Map<String, NameBase> getMap() {
        return buildItemLogic.getTotalCalculatedItem();
    }

    /**
     * @deprecated 
     * Get List
     * @return List < NameBase >
     */    
    @Override
    public List<NameBase> getList() {
        return buildItemLogic.getList();
    }

    /**
     * Get Required Material Object
     * @return NameBase
     */    
    @Override
    public NameBase getRequiredMaterialObject() {
        return (NameBase) buildItemLogic.getObject();
    }
}
