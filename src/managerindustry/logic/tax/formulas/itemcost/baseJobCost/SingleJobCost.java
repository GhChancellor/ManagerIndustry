/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.tax.formulas.itemcost.baseJobCost;

import managerindustry.logic.buiild.fatherclass.NameBase;

/**
 *
 * @author lele
 */
public class SingleJobCost extends NameBase{
    private float singleJobCost = 0f;
    
    public SingleJobCost( String name, float singleJobCost) {
        super.setName(name);
        this.singleJobCost = singleJobCost;
    }

    public float getSingleJobCost() {
        return singleJobCost;
    }

    public void setSingleJobCost(float singleJobCost) {
        this.singleJobCost = singleJobCost;
    }
    
    
    
}
