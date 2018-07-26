/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.structure.logic;

import managerindustry.logic.fitter.structure.engineeringRig.EngineeringRig;

/**
 *
 * @author lele
 */
public class MaxGroupFitted {
    private EngineeringRig engineeringRig;
    private byte currentFitted = 0;

    public MaxGroupFitted(EngineeringRig engineeringRig, byte currentFitted) {
        this.engineeringRig = engineeringRig;
        this.currentFitted = currentFitted;        
    }

    public byte getCurrentFitted() {
        return currentFitted;
    }

    public void setCurrentFitted(byte currentFitted) {
        this.currentFitted = currentFitted;
    }

    public EngineeringRig getEngineeringRig() {
        return engineeringRig;
    }

}