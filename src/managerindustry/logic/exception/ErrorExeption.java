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
public class ErrorExeption extends Exception{
    private ErrorExeptionEnum errorEnum;

    public ErrorExeption(ErrorExeptionEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
    
    public enum ErrorExeptionEnum{
        MAX_CALIBRATION,
        DUPLICATE_RIGS;
    }
    
}
