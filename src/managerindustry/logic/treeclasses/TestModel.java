/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.treeclasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class TestModel {

    public static void main(String[] args) {

        EveComponent scimitar = new EveComponent(1, "Scimitar", 0);

        EveComponent ladarSensorCluster = new EveComponent(2, "ladarSensorCluster", 0); //1
        EveComponent compositeArmorPlate = new EveComponent(21, "compositeArmorPlate", 0); //2
        EveComponent ferniteCarbide = new EveComponent(22, "ferniteCarbide", 0); //2
        EveComponent sylramicFibers = new EveComponent(23, "sylramicFibers", 0); //2

        EveComponent nanoMechanicalMicroProcessor = new EveComponent(3, "nanoMechanicalMicroProcessor", 0);//1
        EveComponent phenolicComposites = new EveComponent(31, "Phenolic Composites", 0);//2
        // EveComponent ferniteCarbide = new EveComponent(32, "Fernite Carbide", 0);//2  GIA ESISTE
        EveComponent plasmonicMetamaterials = new EveComponent(33, "Plasmonic Metamaterials", 0);//2
        EveComponent nanotransistors = new EveComponent(34, "Nanotransistors", 0);//2

        EveComponent CPU = new EveComponent(341, "CPU", 0);//2
        EveComponent viti = new EveComponent(342, "viti", 0);//2

        nanotransistors.addNeededEveComponent(new NeededEveComponent(CPU, 1));
        nanotransistors.addNeededEveComponent(new NeededEveComponent(viti, 30));

        nanoMechanicalMicroProcessor.addNeededEveComponent(new NeededEveComponent(phenolicComposites, 2));
        nanoMechanicalMicroProcessor.addNeededEveComponent(new NeededEveComponent(ferniteCarbide, 3));
        nanoMechanicalMicroProcessor.addNeededEveComponent(new NeededEveComponent(plasmonicMetamaterials, 4));
        nanoMechanicalMicroProcessor.addNeededEveComponent(new NeededEveComponent(nanotransistors, 5));

        ladarSensorCluster.addNeededEveComponent(new NeededEveComponent(compositeArmorPlate, 20));
        ladarSensorCluster.addNeededEveComponent(new NeededEveComponent(ferniteCarbide, 30));
        ladarSensorCluster.addNeededEveComponent(new NeededEveComponent(sylramicFibers, 40));

        scimitar.addNeededEveComponent(new NeededEveComponent(ladarSensorCluster, 1));
        scimitar.addNeededEveComponent(new NeededEveComponent(nanoMechanicalMicroProcessor, 1));

        printEveComponent(scimitar, 1, "");

    }

    public static void printEveComponent(EveComponent eve, int necessaryQuantity, String tab) {

        System.out.println(tab + "Component: " + eve.getName());
        System.out.println(tab + "Component quantità in magazzino: " + eve.getCurrentQuantity());
        System.out.println(tab + "Quantità necessaria: " + necessaryQuantity);
        System.out.println("-------------------------------------------------");
        tab += "\t";
        for (NeededEveComponent neededEve : eve.getNeededEveComponent()) {
            printEveComponent(neededEve.getEveComponent(), neededEve.getNeededQuantity(), tab);
        }

    }

//    public static void fetchEveComponent(EveComponent eve) {
//
//        List<NeededEveComponent> neededComponent = getNeededComponentFromDB(eve);
//        if(neededComponent==null){
//            return;
//        }
//        eve.setNeededEveComponent(neededComponent);
//
//        for (NeededEveComponent neededEve : neededComponent) {
//            fetchEveComponent(neededEve.getEveComponent());
//        }
//
//    }
//
//    private static List<NeededEveComponent> getNeededComponentFromDB(EveComponent eve) {
//        
//        List<NeededEveComponent> result = new ArrayList<>();
//        
//        //DA IMPLEMENTARE DAL DATABASE
//        return result;
//    }

}
