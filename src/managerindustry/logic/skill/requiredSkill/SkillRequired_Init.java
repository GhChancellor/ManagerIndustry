/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill.requiredSkill;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.generic.genericRequiredItem.skillRequied.RequiredSkillGeneric;

/**
 *
 * @author lele
 */
public class SkillRequired_Init extends RequiredSkillGeneric{
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
    public Map < String, SkillInfo > getMap() {
        return skillRequiredLogic.getMap();
    }

    @Override
    public List < SkillInfo > getList() {
        return skillRequiredLogic.getList();
    }

    @Override
    public SkillInfo getRequiredMaterialObject() {
        return (SkillInfo) skillRequiredLogic.getObject();
    }
    
}
