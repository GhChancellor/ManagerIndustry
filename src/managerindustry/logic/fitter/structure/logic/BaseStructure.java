/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.logic;

import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.logic.manager.Manager;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public abstract class BaseStructure {
    protected abstract void calculedBonus();
    public abstract void displayAllValueCalculated();
    public abstract void displayValue();
    
    /**
     * Truncate to decimal
     * @param float value
     * @param byte numberofDecimals
     * @return float 
     */
    public float truncateToDecimal(float value, byte numberofDecimals){
        return StructureLibrary.truncateToDecimal(value, numberofDecimals).floatValue();        
    }

   /**
     * Get bonus station like fuel consumption, manufacturing and science job required time 
     * @param int typeName
     * @param int code
     * @return float 
     */
    public float getDgmTypeAttributes(int typeId, int code){
        DgmTypeAttributes dgmTypeAttribute = 
            Manager.getInstance().managerDB().dgmTypeAttributes().getTypeAttributesByTypeId_ByAttributeID(typeId, code);
        return dgmTypeAttribute.getValueFloat();
    }       
}
