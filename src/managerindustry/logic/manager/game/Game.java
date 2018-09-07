/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.game;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.game.build.old.Build_OLD;
import managerindustry.logic.manager.game.fitter.Fitter;
import managerindustry.logic.prove.skill.old.Skill_OLD;
import managerindustry.logic.manager.game.tax.SystemCost;
import managerindustry.logic.build.buildItem.BuildItemRequired_Init;

/**
 *
 * @author lele
 */
public class Game {
    
    public BuildItemRequired_Init buildItemRequired(){
        BuildItemRequired_Init buildItemRequired = new BuildItemRequired_Init();
        return buildItemRequired;
    }
            
    /**
     * @deprecated 
     * Build
     * @return Build_OLD
     */
    public Build_OLD build_OLD(){
        Build_OLD build = new Build_OLD();
        return build;
    }

    /**
     * Skill_OLD
     * @return Skill_OLD
     */
    public Skill_OLD skill(){
        Skill_OLD skill = new Skill_OLD();
        return skill;
    }
    
    /**
     * @deprecated 
     * System Cost
     * @return SystemCost
     */
    public SystemCost systemCost() throws SolarSystemNotExistsException{
        try {
            SystemCost systemCost = new SystemCost();
            return systemCost;            
        } catch (SolarSystemNotExistsException e) {
            System.out.println(""+ e.getMessage());
            return new SystemCost();
        }

    }
    
    public Fitter fitter() throws ErrorExeption{
        Fitter fitter = new Fitter();
        return fitter;
    }
}
