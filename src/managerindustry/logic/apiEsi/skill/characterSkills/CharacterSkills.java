/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsi.skill.characterSkills;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileReader;
import java.io.Reader;
import managerindustry.db.entities.user.UserApiEntity;

/**
 *
 * @author lele
 */
public class CharacterSkills {
    
    /**
     * Get Character Skills
     * @param userApiEntity
     * @return Map < String, SkillParser >
     */
    public SkillParser getCharacterSkills(UserApiEntity userApiEntity){
        try {
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(SkillRaw.class, new SkillRawDeserializer() );           
            gsonBuilder.registerTypeAdapter(SkillParser.class, new SkillsDeserializer() );  
            Gson gson = gsonBuilder.create();
            
            final String path = "./Skill.json";
            Reader reader = new FileReader(path);
            
//            URL url = new URL("https://login.eveonline.com/oauth/token/");
//            InputStreamReader reader = new InputStreamReader(url.openStream());

            SkillParser skills = ( SkillParser ) gson.fromJson(reader, SkillParser.class);
            return skills;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        

        
    }
}
