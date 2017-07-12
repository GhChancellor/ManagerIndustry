/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.buiild.fatherclass;

/**
 *
 * @author lele
 */
public class NameBase {
    private int id;
    private String name;
    private int quanity;

    /**
     * Get Id
     * @return int
     */
    public int getId() {
        return id;
    }

    /**
     * Set Id
     * @param id 
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Get Name
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name
     * @param String name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get Quanity
     * @return int quanity
     */
    public int getQuanity() {
        return quanity;
    }

    /**
     * Set Quanity
     * @param quanity 
     */
    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }
        
}
