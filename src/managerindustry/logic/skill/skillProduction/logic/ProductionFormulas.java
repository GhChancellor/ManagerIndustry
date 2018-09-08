/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill.skillProduction.logic;

import managerindustry.logic.generic.exception.ErrorExeption;
import managerindustry.logic.generic.fatherClass.SkillInfo;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class ProductionFormulas {

    public ProductionFormulas() {
    }
    
    /**
     * Production Me
     * @param String nameSkill
     * @param byte level
     * @return 
     */
    public float productionMe( String nameSkill, byte level){
        SkillInfo skill = Manager.getInstance().game().skillProduction().getSkillMap(nameSkill);
        
        try {
            if (skill.getValueInt() == null ){
                return calculateLevelPerSkill(level, skill.getValueFloat());
            }else{
                return calculateLevelPerSkill(level, skill.getValueInt() );
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            return 0;            
        }
    }

    /**
     * Calculate Level Per Skill
     * @param byte level
     * @param float percente
     * @return float
     */
    public float calculateLevelPerSkill(byte level, float percente) {
        try {
            if ( level >= 0 && level <= 5){
                return level * percente;
            }else{
                throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_VALUE_SKILL_EXCEEDED);
            }
        } catch (ErrorExeption ex) {
            System.out.println(""+ex.getMessage());
            return 0.0f;
        }
    }
    
    /**
     * Calculate Result With Skill
     * @param float initialValue
     * @param byte levelSkill
     * @param float percente
     * @return 
     */
    public float calculateResultWithSkill( float initialValue, byte levelSkill, float percente){
        float result = calculateLevelPerSkill(levelSkill, percente);
        return initialValue * result;
    }    
}
