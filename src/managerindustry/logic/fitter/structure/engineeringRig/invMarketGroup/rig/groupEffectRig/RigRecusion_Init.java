/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig;

import java.util.List;
import java.util.Map;
import managerindustry.logic.generic.fatherClass.RigMarketGroup;
import managerindustry.logic.generic.genericRequiredItem.requiredMaterial.RequiredMaterialGeneric;

/**
 *
 * @author lele
 */
public class RigRecusion_Init extends RequiredMaterialGeneric{
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
    public Map getMap() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object getRequiredMaterialObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List < RigMarketGroup > getList() {
        return recusionLogic.getList();
    }


}
