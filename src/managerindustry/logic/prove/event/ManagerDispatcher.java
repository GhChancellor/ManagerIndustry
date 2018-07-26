/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.event;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lele
 */
public class ManagerDispatcher {
    private List < Listener > listeners = new ArrayList<>();
    private static ManagerDispatcher instance = null;

    public static ManagerDispatcher getInstance() {
        if ( instance == null )
            instance = new ManagerDispatcher();
        return instance;
    }
    
    public ManagerDispatcher() {
    }

    public List<Listener> getListeners() {
        return listeners;
    }

    public void addListeners(Listener listener) {
        this.listeners.add(listener);
    }
    
    public void updateQualcosa(){
        for (Listener listener : listeners) {
            // listener
        }
    }
    
}
