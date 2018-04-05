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
public enum SecurityStatusEnum {
    HI_SEC("Hi Sec"),
    LOW_SEC("Low Sec"),
    NULL_SEC("Null sec");
    
    private String securityStatus;
    private SecurityStatusEnum securityStatusEnum;
 
    private SecurityStatusEnum(SecurityStatusEnum securityStatusEnum) {
        this.securityStatusEnum = securityStatusEnum;
    }        
    
    private SecurityStatusEnum(String securityStatus) {
        this.securityStatus = securityStatus;
    }

    public String getSecurityStatus() {
        return securityStatus;
    }
    
}
