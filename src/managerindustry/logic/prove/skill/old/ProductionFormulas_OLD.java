/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.old;

import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.skill.old.Skill_OLD;
/**
 *
 * @author lele
 */
public class ProductionFormulas_OLD extends FormulasSkill_OLD{
    // forse è meglio production ME
    public float production( String nameSkill, byte level){
        SkillX_OLD skill = Manager.getInstance().game().skill().getSkillMap(nameSkill);
        FormulasSkill_OLD formulasSkill = new FormulasSkill_OLD();
        
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
