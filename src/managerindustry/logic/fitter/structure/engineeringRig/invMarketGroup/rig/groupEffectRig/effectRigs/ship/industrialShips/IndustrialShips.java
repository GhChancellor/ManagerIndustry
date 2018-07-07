/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.industrialShips;

/**
 * Industrial Ships: standard Industrial Ships, Industrial Command Ships, Advanced Industrial Ships
 * @author lele
 */
public class IndustrialShips {
    /**
     * Standard Industrial Ships
     * @return StandardIndustrialShips
     */
    public StandardIndustrialShips standardIndustrialShips(){
        StandardIndustrialShips standardIndustrialShips = new StandardIndustrialShips();
        return standardIndustrialShips;
    }
    
    /**
     * Industrial Command Ships
     * @return IndustrialCommandShips
     */
    public IndustrialCommandShips industrialCommandShips(){
        IndustrialCommandShips industrialCommandShips = new IndustrialCommandShips();
        return industrialCommandShips;
    }
    
    /**
     * Advanced Industrial Ships
     * @return AdvancedIndustrialShips
     */
    public AdvancedIndustrialShips advancedIndustrialShips(){
        AdvancedIndustrialShips advancedIndustrialShips = new AdvancedIndustrialShips();
        return advancedIndustrialShips;
    }
}
