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
public interface IGenericItemRequiredV2 < A, B, C, E, F >{
    public void requiredItem(A a1);
    public void requiredItem(A a1, B b2);
    public void requiredItem(A a1, B b2, C c3);
    public A requiredItemMoreInfo(E e1);
    public A requiredItemMoreInfo(E e1, F f1);
    public A getObject();
    public void display();    
}
