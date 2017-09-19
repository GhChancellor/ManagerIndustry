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
    private int quanityInt;
    private float quanityFlt;

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
     * @return int quanityInt
     */
    public int getQuanityInt() {
        return quanityInt;
    }

    /**
     * Set Quanity
     * @param quanityInt 
     */
    public void setQuanityInt(int quanityInt) {
        this.quanityInt = quanityInt;
    }

    /**
     * Get Quanity Float
     * @return float
     */
    public float getQuanityFlt() {
        return quanityFlt;
    }

    /**
     * Set Quanity Float
     * @param Float quanityFlt 
     */
    public void setQuanityFlt(float quanityFlt) {
        this.quanityFlt = quanityFlt;
    }

    
    
}
