/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson.skill.characterSkills;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import managerindustry.db.entities.user.UserApiEntity;

/**
 *
 * @author lele
 */
public class CharacterSkills {
    
    /**
     * Get Character Skills
     * @param userApiEntity
     * @return Map < String, Skills >
     */
    public Map < String, Skills > getCharacterSkills(UserApiEntity userApiEntity){
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(Skills.class, new SkillsDeserializer() );
            Gson gson = gsonBuilder.create();

            URL url = new URL("https://esi.tech.ccp.is/latest/characters/xxxx/skills/?datasource=tranquility");
            InputStreamReader reader = new InputStreamReader(url.openStream());

            Type type = new TypeToken< ArrayList<Skills> >() {}.getType();
            List < Skills > skillses = (List < Skills >) gson.fromJson(reader, type);
            
            Map < String, Skills > skillsMap = 
                skillses.stream().collect(Collectors.toMap(Skills::getTotal_sp, Skills -> Skills) );
            return skillsMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        

        
    }
}
