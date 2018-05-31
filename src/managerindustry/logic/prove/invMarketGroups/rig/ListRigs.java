/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class ListRigs {
    private List<Rig> rigs = new ArrayList<>();
        
    public List<Rig> getRigs() {
        return rigs;
    }

    public void setRigs(List<Rig> rigs) {
        this.rigs = rigs;
    }
    
    public void addRigs(Rig rig) {
        this.rigs.add(rig);
    }
    
    private void initRig(){
        addRig(43920);
    }
    
    private void addRig(int code){
        Rig rig = new Rig(43920);
        rigs.add(rig);        
    }
}
