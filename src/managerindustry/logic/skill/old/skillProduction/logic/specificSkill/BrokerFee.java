/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill.old.skillProduction.logic.specificSkill;

import managerindustry.logic.generic.fatherClass.SkillInfo;

/**
 *
 * @author lele
 */
public class BrokerFee extends SkillInfo{
    private float initTaxCorparationStanding;
    private float factionStandingTax;

    public BrokerFee(String nameSkill) {
        super(nameSkill);
    }
  
    /**
     * Get Init Tax Corparation Standing
     * @return float
     */
    public float getInitTaxCorparationStanding() {
        return initTaxCorparationStanding;
    }

    /**
     * Init Tax Corparation Standing
     * @param float initTaxCorparationStanding 
     */
    public void setInitTaxCorparationStanding(float initTaxCorparationStanding) {
        this.initTaxCorparationStanding = initTaxCorparationStanding;
    }

    /**
     * Get Faction Standing Tax
     * @return float
     */
    public float getFactionStandingTax() {
        return factionStandingTax;
    }

    /**
     * Set Faction Standing Tax
     * @param float factionStandingTax 
     */
    public void setFactionStandingTax(float factionStandingTax) {
        this.factionStandingTax = factionStandingTax;
    }
    
}
