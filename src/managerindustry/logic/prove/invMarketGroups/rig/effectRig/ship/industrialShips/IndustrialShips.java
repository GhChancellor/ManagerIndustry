/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.invMarketGroups.rig.effectRig.ship.industrialShips;

/**
 * @deprecated
 * @author lele
 */
public class IndustrialShips {
    public StandardIndustrialShips standardIndustrialShips(){
        StandardIndustrialShips standardIndustrialShips = new StandardIndustrialShips();
        return standardIndustrialShips;
    }
    
    public IndustrialCommandShips industrialCommandShips(){
        IndustrialCommandShips industrialCommandShips = new IndustrialCommandShips();
        return industrialCommandShips;
    }
    
    public AdvancedIndustrialShips advancedIndustrialShips(){
        AdvancedIndustrialShips advancedIndustrialShips = new AdvancedIndustrialShips();
        return advancedIndustrialShips;
    }
}
