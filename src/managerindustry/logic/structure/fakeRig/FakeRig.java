/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.fakeRig;

import managerindustry.logic.enumName.RuleBonusRigEnum;
import managerindustry.logic.enumName.TierEnum;

/**
 *
 * @author lele
 */
public class FakeRig {
    private int id;
    private int idBackUp;
    private TierEnum tier;
    private RuleBonusRigEnum rule_bonus;
    
    public FakeRig() {
    }

    public FakeRig(int id, int idBackUp, TierEnum tier, RuleBonusRigEnum rule_bonus) {
        this.id = id;
        this.idBackUp = idBackUp;
        this.tier = tier;
        this.rule_bonus = rule_bonus;
    }

    public RuleBonusRigEnum getRule_bonus() {
        return rule_bonus;
    }

    public void setRule_bonus(RuleBonusRigEnum rule_bonus) {
        this.rule_bonus = rule_bonus;
    }

    public TierEnum getTier() {
        return tier;
    }

    public void setTier(TierEnum tier) {
        this.tier = tier;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBackUp() {
        return idBackUp;
    }

    public void setIdBackUp(int idBackUp) {
        this.idBackUp = idBackUp;
    }
        
}
