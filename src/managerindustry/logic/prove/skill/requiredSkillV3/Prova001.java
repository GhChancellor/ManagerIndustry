/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.requiredSkillV3;

/**
 *
 * @author lele
 */
public class Prova001 {
    private Integer typeId;
    private Integer attributeID;
    private String attributeName;
    private Integer valueInt;
    private Float valueFloat;
//    private boolean aaa;
 
    public Prova001(Integer typeId, Integer attributeID, String attributeName, Integer valueInt, Float valueFloat) {
        this.typeId = typeId;
        this.attributeID = attributeID;
        this.attributeName = attributeName;
        this.valueInt = valueInt;
        this.valueFloat = valueFloat;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public Integer getAttributeID() {
        return attributeID;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public Integer getValueInt() {
        return valueInt;
    }

    public Float getValueFloat() {
        return valueFloat;
    }
    
    
}
