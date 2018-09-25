/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill;

import managerindustry.logic.generic.exception.ErrorExeption;

/**
 *
 * @author lele
 */
public class SkillProduction {
    private enum SkillProductionEnum{
        INDUSTRY( (short) 3380, (short) 440, true),
        ADVANCED_INDUSTRY( (short) 3388, (short) 1982, true),
        ADVANCED_SMALL_SHIP_CONSTRUCTION( (short) 3395, (short) 1982, true),
        ADVANCED_MEDIUM_SHIP_CONSTRUCTION( (short) 3397, (short) 1982, true),
        ADVANCED_LARGE_SHIP_CONSTRUCTION( (short) 3398, (short) 1982, true),
        ADVANCED_INDUSTRIAL_SHIP_CONSTRUCTION( (short) 3396, (short) 1982, true),
        
        // Science skills with 1% reduction in manufacturing time per level
        AMARR_STARSHIP_ENGINEERING( (short) 11444, (short) 1982, true),
        CALDARI_STARSHIP_ENGINEERING( (short) 11454, (short) 1982, true),
        GALLENTE_STARSHIP_ENGINEERING( (short) 11450, (short) 1982, true),
        MINMATAR_STARSHIP_ENGINEERING( (short) 11445, (short) 1982, true),
        
        ELECTROMAGNETIC_PHYSICS( (short) 11448, (short) 1982, true),
        ELECTRONIC_ENGINEERING( (short) 11453, (short) 1982, true),
        GRAVITON_PHYSICS( (short) 11446, (short) 1982, true),
        HIGH_ENERGY_PHYSICS( (short) 11433, (short) 1982, true),
        HYDROMAGNETIC_PHYSICS( (short) 11443, (short) 1982, true),
        LASER_PHYSICS( (short) 11447, (short) 1982, true),
        MECHANICAL_ENGINEERING( (short) 11452, (short) 1982, true),
        MOLECULAR_ENGINEERING( (short) 11529, (short) 1982, true),
        NANITE_ENGINEERING( (short) 11442, (short) 1982, true),      
        NUCLEAR_PHYSICS( (short) 11451, (short) 1982, true),
        PLASMA_PHYSICS( (short) 11441, (short) 1982, true),
        ROCKET_SCIENCE( (short) 11449, (short) 1982, true),      
        QUANTUM_PHYSICS( (short) 11455, (short) 1982, true),
        
        SCIENCE( (short) 3402, (short) 1982, true), // blueprint copy speed
        RESEARCH( (short) 3403, (short) 1982, true), // manufacturing time
        METALLURGY( (short) 3409, (short) 1982, true); // manufacturing time
        
        private short skillID;
        private short attributeID;
        private boolean published;
        
        private SkillProductionEnum skillProduction;

        private SkillProductionEnum(SkillProductionEnum skillProduction) {
            this.skillProduction = skillProduction;
        }

        private SkillProductionEnum(short skillID, short attributeID, boolean published) {
            this.skillID = skillID;
            this.attributeID = attributeID;
            this.published = published;
        }

        public int getSkillID() {
            return skillID;
        }

        public short getAttributeID() {
            return attributeID;
        }

        public boolean isPublished() {
            return published;
        }                
    }    
    
    private float calculateLevelPerSkill(byte level, float percente) throws ErrorExeption{
        if ( level >= 0 && level <= 5 ){
            return level * percente;
        }else{
            throw new ErrorExeption(ErrorExeption.ErrorExeptionEnum.MAX_VALUE_SKILL_EXCEEDED);
        }
    }

    
}
