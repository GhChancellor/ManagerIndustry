/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.ApiEsiJson;

import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.ApiEsiJson.industry.Industry;
import managerindustry.logic.ApiEsiJson.skill.SkillJson;

/**
 *
 * @author lele
 */
public class ApiEsi {
    private static ApiEsi instance = null;

    public ApiEsi() {
    }
    
    public static ApiEsi getInstance(){
        if ( instance == null)
            instance = new ApiEsi();
        return instance;
    }
    
    public SkillJson skillJson(UserApiEntity userApiEntity) {
        SkillJson skillJson = new SkillJson(userApiEntity);
        return skillJson;
    }
    
    public Industry industryJson(){
        Industry industry = new Industry();
        return industry;
    }
        
}
