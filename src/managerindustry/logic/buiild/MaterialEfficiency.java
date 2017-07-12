/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.buiild;

import managerindustry.logic.buiild.fatherclass.Efficiency;

/**
 *
 * @author lele
 */
public class MaterialEfficiency extends Efficiency{

    public MaterialEfficiency(int bpoLevel) {
        setLevel(bpoLevel);
    }
    
    @Override
    /**
     * Calculate ME BPO
     * 1% = 0.99, 2% = 0.98 ..... 
     * 1 ( valore fisso ) - ( BPO level / 100 )
     */
    public double calculateRateBpo() {        
        return getBaseValue() - ( getLevel().doubleValue() / 100 )  ;
    }
    
}
