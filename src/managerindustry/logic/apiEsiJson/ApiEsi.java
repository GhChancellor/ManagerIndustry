/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson;

import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.apiEsiJson.industry.Industry;
import managerindustry.logic.apiEsiJson.market.Market;
import managerindustry.logic.apiEsiJson.skill.SkillJson;

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
    
    public SkillJson skillJson() {
        SkillJson skillJson = new SkillJson();
        return skillJson;
    }
    
    public Industry industryJson(){
        Industry industry = new Industry();
        return industry;
    }
   
    public Market marketJSon(){
        Market market = new Market();
        return market;
    }
}
