/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill;

import managerindustry.logic.manager.old.ManagerSkill_OLD;

/**
 *
 * @author lele
 */
public class ProductionFormulas extends FormulasSkill{
    // forse è meglio production ME
    public float production( String nameSkill, int level){
        SkillV skill = ManagerSkill_OLD.getInstance().getSkillMap(nameSkill);
        FormulasSkill formulasSkill = new FormulasSkill();
        
        try {
            if (skill.getValueInt() == null ){
                return formulasSkill.calculateLevelPerSkill(level, skill.getValueFloat());
            }else{
                return formulasSkill.calculateLevelPerSkill(level, skill.getValueInt() );
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;            
        }
    }
    
}
