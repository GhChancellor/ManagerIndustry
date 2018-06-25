/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups;

import managerindustry.logic.exception.PriceNotExistsException;
import managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.itemsRecursion.ItemRecusion;
import managerindustry.logic.structure.StructureEngineeringRigs.invMarketGroups.rig.groupEffectRig.GroupEffectRig;

/**
 * http://evewiz.com/329-data-interfaces
 * @author lele
 */
public class MainInvGroup {
    public static void main(String[] args) throws PriceNotExistsException {
       
        ItemRecusion advancedBattleships = GroupEffectRig.getInstance().ships().battleships().getAdvancedBattleships();
        advancedBattleships.display();
    }
    
 
}
/*
    ship modules = ships equipment
    t2 component = advancedComponents 
    Capital construction compoent = standardCapitalShipComponents
    t2 capital component = advancedCapitalComponents
    Deployable structure = personal deployable? Cargo containers ??
    implants = Attribute enhancers/ skill hardwiring
    t3 component = Subsystem Components ( Electromechanical Interface Nexus )
    tools ????
    data Interface ??
    structure component = structure equipment
    upwell structure ??

*/  