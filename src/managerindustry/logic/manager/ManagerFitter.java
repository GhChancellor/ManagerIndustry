/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import managerindustry.logic.exception.ErrorExeption;
import managerindustry.logic.fitter.Fitter;

/**
 *
 * @author lele
 */
public class ManagerFitter {

    public ManagerFitter() throws ErrorExeption {
        Fitter fitter = new Fitter();
    }
    
    
}
// EngineeringRig_OLD engineeringRigs = new EngineeringRig_OLD(TierEnum.T2, RuleBonusRigEnum.RIG_TIME_EFFICIENCY, SecurityStatusEnum.NULL_SEC);