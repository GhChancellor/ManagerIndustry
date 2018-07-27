/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.old;

import managerindustry.logic.apiEsi.skill.characterSkills.SkillRaw;

/**
 *
 * @author lele
 */
public class SkillX_OLD{
    // se usi nel DB new select ..... usa sempre Integer, Double, Float 
    private Float valueFloat; 
    private Integer valueInt;
    
    private String name;
    private String description;
    private float startingValue;  
    public SkillX_OLD(String name, String description, Float valueFloat, Integer valueInt) {
        this.name = name;
        this.description = description;
        this.valueFloat = valueFloat;
        this.valueInt = valueInt;
    }
    
    public SkillX_OLD(String name) {
        this.name = name;
    }

    /**
     * Get Starting Value
     * @return float
     */
    public float getStartingValue() {
        return startingValue;
    }

    /**
     * Set Starting Value
     * @param int startingValue 
     */
    public void setStartingValue(float startingValue) {
        this.startingValue = startingValue;
    }

    /**
     * Get Name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name
     * @param String name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Description
     * @return String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set Description
     * @param String description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get Value Float
     * @return Float
     */
    public Float getValueFloat() {
        return valueFloat;
    }

    /**
     * Set Value Float
     * @param float valueFloat 
     */
    public void setValueFloat(float valueFloat) {
        this.valueFloat = valueFloat;
    }

    /**
     * Get Value Int
     * @return Integer
     */
    public Integer getValueInt() {
        return valueInt;
    }

    /**
     * Set Value Int
     * @param Int valueInt 
     */
    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }
  
}
