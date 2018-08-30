/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV5.basicMaterial;

import managerindustry.logic.generic.nameBase.NameBase;
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
    
    /**
     * Basic Material Required
     * @param String bpoName
     * @param RamActivitiesEnum activitiesEnum
     * @throws ErrorExeption 
     */
    public BasicMaterialRequired(String bpoName, RamActivitiesEnum activitiesEnum)
            throws ErrorExeption {        
        this.basicMaterialRequired = new BasicMaterialRequiredLogic(bpoName, activitiesEnum);
    }
    
    /**
     * Display
     */
    public void display(){
        basicMaterialRequired.display();
    }
    
    /**
     * Get Map
     * @return Map < String, NameBase >
     */
    public Map < String, NameBase > getMap(){
        return basicMaterialRequired.getMap();
    }
    
    /**
     * Get List
     * @return List < NameBase >
     */
    public List < NameBase > getList(){
        return basicMaterialRequired.getList();
    }
    
    public NameBase getRequiredMaterialRecusion(){
        return (NameBase) basicMaterialRequired.getObject();
    }
}
