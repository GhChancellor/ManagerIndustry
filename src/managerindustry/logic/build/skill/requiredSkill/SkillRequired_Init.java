/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.build.skill.requiredSkill;

import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.generic.genericRequiredItem.IGenericlRequest;

/**
 *
 * @author lele
 */
public class SkillRequired_Init implements IGenericlRequest < SkillInfo > {
    private SkillRequired_Logic skillRequiredLogic;

    public SkillRequired_Init() {
    }
    
    public SkillRequired_Init(int typeId, RamActivitiesEnum activitiesEnum) {
        this.skillRequiredLogic = new SkillRequired_Logic(typeId, activitiesEnum);
    }
    
    @Override
    public void display() {
        skillRequiredLogic.display();
    }

    @Override
    public SkillInfo getRequiredMaterialObject() {
        return skillRequiredLogic.getObject();
    }    
}
