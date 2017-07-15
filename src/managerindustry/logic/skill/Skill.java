/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill;

/**
 *
 * @author lele
 */
public class Skill {
    private String name;
    private String description;
    private float valueFloat;
    private int valueInt;
    private int startingValue;

    public Skill() {
    }
    
    public Skill(String nameSkill){
        this.name = nameSkill;
    }

    public int getStartingValue() {
        return startingValue;
    }

    public void setStartingValue(int startingValue) {
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
     * @param int valueInt 
     */
    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
    }

  
}
