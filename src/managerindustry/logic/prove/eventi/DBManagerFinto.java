/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.eventi;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class DBManagerFinto {
    
    private static DBManagerFinto _instance = null;
    private List<PersonaListener> personaListeners = new ArrayList<>();
    
    public static DBManagerFinto getInstance() {
        if (_instance == null) {
            _instance = new DBManagerFinto();
            return _instance;
        } else {
            return _instance;
        }
    }
    
    private DBManagerFinto() {
        super();
    }
    
    public void addPersonaListener(PersonaListener listener){
        this.personaListeners.add(listener);
    }
    
    public void updatePersona(PersonaFinta pf){
        //controller.edit(pf);
        for (PersonaListener personaListener : personaListeners) {
            personaListener.personaUpdated(pf);  //FIRE DELL'EVENTO
        }
        
    }
    
    public void createPersona(PersonaFinta pf){
        //controller.create(pf);
        for (PersonaListener personaListener : personaListeners) {
            personaListener.personaCreated(pf);  //FIRE DELL'EVENTO
        }
        
    }
    
    /**
     * METODO FITTIZZIO DI SUPPORTO
     * @return 
     */
    public PersonaFinta getPersonaFinta(){
        PersonaFinta pf = new PersonaFinta("Luca", "Coraci");
        return pf;
        
    }
    
    
}
