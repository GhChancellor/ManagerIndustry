/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.logic;

import java.math.BigDecimal;
import managerindustry.db.entities.eve.DgmTypeAttributes;
import managerindustry.logic.enumName.RuleBonusRigEnum;
import managerindustry.logic.manager.managerDB.ManagerDB;

/**
 *
 * @author lele
 */
public class StructureLibrary{
    /**
     * Truncate to decimal
     * @param float x
     * @param int numberofDecimals
     * @return BigDecimal
     */    
    public static BigDecimal truncateToDecimal(float x, int numberofDecimals) {
//        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        if (x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }     

}
