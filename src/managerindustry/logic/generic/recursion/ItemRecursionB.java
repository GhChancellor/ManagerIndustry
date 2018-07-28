/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.recursion;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.itemsRecursion.*;

/**
 *
 * @author lele
 */
public class ItemRecursionB {
    private ItemRecursionA recursionA02;

    public ItemRecursionB(ItemRecursionA recursionA02) {
        this.recursionA02 = recursionA02;
    }

    public ItemRecursionA getRecursionA02() {
        return recursionA02;
    }

    public void setRecursionA02(ItemRecursionA recursionA02) {
        this.recursionA02 = recursionA02;
    }
    
}
