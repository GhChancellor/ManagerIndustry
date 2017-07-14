/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill;

import java.util.logging.Level;
import java.util.logging.Logger;
import managerindustry.logic.exception.MaximumValueSkillexceededException;

/**
 *
 * @author lele
 */
public class FormulasSkill {
       
    /**
     * DGB Aggiungere eccezione
     * Calculate Level Per Skill
     * @param int level
     * @param float percente
     * @return float
     */
    protected float calculateLevelPerSkill(int level, float percente) {
        if ( level >= 0 && level <= 5){
            return level * percente;
        }
        return 0.0f;
    }
    
    public float calculateResultWithSkill( float initialValue, int levelSkill, float percente){
        float result = calculateLevelPerSkill(levelSkill, percente);
        
        return initialValue * result;
    }
    
    
}
