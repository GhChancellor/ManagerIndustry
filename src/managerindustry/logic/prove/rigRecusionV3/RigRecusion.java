/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.rigRecusionV3;

import java.util.List;

/**
 *
 * @author lele
 */
public class RigRecusion {
    private RigRecusionLogic recusionLogic;

    public RigRecusion(RigRecusionLogic recusionLogic) {
        this.recusionLogic = recusionLogic;
    }
    
    public void display(){
        recusionLogic.display();
    }
    
    public List < RigRecusionLogic > getList(){
        return recusionLogic.getList();
    }    
}
