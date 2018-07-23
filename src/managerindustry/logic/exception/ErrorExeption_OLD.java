/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.exception;

/**
 *
 * @author lele
 */
public class ErrorExeption_OLD extends Exception{
    private ErrorExeptionEnum errorEnum;

    public ErrorExeption_OLD(ErrorExeptionEnum errorEnum) {
        super();
        this.errorEnum = errorEnum;
    }

    public ErrorExeptionEnum getErrorEnum() {
        return errorEnum;
    }
    
    public enum ErrorExeptionEnum{
        MAX_CALIBRATION,
        DUPLICATE_RIGS,
        MAX_VALUE_SKILL_EXCEEDED,
        PRICE_NOT_EXISTS,
        SECURITY_STATUS_ERROR,
        MAX_SLOT_RIGS,
        RIG_SIZE,
        CANT_REMOVE,
        UNKNOW_ERROR;
    }    
}