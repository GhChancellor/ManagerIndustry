/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsi.skill.characterSkills;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

/**
 *
 * @author lele
 */
public class SkillRawDeserializer implements JsonDeserializer<SkillRaw> {

    @Override
    public SkillRaw deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = je.getAsJsonObject();
        String current_skill_level = jsonObject.get("current_skill_level").getAsString();
        String skill_id = jsonObject.get("skill_id").getAsString();
        String skillpoints_in_skill = jsonObject.get("skillpoints_in_skill").getAsString();
        
        SkillRaw skills = new SkillRaw(current_skill_level, skill_id, skillpoints_in_skill);
        return skills;
    }
    
}
