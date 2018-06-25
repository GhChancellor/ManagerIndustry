/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import managerindustry.logic.enumName.PlatformEnum;
import managerindustry.logic.enumName.RuleBonusRigEnum;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.enumName.TierEnum;
import managerindustry.logic.fitter.Fitter;
import managerindustry.logic.structure.engineeringComplex.EngineeringComplex;
import managerindustry.logic.structure.structureEngineeringRigs.StructureEngineeringRigs;

/**
 *
 * @author lele
 */
public class ManagerFitter {

    public ManagerFitter() {
        Fitter fitter = new Fitter();
    }
    
    
}
// StructureEngineeringRigs engineeringRigs = new StructureEngineeringRigs(TierEnum.T2, RuleBonusRigEnum.RIG_TIME_EFFICIENCY, SecurityStatusEnum.NULL_SEC);