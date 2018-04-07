/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.enumName;

/**
 *
 * @author lele
 */
public enum TierEnum {
    T1("T1"),
    T2("T2");
    
    private String tier;
    private TierEnum tierX;

    private TierEnum(TierEnum tierX) {
        this.tierX = tierX;
    }
    
    private TierEnum(String tier) {
        this.tier = tier;
    }

    public String getTier() {
        return tier;
    }
         
}
