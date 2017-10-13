/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.eventi;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public interface PersonaListener {
    
    public void personaUpdated(PersonaFinta persona);
    
    public void personaCreated(PersonaFinta persona);
    
}
