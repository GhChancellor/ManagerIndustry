/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig;

import java.util.List;
import managerindustry.logic.generic.fatherClass.RigMarketGroup;
import managerindustry.logic.generic.genericRequiredItem.IGenericlRequest;

/**
 *
 * @author lele
 */
public class RigRecusion_Init implements IGenericlRequest <RigMarketGroup>{

     private RigRecusionLogic recusionLogic;

    public RigRecusion_Init(int code) {
        this.recusionLogic = new RigRecusionLogic(code);
    }
    
    public RigRecusion_Init(int code, int excludeCode) {
        this.recusionLogic = new RigRecusionLogic(code, excludeCode);
    }    
    
    @Override
    public void display() {
        recusionLogic.display();
    }

    @Override
    public RigMarketGroup getRequiredMaterialObject() {
        return recusionLogic.getObject();
    }
    
    public List<RigMarketGroup> getList(){
        
    }
}
