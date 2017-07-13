/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill;

import managerindustry.logic.stading.Standing;

/**
 * https://support.eveonline.com/hc/en-us/articles/203218962-Broker-Fee-and-Sales-Tax
 * 
 * Sale Tax Accounting" skill
 * Broker Fee Broker Relations skill
 * 3% - (0.1% * BrokerRelationsLevel ) - (0.03% * FactionStanding ) - (0.02% * CorpStanding)
 * @author lele
 */
public class tradeFormulas extends FormulasSkill{
    
    // Broker Relations skill
    public void brokerFee(int levelSkill){
        
    }
    
    // Accounting" skill.
    public float saleTax(float initialValue, int levelSkill, float percent){
        return sottrazioneDalValoreOriginale(initialValue, levelSkill, percent);
    }
}
