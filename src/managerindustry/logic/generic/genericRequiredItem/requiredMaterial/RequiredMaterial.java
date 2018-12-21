/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem.requiredMaterial;


import managerindustry.logic.generic.fatherClass.NameBase;
import managerindustry.logic.generic.genericRequiredItem.AGenericItemRequired;


/**
 *
 * @author lele
 */
public class RequiredMaterial < A, B, C, D, E, F, G > 
    extends AGenericItemRequired < A, B, C, D, E, F, G > {
    
    protected NameBase requiredMaterial = new NameBase();

    public RequiredMaterial() {
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
    public F requiredItemMoreInfo(D d1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public F requiredItemMoreInfo(D d1, E e1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public G getObject() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
