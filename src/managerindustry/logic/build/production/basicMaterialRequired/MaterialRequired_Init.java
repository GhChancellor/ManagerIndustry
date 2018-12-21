/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.basicMaterialRequired;

import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.generic.genericRequiredItem.IGenericlRequest;

/**
 *
 * @author lele
 */
public class MaterialRequired_Init implements IGenericlRequest  {
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
     * Get Required Material Object
     * @return NameBase
     */    
    @Override
    public NameBase getRequiredMaterialObject() {
        return basicMaterialRequired_Logic.getObject();
    }
    
}
