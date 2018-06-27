/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure;

import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.structure.engineeringRig.EngineeringRig;

/**
 *
 * @author lele
 */
public class mainEngineering {
    public static void main(String[] args) {
//        ManagerFitter managerFitter = new ManagerFitter();
        EngineeringRig engineeringRig = new EngineeringRig("Standup M-Set Blueprint Copy Accelerator II", SecurityStatusEnum.HI_SEC);
        engineeringRig.displayValue();
    }
}
