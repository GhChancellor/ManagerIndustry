/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.production.buildItem;

import managerindustry.logic.fitter.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.BuildItem;
import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.generic.genericRequiredItem.IGenericlRequest;

/**
 *
 * @author lele
 */
public class BuildItemRequired_Init implements IGenericlRequest{

    private BuildItem_Logic buildItemLogic;
    
    public BuildItemRequired_Init( BuildItem buildItem, 
            RamActivitiesEnum activitiesEnum,  
            EngineeringComplex engineeringComplex, EngineeringRig engineeringRig) throws ErrorExeption {
        
        buildItemLogic = new BuildItem_Logic(buildItem, activitiesEnum, 
            engineeringComplex, engineeringRig);
        
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
     * Get Required Material Object
     * @return NameBase
     */    
    @Override
    public NameBase getRequiredMaterialObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
