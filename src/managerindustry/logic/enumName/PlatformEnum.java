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
public enum PlatformEnum {
    STATION("Station"),
    ENGINEERING_COMPLEX("Engineering Complex"),
    RAITARU("Raitaru"),
    AZBEL("Azbel"),
    SOTIYO("Sotiyo");
    
    private String name;
    private PlatformEnum platformEnum;

    private PlatformEnum(String name) {
        this.name = name;
    }

    private PlatformEnum(PlatformEnum platformEnum) {
        this.platformEnum = platformEnum;
    }

    public String getName() {
        return name;
    }
 
}
