/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.logic;

import java.math.BigDecimal;

/**
 *
 * @author lele
 */
public class StructureLibrary{
    /**
     * Truncate to decimal
     * @param float x
     * @param byte numberofDecimals
     * @return BigDecimal
     */    
    public static BigDecimal truncateToDecimal(float x, byte numberofDecimals) {
//        return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        if (x > 0) {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_HALF_UP);
        } else {
            return new BigDecimal(String.valueOf(x)).setScale(numberofDecimals, BigDecimal.ROUND_CEILING);
        }
    }     

}
