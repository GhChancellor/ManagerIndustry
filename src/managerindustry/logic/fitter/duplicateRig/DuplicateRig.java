/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.fitter.duplicateRig;

/**
 *
 * @author lele
 */
public class DuplicateRig {
    private int typeId;
    private float maxGroupFitted;
    private int currentRigFitted = 0;
    
    public DuplicateRig(int rigID, float maxGroupFitted) {
        this.typeId = rigID;
        this.maxGroupFitted = maxGroupFitted;
        currentRigFitted++;
    }

    public DuplicateRig(int rigID, int currentRigFitted, float maxGroupFitted) {
        this.typeId = rigID;
        this.maxGroupFitted = maxGroupFitted;
        this.currentRigFitted = currentRigFitted;
    }    
    
    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public float getMaxGroupFitted() {
        return maxGroupFitted;
    }

    public void setMaxGroupFitted(float maxGroupFitted) {
        this.maxGroupFitted = maxGroupFitted;
    }

    public int getCurrentRigFitted() {
        return currentRigFitted;
    }

    public void setCurrentRigFitted(int currentRigFitted) {
        this.currentRigFitted = currentRigFitted;
    }

}
