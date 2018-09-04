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
public enum RamActivitiesEnum {
    MANUFACTURING(1, "manufacturing"),
    RESEARCHING_TIME_EFFICIENCY(3, "researching_time_efficiency"),
    RESEARCHING_MATERIAL_EFFICIENCY(4, "researching_material_efficiency"),
    COPYING(5, "copying"),
    REVERSE_ENGINEERING(7, ""),
    INVENTION(8, ""),
    REACTION(11, "");
    
    private int code;
    private RamActivitiesEnum RamActivitiesEnum;
    private String activity;
    
    private RamActivitiesEnum(RamActivitiesEnum ramActivitiesEnum) {
        this.RamActivitiesEnum = ramActivitiesEnum;
    }

    private RamActivitiesEnum(int code, String activity) {
        this.code = code;
        this.activity = activity;
    }
    
    private RamActivitiesEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public String getActivity() {
        return activity;
    }
    
}
