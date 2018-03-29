/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson.skill.characterSkills;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class SkillsDeserializer implements JsonDeserializer<Skills>{
    private List < Skills > skillses = new ArrayList<>();

    public SkillsDeserializer() {
    }
    
    @Override
    public Skills deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        try {
            JsonObject jsonObject = je.getAsJsonObject();
            String total_sp = jsonObject.get("total_sp").getAsString();
            
            SkillRaw[] skillRaws = jdc.deserialize(jsonObject.get("skills"), SkillRaw[].class );         
            Skills skill = new Skills(skillRaws, total_sp);
            
            
            return skill;            
        } catch (Exception e) {
            e.printStackTrace();
            return null;        
        }     
    }    
}