/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.generic.fatherClass;

/**
 *
 * @author lele
 */
public class BuildItem {
    private String bpoName;
    private int run;
    private int job;
    private byte bpoME;
    private byte componentMe;

    public BuildItem(String bpoName, int run, int job, byte bpoME, byte componentMe) {
        this.bpoName = bpoName;
        this.run = run;
        this.job = job;
        this.bpoME = bpoME;
        this.componentMe = componentMe;
    }

    /**
     * Get Bpo Name
     * @return String
     */
    public String getBpoName() {
        return bpoName;
    }

    /**
     * Set Bpo Name
     * @param String bpoName 
     */
    public void setBpoName(String bpoName) {
        this.bpoName = bpoName;
    }

    /**
     * Get Run
     * @return int
     */
    public int getRun() {
        return run;
    }

    /**
     * Set Run
     * @param int run 
     */
    public void setRun(int run) {
        this.run = run;
    }

    /**
     * Get Job
     * @return int
     */
    public int getJob() {
        return job;
    }

    /**
     * Set Job
     * @param int job 
     */
    public void setJob(int job) {
        this.job = job;
    }

    /**
     * Get Bpo ME
     * @return byte
     */
    public byte getBpoME() {
        return bpoME;
    }

    /**
     * Set Bpo ME
     * @param byte bpoME 
     */
    public void setBpoME(byte bpoME) {
        this.bpoME = bpoME;
    }

    /**
     * Get Component Me
     * @return byte
     */
    public byte getComponentMe() {
        return componentMe;
    }

    /**
     * Set Component Me
     * @param byte componentMe 
     */
    public void setComponentMe(byte componentMe) {
        this.componentMe = componentMe;
    }
     
    
}
