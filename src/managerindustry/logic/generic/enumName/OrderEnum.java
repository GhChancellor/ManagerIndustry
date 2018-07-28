/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.enumName;

/**
 *
 * @author lele
 */
public enum OrderEnum {
    BUYORDER("BuyOrder"),
    SELLORDER("SellOrder");
    
    private String name;

    private OrderEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}
