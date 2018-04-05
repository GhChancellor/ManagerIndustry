/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import managerindustry.logic.enumName.ErrorMessage;
import managerindustry.logic.exception.ErrorExeption;



/**
 *
 * @author lele
 */
public class ManagerErrorExecption {
    public static String getErrorExecption(ErrorExeption.ErrorExeptionEnum errorExeptionEnum){
        switch (errorExeptionEnum){
            case DUPLICATE_RIGS:
                return ErrorMessage.DUPLICATE_RIGS.getErrorMessage();
            case MAX_CALIBRATION:
                return ErrorMessage.MAX_CALIBRATION.getErrorMessage();
            default:
                System.out.println("errore");
                return "";
        }
    }
}
