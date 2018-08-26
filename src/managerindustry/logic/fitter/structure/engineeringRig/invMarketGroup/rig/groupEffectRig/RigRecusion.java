/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig;

import java.util.List;

/**
 *
 * @author lele
 */
public class RigRecusion {
    private RigRecusionLogic recusionLogic;

    public RigRecusion(int code) {
        this.recusionLogic = new RigRecusionLogic(code);
    }
    
    public RigRecusion(int code, int excludeCode) {
        this.recusionLogic = new RigRecusionLogic(code, excludeCode);
    }
    
    public void display(){
        recusionLogic.display();
    }
    
    public List < RigRecusionLogic > getList(){
        return recusionLogic.getList();
    }    
}
