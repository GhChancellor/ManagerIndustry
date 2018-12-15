/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.recursion_object.genericRequiredItem;

/**
 *
 * @author lele
 */
public interface IGenericRequiredItem < A, B, C >{
    public void requiredItem(A a1);
    public void requiredItem(A a1, B b2);
    public void requiredItem(A a1, B b2, C c3);
    public A requiredItemMoreInfo(A a1);
    public A requiredItemMoreInfo(A a1, B b2);
    public A getObject();
    public void display();    
}
