/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package managerindustry.logic.manager;

import java.util.ArrayList;
import java.util.List;
import managerindustry.logic.structure.EngineeringComplex;

/**
 * Value of EngineeringComplex
 * https://community.eveonline.com/news/dev-blogs/building-dreams-introducing-engineering-complexes/
 * @author lele
 */
public class ManagerEngineeringComplex {
    
    private static ManagerEngineeringComplex instance = null;
    private List < EngineeringComplex > engineeringComplexes = new ArrayList<>();
    
    public ManagerEngineeringComplex() {
    }

    public static ManagerEngineeringComplex getInstance(){
        if ( instance == null ){
            instance = new ManagerEngineeringComplex();
        }
        return instance;
    }
    
    /**
     * Get Engineering Complexes
     * @return List<EngineeringComplex>
     */
    public List<EngineeringComplex> getEngineeringComplexes() {
        return engineeringComplexes;
    }

    /**
     * Set Engineering Complexes
     * @paramList <EngineeringComplex> engineeringComplexes 
     */
    public void setEngineeringComplexes(List<EngineeringComplex> engineeringComplexes) {
        this.engineeringComplexes = engineeringComplexes;
    }
    
    /**
     * Add Engineering Complexes
     * @param engineeringComplex 
     */
    public void addEngineeringComplexes(EngineeringComplex engineeringComplex) {
        this.engineeringComplexes.add(engineeringComplex);
    }
    
}

/*
    Raitaru
    reductionManufacturingJob = 0.01; // 1%
    reductionManufacturingScienceJob = 0.15; // 15%
    reductionManufacturingScienceJobIskCost = 0.03; // 3%
    reductionFuelConsumption = 0.25; // 25%        
*/