/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.prove.event.eventi;

/**
 *
 * @author Luca Coraci <luca.coraci@istc.cnr.it>
 */
public class PersonaFinta {
    
    private String nome;
    private String cognome;

    public PersonaFinta() {
    }

    public PersonaFinta(String nome, String cognome) {
        this.nome = nome;
        this.cognome = cognome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    
    
}
