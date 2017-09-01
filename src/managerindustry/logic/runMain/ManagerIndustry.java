/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.runMain;

import managerindustry.logic.manager.ManagerDisplay;
import managerindustry.logic.manager.ManagerFitter;
import managerindustry.logic.prove.ricorsione.ProvaRicorsione;

/**
 *
 * @author lele
 */
public class ManagerIndustry {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        ProvaClass provaClass = new ProvaClass();
        
        ManagerDisplay managerDisplay = new ManagerDisplay();
        managerDisplay.buildItem();
//        managerDisplay.itemDescription();
//        managerDisplay.displayValueRig();
//        managerDisplay.engineeringComplex();
//        managerDisplay.getSolarSystemID();

//        ManagerFitter managerFitter = new ManagerFitter();
//        managerFitter.initFitter();

        
        ProvaRicorsione provaRicorsione = new ProvaRicorsione();
//        provaRicorsione.baseMaterial("scimitar blueprint");
//        provaRicorsione.baseMaterial("CONCORD 25000mm Steel Plates Blueprint");
//        provaRicorsione.Display();




//        System.out.println("Scrivi qualcosa");
//        Scanner keyboard = new Scanner(System.in);
//        int valore = keyboard.nextInt();
//        System.out.println(""+valore);
    }
    
}
