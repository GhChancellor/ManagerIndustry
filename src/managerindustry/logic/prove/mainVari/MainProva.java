/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.mainVari;

import managerindustry.logic.enumName.RuleBonus;
import managerindustry.logic.enumName.SecurityStatusEnum;
import managerindustry.logic.enumName.Tier;
import managerindustry.logic.prove.riv_v2.RIG_V2;
import managerindustry.logic.structure.StructureEngineeringRigs;
import managerindustry.logic.unused.structure.UNUSED_Manager_Rig_GroupId;
import managerindustry.logic.unused.structure.Rig_GroupId.UNUSED_Rig_GroupId;

/**
 *
 * @author lele
 */
public class MainProva {
    public static void main(String[] args) {
        StructureEngineeringRigs engineeringRigs = new StructureEngineeringRigs(Tier.T1, RuleBonus.HI_SEC, SecurityStatusEnum.HI_SEC);
    }
}
