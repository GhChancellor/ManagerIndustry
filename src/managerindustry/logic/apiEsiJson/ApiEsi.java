/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.apiEsiJson;

import managerindustry.db.entities.user.UserApiEntity;
import managerindustry.logic.apiEsiJson.industry.Industry;
import managerindustry.logic.apiEsiJson.market.Market;
import managerindustry.logic.apiEsiJson.skill.Skill;

/**
 * ApiEsi get all value skill, industry, market from eve server ( json ) 
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
    
    /**
     * ApiEsi get all value skill from eve server ( json ) 
     * @return Skill
     */
    public Skill skill() {
        Skill skillJson = new Skill();
        return skillJson;
    }
    
    /**
     * ApiEsi get all value industry from eve server ( json ) 
     * @return Industry
     */
    public Industry industry(){
        Industry industry = new Industry();
        return industry;
    }
   
    /**
     * ApiEsi get all value market from eve server ( json ) 
     * @return Market
     */
    public Market market(){
        Market market = new Market();
        return market;
    }
}
