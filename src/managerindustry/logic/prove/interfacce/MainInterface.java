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
public class MainInterface {
    public static void main(String[] args) {
        Bicycle bicycle = new Bicycle();
        bicycle.changeGear(2);
        bicycle.speedUp(3);
        bicycle.applyBrakes(1);
         
        System.out.println("Bicycle present state :");
        bicycle.display();
         
        // creating instance of bike.
        MotorBike motorBike = new MotorBike();
        motorBike.changeGear(1);
        motorBike.speedUp(4);
        motorBike.applyBrakes(3);
         
        System.out.println("Bike present state :");
        motorBike.display();        
    }
    
}
