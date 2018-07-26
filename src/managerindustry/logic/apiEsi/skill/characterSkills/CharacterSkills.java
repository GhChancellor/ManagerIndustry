/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsi.skill.characterSkills;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.net.ssl.HttpsURLConnection;
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
            // /home/lele/Documenti/Programmi/EveDoc/eveobject/skill.json
            
            final String path = "/home/lele/Documenti/programmi/EveDoc/eveobject/skill.json";
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
