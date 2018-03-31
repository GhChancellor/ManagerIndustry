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
public class ManagerErrorExecption extends Exception{
    private ErrorExeption.ErrorExeptionEnum

    public ManagerErrorExecption(ErrorExeption.ErrorExeptionEnum errorEnum) {
        this.errorEnum = errorEnum;
    }
    
    
}
