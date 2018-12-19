/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.buildRecursion;

import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.BuildItem;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.prove.recursion_object.genericRequiredItem.IGenericlRequestV2;

/**
 *
 * @author lele
 */
public class BuildItemRequired_InitV2 implements IGenericlRequestV2{

    private BuildItem_LogicV2 buildItemLogic;
    
    public BuildItemRequired_InitV2( BuildItem buildItem, RamActivitiesEnum activitiesEnum) throws ErrorExeption {
        buildItemLogic = new BuildItem_LogicV2(buildItem, activitiesEnum);
    }

    public BuildItemRequired_InitV2() {
    }
    
    /**
     * Display
     */
    @Override
    public void display(){
        buildItemLogic.display();
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
