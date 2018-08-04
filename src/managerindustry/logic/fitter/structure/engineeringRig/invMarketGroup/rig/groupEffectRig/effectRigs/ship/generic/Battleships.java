/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigRecusion;


/**
 * marketGroupID 7 - 1377 
 * parentGroupID 1376
 * @author lele
 */
public class Battleships {
    /**
     * Get Standard Battleships
     * @return RigRecusion
     */
    public final RigRecusion getStandardBattleships(){
        RigRecusion standardBattleships = new RigRecusion(7);     
        return standardBattleships;
    } 
    
    /**
     * Get Advanced Battleships
     * @return RigRecusion
     */    
    public final RigRecusion getAdvancedBattleships (){
        RigRecusion advancedBattleships = new RigRecusion(1377);
        return advancedBattleships;
    }     
}
