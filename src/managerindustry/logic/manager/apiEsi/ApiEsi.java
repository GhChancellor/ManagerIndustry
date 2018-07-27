/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager.apiEsi;

import managerindustry.logic.apiEsi.industry.Industry;
import managerindustry.logic.apiEsi.market.Market;
import managerindustry.logic.apiEsi.skill.Skill;

/**
 * ApiEsi get all value skill, industry, market from eve server ( json ) 
 * @author lele
 */
public class ApiEsi {
    
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
