/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.buildV3.genericRequireRecursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import managerindustry.db.entities.eve.InvTypes;
import managerindustry.logic.fitter.structure.engineeringRig.invMarketGroup.rig.groupEffectRig.RigMarketGroup;
import managerindustry.logic.generic.recursion.ItemRecursionA;
import managerindustry.logic.manager.Manager;

/**
 *
 * @author lele
 */
public class RigMarketGroupRecursion < T > {
    private List < T > templates = new ArrayList<>();
    private Map < T, T > templatem = new HashMap<>();

    public RigMarketGroupRecursion() {
    }
    
    /**
     * Check if map, list, display
     * @param rigMarketGroupRecursion
     * @param choose
     */    
    public RigMarketGroupRecursion
        (RigMarketGroup rigMarketGroupRecursion, GenericRequiredItem.ChooseEnum choose) {
        
        switch(choose){
            case Display:                
                displayRigMarketGroupRecursion(rigMarketGroupRecursion, "" );
                break;
            case List:
                if ( !rigMarketGroupRecursion.getItemRecursionAs().isEmpty() )
                    pharseRigRecursionToList(rigMarketGroupRecursion);
                break;
            case Map:
                if ( !rigMarketGroupRecursion.getItemRecursionAs().isEmpty() )
                    pharseRigRecursionToMap(rigMarketGroupRecursion);
                break;
        }        
    }

    /**
     * Display Rig Market Group Recursion
     * @param RigMarketGroupRecursion rigMarketGroupRecursion rigMarketGroupRecursion
     * @param String tab 
     */
    private void displayRigMarketGroupRecursion(
        RigMarketGroup rigMarketGroupRecursion, String tab){
        
        if (rigMarketGroupRecursion.getMarketGroupID() != 0 )
            System.out.println(tab + 
                rigMarketGroupRecursion.getMarketGroupName() + " " + 
                rigMarketGroupRecursion.getMarketGroupID() + " " + 
                rigMarketGroupRecursion.getParentGroupID() );

        if ( rigMarketGroupRecursion.getItemRecursionAs().isEmpty() ){
            List<InvTypes> parentGroupID = Manager.getInstance().db().item().
                invTypes().getMarketGroupID(rigMarketGroupRecursion.getMarketGroupID(), true);            
            
            for (InvTypes invTypes : parentGroupID) {
                System.out.println(tab + " - "+ invTypes.getTypeName()+ " " + invTypes.getTypeID() );
            }            
        }

        tab += " " ;
        System.out.println("----------");         
        
        for (ItemRecursionA object : rigMarketGroupRecursion.getItemRecursionAs()) {
            displayRigMarketGroupRecursion((RigMarketGroup) object.getRecursionA02(), tab);
        }         
    }
    
    /**
     * Pharse Rig Recursion To List
     * @param RigMarketGroupRecursion rigMarketGroupRecursion 
     */
    private void pharseRigRecursionToList
        (RigMarketGroup rigMarketGroupRecursion){
        if (rigMarketGroupRecursion != null){
            templates.add((T) (RigMarketGroup) rigMarketGroupRecursion);
        }        
    }    
        
    private void pharseRigRecursionToMap(RigMarketGroup rigMarketGroupRecursion){
        throw new UnsupportedOperationException("Not implemented"); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get Templates
     * @return List<T>
     */
    public List<T> getTemplates() {
        return templates;
    }

    /**
     * Get Templatem()
     * @return Map<T, T>
     */
    public Map<T, T> getTemplatem() {
        return templatem;
    }
        
}
