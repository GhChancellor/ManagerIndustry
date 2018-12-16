/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.basicRecursionRequired;

import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.prove.recursion_object.genericRequiredItem.IGenericlRequestV2;

/**
 *
 * @author lele
 */
public class MaterialRequired_InitV2 implements IGenericlRequestV2  {
    private BasicMaterialRequired_LogicV2 basicMaterialRequired_Logic;
    
    /**
     * Basic Material Required
     * @param String bpoName
     * @param RamActivitiesEnum activitiesEnum
     * @throws ErrorExeption 
     */
    public MaterialRequired_InitV2(String bpoName, RamActivitiesEnum activitiesEnum)
            throws ErrorExeption{
        this.basicMaterialRequired_Logic = 
            new BasicMaterialRequired_LogicV2(bpoName, activitiesEnum);
    }    

    public MaterialRequired_InitV2() {
    }
    
    /**
     * Display
     */ 
    @Override
    public void display() {
        basicMaterialRequired_Logic.display();
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
