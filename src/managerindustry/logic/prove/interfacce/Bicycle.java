/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.interfacce;

/**
 *
 * @author lele
 */
public class Bicycle implements Vehicle{
    private int speed;
    private int gear;    

    @Override
    public void changeGear(int newGear) {
        gear = newGear;
    }

    @Override
    public void speedUp(int increment) {
        speed += increment;
    }

    @Override
    public void applyBrakes(int increment) {
        speed -= increment;
    }
    
    public void display(){
         System.out.println("speed: " + speed
              + " gear: " + gear);        
    }    
}
