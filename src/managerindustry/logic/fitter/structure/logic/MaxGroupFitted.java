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
    
     

}

/*
        if ( managerError(engineeringRigs, EngineeringRigEnum.ADD) ){                   

            if (maxGroupFittedMap.containsKey(engineeringRigs.getTypeID())){
                maxGroupFittedMap.put(engineeringRigs.getTypeID(), 
                    maxGroupFittedMap.get(engineeringRigs.getTypeID()) + 1 );                
            }else{
                maxGroupFittedMap.put(engineeringRigs.getTypeID(), 1);                
            }
            
            engineeringComplex_CurrentSlot++;
            currentCalibration += engineeringRigs.getCalibration();            
        }
*/

/*
        case ADD:
            if( maxGroupFittedMap.get(engineeringRigs.getTypeID()) >= 
                engineeringRigs.getMaxGroupFitted().intValue() ){
                    displayErrorRig(ErrorExeption.ErrorExeptionEnum.DUPLICATE_RIGS);
                return false;     
            }                    

        case REMOVE:
            if (maxGroupFittedMap.get(engineeringRigs.getTypeID()) <= 0){
                displayErrorRig(ErrorExeption.ErrorExeptionEnum.CANT_REMOVE);
                return false;
            }
*/