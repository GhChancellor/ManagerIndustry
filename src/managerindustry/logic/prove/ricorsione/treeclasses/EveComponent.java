/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.ricorsione.treeclasses;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class EveComponent {
    
    private long id;
    private String name;
    private int currentQuantity; // quantità di questi componenti (THIS ) nel mio magazzino
    
    private List<NeededEveComponent> neededEveComponent = new ArrayList<>();

    public EveComponent() {
    }

    
    public EveComponent(long id, String name, int currentQuantity) {
        this.id = id;
        this.name = name;
        this.currentQuantity = currentQuantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public List<NeededEveComponent> getNeededEveComponent() {
        return neededEveComponent;
    }

    public void setNeededEveComponent(List<NeededEveComponent> neededEveComponent) {
        this.neededEveComponent = neededEveComponent;
    }
    
    public void addNeededEveComponent(NeededEveComponent component){
        this.neededEveComponent.add(component);
    }
    
    
    
    
    
    
    
}
