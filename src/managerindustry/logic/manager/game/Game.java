/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.game;

import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.exception.SolarSystemNotExistsException;
import managerindustry.logic.manager.game.build.Build;
import managerindustry.logic.manager.game.fitter.Fitter;
import managerindustry.logic.prove.skill.old.Skill_OLD;
import managerindustry.logic.manager.game.tax.SystemCost;

/**
 *
 * @author lele
 */
public class Game {
    /**
     * Build
     * @return Build
     */
    public Build build(){
        Build build = new Build();
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
