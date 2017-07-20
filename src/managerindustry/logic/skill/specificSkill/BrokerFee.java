/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.skill.specificSkill;

import managerindustry.logic.skill.Skill;

/**
 *
 * @author lele
 */
public class BrokerFee extends Skill{
    private float initTaxCorparationStanding;
    private float factionStandingTax;
    private String name;

    public BrokerFee(String nameSkill) {
        super(nameSkill);
    }
  
    public float getInitTaxCorparationStanding() {
        return initTaxCorparationStanding;
    }

    public void setInitTaxCorparationStanding(float initTaxCorparationStanding) {
        this.initTaxCorparationStanding = initTaxCorparationStanding;
    }

    public float getFactionStandingTax() {
        return factionStandingTax;
    }

    public void setFactionStandingTax(float factionStandingTax) {
        this.factionStandingTax = factionStandingTax;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    
    
}
