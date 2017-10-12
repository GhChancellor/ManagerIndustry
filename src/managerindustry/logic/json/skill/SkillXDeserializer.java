/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.json.skill;

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
public class SkillXDeserializer implements JsonDeserializer<SkillX>{

    @Override
    public SkillX deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        JsonObject jsonObject = je.getAsJsonObject();
        String total_sp = jsonObject.get("total_sp").getAsString();
        
        Parameter[] parameters = jdc.deserialize(jsonObject.get("skills"), Parameter.class );
//        SkillX skillX = new SkillX(total_sp, total_sp)
    }

    
}
