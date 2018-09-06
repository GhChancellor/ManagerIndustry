/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.skill.old;

import managerindustry.logic.manager.Manager;
import managerindustry.logic.prove.skill.old.specificSkill.BrokerFee_OLD;
import managerindustry.logic.standing.Standing;

/**
 * https://support.eveonline.com/hc/en-us/articles/203218962-Broker-Fee-and-Sales-Tax
 * 
 * Sale Tax Accounting" skill
 * Broker Fee Broker Relations skill
 * 3% - (0.1% * BrokerRelationsLevel ) - (0.03% * FactionStanding ) - (0.02% * CorpStanding)
 * @author lele
 */
public class TradeFormulas_OLD extends FormulasSkill_OLD{
    
    // Broker Relations skill
    /**
     * Calculate Broker Fee 
     * @param int brokerRelationsLevel
     * @param String station
     * @return float
     */
    public float calculateBrokerFee(byte brokerRelationsLevel, String station){
        float initTax = 0.03f;  // starting value
        float initTaxCorparationStanding = 0.0002f;
        float reduceFeePerLevel = 0.001f; // valueFloat
        float factionStandingTax = 0.0003f;
        
//        brokerFee();

        Standing standing = new Standing(station);
                
        float result = initTax - ( reduceFeePerLevel * brokerRelationsLevel ) -
         (factionStandingTax * standing.getFactionStanding()) -
         ( initTaxCorparationStanding * standing.getCorporationStanding());

        return result;
    }
    
    /**
     * @deprecated 
     * non va query disabilitata, da rifare skill, 
     * lo so float non va da nessuna parte era per aggirare l'errore
     */
    private void brokerFee(){
        BrokerFee_OLD brokerFee = 
            ( BrokerFee_OLD ) Manager.getInstance().game().skill().getSkillMap("Broker Relations");
        
        float initTax = brokerFee.getStartingValue(); // 0.03f;  // starting value
        float initTaxCorparationStanding =  brokerFee.getInitTaxCorparationStanding();  // 0.0002f;
        float reduceFeePerLevel = brokerFee.getValueFloat(); // 0.001f; // valueFloat
        float factionStandingTax = brokerFee.getFactionStandingTax();  // 0.0003f;        
    }
    
    // 
    /**
     * Calculate Sale Tax
     * @param byte levelSkill
     * @return float
     * Accounting" skill.
     */
    public float calculateSaleTax(byte levelSkill){
        float saleTransactionStart = 0.02f; // starting value
        float reducedPrice = 0.01f; // valueFloat  
        
//        Skill_OLD skill = Skill_OLD.getInstance().getSkillMap("Accounting");
//        
//        float saleTransactionStart = skill.getStartingValue(); // starting value
//        float reducedPrice = skill.getValueFloat(); // valueFloat  
        
        float result = saleTransactionStart * calculateLevelPerSkill(levelSkill, reducedPrice );
        return result;
    }
}
