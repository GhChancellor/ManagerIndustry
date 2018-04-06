/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.rigbackup;

import managerindustry.logic.enumName.RuleBonus;
import managerindustry.logic.enumName.Tier;

/**
 *
 * @author lele
 */
public class RigBackUp {
    private int id;
    private int idBackUp;
    private Tier tier;
    private RuleBonus rule_bonus;
    
    public RigBackUp() {
    }

    public RigBackUp(int id, int idBackUp, Tier tier, RuleBonus rule_bonus) {
        this.id = id;
        this.idBackUp = idBackUp;
        this.tier = tier;
        this.rule_bonus = rule_bonus;
    }

    public RuleBonus getRule_bonus() {
        return rule_bonus;
    }

    public void setRule_bonus(RuleBonus rule_bonus) {
        this.rule_bonus = rule_bonus;
    }

    public Tier getTier() {
        return tier;
    }

    public void setTier(Tier tier) {
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
