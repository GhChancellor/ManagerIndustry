/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill;

import java.math.BigDecimal;
import java.math.RoundingMode;
import managerindustry.logic.stading.Standing;

/**
 * https://support.eveonline.com/hc/en-us/articles/203218962-Broker-Fee-and-Sales-Tax
 * 
 * Sale Tax Accounting" skill
 * Broker Fee Broker Relations skill
 * 3% - (0.1% * BrokerRelationsLevel ) - (0.03% * FactionStanding ) - (0.02% * CorpStanding)
 * @author lele
 */
public class TradeFormulas extends FormulasSkill{
    
    // Broker Relations skill
    /**
     * Calculate Broker Fee
     * @param int brokerRelationsLevel
     * @param String station
     * @return float
     */
    public float calculateBrokerFee(int brokerRelationsLevel, String station){
        
        float initTax = 0.03f;
        float initTaxCorparationStanding = 0.0002f;
        float reduceFeePerLevel = 0.001f;
        float factionStandingTax = 0.0003f;
        
        Standing standing = new Standing(station);
                
        float result = initTax - ( reduceFeePerLevel * brokerRelationsLevel ) -
         (factionStandingTax * standing.getFactionStanding()) -
         ( initTaxCorparationStanding * standing.getCorporationStanding());

        return result;
    }
    
    // 
    /**
     * Calculate Sale Tax
     * @param int levelSkill
     * @return float
     * Accounting" skill.
     */
    public float calculateSaleTax(int levelSkill){
        float saleTransactionStart = 0.02f;
        float reducedPrice = 0.01f;   
        float result = saleTransactionStart * calculateLevelPerSkill(levelSkill, reducedPrice );
        return result;
    }
}
