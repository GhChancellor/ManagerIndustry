/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.old;

import managerindustry.logic.generic.exception.ErrorExeption;

/**
 *
 * @author lele
 */
public class FormulasSkill_OLD {
       
    /**
     * Calculate Level Per Skill
     * @param byte level
     * @param float percente
     * @return float
     */
    protected float calculateLevelPerSkill(byte level, float percente) {
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
