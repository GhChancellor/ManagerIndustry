/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill.specificSkill;

import managerindustry.logic.skill.SkillXXX;

/**
 *
 * @author lele
 */
public class BrokerFee extends SkillXXX{
    private float initTaxCorparationStanding;
    private float factionStandingTax;
    private String name;

    public BrokerFee(String nameSkill) {
        super(nameSkill);
    }
  
    /**
     * 
     * @return float
     */
    public float getInitTaxCorparationStanding() {
        return initTaxCorparationStanding;
    }

    /**
     * 
     * @param float initTaxCorparationStanding 
     */
    public void setInitTaxCorparationStanding(float initTaxCorparationStanding) {
        this.initTaxCorparationStanding = initTaxCorparationStanding;
    }

    /**
     * 
     * @return float
     */
    public float getFactionStandingTax() {
        return factionStandingTax;
    }

    /**
     * 
     * @param float factionStandingTax 
     */
    public void setFactionStandingTax(float factionStandingTax) {
        this.factionStandingTax = factionStandingTax;
    }

    /**
     * 
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param Stringname 
     */
    public void setName(String name) {
        this.name = name;
    }


    
    
}
