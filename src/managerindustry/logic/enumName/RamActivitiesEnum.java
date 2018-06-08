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
public enum RamActivitiesEnum {
    MANUFACTURING(1),
    RESEARCHING_TIME_EFFICIENCY(3),
    RESEARCHING_MATERIAL_EFFICIENCY(4),
    COPYING(5),
    REVERSE_ENGINEERING(7),
    INVENTION(8),
    REACTION(11);
    
    private int code;
    private RamActivitiesEnum RamActivitiesEnum;

    private RamActivitiesEnum(RamActivitiesEnum ramActivitiesEnum) {
        this.RamActivitiesEnum = ramActivitiesEnum;
    }

    private RamActivitiesEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    
}
