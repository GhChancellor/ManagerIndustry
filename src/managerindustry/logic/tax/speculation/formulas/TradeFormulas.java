/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.speculation.formulas;

import managerindustry.logic.manager.Manager;
import managerindustry.logic.build.skill.old.skillProduction.logic.specificSkill.BrokerFee;
import managerindustry.logic.standing.Standing;

/**
 *
 * @author lele
 */
public class TradeFormulas extends FormulasSkill{
    private float initTax;
    private float initTaxCorparationStanding;
    private float reduceFeePerLevel;
    private float factionStandingTax;

    public TradeFormulas() {

    }

    /**
     * Calculate Broker Fee - Broker Relations skill
     * @param int brokerRelationsLevel
     * @param String station
     * @return float
     */
    public float calculateBrokerFee(byte brokerRelationsLevel, String station){
//        float initTax = 0.03f;  // starting value
//        float initTaxCorparationStanding = 0.0002f;
//        float reduceFeePerLevel = 0.001f; // valueFloat
//        float factionStandingTax = 0.0003f;
        
        initBrokerFee();

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
    private void initBrokerFee(){
        BrokerFee brokerFee = 
            ( BrokerFee ) Manager.getInstance().game().skillProduction().getSkillMap("Broker Relations");
        
        initTax = brokerFee.getStartingValue(); // 0.03f;  // starting value
        initTaxCorparationStanding =  brokerFee.getInitTaxCorparationStanding();  // 0.0002f;
        reduceFeePerLevel = brokerFee.getValueFloat(); // 0.001f; // valueFloat
        factionStandingTax = brokerFee.getFactionStandingTax();  // 0.0003f;        
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
