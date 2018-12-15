/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.fatherClass;

import managerindustry.logic.generic.fatherClass.recursion.ItemRecursion;

/**
 * Skill info like id level etc...
 * @author lele
 */
public class SkillInfo extends ItemRecursion {
    // se usi nel DB new select ..... usa sempre Integer, Double, Float 
    private Integer typeID;
    private Integer valueInt;
    private Integer requiredSkillLevel;
    private String requireSkillNameLevel;
    private Float valueFloat;
    private String description;
    private String typeName;

    private float startingValue;   
    
    public SkillInfo(String typeName) {
        this.typeName = typeName;
    }
    
    /**
     * Skill Info used from SkillRequired_Logic
     * @param Integer typeID 
     * @param String typeName
     * @param Integer childSkill
     * @param String requireSkillNameLevel
     * @param Integer requiredSkillLevel      
     */    
    public SkillInfo(Integer typeID, String typeName, Integer childSkill, 
        String requireSkillNameLevel, Integer requiredSkillLevel) {
        
        this.typeID = typeID;
        this.typeName = typeName;
        this.valueInt = childSkill;
        this.requireSkillNameLevel = requireSkillNameLevel;
        this.requiredSkillLevel = requiredSkillLevel;
    }
    
    /**
     * Skill Info used from SkillProduction, InvTypes.findByTypeId-Published-AttributeID 
     * SELECT NEW managerindustry.logic.generic.fatherClass.SkillInfo
     * @param Integer typeID
     * @param String typeName
     * @param String description
     * @param Integer valueInt
     * @param Float valueFloat 
     */
    public SkillInfo(Integer typeID, String typeName, String description, 
            Integer valueInt, Float valueFloat ) {
        this.typeID = typeID;
        this.valueInt = valueInt;
        this.valueFloat = valueFloat;
        this.description = description;
        this.typeName = typeName;
    }    
        
    public SkillInfo() {
    }
    
    /**
     * Father skill
     * @return int
     */
    public Integer getTypeID() {
        return typeID;
    }

    /**
     * Set Father skill
     * @param int typeID 
     */
    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }
    
    /**
     * Get Required Skill Level
     * @return int
     */
    public Integer getRequiredSkillLevel() {
        return requiredSkillLevel;
    }    
    
    /**
     * Set Required Skill Level
     * @param int requiredSkillLevel 
     */
    public void setRequiredSkillLevel(int requiredSkillLevel) {
        this.requiredSkillLevel = requiredSkillLevel;
    }

    /**
     * Get Child skill
     * @return int
     */
    public Integer getValueInt() {
        return valueInt;
    }
    
    /**
     * Set Child skill
     * @param int valueInt 
     */
    public void setValueInt(int valueInt) {
        this.valueInt = valueInt;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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
     * Get Require Skill Name Level
     * @return String
     */
    public String getRequireSkillNameLevel() {
        return requireSkillNameLevel;
    }

    /**
     * Set Require Skill Name Level
     * @param String requireSkillNameLevel 
     */
    public void setRequireSkillNameLevel(String requireSkillNameLevel) {
        this.requireSkillNameLevel = requireSkillNameLevel;
    }
    
}
