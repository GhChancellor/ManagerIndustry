/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.skillRequired;

import managerindustry.logic.generic.enumName.RamActivitiesEnum;
import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.prove.recursion_object.genericRequiredItem.IGenericlRequestV2;

/**
 *
 * @author lele
 */
public class SkillRequired_InitV2 implements IGenericlRequestV2{
    private SkillRequired_LogicV2 skillRequiredLogic;

    public SkillRequired_InitV2() {
    }
    
    public SkillRequired_InitV2(int typeId, RamActivitiesEnum activitiesEnum) {
        this.skillRequiredLogic = new SkillRequired_LogicV2(typeId, activitiesEnum);
    }
    
    @Override
    public void display() {
        skillRequiredLogic.display();
    }

    @Override
    public SkillInfo getRequiredMaterialObject() {
        return (SkillInfo) skillRequiredLogic.getObject();
    }    
}
