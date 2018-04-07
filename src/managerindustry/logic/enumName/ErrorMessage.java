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
public enum ErrorMessage {
    MAX_CALIBRATION("Max Calibration"),
    DUPLICATE_RIGS("Duplicate Rigs"),
    MAX_VALUE_SKILL_EXCEEDED("Maximun value skill exceeded"),
    PRICE_NOT_EXISTS("Price Not Exists"),
    SECURITY_STATUS_ERROR("Security status error"),
    MAX_SLOT_RIGS("Max slot rig");
    
    private String errorMessage;

    private ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
    
}
