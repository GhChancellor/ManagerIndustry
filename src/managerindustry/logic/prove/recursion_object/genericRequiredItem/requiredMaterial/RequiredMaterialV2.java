/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.genericRequiredItem.requiredMaterial;


import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.prove.recursion_object.genericRequiredItem.AGenericItemRequiredV2;


/**
 *
 * @author lele
 */
public class RequiredMaterialV2 < A, B, C, E, F > extends AGenericItemRequiredV2 < A, B, C, E, F >{
    protected NameBase requiredMaterial = new NameBase();

    public RequiredMaterialV2() {
    }
    
    /**
     * Display
     */
    @Override
    public void display() {
        displayRequiredMaterial(requiredMaterial, "");
    }   
    
    /**
     * Display Material recursion
     * @param RequiredMaterialRecusion requiredItemA
     * @param String tab 
     */
    private void displayRequiredMaterial(NameBase requiredItemA, String tab){
        if ( requiredItemA.getTypeID() != 0 ){
            System.out.println(tab + requiredItemA.getTypeID() + " " + 
            requiredItemA.getTypeName() + " - " + 
            requiredItemA.getBaseQuantity()+ " > " + 
            requiredItemA.getSingleItemQuantity() + " > " + 
            requiredItemA.getTotalItemsQuantity() );              
        }

        tab += " ";                        
        
        for (NameBase materialRecusion : requiredItemA.getItemRecursions()) {
            displayRequiredMaterial( materialRecusion, tab);
        } 
    }   

    @Override
    public void requiredItem(A a1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requiredItem(A a1, B b2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void requiredItem(A a1, B b2, C c3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public A requiredItemMoreInfo(E e1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public A requiredItemMoreInfo(E e1, F f1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public A getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
