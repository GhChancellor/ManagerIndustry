/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.treeclasses;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class NeededEveComponent {
    
    private EveComponent eveComponent;
    private int neededQuantity;

    public NeededEveComponent() {
    }

    public NeededEveComponent(EveComponent eveComponent, int neededQuantity) {
        this.eveComponent = eveComponent;
        this.neededQuantity = neededQuantity;
    }

    public EveComponent getEveComponent() {
        return eveComponent;
    }

    public void setEveComponent(EveComponent eveComponent) {
        this.eveComponent = eveComponent;
    }

    public int getNeededQuantity() {
        return neededQuantity;
    }

    public void setNeededQuantity(int neededQuantity) {
        this.neededQuantity = neededQuantity;
    }
    
    
    
}
