/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import managerindustry.logic.enumName.ErrorMessage;
import managerindustry.logic.exception.ErrorExeption;



/**
 * @deprecated 
 * @author lele
 */
public class ManagerErrorExecption extends Exception {
//    public String getErrorExecption(ErrorExeption.ErrorExeptionEnum errorExeptionEnum){
//        switch (errorExeptionEnum){
//            case DUPLICATE_RIGS:
//                return ErrorMessage.DUPLICATE_RIGS.getErrorMessage();
//            case MAX_CALIBRATION:
//                return ErrorMessage.MAX_CALIBRATION.getErrorMessage();
//            case MAX_SLOT_RIGS:
//                return ErrorMessage.MAX_SLOT_RIGS.getErrorMessage();
//            case RIG_SIZE:
//                return ErrorMessage.RIG_SIZE.getErrorMessage();
//            default:
//                return ErrorMessage.UNKNOW_ERROR.getErrorMessage();
//        }
//        
//    }
    
    public static void displayErrorExecption(ErrorExeption.ErrorExeptionEnum errorExeptionEnum){
        switch (errorExeptionEnum){
            case DUPLICATE_RIGS:
                System.out.println(""+ ErrorMessage.DUPLICATE_RIGS.getErrorMessage()); 
                break;
            case MAX_CALIBRATION:
                System.out.println(""+ ErrorMessage.MAX_CALIBRATION.getErrorMessage());
                break;
            case MAX_SLOT_RIGS:
                System.out.println(""+ ErrorMessage.MAX_SLOT_RIGS.getErrorMessage());
                break;
            case RIG_SIZE:
                System.out.println(""+ ErrorMessage.RIG_SIZE.getErrorMessage());
                break;
            default:
                System.out.println(""+ ErrorMessage.UNKNOW_ERROR.getErrorMessage());
                break;
        }                
    }
    
}
