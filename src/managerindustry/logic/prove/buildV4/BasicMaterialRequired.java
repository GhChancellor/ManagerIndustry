/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV4;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.exception.ErrorExeption;

/**
 *
 * @author lele
 */
public class BasicMaterialRequired {
    private  BasicMaterialRequiredLogic basicMaterialRequired;
    
    public BasicMaterialRequired(String bpoName, RamActivitiesEnum activitiesEnum)
            throws ErrorExeption {
        
        this.basicMaterialRequired = new BasicMaterialRequiredLogic(bpoName, activitiesEnum);
    }
    
    public void display(){
        basicMaterialRequired.display();
    }
    
    public Map < String, BasicMaterialRequiredLogic > getMap(){
        return basicMaterialRequired.getMap();
    }
    
    public List < BasicMaterialRequiredLogic > getList(){
        return basicMaterialRequired.getList();
    }
}
