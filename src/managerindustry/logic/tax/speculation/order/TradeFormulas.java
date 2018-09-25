/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.speculation.order;

import managerindustry.logic.manager.Manager;
import managerindustry.logic.skill.old.skillProduction.logic.ProductionFormulas;
import managerindustry.logic.skill.old.skillProduction.logic.specificSkill.BrokerFee;
import managerindustry.logic.standing.Standing;

/**
 * https://support.eveonline.com/hc/en-us/articles/203218962-Broker-Fee-and-Sales-Tax
 * 
 * Sale Tax Accounting" skill
 * Broker Fee Broker Relations skill
 * 3% - (0.1% * BrokerRelationsLevel ) - (0.03% * FactionStanding ) - (0.02% * CorpStanding)
 * @author lele
 */
public class TradeFormulas {
    private float initTax;
    private float initTaxCorparationStanding;
    private float reduceFeePerLevel;
    private float factionStandingTax;
    
    // Broker Relations skill
    /**
     * Calculate Broker Fee 
     * @param int brokerRelationsLevel
     * @param String station
     * @return float
     */
    public float calculateBrokerFee(byte brokerRelationsLevel, String station){
//        float initTax = 0.03f;  // starting value
//        float initTaxCorparationStanding = 0.0002f;
//        float reduceFeePerLevel = 0.001f; // valueFloat
//        float factionStandingTax = 0.0003f;
        
        initBokerFee();


        Standing standing = new Standing(station);
                
        float result = initTax - ( reduceFeePerLevel * brokerRelationsLevel ) -
         (factionStandingTax * standing.getFactionStanding()) -
         ( initTaxCorparationStanding * standing.getCorporationStanding());

        return result;
    }
    
    /**
     * 
     */
    private void initBokerFee(){
        BrokerFee brokerFee = 
            (BrokerFee) Manager.getInstance().game().skillProduction().getSkillMap("Broker Relations");
        
        initTax = brokerFee.getStartingValue(); // 0.03f;  // starting value
        initTaxCorparationStanding =  brokerFee.getInitTaxCorparationStanding();  // 0.0002f;
        reduceFeePerLevel = brokerFee.getValueFloat(); // 0.001f; // valueFloat
        factionStandingTax = brokerFee.getFactionStandingTax();  // 0.0003f;        
    }
    
    // 
    /**
     * @deprecated 
     * Calculate Sale Tax
     * @param byte levelSkill
     * @return float
     * Accounting" skill.
     */
    public float calculateSaleTax(byte levelSkill){
        ProductionFormulas productionFormulas = new ProductionFormulas();
        float saleTransactionStart = 0.02f; // starting value
        float reducedPrice = 0.01f; // valueFloat  
        
//        SkillProduction skillProduction = new SkillProduction();
//                
//                skillProduction.getSkillMap("Accounting");
//
//        float saleTransactionStart = skillProduction.getStartingValue(); // starting value
//        float reducedPrice = skillProduction.getValueFloat(); // valueFloat  
        
        float result = 
            saleTransactionStart * productionFormulas.calculateLevelPerSkill(
            levelSkill, reducedPrice );
        
        return result;
    }
}
