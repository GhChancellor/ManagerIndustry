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
public class SolarSystemNotExistsException extends Exception{
    public SolarSystemNotExistsException(){
        super("Solar system not exists");
    }

    public SolarSystemNotExistsException(String solarSystemID){
        super("Solar system "+ solarSystemID + " doesn't exists");
    }
}
