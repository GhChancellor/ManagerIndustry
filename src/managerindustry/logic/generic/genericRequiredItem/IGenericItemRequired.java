/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.genericRequiredItem;

/**
 *
 * @author lele
 */
public interface IGenericItemRequired < A, B, C, D, E, F, G>{
    public void requiredItem(A a1);
    public void requiredItem(A a1, B b2);
    public void requiredItem(A a1, B b2, C c3);
    public F requiredItemMoreInfo(D d1);
    public F requiredItemMoreInfo(D d1, E e1);
    public G getObject();
    public void display();    
}
