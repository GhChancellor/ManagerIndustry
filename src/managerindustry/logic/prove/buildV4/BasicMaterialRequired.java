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
     * @return Map < String, RequiredMaterialRecusion >
     */
    public Map < String, RequiredMaterialRecusion > getMap(){
        return basicMaterialRequired.getMap();
    }
    
    /**
     * Get List
     * @return List < RequiredMaterialRecusion >
     */
    public List < RequiredMaterialRecusion > getList(){
        return basicMaterialRequired.getList();
    }
    
    public RequiredMaterialRecusion getRequiredMaterialRecusion(){
        return (RequiredMaterialRecusion) basicMaterialRequired.getObject();
    }
}
