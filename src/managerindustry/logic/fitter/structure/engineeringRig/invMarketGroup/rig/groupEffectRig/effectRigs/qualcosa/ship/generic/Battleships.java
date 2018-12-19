/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.effectRigs.qualcosa.ship.generic;

import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.old.RigRecusion_Init;


/**
 * marketGroupID 7 - 1377 
 * parentGroupID 1376
 * @author lele
 */
public class Battleships {
    /**
     * Get Standard Battleships
     * @return RigRecusion_Init
     */
    public final RigRecusion_Init getStandardBattleships(){
        RigRecusion_Init standardBattleships = new RigRecusion_Init(7);     
        return standardBattleships;
    } 
    
    /**
     * Get Advanced Battleships
     * @return RigRecusion_Init
     */    
    public final RigRecusion_Init getAdvancedBattleships (){
        RigRecusion_Init advancedBattleships = new RigRecusion_Init(1377);
        return advancedBattleships;
    }     
}
