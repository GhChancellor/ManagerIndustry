/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.exception;

/**
 *
 * @author lele
 */
public class ErrorExeption extends Exception{
    private ErrorExeptionEnum errorEnum;
   
    public ErrorExeption(ErrorExeptionEnum errorEnum) {
        this.errorEnum = errorEnum;
    }

    public ErrorExeptionEnum getErrorEnum() {
        return errorEnum;
    }
    
    public enum ErrorExeptionEnum{
        MAX_CALIBRATION("Max Calibration"),
        DUPLICATE_RIGS("Only 1 this module group may be fitted"),
        MAX_VALUE_SKILL_EXCEEDED("Maximun value skill exceeded"),
        PRICE_NOT_EXISTS("Price Not Exists"),
        SECURITY_STATUS_ERROR("Security status error"),
        MAX_SLOT_RIGS("Max slot rig"),
        RIG_SIZE("Size Wrong"),
        CANT_REMOVE("You can't remove this item"),
        ITEM_NOT_EXITS("This item doesn't exits"),
        UNKNOW_ERROR("Unknow error");

        private String errorMessage;

        private ErrorExeptionEnum(String errorMessage) {
            this.errorMessage = errorMessage;
        }

        public String getErrorMessage() {
            return errorMessage;
        }
    }    
}
